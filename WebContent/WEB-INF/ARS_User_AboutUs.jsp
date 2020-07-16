<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
		    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	
	 <%--
******************************************************************************************************************************
* Description:	Presentation Layer for About Us Page
* Functionality:This is a Jsp, which is used as link in navigator ARS_User_HomePage.
* Author:		Team 1
* Style Sheet:	ArsStyle.css
**********************************************************************************************************************************
--%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AboutUs - Airline Reservation System</title>
<link href=<c:url value="/styles/ArsStyle.css" /> rel="stylesheet" type="text/css" />
<link rel="icon" href=<c:url value="/images/ARS_Icon.jpg" /> />
</head>
<body text="cornsilk">
	<%@ include file="ARS_Header.jsp"%>
	<c:if test="${username==null}">
	<div id="homePageNavigator">
		<a href="mainHome">Home</a>|<a href="aboutUs">About Us</a>
			<div id="homePageLoginLink">
				<a href="mainLogin" >Login</a>|<a href="register">Register</a>
			</div>
	</div>
	<c:url var="addUrl" value="retrieveFlight"/>
	</c:if>
	<c:if test="${username!=null}">
	<div id="homePageNavigator">
		<b>Welcome ${username }</b>
		<div id="homePageLoginLink">
			<a href="showBookings?uname=${username }" >YourBookings</a>|<a href="mainHome">Logout</a>
		</div>
	</div>
	<c:url var="addUrl" value="loginRetrieveFlight"/>
	</c:if>
	<br>
	<br> 
	<center>
	<h3>
	User Can search the flight directly on the home page.<br><br>
	If user wants to book the flight then he/she should be registered or can register at the time of booking.<br><br>
	At the time of user has to provide username,password and mobile number.<br><br>
	While booking user has to provide email id and credit card number.<br><br>
	This is Airline Reservation System Project which is made in PLP Training.
	</h3>
	</center>
	<br>
	<br>
	<%@ include file="ARS_Footer.jsp"%>
</body>
</html>