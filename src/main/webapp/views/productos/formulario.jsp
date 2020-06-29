<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   

    
<jsp:include page="../../includes/cabecera.jsp" >
  <jsp:param name="pagina" value="productos" />
  <jsp:param name="title" value="Guardar Producto" /> 
</jsp:include>
	
	

	<h1>Formulario Para Crear/Modificar Producto</h1>
	
	<div class="row pb-4">
	
		<div class="col">
				<form action="producto" method="post">
			
				<div class="form-group">
					<label for="id">id:</label>
					<input type="text" name="id" id="id" value="${producto.id}" readonly class="form-control">
				</div>	
				
				<div class="form-group">
					<label for="nombre">nombre:</label>
					<input type="text" name="nombre" id="nombre" value="${producto.nombre}" class="form-control" placeholder="Escribe el nombre del producto" >
				</div>
				
				<div class="form-group">
					<label for="precio">precio:</label>
					<input type="text" name="precio" id="precio" value="${producto.precio}" class="form-control" placeholder="0.0 €" >
				</div>
				
				<div class="form-group">
					<label for="imagen">Imagen:</label>
					<input type="text" name="imagen" id="imagen" value="${producto.imagen}" class="form-control" placeholder="URL de la imagen (.jpg o .png)" >
				</div>
				
				<div class="form-group">
					<select class="custom-select" name="categoria_id">
					  <c:forEach items="${categorias}" var="categoria">
					  	<option value="${categoria.id}"  ${ ( categoria.id eq producto.categoria.id ) ? "selected" : "" }  >${categoria.nombre}</option>
					  </c:forEach>					  					  
					</select>
				</div>	
				
				
				<input type="submit" value="Guardar" class="btn btn-primary btn-block">
			</form>
		</div>
		
		<div class="col">
			<img src="${producto.imagen}" class="img-thumbnail" alt="imagen del producto a modificar">
		</div>
	</div>
	
	
	


<jsp:include page="../../includes/pie.jsp"  />	
