/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.persistencia.impl.jdbc;

import com.fpmislata.banco.dominio.Cliente;
import com.fpmislata.banco.persistencia.ClienteDAO;
import com.fpmislata.banco.persistencia.impl.jdbc.connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Oliver
 */
public class ClienteDAOImplJDBC implements ClienteDAO {

    @Autowired
    ConnectionFactory connectionFactory;

    @Override
    public Cliente get(Integer idCliente) {
        try {
            Cliente cliente;
            Connection connection = connectionFactory.getConnection();

            String selectSQL = "SELECT * FROM cliente WHERE idCliente = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(selectSQL);
            preparedStatement.setInt(1, idCliente);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next() == true) {
                cliente = new Cliente();

                cliente.setNombre(rs.getString("nombre"));
                cliente.setUsuario(rs.getString("usuario"));
                cliente.setIdCliente(rs.getInt("idCliente"));
                cliente.setDni(rs.getString("dni"));
                cliente.setContrasenya(rs.getString("contraseña"));

                if (rs.next() == true) {
                    throw new RuntimeException("ERROR. Existe mas de un cliente con esta id." + idCliente);
                }
                return cliente;
            } else {

            }

            connectionFactory.close(connection);
            System.out.println("Conexion creada y datos mostrados.");
            return null;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

    }

    @Override
    public Cliente insert(Cliente cliente) {
        try {

            Connection connection = connectionFactory.getConnection();

            String insertTableSQL = "INSERT INTO cliente"
                    + "(idCliente, usuario, contraseña, nombre, dni) VALUES"
                    + "(?,?,?,?,?)";

            PreparedStatement preparedStatement2 = connection.prepareStatement(insertTableSQL);
            preparedStatement2.setInt(1, cliente.getIdCliente());
            preparedStatement2.setString(2, cliente.getUsuario());
            preparedStatement2.setString(3, cliente.getContrasenya());
            preparedStatement2.setString(4, cliente.getNombre());
            preparedStatement2.setString(5, cliente.getDni());

            preparedStatement2.executeUpdate();

            connectionFactory.close(connection);
            System.out.println("Conexion creada con exito y datos insertados.");

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return cliente;
    }

    @Override
    public Cliente update(Cliente cliente) {
        try {

            Connection connection = connectionFactory.getConnection();

            String updateTableSQL = "UPDATE cliente SET  usuario = ? ,contraseña = ?,nombre = ?, dni = ? WHERE idCliente = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(updateTableSQL);

            preparedStatement.setString(1, cliente.getUsuario());
            preparedStatement.setString(2, cliente.getContrasenya());
            preparedStatement.setString(3, cliente.getNombre());
            preparedStatement.setString(4, cliente.getDni());
            preparedStatement.setInt(5, cliente.getIdCliente());
// execute insert SQL statement
            preparedStatement.executeUpdate();

            connectionFactory.close(connection);
            System.out.println("Conexion creada con exito y datos actualizados.");
        } catch (SQLException ex) {
            throw new RuntimeException(ex);

        }
        return cliente;
    }

    @Override
    public void delete(Integer idCliente) {
        try {

            Connection connection = connectionFactory.getConnection();

            String deleteSQL = "DELETE FROM cliente WHERE idCliente = ?";
            PreparedStatement preparedStatement3 = connection.prepareStatement(deleteSQL);
            preparedStatement3.setInt(1, idCliente);
            // execute delete SQL stetement
            preparedStatement3.executeUpdate();

                        connectionFactory.close(connection);
            System.out.println("Conexion creada con exito");
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public List<Cliente> findAll() {
        try {
            List<Cliente> listaClientes;
            try (Connection connection = connectionFactory.getConnection()) {
                listaClientes = new ArrayList();
                Cliente cliente;
                String selectSQL = "SELECT * FROM cliente ";
                PreparedStatement preparedStatement = connection.prepareStatement(selectSQL);
                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next()) {
                    Integer idCliente = rs.getInt("idCliente");
                    String usuario = rs.getString("usuario");
                    String contrasenya = rs.getString("contraseña");
                    String nombre = rs.getString("nombre");
                    String dni = rs.getString("dni");

                    cliente = new Cliente(idCliente, usuario, contrasenya, nombre, dni);
                    listaClientes.add(cliente);
                }
                connectionFactory.close(connection);
            }
            return listaClientes;

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

    }
}
