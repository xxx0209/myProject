package com.itgroup.cofee.view;

import com.itgroup.cofee.domain.Member;

import java.util.Scanner;

public class LoginView extends View {

    public Member printLogin(Member member) {
        System.out.println();
        System.out.println("======== LOGIN ======== ");
        System.out.print("ID : ");
        String id = scan.next();
        System.out.print("PASSWORD : ");
        String password = scan.next();
        member.setMemberId(id);
        member.setPassword(password);
        System.out.println();

        return member;
    }

    public void printLogOut() {
        System.out.println();
        System.out.println("로그 아웃 되었습니다.");
    }

    public int printRetry() {

        System.out.println("로그인에 실패 하였습니다.");
        System.out.println("종료(0번), 재시도(1번)");
        return this.printChoiceNumber(0, 1);
    }
}
