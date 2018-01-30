/*
 * Copyright (C), 2014-2017, 杭州小卡科技有限公司
 * FileName: SpELTest.java
 * Author:   Cheng Zhujiang
 * Date:     2017/7/22 16:55
 * Description: 
 */
package com.jemmy.spring.chapter5;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.expression.BeanFactoryResolver;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.ParserContext;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.lang.reflect.Method;
import java.util.*;

/**
 * SpELTest
 *
 * @author Cheng Zhujiang
 * @date 2017/7/22
 */
public class SpELTest {

    @Test
    public void helloWorld() {
        ExpressionParser parser = new SpelExpressionParser();
        Expression expression = parser.parseExpression("('Hello' + ' World').concat(#end)");
        EvaluationContext context = new StandardEvaluationContext();
        context.setVariable("end", "!");
        Assert.assertEquals("Hello World!", expression.getValue(context));
    }

    @Test
    public void testParserContext() {
        ExpressionParser parser = new SpelExpressionParser();
        ParserContext parserContext = new ParserContext() {
            @Override
            public boolean isTemplate() {
                return true;
            }

            @Override
            public String getExpressionPrefix() {
                return "#{";
            }

            @Override
            public String getExpressionSuffix() {
                return "}";
            }
        };
        String template = "#{'Hello '}#{'World!!'}";
        Expression expression = parser.parseExpression(template, parserContext);
        Assert.assertEquals("Hello World!!", expression.getValue());
    }

    // 一、类类型表达式
    @Test
    public void testClassTypeExpression() {
        ExpressionParser parser = new SpelExpressionParser();
        //java.lang包类访问
        Class<String> result1 = parser.parseExpression("T(String)").getValue(Class.class);
        Assert.assertEquals(String.class, result1);

        //其他包类访问
        String expression2 = "T(com.jemmy.spring.chapter5.SpELTest)";
        Class<SpELTest> result2 = parser.parseExpression(expression2).getValue(Class.class);
        Assert.assertEquals(SpELTest.class, result2);

        // 类静态字段访问
        int result3 = parser.parseExpression("T(Integer).MAX_VALUE").getValue(int.class);
        Assert.assertEquals(Integer.MAX_VALUE, result3);

        // 类静态方法调用
        int result4 = parser.parseExpression("T(Integer).parseInt('1')").getValue(int.class);
        Assert.assertEquals(1, result4);
    }

    // 二、类实例化
    @Test
    public void testConstructorExpression() {
        ExpressionParser parser = new SpelExpressionParser();
        String result1 = parser.parseExpression("new String('Jacy')").getValue(String.class);
        Assert.assertEquals("Jacy", result1);
        Date result2 = parser.parseExpression("new java.util.Date()").getValue(Date.class);
        Assert.assertNotNull(result2);
    }

    // 三、instanceof表达式
    @Test
    public void testInstanceOfExpression() {
        ExpressionParser parser = new SpelExpressionParser();
        boolean bool = parser.parseExpression("'Lucy' instanceof T(String)").getValue(boolean.class);
        Assert.assertTrue(bool);
    }

    // 四、变量定义及引用
    @Test
    public void testVariableExpression() {
        ExpressionParser parser = new SpelExpressionParser();
        EvaluationContext context = new StandardEvaluationContext();
        context.setVariable("variable", "Eryna");
        context.setVariable("variable", "Eryna");
        String result1 = parser.parseExpression("#variable").getValue(context, String.class);
        Assert.assertEquals("Eryna", result1);

        context = new StandardEvaluationContext("Eryna");
        String result2 = parser.parseExpression("#root").getValue(context, String.class); // 用“#root”引用根对象
        Assert.assertEquals("Eryna", result2);
        String result3 = parser.parseExpression("#this").getValue(context, String.class); // “#this”引用当前上下文对象，此处“#this”即根对象
        Assert.assertEquals("Eryna", result3);
    }

    // 五、自定义函数
    // 此处可以看出“registerFunction”和“setVariable”都可以注册自定义函数，
    // 但是两个方法的含义不一样，推荐使用“registerFunction”方法注册自定义函数。
    @Test
    public void testFunctionExpression() throws NoSuchMethodException {
        ExpressionParser parser = new SpelExpressionParser();
        StandardEvaluationContext context = new StandardEvaluationContext();
        Method parseInt = Integer.class.getDeclaredMethod("parseInt", String.class);
        context.registerFunction("parseInt", parseInt);
        context.setVariable("parseInt2", parseInt);
        String expression1 = "#parseInt('3') == #parseInt2('3')";
        boolean result1 = parser.parseExpression(expression1).getValue(context, boolean.class);
        Assert.assertEquals(true, result1);
    }

    // 六、赋值表达式
    // SpEL即允许给自定义变量赋值，也允许给跟对象赋值，直接使用“#variableName=value”即可赋值
    @Test
    public void testAssignExpression() {
        ExpressionParser parser = new SpelExpressionParser();
        //1.给root对象赋值
        EvaluationContext context = new StandardEvaluationContext("Daisy");
        String result1 = parser.parseExpression("#root='Serena'").getValue(context, String.class);
        Assert.assertEquals("Serena", result1);
        String result2 = parser.parseExpression("#this='Daisy'").getValue(context, String.class);
        Assert.assertEquals("Daisy", result2);

        //2.给自定义变量赋值
        context.setVariable("#variable", "Hebe");
        String result3 = parser.parseExpression("#variable=#root").getValue(context, String.class);
        Assert.assertEquals("Daisy", result3);
    }

    // 七、对象属性存取及安全导航表达式
    // 对于当前上下文对象属性及方法访问，可以直接使用属性或方法名访问，
    // 比如此处根对象date属性“year”，注意此处属性名首字母不区分大小写。
    @Test
    public void testPropertyExpression() {
        ExpressionParser parser = new SpelExpressionParser();
        //1.访问root对象属性
        Date date = new Date();
        StandardEvaluationContext context = new StandardEvaluationContext(date);
        int result1 = parser.parseExpression("Year").getValue(context, int.class);
        Assert.assertEquals(date.getYear(), result1);
        int result2 = parser.parseExpression("year").getValue(context, int.class);
        Assert.assertEquals(date.getYear(), result2);

        //2.安全访问
        context.setRootObject(null);
        // SpEL引入了Groovy的安全导航运算符，比如此处根对象为null，所以如果访问其属性时肯定抛出空指针异常，
        // 而采用“?.”安全访问导航运算符将不抛空指针异常，而是简单的返回null。
        Object result3 = parser.parseExpression("#root?.year").getValue(context, Object.class);
        Assert.assertEquals(null, result3);

        //3.给root对象属性赋值
        context.setRootObject(date);
        int result4 = parser.parseExpression("Year = 4").getValue(context, int.class);
        Assert.assertEquals(4, result4);
        parser.parseExpression("Year").setValue(context, 5);
        int result5 = parser.parseExpression("Year").getValue(context, int.class);
        Assert.assertEquals(5, result5);
    }

    // 八、对象方法调用
    // 对象方法调用更简单，跟Java语法一样；如“'haha'.substring(2,4)”将返回“ha”；而对于根对象可以直接调用方法；
    @Test
    public void testMethodExpression() {
        ExpressionParser parser = new SpelExpressionParser();
        Date date = new Date();
        StandardEvaluationContext context = new StandardEvaluationContext(date);
        int result2 = parser.parseExpression("getYear()").getValue(context, int.class);
        Assert.assertEquals(date.getYear(), result2);

//        Calendar calendar = Calendar.getInstance();
//        context = new StandardEvaluationContext(calendar);
//        int result3 = parser.parseExpression("get('Calendar.YEAR')").getValue(context, int.class);
//        Assert.assertEquals(calendar.get(Calendar.YEAR), result3);
    }

    // 九、Bean引用
    // SpEL支持使用“@”符号来引用Bean，在引用Bean时需要使用BeanResolver接口实现来查找Bean，Spring提供BeanFactoryResolver实现；
    @Test
    public void testBeanExpression() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext();
        ctx.refresh();
        ExpressionParser parser = new SpelExpressionParser();
        StandardEvaluationContext context = new StandardEvaluationContext();
        context.setBeanResolver(new BeanFactoryResolver(ctx));
        Properties result1 = parser.parseExpression("@systemProperties").getValue(context, Properties.class);
        Assert.assertEquals(System.getProperties(), result1);
    }

    // 5.3.3  集合相关表达式
    @Test
    public void testCollectionExpression() {
        ExpressionParser parser = new SpelExpressionParser();

        // 一、内联List：
        //将返回不可修改的空List
        List<Integer> result2 = parser.parseExpression("{}").getValue(List.class);
        Assert.assertNotNull(result2);

        //对于字面量列表也将返回不可修改的List
        List<Integer> result1 = parser.parseExpression("{1,2,3}").getValue(List.class);
        Assert.assertEquals(new Integer(1), result1.get(0));
        try {
            result1.set(0, 2);
            //不可能执行到这，对于字面量列表不可修改
            Assert.fail();
        } catch (Exception e) {
            e.printStackTrace();
        }

        //对于列表中只要有一个不是字面量表达式，将只返回原始List，
        //不会进行不可修改处理
        String expression3 = "{{1+2,2+4},{3,4+4}}";
        List<List<Integer>> result3 = parser.parseExpression(expression3).getValue(List.class);
        result3.get(0).set(0, 1);
        Assert.assertEquals(2, result3.size());

        //声明一个大小为2的一维数组并初始化
        int[] result4 = parser.parseExpression("new int[2]{1,2}").getValue(int[].class);

        //定义一维数组但不初始化
        int[] result5 = parser.parseExpression("new int[1]").getValue(int[].class);

        // 二、内联数组：和Java 数组定义类似，只是在定义时进行多维数组初始化。
        //定义多维数组但不初始化
        int[][][] result6 = parser.parseExpression("new int[1][2][3]").getValue(int[][][].class);

        String expression7 = "new int[1][2][3] {{1}{2}{3}}";
        try {
            int[][][] result7 = parser.parseExpression(expression7).getValue(int[][][].class);
            Assert.fail();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 三、集合，字典元素访问：SpEL目前支持所有集合类型和字典类型的元素访问，使用“集合[索引]”访问集合元素，使用“map[key]”访问字典元素；
        // SpEL内联List访问
        int result8 = parser.parseExpression("{1,2,3}[0]").getValue(int.class);
        // 即list.get(0)
        Assert.assertEquals(1, result8);

        //SpEL目前支持所有集合类型的访问
        Collection<Integer> collection = new HashSet<>();
        collection.add(1);
        collection.add(2);
        EvaluationContext context2 = new StandardEvaluationContext();
        context2.setVariable("collection", collection);
        int result9 = parser.parseExpression("#collection[1]").getValue(context2, int.class);
        //对于任何集合类型通过Iterator来定位元素
        Assert.assertEquals(2, result9);

        //SpEL对Map字典元素访问的支持
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("a", 1);
        EvaluationContext context3 = new StandardEvaluationContext();
        context3.setVariable("map", map);
        int result10 = parser.parseExpression("#map['a']").getValue(context3, int.class);
        Assert.assertEquals(1, result10);
    }

    @Test
    public void testCollection2() {
        ExpressionParser parser = new SpelExpressionParser();

        // 四、列表，字典，数组元素修改：可以使用赋值表达式或Expression接口的setValue方法修改
        //1.修改数组元素值
        int[] array = new int[]{1, 2};
        EvaluationContext context1 = new StandardEvaluationContext();
        context1.setVariable("array", array);
        int result11 = parser.parseExpression("#array[1] = 3").getValue(context1, int.class);
        Assert.assertEquals(3, result11);

        //2.修改集合值
        Collection<Integer> collection1 = new ArrayList<>();
        collection1.add(1);
        collection1.add(2);
        EvaluationContext context4 = new StandardEvaluationContext();
        context4.setVariable("collection", collection1);
        int result12 = parser.parseExpression("#collection[1]=3").getValue(context4, int.class);
        Assert.assertEquals(3, result12);
        parser.parseExpression("#collection[1]").setValue(context4, 4);
        result12 = parser.parseExpression("#collection[1]").getValue(context4, int.class);
        Assert.assertEquals(4, result12);

        //3.修改map元素值
        Map<String, Integer> map13 = new HashMap<>();
        map13.put("a", 1);
        EvaluationContext context13 = new StandardEvaluationContext();
        context13.setVariable("map", map13);
        int result13 = parser.parseExpression("#map['a']=2").getValue(context13, int.class);
        Assert.assertEquals(2, result13);

        //五、集合投影 SpEL使用“（list|map）.![投影表达式]”来进行投影运算
        //1.首先准备测试数据
        Collection<Integer> collection = new ArrayList<Integer>();
        collection.add(4);
        collection.add(5);
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("a", 1);
        map.put("b", 2);

        //2.测试集合或数组 其中投影表达式中“#this”代表每个集合或数组元素，可以使用比如“#this.property”来获取集合元素的属性
        EvaluationContext context14 = new StandardEvaluationContext();
        context14.setVariable("collection", collection);
        Collection<Integer> result14 = parser.parseExpression("#collection.![#this+1]").getValue(context14, Collection.class);
        Assert.assertEquals(2, result14.size());
        Assert.assertEquals(new Integer(5), result14.iterator().next());

        //3.测试字典
        EvaluationContext context15 = new StandardEvaluationContext();
        context15.setVariable("map", map);
        List<Integer> result15 = parser.parseExpression("#map.![ value+1]").getValue(context15, List.class);
        Assert.assertEquals(2, result15.size());
    }

    @Test
    public void testCollection3() {
        ExpressionParser parser = new SpelExpressionParser();

        // 六、集合选择 SpEL使用“(list|map).?[选择表达式]”，其中选择表达式结果必须是boolean类型，
        // 如果true则选择的元素将添加到新集合中，false将不添加到新集合中。
        //1.首先准备测试数据
        Collection<Integer> collection = new ArrayList<Integer>();
        collection.add(4);
        collection.add(5);
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("a", 1);
        map.put("b", 2);

        //2.测试集合或数组 如“#collection.?[#this>4]”将选择出集合元素值大于4的所有元素。选择表达式必须返回布尔类型，使用“#this”表示当前元素。
        EvaluationContext context15 = new StandardEvaluationContext();
        context15.setVariable("collection", collection);
        Collection<Integer> result15 = parser.parseExpression("#collection.?[#this>4]").getValue(context15, Collection.class);
        Assert.assertEquals(1, result15.size());
        Assert.assertEquals(new Integer(5), result15.iterator().next());

        //3.字典测试
        EvaluationContext context16 = new StandardEvaluationContext();
        context16.setVariable("map", map);
        Map<String, Integer> result16 = parser.parseExpression("#map.?[#this.key != 'a']").getValue(context16, Map.class);
        Assert.assertEquals(1, result16.size());

        List<Integer> result17 = parser.parseExpression("#map.?[key != 'a'].![value+1]").getValue(context16, List.class);
        Assert.assertEquals(new Integer(3), result17.iterator().next());
        // 5.3.4  表达式模板
    }
}