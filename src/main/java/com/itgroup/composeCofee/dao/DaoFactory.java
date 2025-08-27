package com.itgroup.composeCofee.dao;

import com.itgroup.composeCofee.dao.ConnectionProvider;
import com.itgroup.composeCofee.dao.OrderDao;
import com.itgroup.composeCofee.dao.SimpleConnectionProvider;
import com.itgroup.composeCofee.dao.StampDao;


public class DaoFactory {

    public OrderDao orderDao() {
        return new OrderDao(this.getConnection());
    }

    public StampDao stampDao() {
        return new StampDao(this.getConnection());
    }

    public ConnectionProvider getConnection() {
        return new SimpleConnectionProvider();
    }

}
