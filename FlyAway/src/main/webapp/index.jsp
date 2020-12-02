
<%@page import="com.FlyAway.controller.Getplaces"%>
<%@page import="java.util.Collections"%>
<%@page import="java.util.ArrayList"%>

<%@page import="java.util.Calendar"%>
<%@page import="java.util.Collection"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Flyaway</title>
<style>
h1 {
	position: absolute;
	top: 5%;
	left: 21%;
		color:white;
}

h2 {
	position: absolute;
	top: 13%;
	left: 24%;
	color:white;
}

h4 {
	position: absolute;
	top: 20%;
	left: 27%;
		color:white;
}

h3 {
	position: absolute;
	top: 25%;
	left: 16%;
	color:white;
}

#Source {
	position: absolute;
	top: 43%;
	width: 25%;
	left: 22%;
	font-size: 18px;
}

#Destination {
	position: absolute;
	top: 50%;
	
	width: 25%;
	left: 22%;
	font-size: 18px;
}

#slabel {
	position: absolute;
	top: 43%;
	width: 25%;
	left: 10%;
	font-size: 18px;
	color:white;
}

#dLabel {
	position: absolute;
	top: 50%;
	width: 25%;
	left: 10%;
	font-size: 18px;
	color:white;
}

#noofpeoplelabel {
	position: absolute;
	top: 57%;
	width: 25%;
	left: 10%;
	font-size: 18px;
	color:white;
}

#noofpeople {
	position: absolute;
	top: 57%;
	width: 25%;
	left: 22%;
	font-size: 18px;
}

#DDlabel {
	position: absolute;
	top: 64%;
	width: 25%;
		color:white;
		
	left: 10%;
	font-size: 18px;
}

#traveldate {
	position: absolute;
	top: 64%;
	width: 25%;
	left: 22%;
	font-size: 18px;
}

#submit {
	position: absolute;
	top: 74%;
	width: 12%;
	left: 22%;
	font-size: 18px;
}

img {
	position: absolute;
	top: 0%;
	height: 100%;
	width: 50%;
	left: 50%;
}
</style>

<title>JSP Page</title>
</head>
<body style="background-color: #002e63">
	<img src="img1.jpg">
	<h1>Welcome To</h1>
	<h2>FlyAway</h2>
	<h4>By</h4>
	<h3>Tushar Srivastav(tushars292@gmail.com)</h3>

	<%
		Getplaces gp=new Getplaces();
		gp.connectToDb();
		ArrayList<String> arr = gp.fetchRecordsforplace();
	%>
	<form action="/FlyAway/flightdetail" method="post">



		<label for="Source" id="slabel"><b>Source :</b></label> <label
			for="Destination" id="dLabel"><b>Destination :</b></label> <br>

		<select name="Source" id="Source" required>

			<%
			
			 Collections.sort(arr);
			
				for (int i = 0; i < arr.size(); i++) {
					out.println("<option>" + arr.get(i) + "</option>");

				}
			%>
		</select> <select name="Destination" id="Destination" required>

			<%
			 Collections.reverse(arr); 
				
				for (int i = 0; i < arr.size(); i++) {
					out.println("<option>" + arr.get(i) + "</option>");

				}
			%>
		</select> <br> <label for="NoofPeople" id="noofpeoplelabel"><b>No
				of People :</b></label> <select name="NoofPeople" id="noofpeople">
			<%
				for (int i = 1; i < 10; i++) {
					out.println("<option>" + i + "</option>");

				}
			%>
		</select> <label for="DepartureDate" id="DDlabel"><b>Departure Date
				:</b></label>

		<%
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.DATE, 1);
			Date d = cal.getTime();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			String strDate = formatter.format(d);
		%>
		<input type=date name="traveldate" id="traveldate" min="<%=strDate%>"
			required>
		<button type="submit" name="submit" id="submit">Submit</button>
	</form>


</body>
</html>
