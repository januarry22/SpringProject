<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>


</script>
</head>
<body>
	<div>
		<form id="commentForm" name="commentForm" method="post">
		
		<div>
            <div>
                <span><strong>Comments</strong></span> <span id="cCnt"></span>
            </div>
            <div>
                <table class="table">                    
                    <tr>
                        <td>
                            <textarea style="width: 1100px" rows="3" cols="30" id="c_content" name="c_content" placeholder="댓글을 입력하세요"></textarea>
                            <br>
                            <div>
                                <a href='#' onClick="fn_comment('${comment.c_id}')">등록</a>
                            </div>
                        </td>
                    </tr>
                </table>
            </div>
        </div>
		<input type="hidden" id="commentB_id" name="commentB_id" value="${comment.commentB_id}"/>
		
		</form>
	</div>
	
	<div>
		<form id="commentListForm" name="commentListForm" method="post">
			<div id="commentList">
				<c:forEach var="reply" items="${list}">
					<tr>
						<td>
						${reply.c_writer}
						<br>
						${reply.c_contetn}
						</td>
					</tr>
				</c:forEach>
			</div>
		</form>
	
	</div>
	
	<script>
	/*댓글 등록 AJax
	
	function fn_comment(c_id){
			$.ajax({
				type:'POST'
				url: "<c:url value='/commentInsert'/>",
				data: $(#commentForm).serialize(),
				success: function(data){
						if(data=="success"){
							getCommentList();
							$("#c_content").val("");
							}
					},
					error:function(request, status, error){
					}
			});
		}
	$(function(){
		getCommentList();
	});

	function getCommentList(){
			$.ajax({
				type:'GET',
				url : "<c:url value='/commentList'/>",
				dataType:"json",
				data:$("#commentForm").serialize(),
				contentType:"application/x-www-form-urlencoded; charset=UTF-8", 
				success: function(data){

						var html="";
						var cCnt=data.length;

						if(data.length>0){
							for(i=0; i<data.length; i++){
									html += "<div>";
									html += "<div><table>"+data[i].writer;
									html += data[i].comment+"<tr><td></td></tr>";
									html += "</table></div>";
									html += "</div>";

								}
						}else{
							html += "<div>";
							html += "<div><table> 등록된 댓글이 없습니다.";
							html += data[i].comment+"<tr><td></td></tr>";
							html += "</table></div>";
							html += "</div>";
						}

						$("#cCnt").html(cCnt);
						$("#commentList").html(html);
						
					},
					error:function(request, status, error){

						}
				})
		}

	*/
	</script>
</body>
</html>