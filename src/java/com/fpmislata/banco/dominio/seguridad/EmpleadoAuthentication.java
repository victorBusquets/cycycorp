/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fpmislata.banco.dominio.seguridad;

import com.fpmislata.banco.dominio.Empleado;

/**
 *
 * @author alumno
 */
public interface EmpleadoAuthentication {
    public Empleado Authenticate(Credencial credencial);
}
