
<jsp:include page="../includes/cabecera.jsp" >
  <jsp:param name="pagina" value="Login" />
  <jsp:param name="title" value="Login" /> 
</jsp:include>
		
	<form action="registro" method="post" onsubmit="cifrar()">
			
		
		<div class="form-group">			
			<label for="nombre">nombre:</label>
			<small id="nombreHelp" class="form-text"></small>
			<input type="text" name="nombre" onkeyUp="buscarUsuario(event)" id="nombre" value="${nombre}" class="form-control" placeholder="Escribe tu nombre de usuario" >			
		</div>
		
		<div class="form-group">
			<label for="nombre">Fecha Nacimiento:</label>
			<input type="date" name="fecha" id="fecha" value="${fecha}" class="form-control" >
		</div>
		
		
		<div class="form-group">
			<label for="nombre">Contraseña:</label>
			<input type="password" name="pass" id="pass"  class="form-control" >
		</div>
		
		<div class="form-group">
			<label for="nombre">Repite Contraseña:</label>
			<input type="password" name="repass" id="repass"  class="form-control" >
		</div>
							
				
		<input type="submit" value="Guardar" class="btn btn-primary btn-block">
	</form>
	

<%@include file="../includes/pie.jsp" %>

