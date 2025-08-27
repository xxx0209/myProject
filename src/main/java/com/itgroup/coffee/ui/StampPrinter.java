package com.itgroup.coffee.ui;

import com.itgroup.coffee.domain.Member;
import com.itgroup.coffee.domain.Order;

import java.util.Scanner;

public class StampPrinter {

    private final Scanner scan = new Scanner(System.in);

    public int printMenu() {
        System.out.println();
        System.out.println("더보기 메뉴 --------------------------------------");
        System.out.println("홈(0번), 스탬프&리워드(1번), 주문내역(2번), 회원정보(미구현)");
        System.out.print("입력 ✎ : ");
        return scan.nextInt();
    }

    public void printStamp() {

        System.out.print("스탬프 도장(리워드 : 1) ");
        System.out.println("☕\s☕\s☕\s〇\s〇\s〇\s〇\s〇\s〇\s〇");
    }

    public int printStamp(Member member) {

        System.out.println();
        System.out.print("스탬프 도장(리워드 : 1) ");
        System.out.println("☕\s☕\s☕\s〇\s〇\s〇\s〇\s〇\s〇\s〇");
        System.out.println("닫기(0번)");
        System.out.print("입력 ✎ : ");
        return scan.nextInt();
    }
}
