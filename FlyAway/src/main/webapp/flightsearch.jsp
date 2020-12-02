<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.FlyAway.controller.flightdetail"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Flyaway</title>
<style>
table, th, td {
	border: 1px solid white;
}
h1{
	text-align: center;
}
#Source{
	position: absolute;s
	top: 10%;
	width: 25%;
	left: 10%;
	font-size: 18px;
	}
	
#Destination{
	position: absolute;
	top: 10%;
	width: 25%;
	left: 45%;
	font-size: 18px;
	}
	
	#Dateoftravel{
	position: absolute;
	top: 10%;
	width: 25%;
	left: 75%;
	font-size: 18px;
	}
	
	#tableflight{
	position: absolute;
	top: 30%;
	width: 100%;
	}	
</style>
</head>
<body style="background-color: #002e63">
	<h1 style="color:white">Flyaway</h1>
	<form action="/FlyAway/Booking" method="post">
	<%
		ArrayList<String> ut = (ArrayList<String>) request.getAttribute("data");
		ResultSet rs = (ResultSet) request.getAttribute("resultset");
	
		
		session.setAttribute("noofpeople", ut.get(2));
		                           
	%>
	<div>
		<h3 id="Source" style="color:white">
			Source :
			<%=ut.get(0)%>
		</h3>
		<h3 id="Destination" style="color:white">
			Destination :
			<%=ut.get(1)%>
		</h3>
		<h3 id="Dateoftravel" style="color:white">
			Date of travel :
			<%=ut.get(3)%>
		</h3>
	</div>

	<div id="tableflight">
	
		<table style="width: 100%">
			<tr>
			<td style="color:white">Flight Name</td>
				<td style="color:white">Flight Number</td>
				<td style="color:white">Departure</td>
				<td style="color:white">Arrival</td>
				<td style="color:white">No of Stop</td>
				<td style="color:white">time</td>
				<td style="color:white">price</td>
				<td style="color:white">Book the flight</td>
				<%
					while (rs.next()) {
						int k = (Integer.valueOf(rs.getString("price")) * (Integer.valueOf(ut.get(2))));
						String flightno=rs.getString("Flight_No");
				%>

				<%-- Arranging data in tabular form 
	        --%>
			<tr>
				
				<td style="color:white"><%=rs.getString("Flight_Name")%></td>
				<td style="color:white"><%=flightno%></td>
				<td style="color:white"><%=rs.getString("Depature")%></td>
				<td style="color:white"><%=rs.getString("Arrival")%></td>
				<td style="color:white"><%=rs.getString("No_of_stops")%></td>
				<td style="color:white"><%=rs.getString("time")%></td>
				<td style="color:white"><%=k%></td>
				<td><button type=submit value="<%=flightno%>" name=book>Book</button></td>
				
			</tr>

			<%
				}
			%>
		</table>
		
	</div>
	</form>
</body>
</html>