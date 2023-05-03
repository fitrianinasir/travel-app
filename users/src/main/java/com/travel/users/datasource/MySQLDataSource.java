package com.travel.users.datasource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLDataSource {
    private static final Logger LOGGER = LoggerFactory.getLogger(MySQLDataSource.class.getPackageName());
    public static final String JDBC_URL = "jdbc:mysql://localhost:3306/transaction";
    public static final String JDBC_USERNAME = "root";
    public static final String JDBC_PASSWORD = "";
    public MySQLDataSource(){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
            LOGGER.info("connection successfully");
        }catch (SQLException e){
            e.printStackTrace();
            LOGGER.info("connection failed");
        }finally {
            try{
                if(connection!=null){
                    connection.close();
                }
            }catch (Exception e){
            }
        }
    }

}
