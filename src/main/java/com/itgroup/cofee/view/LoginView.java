package com.itgroup.cofee.view;

import com.itgroup.cofee.domain.Member;

import java.util.Scanner;

public class LoginView {

    private final Scanner scan = new Scanner(System.in);

    public Member printLogin(Member member) {
        System.out.println();
        System.out.println("======== LOGIN ======== ");
        System.out.print("ID :");
        String id = scan.next();
        System.out.print("PASSWORD :");
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
}
