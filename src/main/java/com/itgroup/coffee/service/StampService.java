package com.itgroup.coffee.service;

import com.itgroup.coffee.domain.Member;
import com.itgroup.coffee.domain.MoreStep;
import com.itgroup.coffee.domain.Step;
import com.itgroup.coffee.factory.DaoFactory;
import com.itgroup.coffee.infrastructure.StampDao;
import com.itgroup.coffee.ui.StampPrinter;

public class StampService {

    private final StampDao stampDao;
    private final StampPrinter printer;

    public StampService() {
        this.stampDao = new DaoFactory().stampDao();
        this.printer = new StampPrinter();
    }

    public void stampTemplate(Member member) {
        Step step = new Step();
        step.setMoreStep(MoreStep.MENU);
        while (true) {
            switch (step.getMoreStep()) {
                case HOME: //홈
                    return;
                case MENU: {
                    int choice = printer.printMenu();
                    switch (choice) {
                        case 0 : {
                            step.setMoreStep(MoreStep.HOME);
                            break;
                        }
                        case 1 : {
                            step.setMoreStep(MoreStep.STAMP);
                            break;
                        }
                        case 3 : {
                            step.setMoreStep(MoreStep.ORDERS);
                            break;
                        }
                        case 4 : {
                            step.setMoreStep(MoreStep.MEMBER);
                            break;
                        }
                    }
                    break;
                }
                case STAMP: { //스템프 및 리워드
                    int choice = printer.printStamp(member);
                    switch (choice) {
                        case 0: {
                            step.setMoreStep(MoreStep.MENU);
                            break;
                        }
                    }
                    break;
                }
                case ORDERS: { //주문 내역
                    System.out.println("주문 내역 미구현");
                    break;
                }
                case MEMBER: { //회원 정보
                    System.out.println("회원정보 미구현");
                    break;
                }
            }
        }
    }

    public void getStamp() {
        System.out.print("스탬프 도장(리워드 : 1) ");
        System.out.println("☕\s☕\s☕\s〇\s〇\s〇\s〇\s〇\s〇\s〇");
    }
}
