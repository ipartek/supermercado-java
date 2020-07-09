package com.ipartek.formacion.tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.log4j.Logger;

public class TagCard extends SimpleTagSupport {

	private final static Logger LOG = Logger.getLogger(TagCard.class);

	private String titulo;
	private String urlImagen;
	private String urlEnlaceBoton;
	private String descripcion; // al ser opcional si no se pone, no entra en el setter

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setUrlImagen(String urlImagen) {
		this.urlImagen = urlImagen;
	}

	public void setUrlEnlaceBoton(String urlEnlaceBoton) {
		this.urlEnlaceBoton = urlEnlaceBoton;
	}

	public void setDescripcion(String descripcion) {		
		this.descripcion = descripcion;
	}

	@Override
	public void doTag() throws JspException, IOException {

		LOG.trace("Empezamos a escribir etiqueta");
		try {
			
			// cuidado porque puede ser null al ser no-requerido
			descripcion = ( descripcion == null ) ? "" : descripcion;
			
			JspWriter out = getJspContext().getOut();
			out.print("<div class=\"card\" style=\"width: 18rem; margin-right:0.5rem;\">");
				out.print("<img class=\"card-img-top\" src=\"" + urlImagen + "\" alt=\"Card image cap\">");
				out.print("<div class=\"card-body\">");
				out.print("<h5 class=\"card-title\">" + titulo + "</h5>");
				out.print("<p class=\"card-text\">" + descripcion + "</p>");
				out.print("<a href=\"" + urlEnlaceBoton + "\" class=\"btn btn-block btn-outline-primary\">Ver Detalle</a>");
				out.print("</div>");
			out.print("</div>");

		} catch (Exception e) {
			LOG.error(e);
			throw new JspException("error creando tag");
		}
	}

}
