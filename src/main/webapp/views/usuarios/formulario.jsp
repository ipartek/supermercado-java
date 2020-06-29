<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<jsp:include page="../../includes/cabecera.jsp" >
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
			
			<select name="rol"  class="form-control">
				<option value="1" ${ ( 1 == usuario.rol.id ) ? "selected" : "" }>normal</option>
				<option value="2" ${ ( 2 == usuario.rol.id ) ? "selected" : "" }>Administrador</option>
			</select>
			
			
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
				
		<c:if test="${ usuario.id != 0}">
		
			<div class="accordion mb-4" id="accordionExample">
			  <div class="card">
			  
			    <div class="card-header" id="headingOne">
			      <h2 class="mb-0">
			        <button class="btn btn-link btn-block text-left" type="button" data-toggle="collapse" data-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
			          Resetear Contraseña
			        </button>
			      </h2>
			    </div>
			
			    <div id="collapseOne" class="collapse" aria-labelledby="headingOne" data-parent="#accordionExample">
			      <div class="card-body">
			      
			        <input type="password" id="pass" name="passNuevo" class="form-control" placeholder="Nueva Contraseña">
					<input type="password" id="repass" name="passNuevoConfirmacion" class="form-control"  placeholder="Repitela para confirmar" >
					
			      </div>
			    </div>
			    
			  </div>
			  <!-- /.card -->
			  
			</div>
			<!--  accordion -->
			
				
			
			</c:if>		
				
				
		<input type="submit" value="Guardar" class="btn btn-primary btn-block">
	</form>

<%@include file="../../includes/pie.jsp" %>

