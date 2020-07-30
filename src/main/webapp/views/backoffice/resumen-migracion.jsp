<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<jsp:include page="../../includes/office-head.jsp" />
<jsp:include page="../../includes/office-navbar-admin.jsp" />

<h1>Resumen Proceso Migración</h1>
<hr>
<p style="font-size:20px; font-weight: 600; margin-bottom:10px;">${mensaje}</p>

<div style="border:1px solid black; padding:10px;">
	<p>Fichero Leido: <b>${fichero}</b></p>
	<p>Tiempo (ms): <b>${tiempo}</b></p>
	<p>Personas Leidas: <b>${numero_lineas}</b></p>
	<p>Personas Insertadas: <b>${numero_insercciones}</b></p>
	<p>Numero Linea Errorneas <b>${fn:length(lineaserroneas)}</b></p>
	<p>Error nombre duplicadp: <b>${numero_errores_nombre}</b></p>
</div>	

<h2>Lineas Erroneas</h2>
<ul class="list-group">
	<c:forEach items="${lineaserroneas}" var="linea">
		<li class="list-group-item">${linea}</li>
	</c:forEach>
</ul>

  
 <jsp:include page="../../includes/office-footer.jsp" />    