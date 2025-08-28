package com.itgroup.cofee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StampDao {
    ConnectionProvider connectionProvider;

    public StampDao(ConnectionProvider connectionProvider) {
        this.connectionProvider = connectionProvider;
    }

    //스탬프 개수 조회하기
    public int getStampCount(String id) throws ClassNotFoundException, SQLException {
        String sql = "select count(*) from order where id = ?";

        Connection conn = connectionProvider.getConnection(); //접속 객체 구하기
        PreparedStatement ps = null;
        ResultSet rs = null;

        int cnt = 0; //검색된 스탬프 개수

        try {

            ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                cnt = rs.getInt("cnt");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        return cnt;
    }
}
