<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

 <%--
******************************************************************************************************************************
* Description:	Presentation Layer for Retrieve Flights Page
* Functionality:This is a Jsp, which shows list of flights based on user input.
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
<title>Flight Details - Airline Reservation System</title>
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
<c:if test="${flights.isEmpty()==false}">
<h1>Available Flights</h1>
<table class="clsTable" border="1">
<div id="idRetrieveFlightHeading">
<tr>
	<th>Flight Number</th>
	<th>Airline</th>
	<th>Arrival Date</th>
	<th>Departure Time</th>
	<th>Arrival Time</th>
	<th>First Class Seats Left</th>
	<th>First Class Fare</th>
	<th>Business Class Seats Left</th>
	<th>Business Class Fare</th>
	<th>Action</th>
</tr></div>
<div id="idRetieveFlightContent">
<c:forEach var="flights" items="${flights}">
			<tr>
				<td>${flights.flightno}</td> 
				<td>${flights.airline}</td>
				<td>${flights.arrDate}</td>
				<td>${flights.depTime}</td>
				<td>${flights.arrTime}</td>
				<td>${flights.firstSeatLeft}</td>
				<td>${flights.firstSeatFare}</td>
				<td>${flights.bussSeatLeft}</td>
				<td>${flights.bussSeatFare}</td>
				<td>
					<c:if test="${username==null}">
						<c:if test="${type.equals('First Class')}">
							<c:if test="${noOfSeats<=flights.firstSeatLeft }">
								<a href="beforeLogin?flightNo=${flights.flightno}&type=${type}&noOfSeats=${noOfSeats}" class="clsHref">Book Ticket</a>
							</c:if>
							<c:if test="${noOfSeats>flights.firstSeatLeft }">
								No Seats available for the selected class type
							</c:if>
						</c:if>
						<c:if test="${type.equals('Business Class')}">
							<c:if test="${noOfSeats<=flights.bussSeatLeft }">
								<a href="beforeLogin?flightNo=${flights.flightno}&type=${type}&noOfSeats=${noOfSeats}" class="clsHref">Book Ticket</a>
							</c:if>
							<c:if test="${noOfSeats>flights.bussSeatLeft }">
								No Seats available for the selected class type
							</c:if>
						</c:if>
					</c:if>
					<c:if test="${username!=null}">
						<c:if test="${type.equals('First Class')}">
							<c:if test="${noOfSeats<=flights.firstSeatLeft }">
								<a href="bookTicket?flightNo=${flights.flightno}&type=${type}&noOfSeats=${noOfSeats}&username=${username}" class="clsHref">Book Ticket</a>
							</c:if>	
							<c:if test="${noOfSeats>flights.firstSeatLeft }">
								No Seats available for the selected class type
							</c:if>
						</c:if>
						<c:if test="${type.equals('Business Class')}">
							<c:if test="${noOfSeats<=flights.bussSeatLeft }">
								<a href="bookTicket?flightNo=${flights.flightno}&type=${type}&noOfSeats=${noOfSeats}&username=${username}" class="clsHref">Book Ticket</a>
							</c:if>	
							<c:if test="${noOfSeats>flights.bussSeatLeft }">
								No Seats available for the selected class type
							</c:if>
						</c:if>
					</c:if>
				</td>
			</tr>
		</c:forEach>
		</div>
		</table>
</c:if>

<c:if test="${flights.isEmpty()==true}">
	<h1 style="color: red;">Sorry!!!No Flights Found.</h1>
</c:if>
</center>
<%@ include file="ARS_Footer.jsp"%>
</body>
</html>