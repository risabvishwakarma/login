<html>
<head>

<title>login</title>

</head>
<body>
<form action="/log" method="post">
<input type="pass" name="otp" placeholder="OTP">

<button>SUBMIT</button>
</form>
<button><a href = "/"> Another Login</a></button>
<br>
check your Gmail "<%= (String)request.getAttribute("id")%>  ",enter that OTP here
</body>


</html>