<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   

<jsp:include page="../../includes/office-head.jsp" />
<jsp:include page="../../includes/office-navbar.jsp" />

              
        <h1 class="mt-2">Dar de Alta Nuevo Producto</h1>
                     
        <form action="views/frontoffice/guardar-producto" method="post">
        
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
					<label for="categoria_id">Categoria:</label>
					<select class="custom-select" name="categoria_id" id="categoria_id">
					  <c:forEach items="${categorias}" var="categoria">
					  	<option value="${categoria.id}"  ${ ( categoria.id eq producto.categoria.id ) ? "selected" : "" }  >${categoria.nombre}</option>
					  </c:forEach>					  					  
					</select>
				</div>	
				
				
				<input type="submit" value="Guardar" class="btn btn-primary btn-block">
        
        </form>
                        
  
 <jsp:include page="../../includes/office-footer.jsp" />                  