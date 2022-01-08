<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- Spring Custom Tag 를 사용하기 위한 설정 -->
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="login.form.title"/></title>
</head>
<body>
	<form action="loginform" method="post">
		<p>
			<label for="email">
				<spring:message code="email"></spring:message>
			</label>
			<input type="text" name="email" id="email"/>
		</p>
		
		<p>
			<label for="password">
				<spring:message code="password"></spring:message>
			</label>
			<input type="password" name="password" id="password"/>
		</p>
		
		<input type="submit" value="<spring:message code='login.form.login'/>"/>
	</form>
</body>
</html>