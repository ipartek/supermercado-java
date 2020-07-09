package com.ipartek.formacion.tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class TagBadge extends SimpleTagSupport {

	// atributos de la etiqueta
	private float valorMostrar;
	private float valorComparar;
	
	public void setValorMostrar(float valorMostrar) {
		this.valorMostrar = valorMostrar;
	}

	public void setValorComparar(float valorComparar) {
		this.valorComparar = valorComparar;
	}
	



	@Override
	public void doTag() throws JspException, IOException {
		
		JspWriter out = getJspContext().getOut();
		
		String clase = "";
		if ( valorMostrar > valorComparar ) {
			clase = "success";
		}else if ( valorMostrar < valorComparar ) {
			clase = "danger";
		}else {
			clase = "primary";
		}
		
		out.print("<span class=\"badge badge-" + clase + "\">");
			out.print(valorMostrar);
		out.print("</span>");
	}
	

}
