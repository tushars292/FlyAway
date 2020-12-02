<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page import="java.util.Calendar"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style>
#creditcardnolabel {
	position: absolute;
	left: 22%;
	color: white
}
#creditcardno {
	position: absolute;
	left:40%;
}
#enterexpiredatelabel {
	position: absolute;
	left: 22%;
	color: white
}
#enterexpiredate {
	position: absolute;
	left: 40%;
}
#cvvlabel {
	position: absolute;
	left: 22%;
	color: white
}
#cvv {
	position: absolute;
	left:40%;
}
#namelabel {
	position: absolute;
	left: 22%;
	color: white
}
#name {
	position: absolute;
	left:40%;
}
#submit {
position: absolute;
left:42%;}
</style>
<title>FlyAway Payment Gateway</title>
</head>
<body style="background-color: #002e63">

	<h1 style="color: white;text-align:center;">Payment Gateway</h1>
	<br>
	<div>
	<form action="/FlyAway/Flightbookingreport" method="post">
	<br>
		<h2 id="creditcardnolabel">Enter credit card no :</h2><br>
		<input type="text" name="creditcardno" placeholder="creditcardno"
			id="creditcardno" minlength=16 maxlenght=16 required /> <br>
		<h2 id="enterexpiredatelabel">Enter Expire Date :</h2><br>
		<%
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.DATE, 1);
			Date d = cal.getTime();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			String strDate = formatter.format(d);
		%>
		<input type=date name="expirydate" id="enterexpiredate"
			min="<%=strDate%>" required> <br><br>

		<h2 id="cvvlabel">Enter cvv :</h2><br>
		<input type="text" name="cvv" placeholder="cvv" id="cvv" minlength=3
			maxlenght=3 required /> <br>

		<h2 id="namelabel">Enter name :</h2><br>
		<input type="text" name="name" placeholder="name" id="name"
			minlength=3 maxlenght=3 required /> <br> <br> <br>
		<%
			ArrayList<String> fd = (ArrayList<String>) session.getAttribute("flightinformation");
		%>
		<button type="submit" name="submit" id="submit">
			Pay
			<%=fd.get(8)%></button>
	</form>
	</div>
</body>
</html>