<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   

<jsp:include page="../../includes/office-head.jsp" />
<jsp:include page="../../includes/office-navbar.jsp" />
    
           
                        
        <h2>Fomrulario</h2>
        
        ${producto}
        
        <form action="views/frontoffice/crear-producto" method="post">
        
        	<input type="submit" value="Crear">
        
        </form>
                        
  
 <jsp:include page="../../includes/office-footer.jsp" />                  