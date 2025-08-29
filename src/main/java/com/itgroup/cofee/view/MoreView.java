package com.itgroup.cofee.view;

import com.itgroup.cofee.domain.*;

import java.util.List;
import java.util.Scanner;

public class MoreView extends View{

    public int printMenu() {
        System.out.println();
        System.out.println("더보기 메뉴 --------------------------------------");
        System.out.println("홈(0번), 스탬프&리워드(1번), 주문내역(2번), 회원정보(3번)");
        return this.printChoiceNumber(0, 3);
    }

    public int printStamp(Stamp stamp) {

        System.out.println();
        System.out.println("스탬프 및 리워드 --------------------------------------");
        System.out.print("스탬프("+stamp.getCoupon()+"개) ");
        String coupon = "";
        for (int i = 0; i < 10; i++) {
            if(i < stamp.getCoupon()) {
                coupon = coupon + "● ";
            } else {
                coupon = coupon + "○ ";
            }
        }
        System.out.print(coupon);
        System.out.print("(스탬프 10장을 모으면 리워드 1개 제공)");
        System.out.println();
        System.out.print("리워드("+stamp.getReward()+"개) ");
        String reward = "";
        for (int i = 0; i < stamp.getReward(); i++) {
            if(i < stamp.getCoupon()) {
                reward = reward + "♣ ";
            }
        }
        System.out.print(reward);
        System.out.print("(리워드 쿠폰은 주문당 1건만 사용 가능)");
        System.out.println();
        System.out.println();
        System.out.println("닫기(0번)");
        return this.printChoiceNumber(0, 0);
    }

    public int printOderHistory(List<OrderGroup> orders) {

        System.out.println();
        System.out.println("주문내역 --------------------------------------");

        for(OrderGroup order : orders) {
            String str = " ";
            if (order.getOrderCount() > 1) {
                str = " 외 " + (order.getOrderCount() - 1) + "건 ";
            }
            System.out.println("주문번호 " + order.getOrderId() + " : " + order.getRecentDate() + " " + order.getLastDrink().getName() + str + df.format(order.getTotalPrice())+ "원 결제");
        }
        System.out.println();
        System.out.println("닫기(0번)");
        return this.printChoiceNumber(0, 0);
    }

    public int printMemberInfo(Member member) {

        System.out.println();
        System.out.println("회원 정보 --------------------------------------");
        System.out.println("ID : " + member.getMemberId());
        System.out.println("이름 : " + member.getName());
        System.out.println("전화번호 : " + member.getPhone());
        System.out.println("가입일 : " + member.getJoinDate());
        System.out.println();
        System.out.println("닫기(0번)");
        return this.printChoiceNumber(0, 0);
    }


}
