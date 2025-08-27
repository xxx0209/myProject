package com.itgroup.composeCofee.service;

import com.itgroup.composeCofee.domain.Order;

import java.util.List;

public class OrderCalculator {

    //주문한 커피값 계산식
    static public int calculatePrice(Order order) {

        return order.getCoffeeMenu().getPrice() * order.getQuantity();
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
