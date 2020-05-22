<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<a href="index.jsp">Volver</a>

	<h1>Listado Productos</h1>
	<p>${mensaje}</p>


	<a href="producto">Ir a formulario para Crear Nuevo Producto</a>

	<%
		// Podemos usar el ${}  EL - Expresion Lenguage en los JSPs
		// suele ser mas comodo que tener que usar < % % >, a estos porcentajes se les llama SCRIPLETS
		// ademas se pueden combinar con JSTL - Java Servlet Tag Libraries
	%>	

	
	<table>
		<thead>
			<tr>
				<td>Id</td>
				<td>Nombre</td>
				<td>Precio</td>
				<td>Imagen</td>
				<td>Operaciones</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${productos}" var="p">
				<tr>
					<td>${p.id}</td> <% // no hace falta usar el getter p.id == p.getId() %>
					<td>${p.nombre}</td>
					<td>${p.precio} &euro;</td>
					<td><img src="${p.imagen}" alt="imagen..."></td>
					<td>
						<a href="producto?id=${p.id}">EDITAR</a>
						<a href="producto-eliminar?id=${p.id}">ELIMINAR</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	


</body>
</html>