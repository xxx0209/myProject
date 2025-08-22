package com.itgroup.api;

import java.sql.Connection;
import java.sql.SQLException;

public interface SimpleConnection {
    public Connection getConnection() throws ClassNotFoundException, SQLException;
}
