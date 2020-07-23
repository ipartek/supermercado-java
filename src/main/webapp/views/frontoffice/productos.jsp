<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   

<jsp:include page="../../includes/office-head.jsp" />
<jsp:include page="../../includes/office-navbar.jsp" />
    
           
<h2>${titulo}</h2>
	
	<table class="tabla table table-striped">
		<thead>
			<tr>
				<td>Id</td>
				<td>Nombre</td>
				<td>Precio</td>
				<td>Imagen</td>
				<td>Categoria</td>
				<td>Operaciones</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${productos}" var="p">
				<tr>
					<td>${p.id}</td> <% // no hace falta usar el getter p.id == p.getId() %>
					<td>${p.nombre}</td>
					<td>${p.precio} &euro;</td>
					<td><img src="${p.imagen}"  class="img-thumbnail" alt="imagen..."></td>
					<td>${p.categoria.nombre}</td>
					<td>
						<a href="views/frontoffice/guardar-producto?id=${p.id}" class="mr-4"> <i class="far fa-edit fa-2x" title="Editar Producto"></i></a>
						<a href="views/frontoffice/eliminar?id=${p.id}"
						   onclick="confirmar('${p.nombre}')" 
						   ><i class="fas fa-trash fa-2x" title="Eliminar Producto"></i></a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
                        
  
 <jsp:include page="../../includes/office-footer.jsp" />                  