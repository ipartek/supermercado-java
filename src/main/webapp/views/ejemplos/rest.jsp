
<jsp:include page="../../includes/cabecera.jsp" >
  <jsp:param name="pagina" value="WS Rest" />
  <jsp:param name="title" value="Ejemplo rest" /> 
</jsp:include>

<h1>WS REST</h1>


<p>Lo primero es crear un controlador para que retorne datos en JSON un producto harcodeado.</p>
<code>
{
   "id": 5,
   "nombre": "Gazpacho",
   "precio": 2.34
}
</code>
<p>El controlador ahora tenemos que cambiar el <b>response-type</b> que por defecto un servlet usa <b>text/html</b>, deberemos cambiarlo a <b>application/json</b></p>
<p>Ademas de habilitar <a href="https://developer.mozilla.org/es/docs/Web/HTTP/Access_control_CORS" target="_blank">CORS</a> si se van ahcer llamdas al servicio desde fuera del servidor.</p>

<h2>Ejemplo Básico</h2>
<a href="ejemplo-rest" target="_blank">Llamada tipo GET</a>
<p>Para el resto de peticiones (POST, PUT y DELETE) lo mejor es usar un cliente como POSTMAN o JS </p>


<h2>Ejemplo Usando DAO y GSON</h2>
<p>Vamos habilitar un servicio que pasamos como parametro el id de un producto y nos retorna su informacion en json.</p>
<p>Si el id existe en la bbdd retorna 200</p>
<p>Si el id NO existe en la bbdd retorna 204</p> 
<form method="get" action="ejemplo-rest2">
	<input type="text" name="id" placeholder="id del producto" required>
	<br>
	<input type="submit" value="Realizar REQUEST">
</form>
	

<%@include file="../../includes/pie.jsp" %>

