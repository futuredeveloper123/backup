<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!-- spring form tag 를 사용하기 위한 설정  -->
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<title><spring:message code="login.form.title" /></title>
</head>

<body> 
	<form:form modelAttribute="member">
		<p>
			<label for="email">
			<spring:message code="email" /></label>
			 <form:input path="email"/>
			 <form:errors path="email"/>
		</p>
		<p>
			<label for="password">
			<spring:message code="password" />
			</label> 
			<form:password path="pw"/>
			<form:errors path="pw"/>
		</p>
		
		<p>
		<label for ="loginType">로그인 유형 </label>
		<form:select path="loginType" items="${loginTypes}"/>
		</p>
		
		<input type="submit"
			value="<spring:message code="login.form.login" />">
	</form:form>

	<ul>
		<li><spring:message code="login.form.help" /></li>
	</ul>
</body>
</html>