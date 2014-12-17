package com.fpmislata.banco.presentacion.controller.seguridad;

import com.fpmislata.banco.common.json.JsonConvert;
import com.fpmislata.banco.dominio.Cliente;
import com.fpmislata.banco.dominio.seguridad.Credencial;
import com.fpmislata.banco.dominio.seguridad.ClienteAuthentication;
import com.fpmislata.banco.persistencia.ClienteDAO;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ClienteSessionController {

    @Autowired
    JsonConvert jsonConvert;
    @Autowired
    ClienteAuthentication clienteAuthentication;
    @Autowired
    ClienteDAO clienteDAO;

    @RequestMapping(value = {"/session/cliente"}, method = RequestMethod.POST)
    public void login(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @RequestBody String jsonEntrada) throws IOException {
        
        Credencial credencial = (Credencial)jsonConvert.fromJson(jsonEntrada, Credencial.class);
        
        Cliente cliente = clienteAuthentication.Authenticate(credencial);
        
        if( cliente != null ){
        
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
            HttpSession httpSession = httpServletRequest.getSession(true);
            httpSession.setAttribute("idCliente", cliente.getIdCliente());
            
        } else {
            httpServletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }

    @RequestMapping(value = {"/session/cliente"}, method = RequestMethod.DELETE)
    public void logout(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException {

        HttpSession httpSession = httpServletRequest.getSession(true);
        httpSession.setAttribute("idCliente", null);
        httpServletResponse.setStatus(HttpServletResponse.SC_NO_CONTENT);
        
    }

    @RequestMapping(value = {"/session/cliente"}, method = RequestMethod.GET)
    public void get(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException {

        HttpSession httpSession = httpServletRequest.getSession(true);
        Integer idCliente = (Integer) httpSession.getAttribute("idCliente");
        
        
        if(idCliente != null){
            Cliente cliente = clienteDAO.get(idCliente);
            
            String jsonSalida = jsonConvert.toJson(cliente);
            
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
            httpServletResponse.getWriter().println(jsonSalida);
            
        } else {
            httpServletResponse.setStatus(HttpServletResponse.SC_NO_CONTENT);
        }
    }
}
