/*
 * Copyright (C), 2014-2017, 杭州小卡科技有限公司
 * FileName: FactoryBeanTest.java
 * Author:   Cheng Zhujiang
 * Date:     2017/5/25 19:38
 * Description: 
 */
package com.jemmy.spring.core.factorybean;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.TimeUnit;

/**
 * FactoryBeanTest
 *
 * @author Cheng Zhujiang
 * @date 2017/5/25
 */
public class FactoryBeanTest {

    @Test
    public void test() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:spring/core/factorybean/factory-bean.xml");
        Car car = ctx.getBean("car", Car.class);
        System.out.println(car.toString());
    }

    @Test
    public void httpClientTest() throws IOException, URISyntaxException, InterruptedException {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:spring/core/factorybean/factory-bean.xml");
        HttpClient httpClient = ctx.getBean("httpClient", HttpClient.class);

        String json = "{\"orderId\":31730,\"bankUser\":\"许涵淋\",\"bankNo\":\"6230200550940048\",\"phone\":\"13656695626\",\"transferAmount\":364872,\"transferStatus\":0,\"remark\":\"申请中\",\"sourceBatchNum\":\"P171012500004246\",\"retCode\":\"0\"}";

        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 50; i++) {
                        try {
                            postData(httpClient, json);
                        } catch (IOException e) {
                            e.printStackTrace();
                        } catch (URISyntaxException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        }

        TimeUnit.SECONDS.sleep(15);
    }

    public static void main(String[] args) throws Exception {
        System.setProperty("log4j.addivity.org.apache", "true");
        System.setProperty("log4j.logger.httpclient", "error");
        System.setProperty("log4j.logger.httpclient.wire.header", "error");
        System.setProperty("log4j.logger.org.apache.commons.httpclient", "error");

        HttpClientFactoryBean factoryBean = new HttpClientFactoryBean();
        HttpClient httpClient = factoryBean.getObject();

        String json = "{\"orderId\":31730,\"bankUser\":\"许涵淋\",\"bankNo\":\"6230200550940048\",\"phone\":\"13656695626\",\"transferAmount\":364872,\"transferStatus\":0,\"remark\":\"申请中\",\"sourceBatchNum\":\"P171012500004246\",\"retCode\":\"0\"}";

        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 50; i++) {
                        try {
                            postData(httpClient, json);
                        } catch (IOException e) {
                            e.printStackTrace();
                        } catch (URISyntaxException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        }

        TimeUnit.SECONDS.sleep(15);
    }

    private static void postData(HttpClient httpClient, String json) throws IOException, URISyntaxException {
        HttpPost request = new HttpPost();

        request.setURI(new URI("http://int.xiaokakeji.com:8091/ins/paycenter/transfer/1.1?debugMode=1"));
        request.addHeader("Content-Type", "application/json");
        HttpEntity entity = new StringEntity(json, "utf-8");
        request.setEntity(entity);
        HttpResponse response = httpClient.execute(request);
        int statusCode = response.getStatusLine().getStatusCode();
        BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        StringBuilder result = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }
        // rd.close();
        System.out.println("Response Code : " + statusCode + " result : " + result.toString());
//        if (statusCode == 200) {
//            System.out.println("Notification sent successfully.");
//        } else {
//            System.out.println("Failed to send the notification!");
//        }
    }

}
