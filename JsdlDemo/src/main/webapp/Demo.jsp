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
	<c:set var="firstName" value="${param['firstName']}"/>
	<c:set var="lastName" value="${param['lastName']}"/>
	First Name:
	<b>
		<c:out value="${firstName}"/>
		</b><br/><br/>
	Last Name:
	<b>
		<c:out value="${lastName}"/>
		</b>
</body>
</html>