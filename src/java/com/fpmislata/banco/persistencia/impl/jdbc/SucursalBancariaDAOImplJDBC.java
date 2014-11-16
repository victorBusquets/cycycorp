
package com.fpmislata.banco.persistencia.impl.jdbc;

import com.fpmislata.banco.dominio.SucursalBancaria;
import com.fpmislata.banco.persistencia.SucursalBancariaDAO;
import com.fpmislata.banco.persistencia.impl.jdbc.connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

public class SucursalBancariaDAOImplJDBC implements SucursalBancariaDAO{

    @Autowired
    ConnectionFactory connectionFactory ;
    Connection connection;
    
    @Override
    public SucursalBancaria get(Integer idSucursal) {
        try {
            SucursalBancaria sucursalBancaria;
            PreparedStatement preparedStatement;
            ResultSet resultSet;
            
            connection = connectionFactory.getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM "
                                 + "sucursal WHERE idSucursal=?");
            preparedStatement.setInt(1, idSucursal);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                sucursalBancaria = new SucursalBancaria(resultSet.getInt("idSucursal"),
                                                      resultSet.getString("localizacion"), 
                                                      resultSet.getString("codigoSucursal"), 
                                                      resultSet.getString("entidadBancaria"),
                                                      resultSet.getString("nombreSucursal"));
            } else {
                sucursalBancaria = null;
            }
            connectionFactory.close(connection);
            return sucursalBancaria;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    
    @Override
    public SucursalBancaria insert(SucursalBancaria sucursal) {
        try {
            PreparedStatement preparedStatement;
            
            connection = connectionFactory.getConnection();
            preparedStatement = connection.prepareStatement("INSERT INTO sucursal VALUES(?,?,?,?,?)");
            preparedStatement.setInt(1,sucursal.getIdSucursal());
            preparedStatement.setString(2, sucursal.getLocalizacion());
            preparedStatement.setString(3, sucursal.getCodigoSucursal());
            preparedStatement.setString(4, sucursal.getEntidadBancaria());
            preparedStatement.setString(5, sucursal.getNombreSucursal());
            preparedStatement.executeUpdate();
            connectionFactory.close(connection);
            return sucursal;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    
    @Override
    public SucursalBancaria update(SucursalBancaria sucursal) {
        try {
            PreparedStatement preparedStatement;
            
            connection = connectionFactory.getConnection();
            preparedStatement = connection.prepareStatement("UPDATE sucursal "
                    + "SET localizacion=?,codigoSucursal=?,entidadBancaria=?,nombreSucursal=? "
                    + "WHERE idSucursal=?");
            preparedStatement.setString(1, sucursal.getLocalizacion());
            preparedStatement.setString(2, sucursal.getCodigoSucursal());
            preparedStatement.setString(3, sucursal.getEntidadBancaria());
            preparedStatement.setString(4, sucursal.getNombreSucursal());
            preparedStatement.setInt(5, sucursal.getIdSucursal());
            preparedStatement.executeUpdate();
            connectionFactory.close(connection);
            return sucursal;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    
    @Override
    public void delete(Integer idSucursal) {
        try {
            PreparedStatement preparedStatement;
            connection = connectionFactory.getConnection();
            preparedStatement = connection.prepareStatement("DELETE FROM sucursal"
                    + " WHERE idsucursal=?");
            preparedStatement.setInt(1, idSucursal);
            preparedStatement.executeUpdate();
            connectionFactory.close(connection);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    
    @Override
    public List<SucursalBancaria> findAll() {
        List list=new ArrayList();
        try{
            PreparedStatement preparedStatement;
            ResultSet resultSet;
            
            connection = connectionFactory.getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM sucursal");
            resultSet=preparedStatement.executeQuery();
            while(resultSet.next()) {
                list.add(
                new SucursalBancaria(resultSet.getInt("idSucursal"),
                                                      resultSet.getString("localizacion"), 
                                                      resultSet.getString("codigoSucursal"), 
                                                      resultSet.getString("entidadBancaria"),
                                                      resultSet.getString("nombreSucursal"))
                    );
            }
            connectionFactory.close(connection);
            return list;  
        }catch(SQLException ex){
            throw new RuntimeException(ex);   
        }
    }

}
