<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>data: ${sessionScope.sdata}</h1>
<div id="wrap">
    <br>
    <div id="topForm">
  			<a href="/board_Write">글쓰기</a>
         	<a href="/">Home</a>
           
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
			<c:forEach var="board" items="${list}">
       			 <tr>
                <td>${board.b_id}</td>
                <td align="left">
			      ${board.b_title}
                </td>
                <td>
                    ${board.b_writer}
                </td>
                <td>${board.b_date}</td>
                <td></td>
            </tr>
           	 </c:forEach>
        	</table>
   		</div>
    
    <!-- 페이지 넘버 부분-->
 
     
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