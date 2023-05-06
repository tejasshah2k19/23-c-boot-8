<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Signup</h2>

	<form enctype="multipart/form-data" method="post" action="saveprofile" >
		
		Profile : <input type="file" name="profile"/>
		<br><br>
		
		<input type="submit" value="SaveProfile"/>
	</form>

</body>
</html>