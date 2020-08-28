<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원가입</h1>
	<hr>
	
	<form action="/signup" method="post">
	<!-- csrf -->
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
		<input type="text" name="username" placeholder="id을 입력하세요">
		<input type="text" name="u_name" placeholder="이름을 입력하세요">
		<input type="password" name="password" placeholder="비밀번호를 입력하세요">
		<input type="submit" value="가입하기">
	</form>
</body>
</html>