package com.fpmislata.banco.persistencia.impl.jdbc;

import com.fpmislata.banco.dominio.Cuenta;
import com.fpmislata.banco.persistencia.CuentaDAO;
import com.fpmislata.banco.persistencia.impl.jdbc.connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

public class CuentaDAOImplJDBC implements CuentaDAO {
    
    @Autowired
    ConnectionFactory connectionFactory;

    @Override
    public Cuenta get(Integer id) {

        Connection connection = connectionFactory.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM cuenta WHERE idCuenta = ?");
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();

            Cuenta cuenta = new Cuenta();

            cuenta.setIdCuenta(resultSet.getInt("idCuenta"));
            cuenta.setCliente(resultSet.getString("cliente"));
            cuenta.setSaldo(resultSet.getInt("saldo"));
            cuenta.setSucursalBancaria(resultSet.getInt("sucursalBancaria"));

            return cuenta;

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } finally {
            connectionFactory.close(connection);
        }

    }

    @Override
    public Cuenta insert(Cuenta t) {
        Connection connection = connectionFactory.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO cuenta VALUES (null, ?,?,null,?)");

            preparedStatement.setString(1, t.getCliente());
            preparedStatement.setDouble(2, t.getSaldo());
            preparedStatement.setInt(3, t.getSucursalBancaria());

            preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } finally {
            connectionFactory.close(connection);
        }
        return t;
    }

    @Override
    public Cuenta update(Cuenta t) {
        Connection connection = connectionFactory.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE cuenta SET cliente= ?, saldo=?, sucursalBancaria=? WHERE idCuenta=?");

            preparedStatement.setInt(4, t.getIdCuenta());
            preparedStatement.setString(1, t.getCliente());
            preparedStatement.setDouble(2, t.getSaldo());
            preparedStatement.setInt(3, t.getSucursalBancaria());

            preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } finally {
            connectionFactory.close(connection);
        }

        return t;
    }

    @Override
    public void delete(Integer id) {
        Connection connection = connectionFactory.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM Cuenta WHERE idCuenta=?");

            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } finally {
            connectionFactory.close(connection);
        }
    }

    @Override
    public List<Cuenta> findAll() {

        List<Cuenta> lista = new ArrayList();

        Connection connection = connectionFactory.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Cuenta");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Cuenta cuenta = new Cuenta();

                cuenta.setIdCuenta(resultSet.getInt("idCuenta"));
                cuenta.setCliente(resultSet.getString("cliente"));
                cuenta.setSaldo(resultSet.getInt("saldo"));
                cuenta.setSucursalBancaria(resultSet.getInt("sucursalBancaria"));

                lista.add(cuenta);
            }

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } finally {
            connectionFactory.close(connection);
        }

        return lista;
    }
}

