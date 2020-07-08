package com.ipartek.formacion.tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.log4j.Logger;

public class TagBoton extends SimpleTagSupport {
	
	private final static Logger LOG = Logger.getLogger(SimpleTagSupport.class);
	
	private String colorFondo;
	private String texto;
	
	public void setColorFondo(String colorFondo) {
		this.colorFondo = colorFondo;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	
	@Override
	public void doTag() throws JspException, IOException {
	
		LOG.trace("Empezamos a escribir etiqueta");
		try {
			JspWriter out = getJspContext().getOut();		
			out.print("<button style='background-color:" + colorFondo + "'>");
				out.print(texto);
			out.print("</button>");
			
		}catch (Exception e) {
			LOG.error(e);
			throw new JspException("error creando tag");
		}	
	}	
	
	
	

}
