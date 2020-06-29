<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    

<%! String pagina = "formulario";  %>
<%! String title = "Form Validacion";  %>
<%@include file="../../includes/cabecera.jsp" %>

	<c:if test="${not empty  validaciones}">
	
		<ol>
			<c:forEach items="${validaciones}" var="validacion">
				<li>${validacion}</li>
			</c:forEach>
		</ol>
	
	</c:if>
	

	<form action="formulario-validacion-ejemplo" method="post">
	
		<input type="text" name="nombre" value="${nombre}" placeholder="Tu Nombre">
		<br>
		
		<input type="text" name="apellidos" value="${apellidos}" placeholder="Tus Apellidos">
		<br>
		
		 <label for="cars">Choose a car:</label>

		<p style="background-color:yellow;">ATRIBUTO DEBUG => ${cars}</p>
		<select name="cars" id="cars"> 
		  <option value="volvo"    ${ ( cars eq "volvo" ) ? "selected" : "" } >Volvo</option>
		  <option value="saab"     ${ ( cars eq "saab" ) ? "selected" : "" } >Saab</option>
		  <option value="mercedes" ${ ( cars eq "mercedes" ) ? "selected" : "" }>Mercedes</option>
		  <option value="audi"     ${ ( cars eq "audi" ) ? "selected" : "" }>Audi</option>
		</select> 
		<br>
		
		<input type="submit" value="Enviar Formulario">
	
	</form>

	
<%@include file="../../includes/pie.jsp" %>	
	