
package com.fpmislata.banco.presentacion.controller;

import com.fpmislata.banco.dominio.SucursalBancaria;
import com.fpmislata.banco.persistencia.SucursalBancariaDAO;
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
public class SucursalController {
    
    //////////////////////////////////////////////////////////////////////////////////////   
    //              http://localhost:8084/banco/api/EntidadBancaria/3                   //
    //    Con esta ruta probamos que se muestra el hola mundo ya que al acceder a la    //
    //    ruta "/EntidadBancaria/3" gracias al @Controller es accesible para hacerle    // 
    //                         peticiones desde la web.                                 //
    //                                                                                  //
    //   Hay que poner un @Autowired por cada interfaz a implementar, el @Autowired     //
    //   lo que hace es buscar dentro de applicationContext.xml la implementacion a     //
    // usar para la interfaz indicacada en este caso JsonConvert y EntidadBancariaDAO.  //
    //                                                                                  //    
    //  Con ''@PathVariable("id") int idEntidadBancaria'' indicamos que la variable     //
    //  int idEntidadBancaria la sacamos de la url. Para ello lo que hay entre llaves   //
    //  en la url y lo que hay entre parentesis en @PathVariable debe ser igual.        //
    ////////////////////////////////////////////////////////////////////////////////////// 
    
    @Autowired
    SucursalBancariaDAO sucursalDAO;
    
    @Autowired
    JsonConvert jsonConvert;
    
    //Metodo get
    @RequestMapping(value = {"/SucursalBancaria/{id}"},method = RequestMethod.GET)
    public void get(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @PathVariable("id") int idSucursal) throws IOException {

        SucursalBancaria sucursalBancaria= sucursalDAO.get(idSucursal);
        httpServletResponse.getWriter().println(jsonConvert.toJson(sucursalBancaria));
    }
    
    //Metodo findAll
    @RequestMapping(value = {"/SucursalBancaria"})
    public void find(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException {
        List sucursalBancaria = sucursalDAO.findAll();

        httpServletResponse.getWriter().println(jsonConvert.toJson(sucursalBancaria));
    }
    
    //Metodo delete
    @RequestMapping(value = {"/SucursalBancaria/{id}"},method = RequestMethod.DELETE)
    public void delete(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @PathVariable("id") int idSucursal) throws IOException {
        sucursalDAO.delete(idSucursal);
         httpServletResponse.setStatus(204);
    }
    
    //Metodo insert
    @RequestMapping(value = {"/SucursalBancaria"},method = RequestMethod.POST)
    public void insert(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @RequestBody String jsonEntrada) throws IOException {
        
        SucursalBancaria sucursalBancaria=(SucursalBancaria)jsonConvert.fromJson(jsonEntrada, SucursalBancaria.class);
        sucursalDAO.insert(sucursalBancaria);
    }
    
    //Metodo update
    @RequestMapping(value = {"/SucursalBancaria"},method = RequestMethod.PUT)
    public void update(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @RequestBody String jsonEntrada) throws IOException {
        
        SucursalBancaria sucursalBancaria=(SucursalBancaria)jsonConvert.fromJson(jsonEntrada, SucursalBancaria.class);
        sucursalDAO.update(sucursalBancaria);
        
    }
}
