package com.fpmislata.banco.presentacion.controller;

import com.fpmislata.banco.dominio.MovimientoBancario;
import com.fpmislata.banco.persistencia.MovimientoBancarioDAO;
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
 * @author JuanPe
 */
@Controller
public class MovimientoBancarioController {

    @Autowired
    MovimientoBancarioDAO movimientoBancarioDAO;
    @Autowired
    JsonConvert jsonConvert;

    @RequestMapping(value = {"/MovimientoBancario/{idMovimiento}"}, method = RequestMethod.GET)
    public void read(HttpServletRequest httpRequest, HttpServletResponse httpServletResponse, @PathVariable("idMovimiento") int idMovimientoBancario) throws IOException, SQLException {

        try {

            MovimientoBancario movimientoBancario = (MovimientoBancario) movimientoBancarioDAO.get(idMovimientoBancario); 
            httpServletResponse.setContentType("application/json; charset=UTF-8");
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);

            String json = jsonConvert.toJson(movimientoBancario);
      
            httpServletResponse.getWriter().println(json);

        } catch (IOException ex) {
            httpServletResponse.setContentType("text/plain; charset=UTF-8");
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            try {
                ex.printStackTrace(httpServletResponse.getWriter());
            } catch (IOException ex1) {
                throw new RuntimeException(ex);
            }
        }
    }

    @RequestMapping(value = {"/MovimientoBancario/{idMovimiento}"}, method = RequestMethod.DELETE)
    public void delete(HttpServletRequest httpRequest, HttpServletResponse httpServletResponse, @PathVariable("idMovimiento") int idMovimiento) {

        try { 
            movimientoBancarioDAO.delete(idMovimiento);

            httpServletResponse.setStatus(HttpServletResponse.SC_NO_CONTENT);
        } catch (Exception ex) {
            httpServletResponse.setContentType("text/plain; charset=UTF-8");
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            try {
                ex.printStackTrace(httpServletResponse.getWriter());
            } catch (IOException ex1) {
                throw new RuntimeException(ex);
            }
        }
    }

    @RequestMapping(value = {"/MovimientosBancarios"}, method = RequestMethod.GET)
    public void find(HttpServletRequest httpRequest, HttpServletResponse httpServletResponse) throws IOException {

        try {
            List<MovimientoBancario> movimientoBancario = movimientoBancarioDAO.findAll();

            httpServletResponse.setContentType("application/json; charset=UTF-8");
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);

            String json = jsonConvert.toJson(movimientoBancario);
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

    @RequestMapping(value = {"/MovimientoBancario"}, method = RequestMethod.POST)
    public void insert(HttpServletRequest httpRequest, HttpServletResponse httpServletResponse, @RequestBody String json) {

        try {

            MovimientoBancario movimientoBancario = (MovimientoBancario) jsonConvert.fromJson(json, MovimientoBancario.class);

            movimientoBancarioDAO.insert(movimientoBancario);

            httpServletResponse.setContentType("application/json; charset=UTF-8");
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
            json = jsonConvert.toJson(movimientoBancario);
            httpServletResponse.getWriter().println(json);

        } catch (Exception ex) {
            httpServletResponse.setContentType("text/plain; charset=UTF-8");
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            try {
                ex.printStackTrace(httpServletResponse.getWriter());
            } catch (IOException ex1) {
                throw new RuntimeException(ex);
            }
        }
    }

    @RequestMapping(value = {"/MovimientoBancario/{idMovimiento}"}, method = RequestMethod.PUT)
    public void update(HttpServletRequest httpRequest, HttpServletResponse httpServletResponse, @PathVariable("idMovimiento") int idMovimiento, @RequestBody String json) {

        try {
            MovimientoBancario movimientoBancario = (MovimientoBancario) jsonConvert.fromJson(json, MovimientoBancario.class);

            MovimientoBancario movimientoBancarioUpdate = (MovimientoBancario) movimientoBancarioDAO.get(idMovimiento);
            
            movimientoBancarioUpdate.setCantidad(movimientoBancario.getCantidad());

            movimientoBancarioUpdate.setCuentaDestino(movimientoBancario.getCuentaDestino());
            
            movimientoBancarioUpdate.setCuentaOrigen(movimientoBancario.getCuentaOrigen());
            
            movimientoBancarioUpdate.setMotivo(movimientoBancario.getMotivo());

            movimientoBancarioDAO.update(movimientoBancarioUpdate);  


            httpServletResponse.setContentType("application/json; charset=UTF-8");
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
            json = jsonConvert.toJson(movimientoBancarioUpdate);
            httpServletResponse.getWriter().println(json);

        } catch (Exception ex) {
            httpServletResponse.setContentType("text/plain; charset=UTF-8");
            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            try {
                ex.printStackTrace(httpServletResponse.getWriter());
            } catch (IOException ex1) {
                throw new RuntimeException(ex);
            }
        }

    }
}
