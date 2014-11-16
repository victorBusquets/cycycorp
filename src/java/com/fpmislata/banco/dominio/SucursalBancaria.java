
package com.fpmislata.banco.dominio;

/**
 *
 * @author CycyCorp
 */
public class SucursalBancaria {
    //Aributos
    int idSucursal;
    String localizacion,codigoSucursal,entidadBancaria,nombreSucursal;
    
    //Constructor vacio
    public SucursalBancaria(){}
    
    //Constructor con parametros
    public SucursalBancaria(int idSucursal, String localizacion, String codigoSucursal, String entidadBancaria, String nombreSucursal) {
        this.idSucursal = idSucursal;
        this.localizacion = localizacion;
        this.codigoSucursal = codigoSucursal;
        this.entidadBancaria = entidadBancaria;
        this.nombreSucursal = nombreSucursal;
    }
    
    //Metodos
    public int getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(int idSucursal) {
        this.idSucursal = idSucursal;
    }

    public String getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(String localizacion) {
        this.localizacion = localizacion;
    }

    public String getCodigoSucursal() {
        return codigoSucursal;
    }

    public void setCodigoSucursal(String codigoSucursal) {
        this.codigoSucursal = codigoSucursal;
    }

    public String getEntidadBancaria() {
        return entidadBancaria;
    }

    public void setEntidadBancaria(String entidadBancaria) {
        this.entidadBancaria = entidadBancaria;
    }

    public String getNombreSucursal() {
        return nombreSucursal;
    }

    public void setNombreSucursal(String nombreSucursal) {
        this.nombreSucursal = nombreSucursal;
    }
    
}
