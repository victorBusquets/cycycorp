package com.fpmislata.banco.presentacion.filter.security;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class FilterImplSecurity implements Filter {

    FilterConfig filterConfig = null;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        HttpSession httpSession = httpServletRequest.getSession(true);
        String URIempleado = httpServletRequest.getContextPath()+"/api/session/empleado";
        String URIcliente = httpServletRequest.getContextPath()+"/api/session/cliente";

        if ((httpSession.getAttribute("idEmpleado") != null) ||(httpServletRequest.getRequestURI().equals(URIempleado))||(httpServletRequest.getRequestURI().equals(URIcliente))) {
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            httpServletResponse.setStatus(HttpServletResponse.SC_FORBIDDEN);

        }
    }

    @Override
    public void destroy() {
    }

}
