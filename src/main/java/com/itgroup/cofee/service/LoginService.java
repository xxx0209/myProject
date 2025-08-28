package com.itgroup.cofee.service;

import com.itgroup.cofee.dao.DaoFactory;
import com.itgroup.cofee.dao.MemberDao;
import com.itgroup.cofee.dao.StampDao;
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

    // 리워드 개수 조회
    public int getReWordCount() {
        return -1;
    }

    // 리워드 개수 조회
    public int updateReWordCount() {
        return -1;
    }

    // 스탬프 개수 조회
    public int getStampCount(String id) {

        return 1;
    }

    // 스탬프 사용여부 수정
    public int updateStampUseYn() {
        return 1;
    }


}
