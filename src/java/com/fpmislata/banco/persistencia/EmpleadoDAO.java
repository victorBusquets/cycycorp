
package com.fpmislata.banco.persistencia;

import com.fpmislata.banco.dominio.seguridad.Credencial;
import com.fpmislata.banco.dominio.Empleado;


public interface EmpleadoDAO extends GenericDAO<Empleado, Integer>{
    public Empleado getByUsuario(String Usuario);
}
