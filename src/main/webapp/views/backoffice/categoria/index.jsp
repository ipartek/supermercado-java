<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>   

<jsp:include page="../../../includes/office-head.jsp" />
<jsp:include page="../../../includes/office-navbar-admin.jsp" />
    
	<h1>${fn:length(categorias)} Categorias </h1>
	<a href="views/backoffice/categoria?id=0">Crear Nuevo Categoria</a> 
	  
	<table class="tabla table table-striped">
		<thead>
			<tr>
				<td>Id</td>
				<td>Nombre</td>				
				<td>operaciones</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${categorias}" var="cat">
				<tr>
					<td>${cat.id}</td>
					<td>${cat.nombre}</td>					
					<td>
						<a href="views/backoffice/categoria?id=${cat.id}" class="mr-4"> <i class="far fa-edit fa-2x" title="Editar Categoria"></i></a>
						<a href="views/backoffice/categoria?id=${cat.id}&accion=delete"
						   onclick="confirmar('${cat.nombre}')" 
						   ><i class="fas fa-trash fa-2x" title="Eliminar Categoria"></i></a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
                 
  
  
 <jsp:include page="../../../includes/office-footer.jsp" />  