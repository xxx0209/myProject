package com.itgroup.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SimpleConnection {

    String driver = "oracle.jdbc.driver.OracleDriver";

    public SimpleConnection() {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            System.out.println("해당 드라이버가 존재하지 않습니다.");
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String id = "ljy";
        String password = "ljy";

        Connection conn = null;

        try {
            conn = DriverManager.getConnection(url, id, password);
        } catch (SQLException e) {
            System.out.println("해당 접속에 실패 하였습니다.");
            e.printStackTrace();
        }
        return conn;
    }
}
