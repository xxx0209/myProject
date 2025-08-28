package com.itgroup.cofee.service;

import com.itgroup.cofee.domain.Order;

import java.util.List;

public class OrderCalculator {

    //주문한 커피값 계산식
    static public int calculatePrice(Order order) {

        return order.getDrinkName().getPrice() * order.getQuantity();
    }

    //주문한 커피값 계산 총합
    static public int calculateTotal(List<Order> orderList) {

        int totalPrice = 0;

        for (Order order : orderList) {
            totalPrice += calculatePrice(order);
        }
        return totalPrice;
    }
}
