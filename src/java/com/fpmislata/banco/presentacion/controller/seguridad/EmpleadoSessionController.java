package com.fpmislata.banco.presentacion.controller.seguridad;

import com.fpmislata.banco.common.json.JsonConvert;
import com.fpmislata.banco.dominio.Empleado;
import com.fpmislata.banco.dominio.seguridad.Credencial;
import com.fpmislata.banco.dominio.seguridad.EmpleadoAuthentication;
import com.fpmislata.banco.persistencia.EmpleadoDAO;
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
public class EmpleadoSessionController {

    @Autowired
    JsonConvert jsonConvert;
    @Autowired
    EmpleadoAuthentication empleadoAuthentication;
    @Autowired
    EmpleadoDAO empleadoDAO;

    @RequestMapping(value = {"/session/empleado"}, method = RequestMethod.POST)
    public void login(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @RequestBody String jsonEntrada) throws IOException {
        
        Credencial credencial = (Credencial)jsonConvert.fromJson(jsonEntrada, Credencial.class);
        
        Empleado empleado = empleadoAuthentication.Authenticate(credencial);
        
        if( empleado!= null ){
        
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
            HttpSession httpSession = httpServletRequest.getSession(true);
            httpSession.setAttribute("idEmpleado", empleado.getIdEmpleado());
            
        }else {
            httpServletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }

    @RequestMapping(value = {"/session/empleado"}, method = RequestMethod.DELETE)
    public void logout(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException {

        HttpSession httpSession = httpServletRequest.getSession(true);
        httpSession.setAttribute("idEmpleado", null);
        httpServletResponse.setStatus(HttpServletResponse.SC_NO_CONTENT);
        
    }

    @RequestMapping(value = {"/session/empleado"}, method = RequestMethod.GET)
    public void get(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException {

        HttpSession httpSession = httpServletRequest.getSession(true);
        Integer idEmpleado = (Integer) httpSession.getAttribute("idEmpleado");
        
        
        if(idEmpleado != null){
            Empleado empleado = empleadoDAO.get(idEmpleado);
            if(empleado != null){
                empleado.setPassword("*******");
            
                String jsonSalida = jsonConvert.toJson(empleado);
            
                httpServletResponse.setStatus(HttpServletResponse.SC_OK);
                httpServletResponse.getWriter().println(jsonSalida);
            } else {
                httpServletResponse.setStatus(HttpServletResponse.SC_NO_CONTENT);
            }
            
        } else {
            httpServletResponse.setStatus(HttpServletResponse.SC_NO_CONTENT);
        }
    }
}
