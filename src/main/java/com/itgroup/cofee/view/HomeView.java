package com.itgroup.cofee.view;

import com.itgroup.cofee.domain.Member;

import java.util.Scanner;

public class HomeView extends View{

    public void printTop(Member member) {
        System.out.println();
        System.out.println("❆❆❆❆❆" + " COMPOSE COFFEE " + "❆❆❆❆❆❆❆❆❆❆❆❆❆❆❆❆");
        System.out.println(member.getName() + " 님 반가워요!");
        System.out.println("스탬프 " + member.getCoupon() + " 개");
        System.out.println("리워드 " + member.getReward() + " 개");
        System.out.println("❆❆❆❆❆❆❆❆❆❆❆❆❆❆❆❆❆❆❆❆❆❆❆❆❆❆❆❆❆❆❆❆");

    }

    public int printMenu() {

        System.out.println();
        System.out.println("메인 메뉴 --------------------------------------");
        System.out.println("종료(0번), 주문(1번), 더보기(2번)");
        return this.printChoiceNumber(0, 2);
    }
}
