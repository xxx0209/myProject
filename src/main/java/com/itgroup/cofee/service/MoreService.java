package com.itgroup.cofee.service;

import com.itgroup.cofee.dao.DaoFactory;
import com.itgroup.cofee.dao.MemberDao;
import com.itgroup.cofee.dao.OrderDao;
import com.itgroup.cofee.dao.StampDao;
import com.itgroup.cofee.domain.Order;
import com.itgroup.cofee.domain.OrderGroup;
import com.itgroup.cofee.domain.Stamp;

import java.util.List;

public class MoreService {

    private final MemberDao memberDao;
    private final OrderDao orderDao;

    public MoreService() {

        this.memberDao = new DaoFactory().memberDao();
        this.orderDao = new DaoFactory().orderDao();
    }

    // 스탬프/리워드 개수조회
    public Stamp getStampInfo(String memberId) {
        return memberDao.getStampInfo(memberId);
    }

    // 주문내역 조회
    public List<OrderGroup> getOrders(String memberId) {
        return orderDao.getOrders(memberId);
    }
}
