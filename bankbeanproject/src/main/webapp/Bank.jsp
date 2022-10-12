<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<body>
	<jsp:useBean id="beanBank" class="com.infinite.bankbeanproject.Bank" scope="page"/>
	<jsp:setProperty property="*" name="beanEmploy"/>
	Account No:<jsp:getProperty property="accountNo" name="beanBank"/><br/>
	FirstName:<jsp:getProperty property="firstName" name="beanBank"/><br/>
	LirstName:<jsp:getProperty property="lastName" name="beanBank"/><br/>
	City:<jsp:getProperty property="city" name="beanBank"/><br/>
	State:<jsp:getProperty property="state" name="beanBank"/><br/>
	Amount:<jsp:getProperty property="amount" name="beanBank"/><br/>
	CheqFacil:<jsp:getProperty property="cheqFacil" name="beanBank"/><br/>
	AccountType:<jsp:getProperty property="accountType" name="beanBank"/><br/>
	
</body>
</body>
</html>