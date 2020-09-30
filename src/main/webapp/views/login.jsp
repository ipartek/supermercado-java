
<jsp:include page="../includes/cabecera.jsp" >
  <jsp:param name="pagina" value="Login" />
  <jsp:param name="title" value="Login" /> 
</jsp:include>
		
	<form action="login" method="post" class="form-login" onsubmit="cifrar()">
	
	 	<div class="form-group">
			<input type="text" name="nombre" value="admin" placeholder="Tu Nombre"  class="form-control">
		</div>
		
		<div class="form-group">
			<input type="password" id="pass" value="123456" name="pass" placeholder="Tu Contraseña"  class="form-control">
		</div>
		
		<div class="form-group">
			<select name="idioma" class="custom-select">		  
			  <option value="es">Castellano</option>
			  <option value="eu">Euskera</option>
			  <option value="en">Ingles</option>
			</select>
		</div>
		
		<input type="submit" value="Iniciar Sesión" class="btn btn-primary btn-block">
	
	</form>
	
	<p class="text-center"><a href="views/registro.jsp" class="mt-4 btn btn-outline-primary">Registarte como nuevo usuario</a></p>

<%@include file="../includes/pie.jsp" %>

