<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
 <%--
******************************************************************************************************************************
* Description:	Presentation Layer for User Success Page
* Functionality:This is a Jsp, which shows success page on successful booking, updation and cancellation of ticket.
* Author:		Team 1
* Style Sheet:	ArsStyle.css
**********************************************************************************************************************************
--%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Booking Success - Airline Reservation System</title>
<link href=<c:url value="/styles/ArsStyle.css" /> rel="stylesheet" type="text/css" />
<link rel="icon" href=<c:url value="/images/ARS_Icon.jpg" /> />
</head>
<body>
<%@ include file="ARS_Header.jsp"%>
	<c:if test="${username==null}">
	<div id="homePageNavigator">
		<a href="mainHome">Home</a>|<a href="aboutUs">About Us</a>
			<div id="homePageLoginLink">
				<a href="mainLogin" >Login</a>|<a href="register">Register</a>
			</div>
	</div>
	</c:if>
	<c:if test="${username!=null}">
	<div id="homePageNavigator">
		<b>Welcome ${username }</b>
		<div id="homePageLoginLink">
			<a href="loginSearchHome?uname=${username }">Home</a>|<a href="showBookings?uname=${username }" >YourBookings</a>|<a href="mainHome">Logout</a>
		</div>
	</div>
	</c:if>
<c:if test="${successMessage.equals('Updation')}">
<center>
<h3 style="color: green;">ThankYou ${username}!! Your Updation is Successful.</h3>
</center>
</c:if>

<c:if test="${successMessage.equals('Cancellation')}">
<center>
<h3 style="color: green;">ThankYou ${username}!! Your Cancellation is Successful.</h3>
</center>
</c:if>

<c:if test="${successMessage.equals('Booking')}">
<center>
<h3 style="color: green;">ThankYou ${username}!! Your Booking is Successful.</h3>
</center>
</c:if>
<%@ include file="ARS_Footer.jsp"%>
</body>
</html>