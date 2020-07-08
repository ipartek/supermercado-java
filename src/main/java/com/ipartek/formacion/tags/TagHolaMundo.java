package com.ipartek.formacion.tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;

import org.apache.log4j.Logger;



public class TagHolaMundo implements Tag {
	
	private final static Logger LOG = Logger.getLogger(TagHolaMundo.class);
	
	private PageContext pc;
	private Tag parent;

	@Override
	public void setPageContext(PageContext pc) {
		LOG.trace("seteamos contexto pagina jsp");
		this.pc = pc;
		
	}

	@Override
	public void setParent(Tag parentTag) {
		LOG.trace("seteamos Padre o contendor de la etiqueta");
		this.parent = parentTag;
	}

	@Override
	public Tag getParent() {		
		return parent;
	}

	@Override
	public int doStartTag() throws JspException {
		LOG.trace("Empezamos a escribir etiqueta");
		try {
			JspWriter out = pc.getOut();		
			out.print("Hola Mundo");
			
		}catch (Exception e) {
			LOG.error(e);
		}	
		
		// SKIP_BODY que le indica al motor de JSP que la etiqueta no tiene cuerpo (en realidad que no queremos evaluar el cuerpo)
		// <ejemplo:holaMundo />		
		// una ejempllo de etiqueta con cuerpo seria => <p> Soy en cuerpo </p>
		
		return SKIP_BODY;
	}

	@Override
	public int doEndTag() throws JspException {
		LOG.trace("Finalizamos a escribir etiqueta");
		// El método doEndtag se invoca cuando se encuentra la etiqueta de cierre, 
		// en este ejemplo se devuelve EVAL_PAGE para que siga evaluando el resto de la página, 
		// CUIDADO: si no queremos evaluar el resto de la pagina el valor a devolver será SKIP_PAGE, usando esto no saldra nada de HTML despues 
		return EVAL_PAGE;
	}

	@Override
	public void release() {
		LOG.trace("Lo invoca el motor de JSP para hacer limpieza");
	}

}
