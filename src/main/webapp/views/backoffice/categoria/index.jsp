<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>   

<jsp:include page="../../../includes/office-head.jsp" />
<jsp:include page="../../../includes/office-navbar-admin.jsp" />
    
	<h1>${fn:length(categorias)} Categorias </h1>
	  
	 <ul class="list-group">
	  <c:forEach items="${categorias}" var="cat">
	  	<li class="list-group-item">${cat.id} - ${cat.nombre} </li>
	  </c:forEach> 
	</ul>
  
  
 <jsp:include page="../../../includes/office-footer.jsp" />  