package com.itgroup.coffee.infrastructure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SimpleConnectionProvider implements ConnectionProvider {

    String driver = "oracle.jdbc.driver.OracleDriver";

    public SimpleConnectionProvider() {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            System.out.println("해당 드라이버가 존재하지 않습니다.");
            e.printStackTrace();
        }
    }

    @Override
    public Connection getConnection() throws ClassNotFoundException, SQLException {
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
