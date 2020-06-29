<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	 <h1>Curriculum resume</h1>
	 
	 <p style="color: red;">${mensaje}</p>
 
    <hr>
 
    <h3>Name:</h3>${name}
 
    <h3>Surname:</h3>${surname}
 
    <h3>Age:</h3>${age}
 
    <h3>Studies:</h3>${studies}
 
    <h3>Shifts:</h3>
 
    <%
        ArrayList<String> shifts = (ArrayList<String>) request.getAttribute("shiftsSelected");    
        for (String shift : shifts) {
    %> 
  		  <p> <%=shift%> </p>
 
    <%
    } // FOR
    %>
        
 
    <h3>Gender:</h3>${gender}
 
    <h3>Comments:</h3>${comments}
 

</body>
</html>