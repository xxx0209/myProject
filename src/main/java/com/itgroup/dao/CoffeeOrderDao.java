package com.itgroup.dao;

import com.itgroup.api.SimpleConnection;
import com.itgroup.bean.Order;
import java.sql.Connection;
import java.sql.SQLException;

public class CoffeeOrderDao {
    private SimpleConnection simpleConnection;

    public CoffeeOrderDao(SimpleConnection simpleConnection) {
        simpleConnection = simpleConnection;
    }

    public void order(Order order) {
        try {
            Connection conn = simpleConnection.getConnection();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void get(Order order) {

    }
}
