<html>
<head>

<title>login</title>

</head>
<body>
<form action="/otpgen">
<input type="text" name="userid" placeholder="userId">
<button >GetOTP</button>

<br>
Enter correct gmail id,you will receive OTP there.
<%= (String)request.getAttribute("message")%> 
<form>

</body>

</html>