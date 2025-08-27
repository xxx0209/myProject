package com.itgroup.coffee.service;

import com.itgroup.coffee.domain.Order;

import java.util.List;

public class OrderCalculator {

    //주문한 커피값 계산식
    public int calculatePrice(Order order) {
        return order.getCoffeeMenu().getPrice() * order.getQuantity();
    }

    //주문한 커피값 계산 총합
    public int calculateTotal(List<Order> orderList) {

        int totalPrice = 0;

        for (Order order : orderList) {
            totalPrice += this.calculatePrice(order);
        }
        return totalPrice;
    }
}
