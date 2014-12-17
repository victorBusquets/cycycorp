package com.fpmislata.banco.persistencia.impl.jdbc;

import com.fpmislata.banco.dominio.Empleado;
import com.fpmislata.banco.persistencia.EmpleadoDAO;
import com.fpmislata.banco.persistencia.impl.jdbc.connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

public class EmpleadoDAOImplJDBC implements EmpleadoDAO {

    @Autowired
    ConnectionFactory connectionFactory;

    @Override
    public Empleado get(Integer idEmpleado) {
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        Empleado empleado = null;
        Connection connection = null;

        try {
            connection = connectionFactory.getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM empleado WHERE idEmpleado = ?");
            preparedStatement.setInt(1, idEmpleado);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                empleado = new Empleado(resultSet.getInt("idEmpleado"), resultSet.getString("usuario"),
                        resultSet.getString("contraseña"), resultSet.getString("nombre"),
                        resultSet.getString("dni"), resultSet.getString("sucursal"));
            }

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } finally {
            try {
                connectionFactory.close(connection);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
        return empleado;
    }

    @Override
    public Empleado insert(Empleado empleado) {
        PreparedStatement preparedStatement;
        Connection connection = null;
        try {
            connection = connectionFactory.getConnection();
            preparedStatement = connection.prepareStatement("INSERT INTO empleado VALUES (?,?,?,?,?,?)");
            preparedStatement.setInt(1, empleado.getIdEmpleado());
            preparedStatement.setString(2, empleado.getUsuario());
            preparedStatement.setString(3, empleado.getPassword());
            preparedStatement.setString(4, empleado.getNombre());
            preparedStatement.setString(5, empleado.getDni());
            preparedStatement.setString(6, empleado.getSucursal());

            preparedStatement.executeUpdate();

            return empleado;

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } finally {
            try {
                connectionFactory.close(connection);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }

    }

    @Override
    public Empleado update(Empleado empleado) {
        PreparedStatement preparedStatement;
        Connection connection = null;
        try {
            connection = connectionFactory.getConnection();
            preparedStatement = connection.prepareStatement(
                    "UPDATE empleado SET usuario=?, contraseña=?, nombre=?, dni=?, sucursal=? WHERE idEmpleado=?");
            preparedStatement.setInt(6, empleado.getIdEmpleado());
            preparedStatement.setString(1, empleado.getUsuario());
            preparedStatement.setString(2, empleado.getPassword());
            preparedStatement.setString(3, empleado.getNombre());
            preparedStatement.setString(4, empleado.getDni());
            preparedStatement.setString(5, empleado.getSucursal());

            preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } finally {
            try {
                connectionFactory.close(connection);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
        return empleado;

    }

    @Override
    public void delete(Integer idEmpleado) {
        PreparedStatement preparedStatement;
        Connection connection = null;

        try {
            connection = connectionFactory.getConnection();
            preparedStatement = connection.prepareStatement("DELETE FROM empleado WHERE idEmpleado = ?");
            preparedStatement.setInt(1, idEmpleado);
            preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } finally {
            try {
                connectionFactory.close(connection);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    @Override
    public List<Empleado> findAll() {
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        Connection connection = null;
        List empleados = new ArrayList();
        try {
            connection = connectionFactory.getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM empleado");
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                empleados.add(
                        new Empleado(resultSet.getInt("idEmpleado"),
                                resultSet.getString("usuario"),
                                "******",
                                resultSet.getString("nombre"),
                                resultSet.getString("dni"),
                                resultSet.getString("sucursal")
                        ));
            }

            return empleados;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } finally {
            try {
                connectionFactory.close(connection);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    @Override
    public Empleado getByUsuario(String usuario) {

        Empleado empleado = null;
        Connection connection = null;
        
        try{
            connection = connectionFactory.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT idEmpleado FROM empleado WHERE usuario = ?");
            preparedStatement.setString(1,usuario);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            int idEmpleado = resultSet.getInt("idEmpleado");
            empleado= this.get(idEmpleado);
            
        }catch(SQLException ex){
            throw new RuntimeException(ex);
        }
        finally {
            try {       
                connection.close();
            } catch (SQLException ex) {
                throw new RuntimeException();
            }
        }
        
        return empleado;
    }
}
