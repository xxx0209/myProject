package com.itgroup.cofee.controller;

import com.itgroup.cofee.domain.Member;
import com.itgroup.cofee.domain.Stamp;
import com.itgroup.cofee.service.HomeService;
import com.itgroup.cofee.view.HomeView;

public class HomeController {

    private final HomeView homeView;
    private final HomeService homeService;

    public HomeController(HomeView homeView) {

        this.homeView = homeView;
        this.homeService = new HomeService();
    }

    public int process(Member member) {
        return homeView.printMenu();
    }
}
