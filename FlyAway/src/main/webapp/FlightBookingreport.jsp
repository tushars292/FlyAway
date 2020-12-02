<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Flyaway</title>
<style>
table, th, td {
	border: 1px solid white;
}</style>

</head>
<body  style="background-color: #002e63">
<h3 style="color: white">Flight details</h3>
<%
	ArrayList<String> fd = (ArrayList<String>) session.getAttribute("flightinformation");
	ArrayList<ArrayList<Object>> ud = (ArrayList<ArrayList<Object>>) session.getAttribute("userlist");

	String[] seat = (String[]) request.getAttribute("seat");
%>

<table style="width: 100%">
	<tr>
		<td style="color: white">Flight Name</td>
		<td style="color: white">Flight Number</td>
		<td style="color: white">Source</td>
		<td style="color: white">Departure</td>
		<td style="color: white">Destination</td>
		<td style="color: white">Arrival</td>
		<td style="color: white">No of Stop</td>
		<td style="color: white">time</td>
		<td style="color: white">price</td>
		<td style="color: white">Status</td>
		<td style="color: white">Payment method</td>


	</tr>


	<tr>
		<td style="color: white"><%=fd.get(0)%></td>

		<td style="color: white"><%=fd.get(1)%></td>

		<td style="color: white"><%=fd.get(2)%></td>

		<td style="color: white"><%=fd.get(4)%></td>

		<td style="color: white"><%=fd.get(3)%></td>

		<td style="color: white"><%=fd.get(5)%></td>

		<td style="color: white"><%=fd.get(6)%></td>

		<td style="color: white"><%=fd.get(7)%></td>

		<td style="color: white"><%=fd.get(8)%></td>


		<td style="color: white">Confirm</td>


		<td style="color: white">Credit card</td>
	</tr>




</table>


<h3 style="color: white">User details</h3>
<table style="width: 100%">
	<tr style="color: white">
		<td style="color: white">Title</td>
		<td style="color: white">Name</td>
		<td style="color: white">Date Of Birth</td>
		<td style="color: white">Phone</td>
		<td style="color: white">email id</td>
		<td style="color: white">Address</td>
		<td style="color: white">Status</td>
		<td style="color: white">seat</td>

	</tr>

	<%
		for (int i = 0; i < ud.size(); i++) {
			ArrayList<Object> udi = ud.get(i);
	%>

	<tr style="color: white">
		<td style="color: white"><%=udi.get(0)%></td>
		<td style="color: white"><%=udi.get(1)%></td>
		<td style="color: white"><%=udi.get(2)%></td>
		<td style="color: white"><%=udi.get(3)%></td>
		<td style="color: white"><%=udi.get(4)%></td>
		<td style="color: white"><%=udi.get(5)%></td>
		<td style="color: white" >Confirmed</td>
		<td style="color: white"><%=seat[i]%></td>
	</tr>

	<%
		}
	%>



</table>

</body>
</html>