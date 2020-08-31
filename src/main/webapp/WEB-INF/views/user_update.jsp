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
		<form method="post" action="/user_update">
		<!-- csrf --><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
	
		<div>
			<sec:authorize access="isAuthenticated()">
				<sec:authentication property="principal" var="principal"/>
		<table border="1">
		<tr>
			<th>아이디</th>
			<td><input name="username" value="${principal.username}" readonly></td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td><input type="password" value="${principal.password}" name="password"></td>
		</tr>
		
		<tr>	
			<th>이름</th>
			<td><input type="text" value="${principal.u_name}" name="u_name"></td>
		</tr>
		<tr>	
			<th>성별</th>
			<td><input type="radio" value="남" name="u_gender">남
			<input type="radio" value="여" name="u_gender">여</td>
		</tr>	
		<tr>	
		<th>생년월일</th>
		<td><input type="text" value="${principal.u_birth}" name="u_birth"></td>
		</tr>
		<tr>	
			<th>전화번호</th>
		<td><input type="text" value="${principal.u_tel}" name="u_tel"></td>
		</tr>
		<tr>	
			<th>주소</th>
			<td><input type="text" value="${principal.u_addr}" name="u_addr"></td>
		</tr>	
		</table>			
			</sec:authorize>
			
		</div>
		<input type="submit" value="수정">
		<a href="/">돌아가기</a>
		</form>
</body>
</html>