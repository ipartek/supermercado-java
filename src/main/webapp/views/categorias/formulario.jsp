<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
    
<jsp:include page="../../includes/cabecera.jsp" >
  <jsp:param name="pagina" value="categorias" />
  <jsp:param name="title" value="Categorias" /> 
</jsp:include>


	<form action="categoria" method="post">
	
		<div class="form-group">
			<label for="id">id:</label>
			<input type="text" name="id" id="id" value="${categoria.id}" readonly class="form-control">
		</div>	
		
		<div class="form-group">
			<label for="nombre">Nombre:</label>
			<input type="text" name="nombre" id="nombre" value="${categoria.nombre}" autofocus class="form-control">
		</div>	
		
		<input type="submit" value="Guardar" class="btn btn-primary btn-block">
	
	</form>



<jsp:include page="../../includes/pie.jsp" />