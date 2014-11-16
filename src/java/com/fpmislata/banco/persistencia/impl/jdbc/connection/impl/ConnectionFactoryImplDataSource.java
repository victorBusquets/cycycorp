
package com.fpmislata.banco.persistencia.impl.jdbc.connection.impl;

import com.fpmislata.banco.persistencia.impl.jdbc.connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class ConnectionFactoryImplDataSource implements ConnectionFactory{
    
        @Override
    public Connection getConnection() {
     InitialContext initCtx;
        try {
            initCtx = new InitialContext();
            Context envCtx = (Context) initCtx.lookup("java:comp/env");
            DataSource dataSource = (DataSource)envCtx.lookup("jdbc/cycybank"); 
            return dataSource.getConnection();
        } catch (NamingException|SQLException ex) {
            throw new RuntimeException(ex);
        }  
    }

    @Override
    public void close(Connection connection) {
        try {
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionFactoryImplDataSource.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
