package com.ipartek.formacion.tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * La clase Java que implemente el tag debe implementar el interfaz SimpleTag, que es una implementación más simple que la anterior Tag
 * @author javaee
 *
 */
public class TagHolaMujndoSimple extends SimpleTagSupport {
	
	public void doTag() throws JspException, IOException {
		
		getJspContext().getOut().write("Hello Wolrd con SimpleTagSupport");
	}

}
