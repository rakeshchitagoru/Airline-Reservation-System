<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isErrorPage="true"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
     <%--
******************************************************************************************************************************
* Description:	Presentation Layer for Error Page
* Functionality:This is a Jsp, which is used as Error Page.
* Author:		Team 1
* Style Sheet:	ArsStyle.css
**********************************************************************************************************************************
--%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Error Page - Airline Reservation System</title>
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
	
	<br>
	<br>
	<br>
	<br>
	<center>
<h1>
		<%--Displaying the exception messages coming from the ControllerServlet Or Database--%>
		<c:if test="${errorMessage!=null}">
			Something went wrong( ${errorMessage} )
		</c:if>
</h1>
</center>
<%@ include file="ARS_Footer.jsp"%>
</body>
</html>