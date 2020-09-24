
<jsp:include page="../includes/cabecera.jsp" >
  <jsp:param name="pagina" value="api" />
  <jsp:param name="title" value="API" /> 
</jsp:include>

<h1>API WS REST</h1>

<h2>Productos</h2>
<p>Endpoint: <b>http://localhost:8080/supermerkado-master/api/producto/</b></p>
<p>Podemos realizar un CRUD los productos:</p>


<p>Metodos habilitados:</p>

<ul class="list-group">

	<li class="list-group-item">
		<span class="badge badge-success">GET</span> 
		<b>endpoint/producto/</b>   
		<span class="float-right badge badge-secondary ml-2">200</span>
		<span class="float-right">Listado de todos los productos</span>
	</li>
	<li class="list-group-item">
		<span class="badge badge-success">GET</span> 
		<b>endpoint/producto/{id}</b>   
		<span class="float-right badge badge-secondary ml-2">200</span>
		<span class="float-right badge badge-secondary ml-2">204</span>
		<span class="float-right">Detalle de un producto</span>
	</li>
	
	<li class="list-group-item">
		<span class="badge badge-danger">DELETE</span> 
		<b>endpoint/producto/{id}</b>   
		<span class="float-right badge badge-secondary ml-2">200</span>
		<span class="float-right badge badge-secondary ml-2">409</span>
		<span class="float-right">Eliminar de un producto</span>
	</li>
	
	<li class="list-group-item">
		<span class="badge badge-warning">PUT</span> 
		<b>endpoint/producto/{id}</b>   
		<span class="float-right badge badge-secondary ml-2">200</span>
		<span class="float-right badge badge-secondary ml-2">409</span>
		<span class="float-right">Modificar de un producto</span>
	</li>
	
	<li class="list-group-item">
		<span class="badge badge-info">POST</span> 
		<b>endpoint/producto/</b>   
		<span class="float-right badge badge-secondary ml-2">201</span>
		<span class="float-right badge badge-secondary ml-2">409</span>
		<span class="float-right">Crear de un producto</span>
	</li>
	
	

</ul>

<p>Los metodos POST y PUT deben enviar datos en el body con formato JSON, los datos obligatorios tienen asterisco</p>

<code><pre>
{
  "id": 15,
  <b>*"nombre"</b>: "acelgas con Jamon con brillo",
  <b>*"imagen"</b>: "https://i.blogs.es/6b70d4/acelgas-arco-jamon/1366_2000.jpg",
 <b> *"precio"</b>: 0,
  "usuario": {
    <b>*"id"</b>: 6,
    "nombre": "pepe",
    "contrasenia": "",
    "rol": {
      "id": 1,
      "nombre": ""
    }
  },
  "categoria": {
    <b>*"id"</b>: 1,
    "nombre": "comestibles"   
  }
}
</pre></code>

	

<%@include file="../includes/pie.jsp" %>

