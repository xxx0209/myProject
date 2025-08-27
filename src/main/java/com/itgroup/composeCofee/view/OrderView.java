package com.itgroup.composeCofee.view;

import com.itgroup.composeCofee.domain.CoffeeMenu;
import com.itgroup.composeCofee.domain.CoffeeOption;
import com.itgroup.composeCofee.domain.Order;

import java.util.List;
import java.util.Scanner;

public class OrderView {

    private final Scanner scan = new Scanner(System.in);

    public int printMenu() {
        System.out.println();
        System.out.println("주문 메뉴 --------------------------------------");
        System.out.println("이전(0번), " + CoffeeMenu.ESPRESSO + "(1번), " + CoffeeMenu.AMERICANO + "(2번), " + CoffeeMenu.CAFELATTE + "(3번)");
        System.out.print("입력 ✎ : ");
        return scan.nextInt();
    }

    public int printOption() {
        System.out.println();
        System.out.println("옵션 선택 --------------------------------------");
        System.out.println("이전(0번), " + CoffeeOption.HOT + "(1번), " + CoffeeOption.ICED + "(2번)");
        System.out.print("입력 ✎ : ");
        return scan.nextInt();
    }

    public int printQuantity() {
        System.out.println();
        System.out.println("수량 선택 --------------------------------------");
        System.out.println("이전(0번), 수량[숫자입력]");
        System.out.print("입력 ✎ : ");
        return scan.nextInt();
    }

    public int printWish(Order order, int totalPrice) {
        System.out.println();
        System.out.println("주문 내역 확인 --------------------------------------");
        System.out.println("선택: " + order.getCoffeeMenu() + " " + order.getCoffeeOption() + " "
                + order.getQuantity() + "잔 → " + totalPrice + "원");
        System.out.println("이전(0번), 담기(1번), 주문하기(2번)");
        System.out.print("입력 ✎ : ");
        return scan.nextInt();
    }

    public int printWish(List<Order> orderList, int sumTotalPrice) {
        System.out.println();
        System.out.println("담기 최종 주문 내역 --------------------------------------");

        int cnt = 1;
        for (Order order : orderList) {
            System.out.println(cnt + ". " + order.getCoffeeMenu() + " " + order.getCoffeeOption()
                    + " " + order.getQuantity() + "잔 → " + order.getCoffeeMenu().getPrice() + "원");
            cnt++;
        }
        System.out.println("총 합계 : " + sumTotalPrice + "원");
        System.out.println("이전(0번), 주문하기(1번)");
        System.out.print("입력 ✎ : ");
        return scan.nextInt();
    }

    public int printWish() {
        System.out.println();
        System.out.println("메뉴를 장바구니에 담았어요 --------------------------------------");

        System.out.println("다른메뉴 담기(0번), 장바구니 이동(1번)");
        System.out.print("입력 ✎ : ");
        return scan.nextInt();
    }

    public int printFinalOrder(Order order, int totalPrice) {
        System.out.println();
        System.out.println("결제하기 --------------------------------------");

        System.out.println(order.getCoffeeMenu() + " " + order.getCoffeeOption()
                + " " + order.getQuantity() + "잔 → " + totalPrice + "원");

        System.out.println("이전(0번), 결제하기(1번)");
        System.out.print("입력 ✎ : ");
        return scan.nextInt();
    }

    public int printFinalOrder(List<Order> orderList, int sumTotalPrice) {
        System.out.println();
        System.out.println("결제하기 --------------------------------------");

        int cnt = 1;
        for (Order order : orderList) {
            int totalPrice = order.getCoffeeMenu().getPrice() * order.getQuantity();
            System.out.println(cnt + ". " + order.getCoffeeMenu() + " " + order.getCoffeeOption()
                    + " " + order.getQuantity() + "잔 → " + totalPrice + "원");
            cnt++;
        }
        System.out.println("총 합계 : " + sumTotalPrice + "원");
        System.out.println("이전(0번), 결제하기(1번)");
        System.out.print("입력 ✎ : ");
        return scan.nextInt();
    }

    public int printOrderComplete() {
        System.out.println();
        System.out.println("주문이 완료 되었습니다.");
        System.out.println("확인(0번)");
        System.out.print("입력 ✎ : ");
        return scan.nextInt();
    }

    public void printWrongNumber() {
        System.out.println("잘못된 번호입니다.");
    }

}
