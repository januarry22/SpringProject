<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">

</script>
</head>
<body>

		 <form action="/boardUpdate" method="post">
		 <input type="hidden" name="b_id" value="${board.b_id}">
		<table>		

		<tr>
            <td>작성자</td>	
            <td>${board.b_writer}</td>
        </tr>
            <tr>
            <td>제 목
            </td>
            <td>
               <input type="text" name="b_title" value="${board.b_title}">
            </td>        
        </tr>
        <tr>
            <td>
                내 용
            </td>
            <td>
            <textarea name="b_content" rows="20" cols="75" >${board.b_content}</textarea>
            </td>        
        </tr>

        <tr align="center" valign="middle">
            <td colspan="5">
                <input type="submit" value="수정">
                <input type="button" value="취소" onclick="javascript:window.location='/boardList'">
            </td>
        </tr>
        </table>
        </form>
</body>
</html>