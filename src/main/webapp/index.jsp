<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   

<jsp:include page="includes/cabecera.jsp" >
  <jsp:param name="pagina" value="inicio" />
  <jsp:param name="title" value="Inicio" /> 
</jsp:include>


<h1>Últimos Productos</h1>


<ol>
	<c:forEach items="${productos}" var="p">
		<li>${p}</li>
	</c:forEach>
</ol>


<%@include file="includes/pie.jsp" %>

