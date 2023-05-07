<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<body>
<form action="../authenticate" method="post">
	Email : <input type="text" name="email"/>
	
	<br><Br>
	
	Password : <input type="password" name="password"/>
	
	<bR><br>
	
	<input type="submit" value="Login"/>
</form>
<br>
${error}${msg}
</body>
</html>