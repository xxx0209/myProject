package com.itgroup.coffee.service;

import com.itgroup.coffee.domain.*;
import com.itgroup.coffee.factory.DaoFactory;
import com.itgroup.coffee.infrastructure.OrderDao;
import com.itgroup.coffee.ui.OrderPrinter;

import java.util.ArrayList;
import java.util.List;

public class OrderService {

    private final OrderDao orderDao;
    private final OrderPrinter printer;
    private final OrderCalculator calculator;

    public OrderService() {
        this.orderDao = new DaoFactory().orderDao();
        this.printer = new OrderPrinter();
        this.calculator = new OrderCalculator();
    }

    //커피주문 탬플릿
    public void orderTemplate(Member member) {
        List<Order> orderList = new ArrayList<>();
        Order order = new Order();

        //메뉴선택
        order.setOrderStep(OrderStep.MENU);

        while (true) {
            switch (order.getOrderStep()) {
                case HOME: //메인메뉴
                    return;
                case MENU: { //주문메뉴
                    int choice = printer.printMenu();
                    switch (choice) {
                        case 0: {
                            order.setOrderStep(OrderStep.HOME);
                            break;
                        }
                        case 1: {
                            order.setCoffeeMenu(CoffeeMenu.AMERICANO);
                            order.setOrderStep(OrderStep.OPTION);
                            break;
                        }
                        case 2: {
                            order.setCoffeeMenu(CoffeeMenu.CAFELATTE);
                            order.setOrderStep(OrderStep.OPTION);
                            break;
                        }
                        case 3: {
                            order.setCoffeeMenu(CoffeeMenu.ESPRESSO);
                            order.setOrderStep(OrderStep.OPTION);
                            break;
                        }
                        default: {
                            printer.printWrongNumber();
                            order.setOrderStep(OrderStep.MENU); //이전화면으로
                            break;
                        }
                    }
                    break;
                }
                case OPTION: { //옵션 선택
                    int choice = printer.printOption(); //옵션화면
                    switch (choice) {
                        case 0: {
                            order.setOrderStep(OrderStep.MENU); //이전화면으로
                            break;
                        }
                        case 1: {
                            order.setCoffeeOption(CoffeeOption.HOT);
                            order.setOrderStep(OrderStep.QUANTITY);
                            break;
                        }
                        case 2: {
                            order.setCoffeeOption(CoffeeOption.ICED);
                            order.setOrderStep(OrderStep.QUANTITY);
                            break;
                        }
                        case 3: {
                            order.setCoffeeMenu(CoffeeMenu.ESPRESSO);
                            order.setOrderStep(OrderStep.QUANTITY);
                            break;
                        }
                        default:
                            printer.printWrongNumber();
                            order.setOrderStep(OrderStep.MENU);
                            break;
                    }
                    break;
                }
                case QUANTITY: { //수량 선택
                    int cnt = printer.printQuantity();
                    if (cnt > 0) {
                        order.setQuantity(cnt);
                        order.setOrderStep(OrderStep.WISH); //주문담기
                    } else {
                        order.setOrderStep(OrderStep.OPTION); // 이전화면으로
                    }
                    break;
                }
                case WISH: { //주문 내역 확인
                    int totalPrice = calculator.calculatePrice(order);
                    int choice = printer.printWish(order, totalPrice);

                    switch (choice) {
                        case 0: {
                            order.setOrderStep(OrderStep.QUANTITY); // 이전화면으로
                            break;
                        }
                        case 1: {
                            orderList.add(order); //임시 주문내역 담기
                            order = new Order(); // 새로운 주문 객체
                            order.setOrderStep(OrderStep.WISHCART); //다시 메뉴를 선택하기 위해 메뉴 화면으로
                            break;
                        }
                        case 2: {
                            order.setOrderStep(OrderStep.LAST); //주문 바로하기
                            break;
                        }
                    }
                    break;
                }
                case LAST: { //결제하기
                    int totalPrice = calculator.calculatePrice(order);
                    int choice = printer.printFinalOrder(order, totalPrice);

                    switch (choice) {
                        case 0: {
                            order.setOrderStep(OrderStep.WISH);
                            break;
                        }
                        case 1: {
                            System.out.println("주문이 완료되었습니다.");
                            //orderDao.save(orderList); // DB 저장 처리
                            order.setOrderStep(OrderStep.HOME);
                            break;
                        }
                    }
                    break;
                }
                case WISHCART: { //장바구니
                    int choice = printer.printWish(); // 메뉴를 장바구니에 담았어요

                    switch (choice) {
                        case 0: {
                            order.setOrderStep(OrderStep.MENU);
                            break;
                        }
                        case 1: {
                            order.setOrderStep(OrderStep.WISHLAST);
                            break;
                        }
                    }
                    break;
                }
                case WISHLAST: { //장바구니 결제 하기
                    int totalPrice = calculator.calculateTotal(orderList);
                    int choice = printer.printFinalOrder(orderList, totalPrice);

                    if (!orderList.isEmpty()) {
                        Order copyOrder = orderList.get(orderList.size() - 1);
                        order.setId(copyOrder.getId());
                        order.setQuantity(copyOrder.getQuantity());
                        order.setCoffeeMenu(copyOrder.getCoffeeMenu());
                        order.setCoffeeOption(copyOrder.getCoffeeOption());

                    } else {
                        System.out.println("리스트가 비어 있습니다.");
                    }

                    switch (choice) {
                        case 0: {
                            order.setOrderStep(OrderStep.WISH);
                            break;
                        }
                        case 1: {
                            System.out.println("주문이 완료되었습니다.");
                            System.out.println("장바구니 삭제처리 해야함.");
                            order.setOrderStep(OrderStep.HOME);
                            break;
                        }
                    }
                    break;
                }
            }
        }
    }

    //주문내역
    public void orderList(String id) {
        System.out.println("주문내역 리스트를 보여준다.");
    }
}
