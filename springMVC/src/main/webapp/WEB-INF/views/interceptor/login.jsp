<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>

<body>
	<div align="center">
		<h3>로그인</h3>
		<form action="login" method="post">
			<div>
				<p>이메일을 입력하세요</p>
				<input type="text" name="email" placeholder="EMAIL"
					required="required" />
			</div>
			
			<div>
				
				<p>비밀번호를 입력하세요</p>
				<input type="password" name="userpw" placeholder="Password"/>
		
	</div>
	<div>
	<input type="submit" value="LOGIN" />
</div>
	</form>
</body>
</html>
