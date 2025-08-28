package com.itgroup.cofee.dao;

import com.itgroup.cofee.domain.CoffeeMenu;
import com.itgroup.cofee.domain.CoffeeOption;
import com.itgroup.cofee.domain.Order;
import com.itgroup.cofee.domain.OrderGroup;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDao {

    com.itgroup.cofee.dao.ConnectionProvider connectionProvider;

    public OrderDao(ConnectionProvider connectionProvider) {

        this.connectionProvider = connectionProvider;
    }

    // 시퀀스
    public String getOrderSeq() {
        String sql = "select orders_seq.nextval as seq from dual";

        Connection conn = connectionProvider.getConnection(); //접속 객체 구하기
        PreparedStatement ps = null;
        ResultSet rs = null;

        String strSeq = null;

        try {
            ps = conn.prepareStatement(sql);

            rs = ps.executeQuery();
            if (rs.next()) {
                strSeq = rs.getString("seq");
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

        return strSeq;
    }

    //주문내역 조회하기
    public List<OrderGroup> getOrders(String memberId) {
        String sql = "select order_id, to_char(max(order_date), 'yyyy-mm-dd') as recent_date, sum(price) as total_price, " +
                     " count(*) as order_count, max(drink_name) keep (dense_rank last order by order_date) as last_drink," +
                     " max(drink_option) keep (dense_rank last order by order_date) as last_option" +
                     " from orders where member_id = ? group by order_id order by recent_date desc";




        Connection conn = connectionProvider.getConnection(); //접속 객체 구하기
        PreparedStatement ps = null;
        ResultSet rs = null;

        List<OrderGroup> orders = new ArrayList<OrderGroup>(); //검색된 그룹별 주문

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, memberId);
            rs = ps.executeQuery();
            while (rs.next()) {
                OrderGroup order = new OrderGroup();
                order.setOrderId(rs.getString("order_id"));
                order.setRecentDate(rs.getString("recent_date"));
                order.setTotalPrice(rs.getInt("total_price"));
                order.setOrderCount(rs.getInt("order_count"));
                order.setLastDrink(CoffeeMenu.fromDbValue(rs.getString("last_drink")));
                order.setLastOption(CoffeeOption.fromDbValue(rs.getString("last_option")));
                orders.add(order);
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

        return orders;
    }

    public int saveOrders(Order order) {

        String orderSql = "insert into orders (order_id, member_id, seq, drink_name, drink_option, quantity, price)" +
                          " values(?, ?, ?, ?, ?, ?, ?)";

        String couponSql = "update members set reward = reward + floor((coupon + ?) / 10)," +
                " coupon = mod(coupon + ?, 10)" +
                " where member_id = ?";

        Connection conn = connectionProvider.getConnection(); //접속 객체 구하기
        PreparedStatement ps = null;
        int saveCnt = 0;
        int updateCnt = 0;

        order.setOrderId(this.getOrderSeq());
        order.setSeq(1);

        try {
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(orderSql);
            ps.setString(1, order.getOrderId());
            ps.setString(2, order.getMemberId());
            ps.setInt(3, order.getSeq());
            ps.setString(4, order.getDrinkName().getName());
            ps.setString(5, order.getDrinkOption().getName());
            ps.setInt(6, order.getQuantity());
            ps.setInt(7, order.getDrinkName().getPrice());

            saveCnt = ps.executeUpdate();

            ps = conn.prepareStatement(couponSql);
            ps.setInt(1, order.getQuantity());
            ps.setInt(2, order.getQuantity());
            ps.setString(3, order.getMemberId());

            updateCnt = ps.executeUpdate();

            conn.commit();

        } catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            e.printStackTrace();
        } finally {
            try {
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
        return saveCnt;
    }

    public int[] saveOrders(String memberId, List<Order> orders) {

        String orderSql = "insert into orders (order_id, member_id, seq, drink_name, drink_option, quantity, price) ";
        orderSql += "values(?, ?, ?, ?, ?, ?, ?)";

        String couponSql = "update members set reward = reward + floor((coupon + ?) / 10)," +
                " coupon = mod(coupon + ?, 10)" +
                " where member_id = ?";

        Connection conn = connectionProvider.getConnection(); //접속 객체 구하기
        PreparedStatement ps = null;
        int[] saveCnt = null;
        int updateCnt = 0;

        try {
            String orderId = this.getOrderSeq();

            conn.setAutoCommit(false);
            ps = conn.prepareStatement(orderSql);
            int totalQuantity = 0;
            int seq = 1;
            for (Order order : orders) {
                ps.setString(1, orderId);
                ps.setString(2, memberId);
                ps.setInt(3, seq++);
                ps.setString(4, order.getDrinkName().getName());
                ps.setString(5, order.getDrinkOption().getName());
                ps.setInt(6, order.getQuantity());
                ps.setInt(7, order.getDrinkName().getPrice());

                ps.addBatch(); // 배치에 추가
                totalQuantity += order.getQuantity(); //총 주문수
            }

            saveCnt = ps.executeBatch();

            ps = conn.prepareStatement(couponSql);
            ps.setInt(1, totalQuantity);
            ps.setInt(2, totalQuantity);
            ps.setString(3, memberId);

            updateCnt = ps.executeUpdate();

            conn.commit();

        } catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            throw new RuntimeException(e);
        } finally {
            try {
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
        return saveCnt;
    }
}
