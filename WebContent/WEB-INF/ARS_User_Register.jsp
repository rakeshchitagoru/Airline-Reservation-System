<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page import="com.cg.ars.service.UserServiceImpl"%>

 <%--
******************************************************************************************************************************
* Description:	Presentation Layer for Register Page
* Functionality:This is a Jsp, which allows User to Register.
* Author:		Team 1
* Style Sheet:	ArsStyle.css
* Script:		ArsScript.js
**********************************************************************************************************************************
--%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href=<c:url value="/styles/ArsStyle.css" /> rel="stylesheet" type="text/css" />
<link rel="icon" href=<c:url value="/images/ARS_Icon.jpg" /> />
<title>Register - Airline Reservation System</title>
<script src=<c:url value="/javascript/ArsScript.js" /> type="text/javascript" ></script>
</head>
<body>
	<%@ include file="ARS_Header.jsp"%>

	<div id="homePageNavigator">
		<a href="mainHome">Home</a>|<a href="aboutUs">About Us</a>
	</div>
	<center>
		<h3>Please enter the following details to register</h3>
		<c:if test="${flightNo==null}">
			<c:url var="addUrl" value="confirmRegister"/>
		</c:if>
		<c:if test="${flightNo!=null}">
			<c:url var="addUrl" value="confirmRegisterSearch"/>
		</c:if>
		<br> <br>
		<form:form method="post" action="${addUrl }" modelAttribute="user">
			<table class="clsTable">
				<tr>
					<td>User Name:</td>
					<td><form:input class="clsTextInput" path="username" required="true" />
					<form:errors path="username" cssStyle="color:red" /></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><form:input class="clsTextInput" path="password" id="pass" type="password" onkeyup='checkPassword()' required="true"  />
					<form:errors path="password" cssStyle="color:red" /></td>
				</tr>

				<tr>
					<td>Confirm Password:</td>
					<td><input class="clsTextInput" name="confirmPassword" type="password" id="cPass" onkeyup='checkPassword()'  required />
					<span id='message'></span></td>
				</tr>

				<tr>
					<td>Mobile Number</td>
					<td><form:input class="clsTextInput" path="mobileNo" required="true"  /> 
					<form:errors path="mobileNo" cssStyle="color:red" /></td>
				</tr>
				<tr>
					<td colspan="2"><input class="clsButtonInput" type="submit" value="Register" /></td>
				</tr>
			</table>
			<input type="hidden" name="flightNo" value="${flightNo }">
			<input type="hidden" name="noOfSeats" value="${noOfSeats }">
			<input type="hidden" name="type" value="${type }">
		</form:form>
		<c:if test="${userExist==true}">
			<h3>UserName Already exists. Try another one.</h3>
		</c:if>
	</center>
	<%@ include file="ARS_Footer.jsp"%>
</body>
</html>