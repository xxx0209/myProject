package com.itgroup.cofee.service;

import com.itgroup.cofee.dao.DaoFactory;
import com.itgroup.cofee.dao.MemberDao;
import com.itgroup.cofee.domain.Member;
import com.itgroup.cofee.domain.Stamp;

public class HomeService {

    private final MemberDao memberDao;

    public HomeService() {

        this.memberDao = new DaoFactory().memberDao();
    }

    //회원로그인
    public Member login(String id, String password) {
        return memberDao.login(id, password);
    }

    // 스탬프/리워드 개수 조회
    public Stamp getStampInfo(String id) {
        return memberDao.getStampInfo(id);
    }


}
