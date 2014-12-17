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
    public Cuenta insert(Cuenta cuenta) {
        Connection connection = connectionFactory.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO cuenta VALUES (?, ?,?,null,?)");

            preparedStatement.setInt(1, cuenta.getIdCuenta());
            preparedStatement.setString(2, cuenta.getCliente());
            preparedStatement.setDouble(3, cuenta.getSaldo());
            preparedStatement.setInt(4, cuenta.getSucursalBancaria());

            preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } finally {
            connectionFactory.close(connection);
        }
        return cuenta;
    }

    @Override
    public Cuenta update(Cuenta cuenta) {
        Connection connection = connectionFactory.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE cuenta SET cliente= ?, saldo=?, sucursalBancaria=? WHERE idCuenta=?");

            preparedStatement.setInt(4, cuenta.getIdCuenta());
            preparedStatement.setString(1, cuenta.getCliente());
            preparedStatement.setDouble(2, cuenta.getSaldo());
            preparedStatement.setInt(3, cuenta.getSucursalBancaria());

            preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } finally {
            connectionFactory.close(connection);
        }

        return cuenta;
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

        List<Cuenta> cuentas = new ArrayList();

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

                cuentas.add(cuenta);
            }

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } finally {
            connectionFactory.close(connection);
        }

        return cuentas;
    }
}

