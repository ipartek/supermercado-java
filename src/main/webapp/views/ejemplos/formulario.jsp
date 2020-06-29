<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Formulario Completo</h1>
	
	
	<c:if test="${not empty validationes}">
		<div style="padding:20px; background-color: #DDD; color:#000; ">
			<ol>
				<c:forEach items="${validationes}" var="validacion">
					<li>${validacion}</li>
				</c:forEach>
			</ol>
		</div>
	</c:if>
	
	
	<form novalidate action="formulario-completo" method="post">
	
		  		<label for="name">Name*:</label><br>
                <input type="text" name="name" id="name" value="${name}" autofocus required><br>
 
                <br>
 
                <label for="surname">Surname*:</label><br>
                <input type="text" name="surname" id="surname" required><br>
 
                <br>
 
                <label for="age">Age:</label><br>
                <input type="number" placeholder="16" min="16" step="1" name="age" id="age" size="3" maxlength="3" value="16"><br>
 
                <br>
 
                <label for="studies">Studies:</label>
                <select name="studies" id="studies">
                    <option value="u">University</option>
                    <option value="v">Vocational training</option>
                    <option value="other" selected>Other</option>
                </select><br>
 
                <br>
 
                <fieldset>
                    <legend>Shift:</legend>
 
                    <input type="checkbox" id="fulltime" name="shift" value="ft">
                    <label for="fulltime"> Full time</label><br>
 
                    <input type="checkbox" id="parttime" name="shift" value="pt">
                    <label for="parttime"> Part time</label><br>
 
                    <input type="checkbox" id="all" name="shift" value="all" checked>
                    <label for="all"> All</label><br>
                </fieldset>
 
                <br>
 
                <fieldset>
                    <legend>Gender:</legend>
 
                    <input type="radio" id="male" name="gender" value="m">
                    <label for="male">Male</label><br>
 
                    <input type="radio" id="female" name="gender" value="f">
                    <label for="female">Female</label><br>
 
                    <input type="radio" id="other" name="gender" value="other" checked>
                    <label for="other">Other</label><br>
                </fieldset>
 
                <br>
 
                <label for="comments">Comments:</label><br>
                <textarea name="comments" placeholder="Enter your comments" id="comments"></textarea><br>                        
 
                <br>
 
                <input type="submit" value="Send"><br>
	
	</form>
	
</body>
</html>