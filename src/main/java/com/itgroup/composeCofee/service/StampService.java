package com.itgroup.composeCofee.service;

import com.itgroup.coffee.factory.DaoFactory;
import com.itgroup.coffee.infrastructure.OrderDao;
import com.itgroup.coffee.infrastructure.StampDao;
import com.itgroup.composeCofee.domain.Order;

import java.util.List;

public class StampService {

    private final StampDao stampDao;

    public StampService() {

        this.stampDao = new DaoFactory().stampDao();
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
