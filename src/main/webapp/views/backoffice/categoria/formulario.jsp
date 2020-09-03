<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   

<jsp:include page="../../../includes/office-head.jsp" />
<jsp:include page="../../../includes/office-navbar-admin.jsp" />


	<form action="views/backoffice/categoria" method="post">
	
		<div class="form-group">
			<label for="id">id:</label>
			<input type="text" name="id" id="id" value="${categoria.id}" readonly class="form-control">
		</div>	
		
		<div class="form-group">
			<label for="nombre">nombre:</label>
			<input type="text" name="nombre" id="nombre" value="${categoria.nombre}" class="form-control" placeholder="Escribe el nombre de la categoria" >
		</div>
	

		<input type="submit" value="Guardar" class="btn btn-primary btn-block">
		
	</form>

  
 <jsp:include page="../../../includes/office-footer.jsp" />