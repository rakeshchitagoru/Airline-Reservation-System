<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
	    
	     <%--
******************************************************************************************************************************
* Description:	Presentation Layer for Home Page
* Functionality:This is a Jsp, which is used as Home page.
* Author:		Team 1
* Style Sheet:	ArsStyle.css
* Script:		ArsScript.js
**********************************************************************************************************************************
--%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>HomePage - Airline Reservation System</title>
<link href=<c:url value="/styles/ArsStyle.css" /> rel="stylesheet" type="text/css" />
<link rel="icon" href=<c:url value="/images/ARS_Icon.jpg" /> />
<script src=<c:url value="/javascript/ArsScript.js" /> type="text/javascript" ></script>
</head>
<body onload="ARS_datePicker()">
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
		<div id="searchFlight">
			<form:form name="checkBooking" action="${addUrl}" onsubmit="return flag;">
				<select class="clsSelectInput" id="source" name="source" >
					<option value="" disabled="disabled" selected="selected">Select Departure City</option>
					<c:forEach var="sourceList" items="${sourceList }">
						<option value="${sourceList }" >${sourceList}</option>
					</c:forEach>
				</select>
				
				<br>
				<br>
				<select  class="clsSelectInput" id="destination" name="destination" onchange="ARS_checkDestination();">
					<option value="" disabled="disabled" selected="selected">Select Arrival City</option>
					<c:forEach var="destinationList" items="${destinationList }">
						<option value="${destinationList }">${destinationList}</option>
					</c:forEach>
				</select>
				 <span id='message'></span>
				<br>
				<br> <input type="date" class="clsDateInput" id="idDepartureDate" name="departureDate" placeholder="Enter Departure Date Here" required /><br>
				<br> <div class="clsSelectSeatType"><input type="radio" class="clsRadioInput" name="classType" value="First Class" checked="checked" />&nbsp;First Class 
				<input type="radio" class="clsRadioInput" name="classType" value="Business Class" />&nbsp; Business Class</div>
				<br>
				<br> 
				<select name="numOfSeats" class="clsSelectInput" required>
				<option value="" disabled="disabled" selected="selected" >Select Number of Seats</option>
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
					<option value="4">4</option>
					<option value="5">5</option>
				</select><br>
				<br> <input type="submit" class="clsButtonInput" value="Search Flights" >
			<input type="hidden" name="username" value="${username}"/>
			</form:form>
		</div>
	</center>
	<br>
	<br>
<div class="homeSlideShow" id="slideShowHomePage">
</div>
<%@ include file="ARS_Footer.jsp"%>
</body>
</html>