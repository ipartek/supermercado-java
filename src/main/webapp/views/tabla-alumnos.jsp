
<%@page import="com.ipartek.formacion.modelo.pojo.Usuario"%>
<%@page import="java.util.ArrayList"%>

<a href="index.jsp">VOLVER</a>

<h1>Tabla con Alumnos</h1>


<style>
	td { border:1px solid black }
</style>


<%
	// recogemos la informacion "atributo" enviado desde el controlador
	ArrayList<Usuario> alumnos = (ArrayList<Usuario>)request.getAttribute("alumnos");

%>


<table style="width:100%; border:1px solid black;">
  <tr>
    <th>id</th>
    <th>Nombre</th>     
  </tr>
  
  <% for( Usuario u : alumnos ){ %>
  
  	<tr>
  		<td><%=u.getId()%></td>
  		<td><%=u.getNombre()%></td>
  	</tr>
  
  <% } %>
  
</table>

