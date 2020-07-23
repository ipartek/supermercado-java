<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   

<jsp:include page="includes/cabecera.jsp" >
  <jsp:param name="pagina" value="inicio" />
  <jsp:param name="title" value="Inicio" /> 
</jsp:include>


<p class="bg-danger p-2">BUG Categorias DropDown</p>

<h3>${encabezado}</h3>
	
			
			<c:forEach items="${categoriasConProductos}" var="c">
					
					<h4>${c.nombre}</h4>
					<hr>
					
					<div class="row-card">
							
						<c:forEach items="${c.productos}" var="p">	
							
							<div class="card">
							  <img src="${p.imagen}" class="card-img-top" alt="${p.nombre}">
							  <div class="card-body">
							    <h5 class="card-title">${p.nombre}</h5>
							    <p><span class="badge badge-secondary">${p.categoria.nombre}</span></p>
							    <p class="precio">${p.precio} €</p>					    					    
							    <p class="precio">${p.usuario.nombre}</p>
							  </div>
							</div>					
							
						</c:forEach>
						
					</div>
				
			</c:forEach>
			


<%@include file="includes/pie.jsp" %>

