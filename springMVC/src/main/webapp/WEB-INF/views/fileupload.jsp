<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>file upload</title>
</head>
<body>

	<form action="fileuploadrequest" method="post" enctype="multipart/form-data">
		email : <input type="text" name="email" /><br /> 
		file : <input type="file" name="report" /><br /> 
		<input type="submit"	name="submit" /><br />
	</form>

	<form action="fileuploadparam" method="post" enctype="multipart/form-data">
		email : <input type="text" name="email" /><br /> 
		file : <input type="file" name="report" /><br /> 
		<input type="submit" name="submit" /><br />
	</form>

	<form action="fileuploadcommand" method="post" enctype="multipart/form-data">
		email : <input type="text" name="email" /><br />
		file : <input type="file" name="report" /><br /> 
		<input type="submit" name="submit" /><br />
	</form>

</body>
</html>