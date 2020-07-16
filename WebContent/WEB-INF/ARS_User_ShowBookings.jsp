<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	
 <%--
******************************************************************************************************************************
* Description:	Presentation Layer for ShowBookings Page
* Functionality:This is a Jsp, which allows User to view bookings based on username.
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
<title>Your Bookings - Airline Reservation System</title>
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
<br>
<br>
<center>
<c:if test="${bookings.isEmpty()==false}">
<h3>Your Bookings </h3>
<br>
<table class="clsTable" border="1">
<tr>
	<th>Booking Id</th>
	<th>Flight Number</th>
	<th>Source</th>
	<th>Destination</th>
	<th>Number Of Passengers</th>
	<th>Class Type</th>
	<th>Total Fare</th>
	<th>Seat Number Start</th>
	<th>Seat Number End</th>
	<th>Email Id</th>
	<th>Credit Card Number</th>
	<th>Actions</th>
</tr>
<c:forEach var="bookings" items="${bookings}" >
			<tr>
				<td>${bookings.bookingId}</td>
				<td>${bookings.flightno}</td>
				<td>${bookings.srcCity}</td>
				<td>${bookings.destCity}</td>
				<td>${bookings.noOfPassengers}</td>
				<td>${bookings.classType}</td>
				<td>${bookings.totalFare}</td>
				<td>${bookings.seatNumberStart}</td>
				<td>${bookings.seatNumberEnd}</td>
				<td>${bookings.custEmail}</td>
				<td>${bookings.creditCardNumber}</td>
				<td><a href="update?bId=${bookings.bookingId}&uname=${bookings.username}" class="clsHref">Update</a>&nbsp;&nbsp;<a href="cancel?bId=${bookings.bookingId}&uname=${bookings.username}&noOfPassengers=${bookings.noOfPassengers}" class="clsHref">Cancel</a></td>
			</tr>
</c:forEach>
</table>
</c:if>
<c:if test="${bookings.isEmpty()==true}">
	<h1 style="color: red;">Sorry!!!No Bookings Found.</h1>
</c:if>
</center>
<%@ include file="ARS_Footer.jsp"%>
</body>
</html>