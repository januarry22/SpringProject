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
	<!-- csrf --><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
		
	<table border="1">
		
		<tr>
			<th>아이디</th>
			<td><input type="text" name="username" placeholder="id을 입력하세요"></td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td><input type="password" name="password" placeholder="비밀번호를 입력하세요"></td>
		</tr>
		
		<tr>	
			<th>이름</th>
				<td><input type="text" name="u_name" placeholder="이름을 입력하세요"></td>
		</tr>
		<tr>	
			<th>성별</th>
			<td><input type="radio"  name="u_gender" value="남">남
				<input type="radio"  name="u_gender" value="여">여</td>
		</tr>	
		<tr>	
			<th>생년월일</th>
		<td><input type="text" name="u_birth"></td>
		</tr>
		<tr>	
			<th>전화번호</th>
		<td><input type="text" name="u_tel"></td>
		</tr>
		<tr>	
			<th>주소</th>
			<td><input type="text" name="u_addr"></td>
		</tr>
		
		</table>

			<input type="submit" value="가입하기">
	</form>
</body>
</html>