<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Register</title>
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
color:white;
top: 20%;
text-align: center;
}
#usern{
text-align: center;
position: absolute;
top: 19%;
width: 25%;
left:37%;
font-size: 18px;

}


#newpassword{
text-align: center;
position: absolute;
top: 29%;
width: 25%;
left:37%;
font-size: 18px;

}
#confirmpassword{
text-align: center;
position: absolute;
top: 39%;
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
<form action="/FlyAway/userregistration" method="post">
<div class="log-form">
  <h1 >User Registration</h1>
     <br>
    <input type="text" name="username" placeholder="User Name"  id="usern"  maxlenght=16  required/>

    <br>
 
    <input type="password" name="newpassword" placeholder="New Password"  id="newpassword"  maxlenght=8  required/>
    <br>
   
    <input type="password" name="confirmpassword" placeholder="Confirm Password" id="confirmpassword"  maxlenght=8 required/>
    <br>
    <button type="submit" class="btn"  id="submit">Submit</button>
</div>
  </form>
</body>
</html>