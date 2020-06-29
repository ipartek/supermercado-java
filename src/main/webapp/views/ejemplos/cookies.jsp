<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>

<jsp:include page="../../includes/cabecera.jsp" >
  <jsp:param name="pagina" value="inicio" />
  <jsp:param name="title" value="Inicio" /> 
</jsp:include>

	<h1>Ejemplo Cookies</h1>
	<p>Podemos usar el inspector de codigo para ver la cookies, pestaña <b>Storage</b></p>
	<p>Su ultima visita fue el dia <b> ${ cookie['ultima_visita'].value } </b></p>
	
	<form action="CookieController" method="post">
		
		<input type="text" name="email" placeholder="Tu Email" value="${ cookie['cEmail'].value }">
		<br>
	
		<input type="checkbox" name="recuerdame" ${ (not empty cookie['cEmail'].value) ? "checked" : ""  } >Recuerdame
		<br>
	
		<input type="submit" value="Guardar Cokies">
	</form>	


<%@include file="../../includes/pie.jsp" %>