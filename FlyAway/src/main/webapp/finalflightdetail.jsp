<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title style="color:white">flyAway flight detail</title>
<style>
table, th, td {
	border: 1px solid white;
}
#submit {
	position:  absolute;;
	left: 45%
}
</style>
</head>
<body style="background-color: #002e63">
	<h3 style="color:white">Flight Details :</h3>
	<%
		ArrayList<String> fd = (ArrayList<String>) session.getAttribute("flightinformation");
		ArrayList<ArrayList<Object>> ud = (ArrayList<ArrayList<Object>>) session.getAttribute("userlist");
		
	%>
<form action="/FlyAway/redirectingtosecureserver" method="post">
	<table style="width: 100%">
		<tr >
		
		    <td  style="color:white">Flight Name</td> 
			<td  style="color:white">Flight Number</td>
			<td  style="color:white">Source</td>
			<td style="color:white">Departure</td>
			<td style="color:white">Destination</td>
			<td style="color:white">Arrival</td>
			<td style="color:white">No of Stop</td>
			<td style="color:white">time</td>
			<td style="color:white">price</td>


		</tr>


		<tr >
			<td style="color:white"><%=fd.get(0)%></td>
		
			<td style="color:white"><%=fd.get(1)%></td>
		
			<td style="color:white"><%=fd.get(2)%></td>
		
			<td style="color:white"><%=fd.get(4)%></td>
		
			<td style="color:white"><%=fd.get(3)%></td>
		
			<td style="color:white"><%=fd.get(5)%></td>
		
			<td style="color:white"><%=fd.get(6)%></td>
		
			<td style="color:white"><%=fd.get(7)%></td>
		
			<td style="color:white"><%=fd.get(8)%></td>
		</tr>




	</table>


	<h3 style="color:white">User details :</h3>
	<table style="width: 100%">
		<tr>
			<td style="color:white">Title</td>
			<td style="color:white">Name</td>
			<td style="color:white">Date Of Birth</td>
			<td style="color:white">Phone</td>
			<td style="color:white">email id</td>
			<td style="color:white">Address</td>
		</tr>
		
		<%for(int i=0;i<ud.size();i++){ ArrayList<Object> udi=ud.get(i);%>
		
		<tr>
			<td style="color:white"><%=udi.get(0) %></td>
			<td style="color:white"><%=udi.get(1) %></td>
			<td style="color:white"><%=udi.get(2) %></td>
			<td style="color:white"><%=udi.get(3) %></td>
			<td style="color:white"><%=udi.get(4) %></td>
			<td style="color:white"><%=udi.get(5) %></td>
		</tr>
		
		<%} %>
		


	</table>
	<br>	<br>	<br>
  <button type="submit" class="btn"  id="submit" >Proceed to Pay </button></form>
</body>
</html>