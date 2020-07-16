<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
 <%--
******************************************************************************************************************************
* Description:		Presentation Layer for Book ticket Screen
* Functionality: 	This is a Jsp, which allows User to Book a Ticket based on inputs Destination, Source, Departure Date.
* Author:			Team 1
* Style Sheet:		ArsStyle.css
**********************************************************************************************************************************
--%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Book Ticket - Airline Reservation System</title>
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
	<center>
<h1>Ticket Booking</h1>
<form:form method="post" action="confirmBooking" modelAttribute="bookingInformation" >
<table class="clsTable" border="1">
			
			<tr>
				<td>Flight Number : </td><td><form:input class="clsTextInput" path="flightno" value="${bookingInformation.flightno}" readonly="true"/></td>
			</tr>
			<tr>
				<td>Number of Passengers : </td><td><form:input class="clsTextInput" path="noOfPassengers" value="${bookingInformation.noOfPassengers}" readonly="true" /></td>
			</tr>
			<tr>
				<td>Class Type : </td><td><form:input class="clsTextInput" path="classType" value="${bookingInformation.classType}" readonly="true"  /></td>
			</tr>
			<tr>
				<td>Total Fare : </td><td><form:input class="clsTextInput" path="totalFare" value="${bookingInformation.totalFare}" readonly="true" /></td>
			</tr>
			<tr>
				<td>Seat Number Start : </td><td><form:input class="clsTextInput" path="seatNumberStart" value="${bookingInformation.seatNumberStart}" readonly="true" /></td>
			</tr>
			<tr>
				<td>Seat Number End : </td><td><form:input class="clsTextInput" path="seatNumberEnd" value="${bookingInformation.seatNumberEnd}" readonly="true" /></td>
			</tr>
			<tr>
				<td>Source City : </td><td><form:input class="clsTextInput" path="srcCity" value="${bookingInformation.srcCity}" readonly="true" /></td>
			</tr>
			<tr>
				<td>Destination City : </td><td><form:input class="clsTextInput" path="destCity" value="${bookingInformation.destCity}" readonly="true"  /></td>
			</tr>	
			<tr>
				<td>Customer Email : </td><td><form:input class="clsTextInput" path="custEmail"  /><form:errors path="custEmail" cssStyle="color:red"  /></td>
			</tr>
			<tr>
				<td>Credit card Number : </td><td><form:input class="clsTextInput" path="creditCardNumber"  /><form:errors path="creditCardNumber" cssStyle="color:red"  /></td>
			</tr>
		</table>
		<input type="hidden" name="username" value="${username }">
		<input class="clsButtonInput" type="submit" value="Confirm Booking">
</form:form>
</center>
<%@ include file="ARS_Footer.jsp"%>
</body>
</html>