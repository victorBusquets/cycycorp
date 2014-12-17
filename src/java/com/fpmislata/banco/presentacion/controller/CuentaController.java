package com.fpmislata.banco.presentacion.controller;

import com.fpmislata.banco.persistencia.CuentaDAO;
import com.fpmislata.banco.dominio.Cuenta;
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

@Controller
public class CuentaController {

    @Autowired
    CuentaDAO cuentaDAO;
    @Autowired
    JsonConvert jsonConvert;

    @RequestMapping(value = {"/cuenta/{idCuenta}"}, method = RequestMethod.GET)
    public void read(HttpServletRequest httpRequest, HttpServletResponse httpServletResponse, @PathVariable("idCuenta") int idCuenta) throws IOException, SQLException {

        try {

            Cuenta cuenta = cuentaDAO.get(idCuenta);
            httpServletResponse.setContentType("application/json; charset=UTF-8");
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);

            String json = jsonConvert.toJson(cuenta);
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

    @RequestMapping(value = {"/cuenta/{idCuenta}"}, method = RequestMethod.DELETE)
    public void delete(HttpServletRequest httpRequest, HttpServletResponse httpServletResponse, @PathVariable("idCuenta") int idCuenta) {

        try {
            cuentaDAO.delete(idCuenta);
            httpServletResponse.setStatus(HttpServletResponse.SC_NO_CONTENT);
        } catch (Exception ex) {
            httpServletResponse.setContentType("text/plain; charset=UTF-8");
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            try {
                ex.printStackTrace(httpServletResponse.getWriter());
            } catch (IOException ex1) {
            }
        }
    }

    @RequestMapping(value = {"/cuentas"}, method = RequestMethod.GET)
    public void findall(HttpServletRequest httpRequest, HttpServletResponse httpServletResponse/*, @PathVariable("idEntidad") int idEntidad*/) throws IOException {

        try {
            List<Cuenta> cuentas = cuentaDAO.findAll();

            httpServletResponse.setContentType("application/json; charset=UTF-8");
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);

            String json = jsonConvert.toJson(cuentas);
            httpServletResponse.getWriter().println(json);

        } catch (Exception ex) {
            httpServletResponse.setContentType("text/plain; charset=UTF-8");
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            try {
                ex.printStackTrace(httpServletResponse.getWriter());
            } catch (IOException ex1) {
            }
        }
    }

    @RequestMapping(value = {"/cuenta"}, method = RequestMethod.POST)
    public void insert(HttpServletRequest httpRequest, HttpServletResponse httpServletResponse, @RequestBody String json) {

        try {

            Cuenta cuenta = (Cuenta) jsonConvert.fromJson(json, Cuenta.class);

            cuentaDAO.insert(cuenta);

            httpServletResponse.setContentType("application/json; charset=UTF-8");
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
            json = jsonConvert.toJson(cuenta);
            httpServletResponse.getWriter().println(json);

        } catch (Exception ex) {
            httpServletResponse.setContentType("text/plain; charset=UTF-8");
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            try {
                ex.printStackTrace(httpServletResponse.getWriter());
            } catch (IOException ex1) {
            }
        }
    }

    @RequestMapping(value = {"/cuenta"}, method = RequestMethod.PUT)
    public void update(HttpServletRequest httpRequest, HttpServletResponse httpServletResponse, @RequestBody String json) {

        try {

            Cuenta cuenta = (Cuenta) jsonConvert.fromJson(json, Cuenta.class);

          

            cuentaDAO.update(cuenta);  

            httpServletResponse.setContentType("application/json; charset=UTF-8");
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
            json = jsonConvert.toJson(cuenta);
            httpServletResponse.getWriter().println(json);

        } catch (Exception ex) {
            httpServletResponse.setContentType("text/plain; charset=UTF-8");
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            try {
                ex.printStackTrace(httpServletResponse.getWriter());
            } catch (IOException ex1) {
            }
        }

    }
}
