<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	 
	  <%--
******************************************************************************************************************************
* Description:	Presentation Layer for Footer Page
* Functionality:This is a Jsp, which is used as header for other jsp pages.
* Author:		Team 1
* Style Sheet:	ArsStyle.css
**********************************************************************************************************************************
--%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

</head>
<body>
	<div class="clsHeaderDiv">
		&nbsp;&nbsp;
		<div>
			<img id="idIcon" src=<c:url value ="/images/ARS_Icon.jpg"/> />
		</div>
		<div>
			<h1 align="center">Airline Reservation System</h1>
		</div>
		<br>
		<br>
	</div>
</body>
</html>