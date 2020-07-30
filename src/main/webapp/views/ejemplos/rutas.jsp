<jsp:include page="../../includes/cabecera.jsp" >
  <jsp:param name="pagina" value="ejemplos" />
  <jsp:param name="title" value="Ejemplos" /> 
</jsp:include>


<h1>Rutas: Forward y Redirect</h1>

<p><b>FORWARD</b> Se hace una peticion(request) interna dentro del servidor, el camino que solemos usar es para ir desde un Controlador hacia una JSP. Como es la misma request se pueden pasar parametros y atributos a la Vista. La vista es la que genera la response. Ademas se mantiene la URL de la petición original.</p>
<p><b>REDIRECT</b> Se hace una respuesta (response) de tipo 3XX desde el servidor y el cliente automaticamente realiza la nueva request con la URL que le indica el servidor. Cambia la url original.</p>
<p>Podeis cambiar el <b>LoginController</b> para ver que pasa</p>
<img src="imagenes/froward vs redirect.jpeg" class="responsive">



<%@include file="../../includes/pie.jsp" %>

