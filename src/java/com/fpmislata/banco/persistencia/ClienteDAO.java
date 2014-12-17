
package com.fpmislata.banco.persistencia;

import com.fpmislata.banco.dominio.Cliente;


public interface ClienteDAO extends GenericDAO<Cliente,Integer>{
    public Cliente getByUsuario(String Usuario);
}
