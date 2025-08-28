package com.itgroup.cofee.dao;


import com.itgroup.cofee.domain.Member;

public class DaoFactory {

    public OrderDao orderDao() {
        return new OrderDao(this.getConnection());
    }

    public MemberDao memberDao() {
        return new MemberDao(this.getConnection());
    }

    public ConnectionProvider getConnection() {
        return new SimpleConnectionProvider();
    }

}
