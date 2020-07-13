<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ page isErrorPage="true" %>

<jsp:include page="includes/cabecera.jsp" >
  <jsp:param name="pagina" value="error" />
  <jsp:param name="title" value="error" /> 
</jsp:include>


<div class="jumbotron">
  <h1 class="display-4">Opsss!!!</h1>
  <p class="lead">Lo sentimos pero tenemos un ERROR.</p>
  <hr class="my-4">
  <p>Por favor ponte en contacto con el administrador.</p>
  <a class="btn btn-primary btn-lg" href="mailto:auraga@ipartek.com?Subject=Aquí%20el%20asunto%20del%20mail&body=Motivo:<%=exception.getMessage()%>" role="button">Enviar Email</a>
</div>




<%@include file="includes/pie.jsp" %>