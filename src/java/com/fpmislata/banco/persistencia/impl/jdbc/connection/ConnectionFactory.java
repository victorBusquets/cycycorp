
package com.fpmislata.banco.persistencia.impl.jdbc.connection;

import java.sql.Connection;

public interface ConnectionFactory{
 
    public Connection getConnection();

    public void close(Connection connection);
}
