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

    private boolean running = true;
    private boolean isLogin = false;
    private Member member;

    private final LoginController loginController = new LoginController(new LoginView());
    private final HomeController homeController = new HomeController(new HomeView());
    private final OrderController orderController = new OrderController(new OrderView());
    private final MoreController moreController = new MoreController(new MoreView());

    private void run() throws Exception {
        while (running) {
            // 로그인 처리
            if (!isLogin) {
                login();
                continue;
            }

            // 홈 메뉴 처리
            processHomeMenu();
        }

        System.out.println("\n프로그램을 종료합니다.");
    }

    //로그인
    private void login() throws Exception {

        member = loginController.process(new Member());
        if (member == null) {
            int choice = loginController.retry();
            switch (choice) {
                case 0 : running = false; break;
                case 1 : break;
            }
        } else {
            isLogin = true;
        }
    }

    /** 홈 메뉴 선택 처리 */
    private void processHomeMenu() throws Exception {
        int choice = homeController.process(member);

        switch (choice) {
            case 0 : running = false; break;                 // 종료
            case 1 : orderController.process(member); break; // 주문 화면
            case 2 : moreController.process(member); break; // 더보기 화면
            case 3 : logout(); break;                       // 로그아웃
            default : System.out.println("잘못된 선택입니다.");
        }
    }

    /** 로그아웃 처리 */
    private void logout() {
        member = null;
        isLogin = false;
        loginController.logout();
    }

    public static void main(String[] args) throws Exception {
        Main app = new Main();
        app.run();
    }

}