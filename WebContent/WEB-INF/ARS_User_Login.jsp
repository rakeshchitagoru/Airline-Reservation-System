<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    
     <%--
******************************************************************************************************************************
* Description:	Presentation Layer for Login Page
* Functionality:This is a Jsp, which is used as Login page.
* Author:		Team 1
* Style Sheet:	ArsStyle.css
**********************************************************************************************************************************
--%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href=<c:url value="/styles/ArsStyle.css" /> rel="stylesheet" type="text/css" />
<link rel="icon" href=<c:url value="/images/ARS_Icon.jpg" /> />
<title>LogIn - Airline Reservation System</title>
</head>
<body text="cornsilk">
<%@ include file="ARS_Header.jsp"%>

	<div id="homePageNavigator">
		<a href="mainHome">Home</a>|<a href="aboutUs">About Us</a>
	</div>
<center><h1>Login page</h1>
	<c:if test="${flightNo==null}">
		<c:url var="addUrl" value="loginSearch"/>
	</c:if>
	<c:if test="${flightNo!=null}">
		<c:url var="addUrl" value="login"/>
	</c:if>
	
<form:form method="post" action="${addUrl }" modelAttribute="user">
User name:<input class="clsTextInput" type="text" name="username" required/>
Password:<input class="clsTextInput" type="password" name="password" required/>
<input class="clsButtonInput" type="submit" value="Login"/>
<input type="hidden" name="flightNo" value="${flightNo }">
<input type="hidden" name="noOfSeats" value="${noOfSeats }">
<input type="hidden" name="type" value="${type }">
</form:form>
<c:if test="${message!=null}">
			<h3>Invalid Login credentials.</h3>
</c:if>
<br>
<br>
<c:if test="${flightNo==null}">
<b>New User? </b><a href="register" style="color: cornsilk">Register Here</a>
</c:if>
<c:if test="${flightNo!=null}">
<b>New User? </b><a href="registerSearch?flightNo=${flightNo }&noOfSeats=${noOfSeats }&type=${type}" style="color: cornsilk">Register Here</a>
</c:if>
<br>
<br>
<c:if test="${msg!=null}">
			<h3 style="color: green;">${msg }</h3>
</c:if>
</center>
<%@ include file="ARS_Footer.jsp"%>
</body>
</html>