package com.ipartek.formacion.listenner;

import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.log4j.Logger;

import com.ipartek.formacion.modelo.pojo.Usuario;

/**
 * Application Lifecycle Listener implementation class ListenerUsuarioLogeados
 *
 */
@WebListener
public class ListenerUsuarioLogeados implements HttpSessionListener, HttpSessionAttributeListener {

	private static HashMap<String, Usuario> hm = null;  
	private final static Logger LOG = Logger.getLogger(ListenerUsuarioLogeados.class);
    
	
	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent se)  { 
    	LOG.trace("nueva session");
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent se)  { 
    	LOG.trace("eliminada sesion");
    }

	/**
     * @see HttpSessionAttributeListener#attributeAdded(HttpSessionBindingEvent)
     */
    @SuppressWarnings("unchecked")
	public void attributeAdded(HttpSessionBindingEvent event)  { 
    	String nombreAtributo = event.getName();    	
    	ServletContext ctx = event.getSession().getServletContext();
    	String idSession = event.getSession().getId();
    	
    	LOG.trace("nuevo atributo en sesion " + nombreAtributo);
    	
    	//se acaba de hacer el login en LoginController
    	if ("usuario_login".equals(nombreAtributo)) {
    		Usuario usuario = (Usuario)event.getValue();
    		LOG.trace("usuario logeado " + usuario);
    		
    		hm = (HashMap<String, Usuario>)ctx.getAttribute("usuariosLogeados");
    		if ( null == hm ) {
    			hm = new HashMap<String, Usuario>(); 
    		}
    		hm.put(idSession, usuario);
    		ctx.setAttribute("usuariosLogeados", hm);
    		LOG.trace("usuario guardado en hasmap");
    		
    	}
    	
    }

	/**
     * @see HttpSessionAttributeListener#attributeRemoved(HttpSessionBindingEvent)
     */
    @SuppressWarnings("unchecked")
    public void attributeRemoved(HttpSessionBindingEvent event)  { 
    	String nombreAtributo = event.getName();
    	LOG.trace("eliminado atributo en sesion");
    	String idSession = event.getSession().getId();
    	ServletContext ctx = event.getSession().getServletContext();
    	
    	
    	if ("usuario_login".equals(nombreAtributo)) {
    		
    		hm = (HashMap<String, Usuario>)ctx.getAttribute("usuariosLogeados");
    		if ( null == hm ) {
    			hm = new HashMap<String, Usuario>(); 
    		}
    		hm.remove(idSession);
    		ctx.setAttribute("usuariosLogeados", hm);
    	}
    	
    }

	/**
     * @see HttpSessionAttributeListener#attributeRepla)ced(HttpSessionBindingEvent)
     */
    public void attributeReplaced(HttpSessionBindingEvent event)  { 
    	LOG.trace("modificado atributo en sesion");
    }
	
}
