package com.itgroup.cofee.dao;

import com.itgroup.cofee.domain.Member;
import com.itgroup.cofee.domain.Order;
import com.itgroup.cofee.domain.Stamp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class MemberDao {

    ConnectionProvider connectionProvider;

    public MemberDao(ConnectionProvider connectionProvider) {

        this.connectionProvider = connectionProvider;
    }

    public Member login(String id, String password) {

        Member member = null;

        String sql = "select * from members where member_id = ? and password = ?";

        Connection conn = connectionProvider.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ps.setString(2, password);
            rs = ps.executeQuery();
            if (rs.next()) {
                member = new Member();
                member.setMemberId(rs.getString("member_id"));
                member.setPassword(rs.getString("password"));
                member.setPhone(rs.getString("phone"));
                member.setName(rs.getString("name"));
                member.setReward(rs.getInt("reward"));
                member.setJoinDate(String.valueOf(rs.getDate("join_date")));
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
        return member;

    }

    //회원의 스탬프/리워드 조회하기
    public Stamp getStampInfo(String id) {
        String sql = "select coupon, reward  from members where member_id = ?";

        Connection conn = connectionProvider.getConnection(); //접속 객체 구하기
        PreparedStatement ps = null;
        ResultSet rs = null;

        Stamp stamp = null; //검색된 스탬프/리워드

        try {

            ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                stamp = new Stamp();
                stamp.setCoupon(rs.getInt("coupon"));
                stamp.setReward(rs.getInt("reward"));
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

        return stamp;
    }
}
