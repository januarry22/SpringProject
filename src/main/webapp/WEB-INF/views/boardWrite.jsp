<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<form action="/boardWrite" method="post">

		<sec:authorize access="isAuthenticated()">
				<sec:authentication property="principal" var="principal"/>
				<input type="hidden" name="b_writer" value="${principal.username}">

		</sec:authorize>
		<table>
		 <tr>
            <td>작성자</td>	
            <td>${principal.username}</td>
        </tr>
            <tr>
            <td>제 목
            </td>
            <td>
                <input name="b_title" type="text" size="70" maxlength="100" value=""/>
            </td>        
        </tr>
        <tr>
            <td>
                내 용
            </td>
            <td>
                <textarea name="b_content" cols="75" rows="20"></textarea>            
            </td>        
        </tr>

        <tr align="center" valign="middle">
            <td colspan="5">
               <input type="submit" value="등록">
               <input type="reset" value="취소" onclick="javascript:window.location='/boardList'">
             
            </td>
        </tr>
        
	
	</table> 
	</form> 
</body>
</html>