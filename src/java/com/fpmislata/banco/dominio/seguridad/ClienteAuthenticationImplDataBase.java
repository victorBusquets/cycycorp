
package com.fpmislata.banco.dominio.seguridad;

import com.fpmislata.banco.dominio.Cliente;
import com.fpmislata.banco.persistencia.ClienteDAO;
import org.springframework.beans.factory.annotation.Autowired;



public class ClienteAuthenticationImplDataBase implements ClienteAuthentication{
    
    @Autowired
    ClienteDAO clienteDAO;
    
    @Override
    public Cliente Authenticate(Credencial credencial){
        
        Cliente cliente = clienteDAO.getByUsuario(credencial.getUsuario());
        
        if(cliente != null){
            //En caso de que haya un cliente
            if(!(cliente.getContrasenya().equals(credencial.getContrasenya()))){
                //En caso de que la contraseña sea distinta
                cliente = null;
            } else {
                //En caso de que la contraseña sea igual
            }
        }else{
            //En caso de que exista un cliente.
        }
        
       return cliente; 
    }
}
