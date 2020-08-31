<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="post" action="user_delete">
	<!-- csrf --><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

			<sec:authorize access="isAuthenticated()">
				<sec:authentication property="principal" var="principal"/>
		
			<input name="username" value="${principal.username}">
			<input name="password" value="${principal.password}">
			</sec:authorize>
			<input type="submit" value="삭제">
			</form>
</body>
</html>