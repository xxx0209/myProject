package com.itgroup.cofee.controller;

import com.itgroup.cofee.service.OrderCalculator;
import com.itgroup.cofee.domain.*;
import com.itgroup.cofee.service.OrderService;
import com.itgroup.cofee.view.OrderView;

import java.util.ArrayList;
import java.util.List;

public class OrderController {
    
    private final OrderView orderView;
    private final OrderService orderService;

    public OrderController(OrderView orderView) {
        this.orderView = orderView;
        this.orderService = new OrderService();
    }

    public void process(Member member) {

        List<Order> wishList = new ArrayList<>();
        Order order = new Order();
        order.setMemberId(member.getMemberId());
        OrderStep step = OrderStep.MENU;

        while (true) {
            switch (step) {
                case HOME: //메인메뉴
                    return;
                case MENU: { //주문메뉴
                    int choice = orderView.printMenu();

                    if (choice == 0) {
                        step = OrderStep.HOME; //이전화면으로
                        continue;
                    } else if (choice == 1) {
                        order.setDrinkName(CoffeeMenu.AMERICANO);
                    } else if (choice == 2) {
                        order.setDrinkName(CoffeeMenu.CAFELATTE);
                    } else if (choice == 3) {
                        order.setDrinkName(CoffeeMenu.ESPRESSO);
                    }
                    step = OrderStep.OPTION;
                    break;

                }
                case OPTION: { //옵션 선택
                    int choice = orderView.printOption(); //옵션화면

                    if (choice == 0) {
                        step = OrderStep.MENU; //이전화면으로
                        continue;
                    } else if (choice == 1) {
                        order.setDrinkOption(CoffeeOption.HOT);
                    } else if (choice == 2) {
                        order.setDrinkOption(CoffeeOption.ICED);
                    }
                    step = OrderStep.QUANTITY;
                    break;

                }
                case QUANTITY: { //수량 선택
                    int cnt = orderView.printQuantity();
                    if (cnt > 0) {
                        order.setQuantity(cnt);
                        step = OrderStep.WISH; //주문담기
                    } else {
                        step = OrderStep.OPTION; // 이전화면으로
                    }
                    break;
                }
                case WISH: { //주문 내역 확인
                    int totalPrice = OrderCalculator.calculatePrice(order);
                    int choice = orderView.printWish(order, totalPrice);

                    if (choice == 0) {
                        step = OrderStep.QUANTITY; // 이전화면으로
                        continue;
                    } else if (choice == 1) {
                        wishList.add(order); //임시 주문내역 담기
                        order = new Order(); // 새로운 주문 객체
                        order.setMemberId(member.getMemberId());
                        step = OrderStep.WISHCART; //임시 장바구니 화면
                    } else if (choice == 2) {
                        step = OrderStep.LAST; //주문 바로하기
                    }
                    break;
                }
                case LAST: { //결제하기

                    int totalPrice = OrderCalculator.calculatePrice(order);
                    int choice = orderView.printFinalOrder(order, totalPrice);

                    if (choice == 0) {
                        step = OrderStep.WISH;
                    } else if (choice == 1) {
                        orderService.saveOrders(order);
                        orderView.printOrderComplete();
                        step = OrderStep.HOME;
                    }
                    break;
                }
                case WISHCART: { //장바구니
                    int choice = orderView.printWish(); // 메뉴를 장바구니에 담았어요

                    if (choice == 0) {
                        step = OrderStep.MENU;
                    } else if (choice == 1) {
                        step = OrderStep.WISHLAST;
                    }
                    break;
                }
                case WISHLAST: { //장바구니 결제 하기
                    int totalPrice = OrderCalculator.calculateTotal(wishList);
                    int choice = orderView.printFinalOrder(wishList, totalPrice);
                    if (!wishList.isEmpty()) {
                        Order copyOrder = wishList.get(wishList.size() - 1);
                        order.setMemberId(copyOrder.getMemberId());
                        order.setQuantity(copyOrder.getQuantity());
                        order.setDrinkName(copyOrder.getDrinkName());
                        order.setDrinkOption(copyOrder.getDrinkOption());

                    } else {
                        System.out.println("여기 들어오면 오류임");
                    }

                    if (choice == 0) {
                        step = OrderStep.WISH;
                    } else if (choice == 1) {
                        orderService.saveOrders(order.getMemberId(), wishList);
                        orderView.printOrderComplete();
                        step = OrderStep.HOME;
                    }
                    break;
                }
            }
        }

    }
}
