
<%@page import="com.FlyAway.controller.Adminformser"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>
h1 {
	top: 1%;
	color:white;
	text-align: center;
}
#btnchangepassword {
position: absolute;
top: 30%;
left: 22%;	
}
#btnplace {
position: absolute;
top: 30%;
left: 49%;	
}

#btnairline {
position: absolute;
top: 30%;
left: 68%;	
}
#btnflightdetail {
position: absolute;
top: 45%;
left: 22%;	
}
#btnremove {
position: absolute;
top: 45%;
left: 49%;
}

</style>
<meta charset="ISO-8859-1">
<title>Admin Page</title>
</head>
<body style="background-color: #002e63">
	<%
		String std = (String) request.getAttribute("data");
	    
	%>
	<h1>
		Welcome <%=session.getAttribute("user") %>	
	</h1>
<form action="/FlyAway/Admindat" method="post">
<button type="submit" name="btnchangepassword" class="btnchangepassword" id="btnchangepassword">Change Password
	</button>
	<br>
	<button type="submit" name="btnplace" class="btnplace" id="btnplace">Get Place
	</button>
	<br>
	<button type="submit" name="btnairline" class="btnairline" id="btnairline">Get
		airline</button>
	<br>
	<button type="submit" name="btnflightdetail" class="btnflightdetail" id="btnflightdetail">
		Get flight detail</button>
	<br>
       

</form>


</body>
</html>