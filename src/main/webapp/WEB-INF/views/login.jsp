<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>로그인</h1>
	
	<form action="/loginPro" method="post">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
		<input type="text" name="u_id" placeholder="id을 입력하세요">
		<input type="text" name="u_name" placeholder="이름을 입력하세요">
		<input type="password" name="u_passwd" placeholder="비밀번호를 입력하세요">
		<input id="remember_me" name="remember-me" type="checkbox"/>Remember me
	
		<button type="submit">로그인</button>
	</form>
</body>
</html>