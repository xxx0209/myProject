package com.itgroup.coffee.ui;

import com.itgroup.coffee.domain.Member;

import java.util.Scanner;

public class HomePrinter {

    private final Scanner scan = new Scanner(System.in);

    public void printTop(Member member) {
        System.out.println();
        System.out.println("❆❆❆❆❆" + " COMPOSE COFFEE " + "❆❆❆❆❆❆❆❆❆❆❆❆❆❆❆❆");
        System.out.println(member.getName() + " 님 반가워요!");
        System.out.println("❆❆❆❆❆❆❆❆❆❆❆❆❆❆❆❆❆❆❆❆❆❆❆❆❆❆❆❆❆❆❆❆");
        System.out.println();
    }

    public int printBody() {

        System.out.println();
        System.out.println("메인 메뉴 --------------------------------------");
        System.out.println("닫기(0번), 홈(1번), 주문(2번), 더보기(3번)");
        System.out.print("입력 ✎ : ");

        return scan.nextInt();
    }
}
