/*
 * Copyright (C), 2014-2017, 杭州小卡科技有限公司
 * FileName: HttpClientFactoryBean.java
 * Author:   Cheng Zhujiang
 * Date:     2017/10/12 19:07
 * Description: 
 */
package com.jemmy.spring.core.factorybean;

import org.apache.http.client.HttpClient;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.beans.factory.FactoryBean;

/**
 * <pre>
 * HttpClientFactoryBean
 *
 * @author Cheng Zhujiang
 * @date 2017/10/12
 */
public class HttpClientFactoryBean implements FactoryBean<HttpClient> {

    /** http连接池的总大小 */
    private int poolMaxTotal = 50;

    /** 每个站点路由下允许的最大连接数，默认为2 */
    private int poolMaxPerRoute = 50;

    /** 重试请求的次数，默认为3 */
    private int retryTimes = 3;

    /** 与目标站点建立连接的最大时间，默认为无限等待 */
    private int connectTimeout = 10 * 1000;

    /** 等待目标站点数据的最大时间，包括连续数据传输时间，默认为-1，表示操作系统默认 */
    private int socketTimeout = 30 * 1000;

    /** 从池中获取请求连接的时间，默认为无限等待 */
    private int connectionRequestTimeout = 5 * 1000;

    @Override
    public HttpClient getObject() throws Exception {
        PoolingHttpClientConnectionManager connManager = new PoolingHttpClientConnectionManager();
        connManager.setMaxTotal(poolMaxTotal);
        connManager.setDefaultMaxPerRoute(poolMaxPerRoute);

        HttpRequestRetryHandler retryHandler = new DefaultHttpRequestRetryHandler(retryTimes, false);

        RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(connectTimeout)
                .setSocketTimeout(socketTimeout).setConnectionRequestTimeout(connectionRequestTimeout).build();

        CloseableHttpClient client = HttpClientBuilder.create().setConnectionManager(connManager)
                .setRetryHandler(retryHandler).setDefaultRequestConfig(requestConfig).build();
        return client;
    }

    @Override
    public Class<?> getObjectType() {
        return HttpClient.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    public void setPoolMaxTotal(int poolMaxTotal) {
        this.poolMaxTotal = poolMaxTotal;
    }

    public void setPoolMaxPerRoute(int poolMaxPerRoute) {
        this.poolMaxPerRoute = poolMaxPerRoute;
    }

    public void setRetryTimes(int retryTimes) {
        this.retryTimes = retryTimes;
    }

    public void setConnectTimeout(int connectTimeout) {
        this.connectTimeout = connectTimeout;
    }

    public void setSocketTimeout(int socketTimeout) {
        this.socketTimeout = socketTimeout;
    }

    public void setConnectionRequestTimeout(int connectionRequestTimeout) {
        this.connectionRequestTimeout = connectionRequestTimeout;
    }
}
