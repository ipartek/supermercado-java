<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
    
<jsp:include page="includes/cabecera.jsp" >
  <jsp:param name="pagina" value="productos" />
  <jsp:param name="title" value="Guardar Producto" /> 
</jsp:include>
	
	

	<h1>Formulario Para Crear/Modificar Producto</h1>
	
	<p>${mensaje}</p>
	
	<form action="producto" method="post">
	
		<div class="form-group">
			<label for="id">id:</label>
			<input type="text" name="id" id="id" value="${producto.id}" readonly class="form-control">
		</div>	
		
		<div class="form-group">
			<label for="nombre">nombre:</label>
			<input type="text" name="nombre" id="nombre" value="${producto.nombre}" class="form-control" placeholder="Escribe el nombre del producto" >
		</div>
		
		<input type="submit" value="Guardar" class="btn btn-primary btn-block">
	</form>


<jsp:include page="includes/pie.jsp"  />	
