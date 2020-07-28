<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   

<jsp:include page="../../includes/cabecera.jsp" >
  <jsp:param name="pagina" value="parser" />
  <jsp:param name="title" value="parser" /> 
</jsp:include>



<p>Vamos a usar la libreia de <a href="https://jsoup.org/" target="_blank">JSoup</a> para conectarnos auna pagina web y obtener o parsear el HTML para conseguir información.</p>
<p>Recordar que hay que meter en el <b>pom.xml</b> la dependencia nueva, se puede encontrar en el <a href="https://mvnrepository.com/artifact/org.jsoup/jsoup/1.13.1" target="_blank">Repository Central de Maven</a></p>

<hr>
<p>Vamos a usar como pagina de pruebas <a href="http://example.com/" target="_blank">http://example.com/</a></p>
<p>Titulo: <b>${titulo}</b></p>
<p>Titulo2: <b>${titulo2}</b></p>

<p>Puedes usar <code>doc.selec(String)</code> para hacer consultas mas complejas <a href="https://jsoup.org/cookbook/extracting-data/selector-syntax">leer documentación</a></p>


<%@include file="../../includes/pie.jsp" %>