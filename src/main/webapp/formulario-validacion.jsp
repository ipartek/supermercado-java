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

	<c:if test="${not empty  validaciones}">
	
		<ol>
			<c:forEach items="${validaciones}" var="validacion">
				<li>${validacion}</li>
			</c:forEach>
		</ol>
	
	</c:if>
	

	<form action="formulario-validacion-ejemplo" method="post">
	
		<input type="text" name="nombre" value="${nombre}" placeholder="Tu Nombre">
		<br>
		
		<input type="text" name="apellidos" value="${apellidos}" placeholder="Tus Apellidos">
		<br>
		
		<input type="submit" value="Enviar Formulario">
	
	</form>

</body>
</html>