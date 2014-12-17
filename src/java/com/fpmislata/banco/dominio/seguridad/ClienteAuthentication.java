

package com.fpmislata.banco.dominio.seguridad;

import com.fpmislata.banco.dominio.Cliente;


public interface ClienteAuthentication {
    public Cliente Authenticate(Credencial credencial);
}
