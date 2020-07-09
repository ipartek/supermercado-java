
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
	
	<p>*** Antes de usar el TAGLIB es necesario incluir la directiva para importarlo</p>
	
	<div class="bg-dark text-white">
		<code>&lt;%@ taglib uri="https://formacion.ipartek.com/jsp/tlds/ejemplos" prefix="ejemplos" %&gt;</code>
	</div>
	
	<hr>
	
	<code>&lt;ejemplos:holamundo/&gt;</code> <ejemplos:holamundo/>
	
	<br>
	<code>&lt;ejemplos:holamundo2/&gt;</code> <ejemplos:holamundo2/>
	
	<br>
	<code>&lt;ejemplos:boton texto="Hola Soy un Boton" colorFondo="#00FFCC"/&gt;</code>
	<ejemplos:boton texto="Hola Soy un Boton" colorFondo="#00FFCC"/>
	
	<br>
	<ejemplos:badge valorComparar="100" valorMostrar="500"/>
	<ejemplos:badge valorComparar="100" valorMostrar="100"/>
	<br>
	<ejemplos:badge valorComparar="500" valorMostrar="100"/>
	<br>
	
	
	<br>
	<code>&lt;ejemplos:boton texto="Hola Soy un Boton Rosa" colorFondo="pink"/&gt;</code>
	<ejemplos:boton texto="Hola Soy un Boton Rosa" colorFondo="pink"/>
	
	
	
	<div class="row mt-4">
	
		<ejemplos:card titulo="Surf Search Spot"
					   urlEnlaceBoton="https://www.surfsearchspot.com/"					 
					   urlImagen="https://lh4.googleusercontent.com/-Sis89s8-PxU/U04-HZ8scLI/AAAAAAAAB_o/voPzoUoMsUw/s815/portada-facebook.png" 
					   descripcion="App web y movil para previsiones de surf"/>
	
		<ejemplos:card titulo="BootStrap"
					   urlEnlaceBoton="https://getbootstrap.com/"					 
					   urlImagen="data:image/jpeg;base64,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" 
					   />
	
	</div>	
	<hr>
	<p class="">*** Esto Lo puedes Leer?, Cuidado con el SKIP_BODY del ejemplo <code>com.ipartek.formacion.tags.TagHolaMundo</code>, si cambias ese valor no veras este parrafo.</p>
	<hr class="mb-5">
	
	

<%@include file="../../includes/pie.jsp" %>

