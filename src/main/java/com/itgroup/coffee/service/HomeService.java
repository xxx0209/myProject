package com.itgroup.coffee.service;

import com.itgroup.coffee.domain.Member;

import java.util.Scanner;

public class HomeService {

    private StampService stampService;
    private OrderService orderService;


    public HomeService() {
        this.stampService = new StampService();
        this.orderService = new OrderService();
    }

    public void home() {

        Member member = new Member();
        member.setId("ljy");
        member.setName("이제용");

        System.out.println();
        System.out.println("❆❆❆❆❆" + " COMPOSE COFFEE " + "❆❆❆❆❆");
        System.out.println(member.getName() + " 님 반가워요!");
        System.out.println("❆❆❆❆❆❆❆❆❆❆❆❆❆❆❆❆❆❆❆❆❆");
        System.out.println();

        //회원이 가지고 있는 스탬프
        this.stampService.getStamp();

        System.out.println();
        System.out.println("메인 메뉴 --------------------------------------");
        System.out.println("닫기(0번), 홈(1번), 주문(2번), 더보기(3번)");
        System.out.print("입력 ✎ : ");

        Scanner scan = new Scanner(System.in);
        int menu = scan.nextInt();
        int exit = 0;
        switch (menu) {
            case 0:
                System.out.println("주문이 취소되었습니다.");
                exit = -1;
                break;
            case 1:
                this.home();
                break;
            case 2:
                // this.orderService.orderTemplete();
                break;
            default:
                break;
        }
        //return exit;
    }


}
