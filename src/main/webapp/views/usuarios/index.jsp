<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="../../includes/cabecera.jsp" >
  <jsp:param name="pagina" value="usuario" />
  <jsp:param name="title" value="Usuarios" /> 
</jsp:include>


<h1>Usuarios</h1>

<a href="usuario?id=0">Dar de Alta Nuevo Usuario</a>

<table class="tabla table table-striped">
	<thead>
		<tr>
			<td>Id</td>
			<td>Nombre</td>
			<td>Rol</td>
			<td>Operaciones</td>					
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${usuarios}" var="u">
			<tr>
				<td>${u.id}</td> 
				<td>${u.nombre}</td>
				<td>[${u.rol.id}] ${u.rol.nombre}</td>
				<td><a href="usuario?id=${u.id}" class="mr-4"> <i class="far fa-edit fa-2x" title="Editar Registro"></i></a>			
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>


<%@include file="../../includes/pie.jsp" %>

