package com.itgroup.cofee.controller;

import com.itgroup.cofee.domain.Member;
import com.itgroup.cofee.service.LoginService;
import com.itgroup.cofee.view.LoginView;

public class LoginController {

    private final LoginView loginView;
    private final LoginService loginService;

    public LoginController(LoginView loginView) {
        this.loginView = loginView;
        this.loginService = new LoginService();
    }

    public Member process(Member member) {

        //로그인 화면
        loginView.printLogin(member);
        //로그인 처리
        member = loginService.login(member.getMemberId(), member.getPassword());

        return member;
    }
}
