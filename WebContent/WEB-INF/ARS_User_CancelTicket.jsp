<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
   
    <%--
******************************************************************************************************************************
* Description:	Presentation Layer for Cancel Ticket Page
* Functionality:This is a Jsp, which allows user to cancel ticket.
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
<title>Cancel Ticket - Airline Reservation System</title>
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
	<c:url var="addUrl" value="retrieveFlight"/>
	</c:if>
	<c:if test="${username!=null}">
	<div id="homePageNavigator">
		<b>Welcome ${username }</b>
		<div id="homePageLoginLink">
			<a href="loginSearchHome?uname=${username }">Home</a>|<a href="showBookings?uname=${username }" >YourBookings</a>|<a href="mainHome">Logout</a>
		</div>
	</div>
	<c:url var="addUrl" value="loginRetrieveFlight"/>
	</c:if>
	<br><br><br><br><br><br>
	<center>
<form:form action="confirmCancel" method="post">
<table class="clsTable">
 
<tr>
<td>Booking Id</td>
<td>
<input class="clsTextInput" type="text" value="${bookingId}" name="bookingId" readonly="readonly"/>
<input type="hidden" value="${username}" name="username"/>
<input type="hidden" value="${noOfPassengers}" name="noOfPassengers"/>
</td>
<td>
<input class="clsButtonInput" type="submit" value="Confirm Cancellation"/>
</td>
</tr>
</table>
</form:form>
</center>
<%@ include file="ARS_Footer.jsp"%>
</body>
</html>