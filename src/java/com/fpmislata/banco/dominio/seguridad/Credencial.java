
package com.fpmislata.banco.dominio.seguridad;


public class Credencial {
    
    String usuario;
    String contrasenya;

    public Credencial() {
    }

    public Credencial(String usuario, String contrasenya) {
        this.usuario = usuario;
        this.contrasenya = contrasenya;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenya() {
        return contrasenya;
    }

    public void setContrasenya(String contrasenya) {
        this.contrasenya = contrasenya;
    }
    
    
}
