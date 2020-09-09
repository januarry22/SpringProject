<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
         <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
<div id="wrap">
    <br>
    <div id="topForm">
    		<input type="button" value="글쓰기" onclick="javascript:window.location='/board_Write'">
    		<input type="button" value="Home" onclick="javascript:window.location='/'">

    </div>
    
    <!-- 게시글 목록 부분 -->
    <br>
    <div id="board">
       <table>
            <tr height="30">
                <td>글번호</td>
                <td>제목</td>
                <td>작성자</td>
                <td>작성일</td>
                <td>조회수</td>
            </tr>    
			<c:forEach var="board" items="${board}">
       			 <tr>
                <td>${board.b_id}</td>
                <td align="left">
			     	<a href="/boardDetail?b_id=${board.b_id}&nowPage=${paging.nowPage}">
                 ${board.b_title}</a>
                </td>
                <td>
                    ${board.b_writer}
                </td>
                <td>${board.b_date}</td>
                <td>${board.b_hit}</td>
            </tr>
           	 </c:forEach>
        	</table>
   		</div>
    <!-- 페이징 -->
		<div>
		<c:if test="${paging.startPage != 1 }">
			<a href="/boardList?nowPage=${paging.startPage - 1 }">[이전]</a>
		</c:if>
		<c:forEach begin="${paging.startPage}" end="${paging.endPage}" var="p">
			<c:choose>
				<c:when test="${p == paging.nowPage }">
					${p}&nbsp;
				</c:when>
				<c:when test="${p != paging.nowPage }">
					<a href="/boardList?nowPage=${p}">${p}</a>
				</c:when>
			</c:choose>
		</c:forEach>
		<c:if test="${paging.endPage != paging.lastPage}">
			<a href="/boardList?nowPage=${paging.endPage+1}">[다음]</a>
		</c:if>
		</div>
		
    <!--  검색 부분 -->
    <br>
    <div id="searchForm">
        <form>
            <select name="opt">
                <option value="0">제목</option>
                <option value="1">내용</option>
                <option value="2">제목+내용</option>
                <option value="3">글쓴이</option>
            </select>
            <input type="text" size="20" name="condition"/>&nbsp;
            <input type="submit" value="검색"/>
        </form>    
    </div>
</div>    
	
</body>
</html>