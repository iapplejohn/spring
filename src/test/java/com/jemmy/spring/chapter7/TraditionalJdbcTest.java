/*
 * Copyright (C), 2014-2017, 杭州小卡科技有限公司
 * FileName: TraditionalJdbcTest.java
 * Author:   Cheng Zhujiang
 * Date:     2017/8/13 17:39
 * Description: 
 */
package com.jemmy.spring.chapter7;

import org.junit.Test;

import java.sql.*;

/**
 * TraditionalJdbcTest
 *
 * @author Cheng Zhujiang
 * @date 2017/8/13
 */
public class TraditionalJdbcTest {

    @Test
    public void test() throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement pstmt;

        try {
            conn = getConnection(); //1.获取JDBC连接
            String sql = "select * from INFORMATION_SCHEMA.SYSTEM_TABLES"; // 2.声明SQL
            pstmt = conn.prepareStatement(sql); // 3.预编译SQL
            ResultSet rs = pstmt.executeQuery(); // 4.执行SQL
            process(rs); //5.处理结果集
            closeResultSet(rs); //5.释放结果集
            closeStatement(pstmt); //6.释放Statement
            conn.commit(); //8.提交事务
        } catch (Exception e) {
            //9.处理异常并回滚事务
            conn.rollback();
            throw e;
        } finally {
            //10.释放JDBC连接，防止JDBC连接不关闭造成的内存泄漏
            closeConnection(conn);
        }
    }

    private void closeConnection(Connection conn) {
    }

    private void closeStatement(PreparedStatement pstmt) {

    }

    private void closeResultSet(ResultSet rs) {
    }

    private void process(ResultSet rs) {
    }

    private Connection getConnection() throws SQLException, ClassNotFoundException {
        Class<?> driverClass = Class.forName("com.mysql.Driver");
        Connection conn = DriverManager.getConnection("com.mysql.Driver", "root", "");
        return conn;
    }

}
