package com.itgroup.cofee.service;

import com.itgroup.cofee.dao.OrderDao;
import com.itgroup.cofee.domain.*;
import com.itgroup.cofee.dao.DaoFactory;
import com.itgroup.cofee.domain.Order;

import java.util.List;

public class OrderService {

    private final OrderDao orderDao;

    public OrderService() {
        this.orderDao = new DaoFactory().orderDao();
    }

    //주문 등록
    public int saveOrders(Order order) {
        // DB 저장
        return this.orderDao.saveOrders(order);
    }

    //주문 등록
    public int[] saveOrders(String memberId, List<Order> orders) {
        // DB 저장
        return this.orderDao.saveOrders(memberId, orders);
    }

}
