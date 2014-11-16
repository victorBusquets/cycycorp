package com.fpmislata.banco.presentacion.controller;

import com.fpmislata.banco.dominio.Empleado;
import com.fpmislata.banco.persistencia.EmpleadoDAO;
import com.fpmislata.banco.common.json.JsonConvert;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EmpleadoController {

    @Autowired // va al applicationContext.xml a buscar la implementacion
    EmpleadoDAO empleadoDAO;

    @Autowired // va al applicationContext.xml a buscar la implementacion
    JsonConvert jsonConvert;

    @RequestMapping(value = {"/Empleado/{idEmpleado}"}, method = RequestMethod.GET)
    public void get(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @PathVariable("idEmpleado") int idEmpleado) {
        try {
            Empleado empleado = empleadoDAO.get(idEmpleado);

            if (empleado == null) {
                httpServletResponse.setStatus(204);
            } else {
                httpServletResponse.setStatus(200);
                httpServletResponse.getWriter().println(jsonConvert.toJson(empleado));
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    @RequestMapping(value = {"/Empleado/{idEmpleado}"}, method = RequestMethod.DELETE)
    public void delete(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @PathVariable("idEmpleado") int idEmpleado) {
        empleadoDAO.delete(idEmpleado);
        httpServletResponse.setStatus(204);

    }

    @RequestMapping(value = {"/Empleado"}, method = RequestMethod.POST)
    public void insert(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @RequestBody String jsonEntrada) {

        empleadoDAO.insert((Empleado)jsonConvert.fromJson(jsonEntrada, Empleado.class));

    }

    @RequestMapping(value = {"/Empleado"}, method = RequestMethod.PUT)
    public void update(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @RequestBody String jsonEntrada) {
        empleadoDAO.update((Empleado)jsonConvert.fromJson(jsonEntrada, Empleado.class));
    }

    
    @RequestMapping(value = {"/Empleado"})
    public void findAll(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        try {

            List empleados = empleadoDAO.findAll();
            httpServletResponse.getWriter().println(jsonConvert.toJson(empleados));

        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

}