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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

</head>
<body>
<!-- 
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
	   -->
	<div class="container">
        <label for="content">comment</label>
        <form name="commentInsertForm">
            <div class="input-group">
               <input type="hidden" name="commentB_id" value="${board.b_id}"/>
               <input type="hidden" name="c_writer" value="${board.b_writer}"/>
           
               
               <textarea rows="3" cols="30"  id="c_content" name="c_content" placeholder="내용을 입력하세요.">
               </textarea>
               <span class="input-group-btn">
                    <button class="btn btn-default" type="button" name="commentInsertBtn">등록</button>
               </span>
              </div>
        </form>
    </div>
    
    <div class="container">
        <div class="commentList"></div>
    </div>

<script>
	var bno = '${board.b_id}'; //게시글 번호
	 
	$('[name=commentInsertBtn]').click(function(){ //댓글 등록 버튼 클릭시 
	    var insertData = $('[name=commentInsertForm]').serialize(); //commentInsertForm의 내용을 가져옴
	    commentInsert(insertData); //Insert 함수호출(아래)
	});
	 
	 


	//댓글 목록 
	function commentList(){
	    $.ajax({
	        url : '/commentList',
	        type : 'get',
	        data : {'bno':bno},
	        success : function(data){
	            var a =''; 
	            $.each(data, function(key, value){ 
	                a += '<div class="commentArea" style="border-bottom:1px solid darkgray; margin-bottom: 15px;">';
	                a += '<div class="commentInfo'+value.c_id+'">'+'댓글번호 : '+value.c_id+' / 작성자 : '+value.c_writer;
	                a += '<button type="button" onclick="commentUpdate('+value.c_id+',\''+value.c_content+'\');"> 수정 </a>';
	                a += '<button type="button" onclick="commentDelete('+value.c_id+');"> 삭제 </a> </div>';
	                a += '<div class="commentContent'+value.c_id+'"> <p> 내용 : '+value.c_content +'</p>';
	                a += '</div></div>';
	            });
	            
	            $(".commentList").html(a);
	        }
	    });
	}
	 
	//댓글 등록
	function commentInsert(insertData){
	    $.ajax({
	        url : '/commentInsert',
	        type : 'post',
	        data : insertData,
	        success : function(data){
	            if(data == 1) {
	                commentList(); //댓글 작성 후 댓글 목록 reload
	                $('[name=content]').val('');
	            }
	        }
	    });
	}
	 
	//댓글 수정 - 댓글 내용 출력을 input 폼으로 변경 
	function commentUpdate(c_id, c_content){
	    var a ='';
	    
	    a += '<div class="input-group">';
	    a += '<input type="text" class="form-control" name="content_'+c_id+'" value="'+c_content+'"/>';
	    a += '<span class="input-group-btn"><button class="btn btn-default" type="button" onclick="commentUpdateProc('+c_id+');">수정</button> </span>';
	    a += '</div>';
	    
	    $('.commentContent'+c_id).html(a);
	    
	}
	 
	//댓글 수정
	function commentUpdateProc(c_id){
	    var updateContent = $('[name=content_'+c_id+']').val();
	    
	    
	    $.ajax({
	        url : '/commentUpdate',
	        type : 'post',
	        data : {'c_content' : updateContent, 'c_id' : c_id},
	        success : function(data){
	            if(data == 1) commentList(bno); //댓글 수정후 목록 출력 
	        }
	    });
	}
	 
	//댓글 삭제 
	function commentDelete(c_id){
	    $.ajax({
	        url : '/commentDelete',
	        type : 'post',
	        data : {'c_id':c_id},
	        success : function(data){
	            if(data == 1) commentList(bno); //댓글 삭제후 목록 출력 
	        }
	    });
	}
	 
	 
	 
	 
	$(document).ready(function(){
	    commentList(); //페이지 로딩시 댓글 목록 출력 
	});
	 

	</script>

	
</body>
</html>