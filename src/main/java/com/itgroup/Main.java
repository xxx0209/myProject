package com.itgroup;

import com.itgroup.composeCofee.controller.HomeController;
import com.itgroup.composeCofee.controller.MoreController;
import com.itgroup.composeCofee.controller.OrderController;
import com.itgroup.composeCofee.domain.Member;
import com.itgroup.composeCofee.view.HomeView;
import com.itgroup.composeCofee.view.MoreView;
import com.itgroup.composeCofee.view.OrderView;

public class Main {
    public static void main(String[] args) {

        // 회원 정보
        Member member = new Member();
        member.setId("ljy");
        member.setName("이제용");

        HomeView homeView = new HomeView();
        HomeController homeController = new HomeController(homeView);

        OrderView orderView = new OrderView();
        OrderController orderController = new OrderController(orderView);

        MoreView moreView = new MoreView();
        MoreController moreController = new MoreController(moreView);

        boolean running = true;
        while (running) {
            int choice = homeController.process(member);
            switch (choice) {
                case 0 : {
                    running = false;
                    break;
                }
//                case 1 : {
//                    break;
//                }
                case 1 : {
                    orderController.process(member);
                    break;
                }
                case 2 : {
                    moreController.process(member);
                    break;
                }
            }
        }
        System.out.println("프로그램을 종료합니다.");
    }
}