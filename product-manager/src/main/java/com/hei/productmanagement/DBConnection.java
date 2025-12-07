package com.hei.productmanagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private String URL = "jdbc:postgresql://localhost:5432/product_management_db";
    private String username = "product_manager_user";
    private String password = "123456";

    public Connection getDBConnection(){
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(URL, username, password);
        } catch (SQLException e) {
            System.out.println(e);
        }

        return connection;
    }
}
