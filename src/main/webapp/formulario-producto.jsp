<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<a href="index.jsp">Volver</a>

	<h1>Formulario Para Crear/Modificar Producto</h1>
	
	<p>${mensaje}</p>
	
	<form action="producto" method="post">
	
		<label for="id">id:</label>
		<input type="text" name="id" id="id" value="${producto.id}" readonly >
		<br>
		<label for="nombre">nombre:</label>
		<input type="text" name="nombre" id="nombre" value="${producto.nombre}" placeholder="Escribe el nombre del producto" >
		<br>
		<input type="submit" value="Guardar">
	</form>
	

</body>
</html>