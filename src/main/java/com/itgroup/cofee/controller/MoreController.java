package com.itgroup.cofee.controller;


import com.itgroup.cofee.domain.*;
import com.itgroup.cofee.service.MoreService;
import com.itgroup.cofee.view.MoreView;

import java.util.ArrayList;
import java.util.List;

public class MoreController {
    private final MoreView moreView;
    private final MoreService moreService;


    public MoreController(MoreView moreView) {
        this.moreView = moreView;
        moreService = new MoreService();
    }

    public void process(Member member) {

        List<Order> orderList = new ArrayList<>();
        Order order = new Order();
        MoreStep step = MoreStep.MENU;

        while (true) {
            switch (step) {
                case HOME: //홈
                    return;
                case MENU: {
                    int choice = moreView.printMenu();

                    if (choice == 0) {
                        step = MoreStep.HOME;
                    } else if (choice == 1) {
                        step = MoreStep.STAMP;
                    } else if (choice == 2) {
                        step = MoreStep.ORDERS;
                    } else if (choice == 3) {
                        step = MoreStep.MEMBER;
                    }
                    break;
                }
                case STAMP: { //스템프 및 리워드

                    Stamp stamp = moreService.getStampInfo(member.getMemberId());

                    int choice = moreView.printStamp(stamp);

                    if (choice == 0) {
                        step = MoreStep.MENU;
                    }
                    break;
                }
                case ORDERS: { //주문 내역

                    List<OrderGroup> orders = moreService.getOrders(member.getMemberId());

                    int choice = moreView.printOderHistory(orders);

                    if (choice == 0) {
                        step = MoreStep.MENU;
                    }
                    break;
                }
                case MEMBER: { //회원 정보
                    int choice = moreView.printMemberInfo(member);

                    if (choice == 0) {
                        step = MoreStep.MENU;
                    }
                    break;
                }
            }
        }
    }
}
