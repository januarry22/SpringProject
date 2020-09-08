<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function checkValue(val){

		if(val==0){
				location.href="/boardList";
		}else if(val==1){
			location.href="/board/Update?b_id=${board.b_id}";
		}


</script>
</head>
<body>

		 <form method="post" action="/boardDelete">
		 <input type="hidden" name="b_id" value="${board.b_id}">
	<table>		
		<tr>
            <td>게시글</td>	
            <td>No.${board.b_id}</td>
        </tr>

		<tr>
            <td>작성자</td>	
            <td>${board.b_writer}</td>
        </tr>
            <tr>
            <td>제 목
            </td>
            <td>
               ${board.b_title}
            </td>        
        </tr>
        <tr>
            <td>
                내 용
            </td>
            <td>
            ${board.b_content}
            </td>        
        </tr>
         <tr>
            <td>
                조회수
            </td>
            <td>
            ${board.b_hit}
            </td>        
        </tr>
        </table>
        
                <input type="submit" value="삭제" >  
                <input type="button" value="수정" onclick="javascript:window.location='/board/Update?b_id=${board.b_id}'">
                <input type="button" value="목록" onclick="javascript:window.location='/boardList'">
        </form>
             
</body>
</html>