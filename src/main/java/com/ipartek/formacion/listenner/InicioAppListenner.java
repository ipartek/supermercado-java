package com.ipartek.formacion.listenner;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.ipartek.formacion.controller.Alerta;
import com.ipartek.formacion.modelo.CategoriaDAOImpl;

/**
 * Application Lifecycle Listener implementation class InicioAppListenner
 *
 */
@WebListener
public class InicioAppListenner implements ServletContextListener {

	static private final CategoriaDAOImpl categoriaDAO = CategoriaDAOImpl.getInstance();

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         // cuando paramos la App
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
         // cuando ejecutamos la App en el Servidor, al arrancar la 1º vez
    	System.out.println("Estamos arrancado la App, y soy un evento");
    	
    	
    	// Este contexto es para toda la Aplicacion y es accesible desde cualñquier JSP o Servlet    	
    	ServletContext contextoAplicacion = sce.getServletContext();
    	
    	try {
    	
    		contextoAplicacion.setAttribute("categorias", categoriaDAO.getAll() );
    		
    	}catch (Exception e) {
    		contextoAplicacion.setAttribute("alerta", new Alerta("danger", "Tenemos un problema sin determinar") );
		}	
    	
    }
	
}
