package com.itgroup.cofee.service;

import com.itgroup.cofee.dao.DaoFactory;
import com.itgroup.cofee.dao.MemberDao;
import com.itgroup.cofee.domain.Member;

public class LoginService {

    private final MemberDao memberDao;

    public LoginService() {

        this.memberDao = new DaoFactory().memberDao();
    }

    //회원로그인
    public Member login(String id, String password) {
        return memberDao.login(id, password);
    }


}
