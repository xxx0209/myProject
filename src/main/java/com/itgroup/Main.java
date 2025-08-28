package com.itgroup;

import com.itgroup.cofee.controller.HomeController;
import com.itgroup.cofee.controller.LoginController;
import com.itgroup.cofee.controller.MoreController;
import com.itgroup.cofee.controller.OrderController;
import com.itgroup.cofee.domain.Member;
import com.itgroup.cofee.view.HomeView;
import com.itgroup.cofee.view.LoginView;
import com.itgroup.cofee.view.MoreView;
import com.itgroup.cofee.view.OrderView;

//프로그램의 전체적인 흐름 제어
public class Main {
    public static void main(String[] args) throws Exception {

        // 회원 정보
        Member member = null;

        LoginView loginView = new LoginView();
        LoginController loginController = new LoginController(loginView);

        // 01. 로그인 화면 및 로그인 처리
        boolean isLogin = false;
        boolean running = true;

        logout:
        while (running) {
            while (!isLogin) {
                member = loginController.process(new Member());
                if (member == null) {
                    System.out.println("로그인 실패 하였습니다.");

                } else {
                    isLogin = true;
                }
            }

            // 02. 홈 화면
            HomeView homeView = new HomeView();
            HomeController homeController = new HomeController(homeView);

            // 03. 주문화면
            OrderView orderView = new OrderView();
            OrderController orderController = new OrderController(orderView);

            // 04. 더보기 화면
            MoreView moreView = new MoreView();
            MoreController moreController = new MoreController(moreView);

            while (running) {
                int choice = homeController.process(member);
                switch (choice) {
                    case 0: {
                        running = false;
                        break ;
                    }
                    case 1: {
                        orderController.process(member);
                        break;
                    }
                    case 2: {
                        moreController.process(member);
                        break;
                    }
                    case 3: {
                        member = null;
                        isLogin = false;
                        continue logout;
                    }
                }

            }
        }
        System.out.println();
        System.out.println("프로그램을 종료합니다.");
    }
}