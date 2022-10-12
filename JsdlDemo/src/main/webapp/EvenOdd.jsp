<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form method="get" action="EvenOdd.jsp">
	Enter a Number:
	<input type="number" name="no"/><br/><br/>
	<input type="submit" value="Show"/>
	</form>
	<c:if test="${param.no!=null}">
	<c:set var="no" value="${param.no}"/>
	<c:if test="${no%2==0 }">
		<c:out value="Even Number..."/>
	</c:if>
	
	<c:if test="${no%2==1}">
	<c:out value="Odd Number..."/>
	</c:if>
	</c:if>
</body>
</html>