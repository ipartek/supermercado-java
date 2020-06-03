<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<jsp:include page="includes/cabecera.jsp" >
  <jsp:param name="pagina" value="usuario" />
  <jsp:param name="title" value="Editar Usuario" /> 
</jsp:include>


<h1>Editar Usuario</h1>

	<form action="usuario" method="post" onsubmit="cifrar()">
			
		<div class="form-group">
			<label for="id">id:</label>
			<input type="text" name="id" id="id" value="${usuario.id}" readonly class="form-control">
		</div>
		
		<div class="form-group">
			<label for="id">Rol:</label>
			<input type="text" name="rol" id="rol" value="${usuario.idRol}" readonly class="form-control">
		</div>		
		
		<div class="form-group">
			<label for="nombre">nombre:</label>
			<input type="text" name="nombre" id="nombre" value="${usuario.nombre}" class="form-control" placeholder="Escribe el nombre del producto" >
		</div>
		
		<c:if test="${ usuario.id == 0}">
			<div class="form-group">
				<label for="nombre">Contraseña:</label>
				<input type="password" name="pass" id="pass" value="${usuario.contrasenia}" class="form-control" >
			</div>
		</c:if>					
				
				
		<input type="submit" value="Guardar" class="btn btn-primary btn-block">
	</form>

<%@include file="includes/pie.jsp" %>

