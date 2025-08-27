package com.itgroup;

import com.itgroup.coffee.domain.Member;
import com.itgroup.coffee.service.OrderService;
import com.itgroup.coffee.service.StampService;
import com.itgroup.coffee.ui.HomePrinter;
import com.itgroup.coffee.ui.StampPrinter;

public class Main_Backup {
    public static void main(String[] args) {

        //회원정보 가져오기
        Member member = new Member();
        member.setId("ljy");
        member.setName("이제용");

        HomePrinter homePrinter = new HomePrinter();
        StampPrinter stampPrinter = new StampPrinter();

        OrderService orderService = new OrderService();
        StampService stampService = new StampService();

        //메인화면 상단 출력
        homePrinter.printTop(member);
        stampPrinter.printStamp();

        boolean running = true;

        while (running) {
            //메인화면 바디 출력
            int choice = homePrinter.printBody();

            switch (choice) {
                case 0:
                    running = false;
                    break;
                case 1:
                    break;
                case 2:
                    orderService.orderTemplate(member);
                    break;
                case 3:
                    stampService.stampTemplate(member);
                    break;
            }
        }
        System.out.println("프로그램 종료");
    }
}