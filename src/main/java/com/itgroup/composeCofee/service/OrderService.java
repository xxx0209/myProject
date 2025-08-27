package com.itgroup.composeCofee.service;

import com.itgroup.composeCofee.dao.OrderDao;
import com.itgroup.composeCofee.domain.*;
import com.itgroup.composeCofee.dao.DaoFactory;
import com.itgroup.composeCofee.domain.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderService {

    private final OrderDao orderDao;

    public OrderService() {
        this.orderDao = new DaoFactory().orderDao();
    }

    // 주문 등록
    public int insertOrder(Order order) {
        return 1;
    }

    //임시 장바구니 주문 등록
    public void saveOrders(List<Order> orders, Member member) {

        // DB 저장
        this.orderDao.saveOrders(orders);
//        member.setReward(newStamp);
//        memberDAO.updateStamp(member);
    }

    //주문내역 조회
    public List<Order> getOrderList(String id) {
        System.out.println("주문내역 리스트를 보여준다.");
        return null;
    }
}
