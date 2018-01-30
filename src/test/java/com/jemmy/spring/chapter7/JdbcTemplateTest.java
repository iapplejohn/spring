/*
 * Copyright (C), 2014-2017, 杭州小卡科技有限公司
 * FileName: JdbcTemplateTest.java
 * Author:   Cheng Zhujiang
 * Date:     2017/8/13 18:40
 * Description: 
 */
package com.jemmy.spring.chapter7;

import org.junit.*;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.*;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * JdbcTemplateTest
 *
 * @author Cheng Zhujiang
 * @date 2017/8/13
 */
public class JdbcTemplateTest {

    private static JdbcTemplate jdbcTemplate;

    @BeforeClass
    public static void setUpClass() {
        String url = "jdbc:mysql://localhost:3306/test";
        String userName = "root";
        String password = "";
        DriverManagerDataSource dataSource = new DriverManagerDataSource(url, userName, password);
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Test
    public void test() {
        //1.声明SQL
        String sql = "select * from INFORMATION_SCHEMA.INNODB_SYS_TABLES";
        jdbcTemplate.query(sql, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet resultSet) throws SQLException {
                //2.处理结果集
                String value = resultSet.getString("NAME");
                System.out.println("Column NAME:" + value);
            }
        });
    }

    @Before
    public void setUp() {
        String createTableSql = "CREATE TABLE test (\n" +
                "\tid INT NOT NULL AUTO_INCREMENT,\n" +
                "\tname VARCHAR(16) NOT NULL, PRIMARY KEY id (id)\n" +
                ")";
        jdbcTemplate.update(createTableSql);
    }

    @After
    public void tearDown() {
        String dropTableSql = "drop table test";
        jdbcTemplate.execute(dropTableSql);
    }

    @Test
    public void testCRUD() {
        insert();
        delete();
        update();
        select();
    }

    private void insert() {
        jdbcTemplate.update("insert into test(name) values('name1')");
        jdbcTemplate.update("insert into test(name) values('name2')");
        Assert.assertEquals(2, ((Long)jdbcTemplate.queryForMap("select count(*) as count from test").get("count")).intValue());
    }

    private void delete() {
        jdbcTemplate.update("delete from test where name=?", new Object[] { "name2" });
        Assert.assertEquals(1, ((Long)jdbcTemplate.queryForMap("select count(*) as count from test").get("count")).intValue());
    }

    private void update() {
        jdbcTemplate.update("update test set name='name3' where name=?", new Object[] { "name1" });
        Assert.assertEquals(1, ((Long)jdbcTemplate.queryForMap("select count(*) as count from test where name='name3'").get("count")).intValue());
    }

    private void select() {
        jdbcTemplate.query("select * from test", new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet resultSet) throws SQLException {
                System.out.print("====id:" + resultSet.getInt("id"));
                System.out.println(",name:" + resultSet.getString("name"));
            }
        });
    }

    // 1）预编译语句及存储过程创建回调、自定义功能回调使用：
    @Test
    public void testPreparedStatement1() {
        int count = jdbcTemplate.execute(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                return connection.prepareStatement("select count(*) from test");
            }
        }, new PreparedStatementCallback<Integer>() {
            @Override
            public Integer doInPreparedStatement(PreparedStatement preparedStatement) throws SQLException, DataAccessException {
                preparedStatement.execute();
                ResultSet rs = preparedStatement.getResultSet();
                rs.next();
                return rs.getInt(1);
            }
        });
        Assert.assertEquals(0, count);
    }

    // 2）预编译语句设值回调使用：
    @Test
    public void testPreparedStatement2() {
        String insertSql = "insert into test(name) values (?)";
        int count = jdbcTemplate.update(insertSql, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement) throws SQLException {
                preparedStatement.setObject(1, "name4");
            }
        });
        Assert.assertEquals(1, count);

        String deleteSql = "delete from test where name=?";
        count = jdbcTemplate.update(deleteSql, new Object[] { "name4" });
        Assert.assertEquals(1, count);
    }
}
