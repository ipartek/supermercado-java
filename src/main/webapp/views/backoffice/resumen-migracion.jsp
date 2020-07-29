<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   

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
	<p>Linea Errores numero Campos diferente 6: <b>${numero_errores_campos}</b></p>
	<p>Error nombre duplicadp: <b>${numero_errores_nombre}</b></p>
</div>	


  
 <jsp:include page="../../includes/office-footer.jsp" />    