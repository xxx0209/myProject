package com.itgroup.cofee.service;

import com.itgroup.cofee.dao.DaoFactory;
import com.itgroup.cofee.dao.MemberDao;

public class HomeService {

    private final MemberDao memberDao;

    public HomeService() {

        this.memberDao = new DaoFactory().memberDao();
    }
}
