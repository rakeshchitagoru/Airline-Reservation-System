<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    
<%--
******************************************************************************************************************************
* Description:	Presentation Layer for Update Ticket Page
* Functionality:This is a Jsp, which allows user to update ticket.
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
<title>Update Booking - Airline Reservation System</title>
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
<h1>User Booking Information</h1>

<form:form method="post" action="confirmUpdate" modelAttribute="booking" >
<table class="clsTable">

	<tr>
		<td>Booking ID</td>
		<td><form:input class="clsTextInput" path="bookingId" value="${booking.bookingId }" readonly="true"/></td>
	</tr>
	<tr>
		<td>Flight Number</td>
		<td><form:input class="clsTextInput" path="flightno" value="${booking.flightno }" readonly="true"/></td>
	</tr>
	<tr>
		<td>Customer Email ID</td>
		<td><form:input class="clsTextInput" path="custEmail" value="${booking.custEmail }" /><form:errors path="custEmail" cssStyle="color:red"  /></td>
	</tr>
	<tr>
		<td>Number Of Passengers</td>
		<td><form:input class="clsTextInput" path="noOfPassengers" value="${booking.noOfPassengers }" readonly="true" /></td>
	</tr>
	<tr>
		<td>Class type</td>
		<td><form:input class="clsTextInput" path="classType" value="${booking.classType }" readonly="true" /></td>
	</tr>
	<tr>
		<td>Total Fare</td>
		<td><form:input class="clsTextInput" path="totalFare" value="${booking.totalFare }" readonly="true" /></td>
	</tr>
	<tr>
		<td>Seat Number Start</td>
		<td><form:input class="clsTextInput" path="seatNumberStart" value="${booking.seatNumberStart }" readonly="true" /></td>
	</tr>
	<tr>
		<td>Seat Number End</td>
		<td><form:input class="clsTextInput" path="seatNumberEnd" value="${booking.seatNumberEnd }" readonly="true"/></td>
	</tr>
	<tr>
		<td>Credit card Info</td>
		<td><form:input class="clsTextInput" path="creditCardNumber" value="${booking.creditCardNumber }" /><form:errors path="creditCardNumber" cssStyle="color:red"  /></td>
	</tr>
	<tr>
		<td>Source City</td>
		<td><form:input class="clsTextInput" path="srcCity" value="${booking.srcCity }"  readonly="true"/></td>
	</tr>
	<tr>
		<td>Destination City</td>
		<td><form:input class="clsTextInput" path="destCity" value="${booking.destCity }" readonly="true" /></td>
	</tr>
	<tr><td colspan="2">
	<form:input path="username" type="hidden" value="${booking.username}"/>
	<input class="clsButtonInput" type="submit" value="Update"/></td>
	</tr>
		
</table>
</form:form>
</center>
<%@ include file="ARS_Footer.jsp"%>
</body>
</html>