package com.itgroup.coffee.factory;

import com.itgroup.coffee.infrastructure.ConnectionProvider;
import com.itgroup.coffee.infrastructure.SimpleConnectionProvider;
import com.itgroup.coffee.infrastructure.OrderDao;
import com.itgroup.coffee.infrastructure.StampDao;


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
