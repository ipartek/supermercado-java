<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   

<jsp:include page="../../includes/office-head.jsp" />
<jsp:include page="../../includes/office-navbar-admin.jsp" />

<h2>Crawler de productos</h2>

<c:if test="${not empty cont}">
	<div class="alert alert-primary" role="alert">
	  Parseados y guaraddos ${cont} Productos.
	</div>
	<div class="alert alert-danger" role="alert">
	  Errores Parseando ${contError} Productos.
	</div>
</c:if>

<div class="row">
	
	
	<form action="views/backoffice/crawler" method="post">
	
	 	<div class="form-group">
	 		<p>1º Selecciona la Categoria donde importar los prductos.</p>
			<select class="custom-select" name="cat">		
			  <c:forEach items="${categorias}" var="cat">	
			  	<option value="${cat.id}" >${cat.nombre}</option>
			  </c:forEach>
			</select>
		</div>
		
		<div class="form-group">
		    <p>2º Indica la url donde estan los productos</p>
		    <input type="text" class="form-control" value="" name="url" id="url" placeholder="https://www.lidl.es/es/verano/c2159">
		</div>	  
		  
		<div class="form-group">		
		    <input type="submit" class="bnt btn-primary" value="buscar productos">
		</div>
		  
    </form>		  		 
	

</div>

  
 <jsp:include page="../../includes/office-footer.jsp" />    
