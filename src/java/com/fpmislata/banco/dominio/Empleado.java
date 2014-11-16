
package com.fpmislata.banco.dominio;

public class Empleado {
    
    int idEmpleado;
    String usuario, password, nombre;
    String dni;
    String sucursal;

    public Empleado() {
    }

    public Empleado(int idEmpleado, String usuario, String password, String nombre, String dni, String sucursal) {
        this.idEmpleado = idEmpleado;
        this.usuario = usuario;
        this.password = password;
        this.nombre = nombre;
        this.dni = dni;
        this.sucursal = sucursal;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }
    
    
    
}
