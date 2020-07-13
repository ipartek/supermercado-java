<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ page isErrorPage="true" %>

<jsp:include page="includes/cabecera.jsp" >
  <jsp:param name="pagina" value="404" />
  <jsp:param name="title" value="404" /> 
</jsp:include>


<div class="jumbotron">
  <h1 class="text-center display-1">404</h1>
  <p class="lead">Lo sentimos pero no existe la pagina indicada.</p>
  <hr class="my-4">  
  <a class="btn btn-primary btn-lg" href="inicio" role="button">Volver Al Inicio</a>
</div>




<%@include file="includes/pie.jsp" %>