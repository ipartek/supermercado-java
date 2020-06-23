<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   

<jsp:include page="includes/cabecera.jsp" >
  <jsp:param name="pagina" value="inicio" />
  <jsp:param name="title" value="Inicio" /> 
</jsp:include>


<h1>Últimos Productos </h1>


	<div class="row-card">	

			<c:forEach items="${productos}" var="p" varStatus="loop">
						
					<div class="card">
					  <img src="${p.imagen}" class="card-img-top" alt="${p.nombre}">
					  <div class="card-body">
					    <h5 class="card-title">${p.nombre}</h5>
					    <p><span class="badge badge-secondary">${p.categoria.nombre}</span></p>
					    <p class="precio">${p.precio} €</p>					    					    
					  </div>
					</div>
				
			</c:forEach>
	</div>



<%@include file="includes/pie.jsp" %>

