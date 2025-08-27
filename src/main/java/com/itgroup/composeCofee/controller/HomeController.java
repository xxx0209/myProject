package com.itgroup.composeCofee.controller;

import com.itgroup.composeCofee.domain.Member;
import com.itgroup.composeCofee.view.HomeView;

public class HomeController {

    private HomeView homeView;

    public HomeController(HomeView homeView) {

        this.homeView = homeView;
    }

    public int process(Member member) {
        homeView.printTop(member);
        return homeView.printMenu();
    }
}
