/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.banco.presentacion.controller;

import com.fpmislata.banco.dominio.Cliente;
import com.fpmislata.banco.persistencia.ClienteDAO;
import com.fpmislata.banco.common.json.JsonConvert;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Oliver
 */


@Controller
public class ClienteController {

    @Autowired
    ClienteDAO clienteDao;
    @Autowired
    JsonConvert jsonConvert;

    @RequestMapping(value = {"/Cliente/{idCliente}"}, method = RequestMethod.GET)
    public void read(HttpServletRequest httpRequest, HttpServletResponse httpServletResponse, @PathVariable("idCliente") int idCliente) throws IOException, SQLException {

        try {

            Cliente cliente = clienteDao.get(idCliente); //creo variable para pasarla abajo
            httpServletResponse.setContentType("application/json; charset=UTF-8");
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);

            String json = jsonConvert.toJson(cliente);

            httpServletResponse.getWriter().println(json);

        } catch (IOException ex) {
            httpServletResponse.setContentType("text/plain; charset=UTF-8");
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            try {
                ex.printStackTrace(httpServletResponse.getWriter());
            } catch (IOException ex1) {

                
            }
        }
    }

    @RequestMapping(value = {"/Cliente/{idCliente}"}, method = RequestMethod.DELETE)
    public void delete(HttpServletRequest httpRequest, HttpServletResponse httpServletResponse, @PathVariable("idCliente") int idCliente) {

        try {

            clienteDao.delete(idCliente);

            httpServletResponse.setStatus(HttpServletResponse.SC_NO_CONTENT);
        } catch (Exception ex) {
            httpServletResponse.setContentType("text/plain; charset=UTF-8");
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            try {
                ex.printStackTrace(httpServletResponse.getWriter());
            } catch (IOException ex1) {
                //Capturamos el error de si da error mostrar el error !!! LOL
            }
        }
    }

    @RequestMapping(value = {"/Clientes"}, method = RequestMethod.GET)
    public void find(HttpServletRequest httpRequest, HttpServletResponse httpServletResponse) throws IOException {

        try {
            List<Cliente> clientes = clienteDao.findAll();

            httpServletResponse.setContentType("application/json; charset=UTF-8");
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);

            String json = jsonConvert.toJson(clientes);
            httpServletResponse.getWriter().println(json);

        } catch (IOException ex) {
            httpServletResponse.setContentType("text/plain; charset=UTF-8");
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            try {
                ex.printStackTrace(httpServletResponse.getWriter());
            } catch (IOException ex1) {
            }
        }
    }

    @RequestMapping(value = {"/Cliente"}, method = RequestMethod.POST)
    public void insert(HttpServletRequest httpRequest, HttpServletResponse httpServletResponse, @RequestBody String json) {

        try {

            Cliente cliente = (Cliente) jsonConvert.fromJson(json, Cliente.class);

            clienteDao.insert(cliente);

            httpServletResponse.setContentType("application/json; charset=UTF-8");
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
            json = jsonConvert.toJson(cliente);
            httpServletResponse.getWriter().println(json);

        } catch (IOException ex) {
            httpServletResponse.setContentType("text/plain; charset=UTF-8");
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            try {
                ex.printStackTrace(httpServletResponse.getWriter());
            } catch (IOException ex1) {
                //Capturamos el error de si da error mostrar el error !!! LOL
            }
        }
    }

    @RequestMapping(value = {"/Cliente"}, method = RequestMethod.PUT)
    public void update(HttpServletRequest httpRequest, HttpServletResponse httpServletResponse, @RequestBody String json) {

        try {
            //Aqui transformo el json de la cabecera en un objeto java para poder insertarlo en la BBDD

            Cliente cliente = (Cliente) jsonConvert.fromJson(json, Cliente.class);

            //Leo la entidad que voy a actualizar y la guardo en un objeto
            clienteDao.update(cliente);  //Actualizo la entidad

            //Casteo el objeto creado de nuevo a formato json para poder devolverlo
            httpServletResponse.setContentType("application/json; charset=UTF-8");
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
            json = jsonConvert.toJson(cliente); //Aqui la variable creada
            httpServletResponse.getWriter().println(json);

        } catch (IOException ex) {
            httpServletResponse.setContentType("text/plain; charset=UTF-8");
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            try {
                ex.printStackTrace(httpServletResponse.getWriter());
            } catch (IOException ex1) {
                //Capturamos el error de si da error mostrar el error !!! LOL
            }
        }

    }

}
