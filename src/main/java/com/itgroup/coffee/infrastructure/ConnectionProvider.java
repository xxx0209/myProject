package com.itgroup.coffee.infrastructure;

import java.sql.Connection;
import java.sql.SQLException;


public interface ConnectionProvider {
    public Connection getConnection() throws ClassNotFoundException, SQLException;
}
