
<jsp:include page="../../includes/cabecera.jsp" >
  <jsp:param name="pagina" value="tagas" />
  <jsp:param name="title" value="Ejemplo Tag" /> 
</jsp:include>

<h1>TAGs Propios</h1>

	<%@ taglib uri="https://formacion.ipartek.com/jsp/tlds/ejemplos" prefix="ejemplos" %>
	
	
	<p>Como hemos visto en JSTL, las librerías de tags encapsulan funcionalidad Java en los JSP sin necesidad de insertar código. Podría ser útil por tanto desarrollar nuestras propias tags para el uso en nuestras aplicaciones. JSP nos ofrece esta posibilidad desde las primeras versiones del API. </p>
	<p>Podemos definir nuestras propias etiquetas y programarlas en Java para que generes HTML.</p>
	<p>Para ello debemos realizar los siguientes pasos:</p>
	<ol>
		<li>Crear una Clase que implemente la interfaz <code>javax.servlet.jsp.tagext.Tag</code> o <code>SimpleTagSupport</code></li>
		<li>Crear un descriptor de despliege (.tld) escrito en XML, mirar <code>WEB-INF/ejemplo.tld</code></li>
		<li>Registrar la etiqueta en el <code>WEB-INF/web.xml</code></li>
	</ol>
	<p>Existen varios projectos que podemos usar en nuestras Apps que ya implementan etiquetas, uno de los mas conocidos es <a href="https://www.primefaces.org/" target="_blank">PrimeFaces</a></p>
	
	<h2>Documentación</h2> 
	<nav>
		<ul>
			<li><a href="https://docs.oracle.com/cd/E19879-01/819-3669/bnalj/index.html" target="_blank">Documentación oficial Oravle JEE5</a></li>
			<li><a href="http://www.jtech.ua.es/ayto/ayto2008/jsp/sesion08-apuntes.html" target="_blank">Universidad Alicante - Creación de tags propias</a></li>
			<li><a href="JSP Custom Tags, etiquetas a medida" target="_blank">Programacion.net - Creación de tags propias</a></li>
			<li><a href="https://www.journaldev.com/2099/jsp-custom-tags-example-tutorial" target="_blank">Ejemplo Tag por parametros</a></li>
		</ul>
	</nav>
	
	<h2>Ejemplo de Uso de etiqueta propia</h2>
	<code>&lt;ejemplos:holamundo/&gt;</code> <ejemplos:holamundo/>
	
	<br>
	<code>&lt;ejemplos:holamundo2/&gt;</code> <ejemplos:holamundo2/>
	
	<br>
	<code>&lt;ejemplos:boton texto="Hola Soy un Boton" colorFondo="#00FFCC"/&gt;</code>
	<ejemplos:boton texto="Hola Soy un Boton" colorFondo="#00FFCC"/>
	
	<br>
	<code>&lt;ejemplos:boton texto="Hola Soy un Boton Rosa" colorFondo="pink"/&gt;</code>
	<ejemplos:boton texto="Hola Soy un Boton Rosa" colorFondo="pink"/>
	
	<hr>
	<p class="">*** Esto Lo puedes Leer?, Cuidado con el SKIP_BODY del ejemplo <code>com.ipartek.formacion.tags.TagHolaMundo</code>, si cambias ese valor no veras este parrafo.</p>
	<hr class="mb-5">
	
	

<%@include file="../../includes/pie.jsp" %>

