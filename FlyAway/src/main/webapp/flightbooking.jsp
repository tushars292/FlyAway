<%@page import="java.util.ArrayList"%>

<%@page import="java.nio.channels.SeekableByteChannel"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style>
#id {
	position: absolute;
	left: 22%;
}

#po {
	position: absolute;
	left: 22%;
}

#iddes {
	position: absolute;
	left: 35%;
}

#namelabel {
	position: absolute;
	left: 22%;
}

#dateofbirthlabel {
	position: absolute;
	left: 22%;
}

#phonelabel {
	position: absolute;
	left: 22%;
}

#emaillabel {
	position: absolute;
	left: 22%;
}

#textlabel {
	position: absolute;
	left: 22%;
}

#dateofbirth {
	position: absolute;
	left: 35%;
}

#email {
	position: absolute;
	left: 35%;
}

#text {
	position: absolute;
	left: 35%;
}

#phone {
	position: absolute;
	left: 35%;
}

#name {
	position: absolute;
	left: 42%;
}

#submit {
	position: absolute;
	left: 50%;
}
</style>
<title>flight Registration</title>
</head>
<body style="background-color: #002e63">

	<h1 style="color: white; text-align: center">Flyaway User
		Detail</h1>
	<br>
	<%
		int noofpeople = Integer.valueOf((String) session.getAttribute("noofpeople"));
	%>
	<%
		Calendar cal = Calendar.getInstance();

		Date d = cal.getTime();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String strDate = formatter.format(d);
		String ut = (String) request.getAttribute("flightinformation");
	%>


	<form action="/FlyAway/registerpageinfo" method="post">
		<%
			for (int i = 1; i <= noofpeople; i++) {
		%>
		<div>
			<br> <br>
			<h3 id="po" style="color: white">
				Person
				<%=i%></h3>
			<br> <br>
			<h3 id="namelabel" style="color: white">Enter Your Name :</h3>
			<br> <select name="id" id="iddes" required>
				<%
					String[] arr = { "Mr", "Mrs", "Miss" };
						for (int k = 0; k < arr.length; k++) {
							out.println("<option>" + arr[k] + "</option>");

						}
				%>
			</select> <input type="text" name="name" placeholder="Enter Your name"
				id="name" maxlenght=20 required /><br> <br>
			<h3 id="dateofbirthlabel" style="color: white">Date Of Birth :</h3>
			<br> <input type="date" name="dateofbirth"
				placeholder="Date of Birth" id=dateofbirth max="<%=strDate%>"
				required /><br> <br>
			<h3 id="phonelabel" style="color: white">Phone :</h3>
			<br> <input type="tel" id="phone" name="phone"
				placeholder="mobile no" pattern="[0-9]{4}[0-9]{6}" required /><br>
			<h3 id="emaillabel" style="color: white">Email Address :</h3>
			<br> <input type="email" placeholder="Email Address" id="email"
				name="email">
		</div>
		<%
			}
		%>
		<br>
		<br>
		<h3 id="textlabel" style="color: white">Address :</h3>
		<input type="text" style="width: 300px; height: 200px" name="message"
			id="text" maxlength=100 required><br>
		<br> <br>
		<br> <br>
		<br> <br>
		<br> <br>
		<br> <br>
		<br> <br>
		<br> <br>
		<br> <br>
		<br> <br>
		<button type="submit" class="submit" id="submit" name="submit">Register</button>

	</form>
</body>
</html>