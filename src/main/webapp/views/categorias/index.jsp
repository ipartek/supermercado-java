<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
    
<jsp:include page="../../includes/cabecera.jsp" >
  <jsp:param name="pagina" value="categorias" />
  <jsp:param name="title" value="Categorias" /> 
</jsp:include>

	<h1>Listado Categorias</h1>
	
	<a href="categoria?id=0">Crear Nueva Categoria</a>
		
	<table class="tabla table table-striped">
		<thead>
			<tr>
				<td>Id</td>
				<td>Nombre</td>
				<td>Operaciones</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${categorias}" var="cat">
				<tr>
					<td>${cat.id}</td>
					<td>${cat.nombre}</td>
					<td>
						<a href="categoria?id=${cat.id}"><i class="far fa-edit fa-2x" title="Editar Registro"></i></a>
						<a href="categoria?id=${cat.id}&operacion=2" onclick="confirmar('${cat.nombre}')"><i class="fas fa-trash fa-2x" title="Eliminar Registro"></i></a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>			


<jsp:include page="../../includes/pie.jsp" />