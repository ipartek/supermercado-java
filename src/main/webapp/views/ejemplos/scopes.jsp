<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   

<jsp:include page="../../includes/cabecera.jsp" >
  <jsp:param name="pagina" value="scopes" />
  <jsp:param name="title" value="Scopes" /> 
</jsp:include>


<h1>SERVLET/JSP Scopes</h1>

<!-- definimos una varaible en la JSP -->
<c:set var="ejemplo_page" value="Titulo para la jsp de PageScope"></c:set>

<div class="row">
	<div class="col">
		<p>Tenemos 4 ambitos disponibles para guardar atributos.</p>
		
		<p class="bg-primary text-white p-2"><b>Usando los prefijos</b></p>
		<p>Atributo de Aplicacion <b>ejemplo_usuarios_conectados</b> = ${applicationScope.ejemplo_usuarios_conectados} </p>
		<p>Atributo de session <b>ejemplo_tiempo_conectado</b> = ${sessionScope.ejemplo_tiempo_conectado} minutos</p>
		<p>Atributo de Request <b>ejemplo_tiempo_conectado</b> = ${requestScope.ejemplo_nombre} </p>
		<p>Atributo de Pagina <b>ejemplo_page</b> = ${pageScope.ejemplo_page} </p>
		
		
		<p class="bg-primary text-white p-2"><b>Sin Usar los prefijos</b></p>
		<p>Atributo de Aplicacion <b>ejemplo_usuarios_conectados</b> = ${ejemplo_usuarios_conectados} </p>
		<p>Atributo de session <b>ejemplo_tiempo_conectado</b> = ${ejemplo_tiempo_conectado} minutos</p>
		<p>Atributo de Request <b>ejemplo_tiempo_conectado</b> = ${ejemplo_nombre} </p>
		<p>Atributo de Pagina <b>ejemplo_page</b> = ${ejemplo_page} </p>
		
		<p class="bg-primary text-white p-2"><b>Sin Usar los prefijos y mismo nombre atributo</b></p>
		<p>Vamos a guardar con el mismo nombre <b>"ejemplo_igual"</b> en todos los ambitos para ver cual prevalece.</p>
		<p>Si no especificamos el prefijo 1º busca en Pagina, luego en Request, session y finalmente en AplicationScope</p>
		
		<c:set var="ejemplo_igual" value="pagina"></c:set>
		
		
		<p>Atributo de Aplicacion <b>ejemplo_igual</b> = ${ejemplo_igual} </p>
		<p>Atributo de session <b>ejemplo_igual</b> = ${ejemplo_igual}</p>
		<p>Atributo de Request <b>ejemplo_igual</b> = ${ejemplo_igual}</p>
		<p>Atributo de Pagina <b>ejemplo_igual</b> = ${ejemplo_igual}</p>
		
	</div>
	<div class="col">
		<img src="imagenes/scopes.gif" alt="scopes de javaee" />
	</div>
</div>


<%@include file="../../includes/pie.jsp" %>

