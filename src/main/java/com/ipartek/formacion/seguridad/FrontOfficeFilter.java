package com.ipartek.formacion.seguridad;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.ipartek.formacion.modelo.pojo.Rol;
import com.ipartek.formacion.modelo.pojo.Usuario;

/**
 * Servlet Filter implementation class BackOfficeFilter
 */
@WebFilter(dispatcherTypes = {
				DispatcherType.REQUEST, 
				DispatcherType.FORWARD, 
				DispatcherType.INCLUDE, 
				DispatcherType.ERROR
		}
					, urlPatterns = { "/views/frontoffice/*" })
public class FrontOfficeFilter implements Filter {

	private final static Logger LOG = Logger.getLogger(FrontOfficeFilter.class);

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {		
		LOG.trace("se destruye filtro");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		
		//Cuidado que hay que castear de ServletRequest -> HttpServletRequest
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		
		//necesitamos la url de como comienza nuestra App, apra construir una ryta ABSOLUTA y que no sea relativa
		String urlInicioApp = req.getContextPath();
		
		LOG.trace("filtrando URI:" + req.getRequestURI() );
	
		// recuperar usuario de session
		Usuario usarioLogin = (Usuario) req.getSession().getAttribute("usuario_login");
		
		if ( usarioLogin == null ) {
			LOG.warn("No ha pasado por el LOGIN, usuario NULL, SIN AUTENTIFICAR ");
			//res.sendRedirect( "login.jsp"); => ruta relativa, se no mete en un bucle
			res.sendRedirect( urlInicioApp + "/views/login.jsp"); //ruta absoluta
			
		}else if ( usarioLogin.getRol().getId() != Rol.USUARIO) {
			
			LOG.warn("Cuidado usuario sin privilegios de USUARIO, SIN AUTORIZACION");
			res.sendRedirect( urlInicioApp + "/views/login.jsp");
			
			
		}else {
			// si usuario administrador
			// dejamos pasar y continua la request
			chain.doFilter(request, response);	
		}
		
		
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		LOG.trace("se inicializa filtro");
	}

}
