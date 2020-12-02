<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Administrator Login</title>


<style>
h1 {
top: 1%;
color:white;
	text-align: center;
}

h2 {
color:white;
top: 10%;
	text-align: center;
}

h4 {
top: 20%;
color:white;
text-align: center;
}
#usern{
text-align: center;
position: absolute;
top: 25%;
width: 25%;
left:37%;
font-size: 18px;

}
#pwd{
text-align: center;
position: absolute;
left:37%;
width: 25%;
font-size: 18px;

}

#submit{
text-align: center;
position: absolute;
left:37%;
width: 25%;
font-size: 18px;
top: 60%;
}

</style>

</head>
<body style="background-color: #002e63">
<form action="/FlyAway/Adminformser" method="post">
<div class="log-form">
  <h1 >Administrator Log-in</h1>
  <h2>Flyaway</h2>
  <h4>User name</h4>
    <input type="text" name="username" placeholder="User Name"  id="usern"  maxlenght=16  required/>
    ,<br>
    <h4>Password</h4>
    <input type="password" name="password" placeholder="Password" id="pwd"  maxlenght=8 required/>
    <br>
    <button type="submit" class="btn"  id="submit">Log in</button>
</div>
  </form>
</body>
</html>