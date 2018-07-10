package com.ciao.utils;

import com.alibaba.druid.pool.DruidDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class JDBCUtils {

    private static DruidDataSource dc =  new DruidDataSource();

    static {
        ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
        String driverClassName = bundle.getString("driverClassName");
        String url = bundle.getString("url");
        String username = bundle.getString("username");
        String password = bundle.getString("password");

        dc.setDriverClassName(driverClassName);
        dc.setUrl(url);
        dc.setUsername(username);
        dc.setPassword(password);
    }

    public static Connection getConnection() throws SQLException {
        return dc.getConnection();
    }

    public static DataSource getDataSource(){
        return dc;
    }
}
