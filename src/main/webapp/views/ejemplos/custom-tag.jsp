
<jsp:include page="../../includes/cabecera.jsp" >
  <jsp:param name="pagina" value="tagas" />
  <jsp:param name="title" value="Ejemplo Tag" /> 
</jsp:include>

<h1>TAGs Propios</h1>

	<%@ taglib uri="https://formacion.ipartek.com/jsp/tlds/ejemplos" prefix="ejemplos" %>
	
	<p>Podemos definir nuestras propias etiquetas y programarlas en Java para que generes HTML</p>
	
	<code>&lt;ejemplos:holamundo/&gt;</code> <ejemplos:holamundo/>
	
	

<%@include file="../../includes/pie.jsp" %>

