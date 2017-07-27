<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css"><!-- 별모양 폰트 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<style>
@import url('//cdn.rawgit.com/young-ha/webfont-archive/master/css/PureunJeonnam.css');
#diy_wrap{
	width:1000px;
	margin-left:auto;
	margin-right:auto;
	font-family:PureunJeonnam;
}
#diy_wrap table{
	text-align:center;
	line-height:20px;
}

#diy_wrap th{
	line-height:40px;
}
#diy_wrap td{
	text-align:left;
	line-height:40px;
	padding-left:20px;
}
#cmt a{
	color:#fdd66e;
}

</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="https://code.jquery.com/jquery-3.0.0.min.js"></script> 
<script src="resources/file/js/common.js"></script>
<script>
var rate=0;

$(document).ready(function(){
	
	
	

    $("#resister").click(function ajax(){ 
    	
    	
    	var src =document.getElementById("commentContents");
    	
    	
    	
    	var commentStr = $("#commentContents").val();
    	var commentNo = $("#commentDiyNo").val();
    	var commentRate = rate;
    	var comtUrl = "memberDiyComment"
    	
    	$.ajax({url: "memberDiyComment",  
   		type : "POST", 
   		data : { 
   			str : commentStr,
   			no : commentNo,
   			rate : commentRate
   		},
   		success: function(result){ 
   			$("#commentContents").val("");
   			$("#commentList").html(result); 
   		},
   		error: function(result){ 
   			alert("실패"); 
   		}   		
       });
   }); 
});


$( document ).ready(function() {

	$( ".star a" ).click(function() {
	    $(this).parent().children("a").removeClass("on");
	    $(this).addClass("on").prevAll("a").addClass("on");
	    
	    rate = $(this).attr("id");

	    return false;
	});
});

$(document).ready(function () {
	//btn클릭 이벤트 처리
	$("#list").click(function () {
		alert("목록으로 ㄱㄱ.") 
		document.location.href="memberDiyBoardList";	
	});
	//페이지 로드시 버튼 클릭
	
	$("#modify").on("click", function(e){ //목록으로 버튼
		e.preventDefault();
		fn_openDiyBoardModify();
	});	
	
	$("#delete").on("click", function(e){ //목록으로 버튼
		e.preventDefault();
		fn_openDiyBoardDelete();
	});	
	
});

function fn_openDiyBoardModify(){
	var comSubmit = new ComSubmit('frm');
	comSubmit.setUrl('/SG/memberDiyBoardModifyForm');
	comSubmit.submit();
}

function fn_openDiyBoardDelete(){
	var comSubmit = new ComSubmit('frm');
	comSubmit.setUrl('/SG/memberDiyBoardDelete');
	comSubmit.submit();
}

</script>
</head>
<body>
<div id="diy_wrap">
<table class="table">
<colgroup>
	<col width="15%"/>
	<col width="35%"/>
	<col width="15%"/>
	<col width="35%"/>
</colgroup>
	<tr>
		<th colspan="4" style="font-family:PureunJeonnam; background:#f5f5f5; font-size:20px;">${diy.DIY_TITLE }</th>
	</tr>
	<tr>
		<th style="background:#f5f5f5; text-align:center;">작성자</th>
		<td>${diy.DIY_MEMBER_ID}</td>
		<th style="background:#f5f5f5; text-align:center;">작성일</th>
		<td>${diy.DIY_REGDATE}</td>
	</tr>
	
	
	
	<tr>
		
		<th colspan="4">
		<img src="resources/file/diyFile/${diy.DIY_IMAGE}" class="img-rounded" style="width:250px; height:250px; both:clear; float:left;">
		<span style="clear:both; float:left;">${diy.DIY_CONTENT }</span>
		
		</th>
	</tr>
	<tr>
	</tr>
</table>
<div id="cmt" style="margin-left:auto; margin-right:auto;">
<c:if test="${sessionScope.MEMBER_ID == null }">
<p align="left">로그인 후 이용이 가능합니다.</p>
</c:if>

<c:if test="${sessionScope.MEMBER_ID != null }">
<p align="left" style="font-family:PureunJeonnam; font-weight:bold;">후기글에 대한 댓글을 적어주세요!</p>
<input type="hidden" id="commentDiyNo" name="DIY_NO" value="${diy.DIY_NO}"/>
<p class="star" id="star" align="left" style="color:#fdd66e;">
    <a href="#" id="1"><i class="fa fa-star" aria-hidden="true"></i></a>
    <a href="#" id="2"><i class="fa fa-star" aria-hidden="true"></i></a>
    <a href="#" id="3"><i class="fa fa-star" aria-hidden="true"></i></a>
    <a href="#" id="4"><i class="fa fa-star" aria-hidden="true"></i></a>
    <a href="#" id="5"><i class="fa fa-star" aria-hidden="true"></i></a>
</p>
</c:if>
<c:if test="${sessionScope.MEMBER_ID != null }">
<div style="width:1000px; margin-left:auto; margin-right:auto;">

	<div style="width:80%; float:left;  padding-bottom:19px;">
		<textarea id="commentContents" class="form-control" rows="2"></textarea>
	</div>
	<div style="width:20%; float:left;">
		<button type="button" id="resister" class="btn btn-warning btn-lg btn-block" style="padding-top:10px; padding-bottom:10px;">댓글작성</button>	
	</div>	
</div>
</c:if>
</div>
<div id="commentList" style="width:1000px; margin-left:auto; margin-right:auto;"><jsp:include page="memberDiyComment.jsp"></jsp:include></div>

<div>
	<input type="button" value="목록으로" class="btn btn-primary" id="list" style="float:right;">
</div>
<c:if test="${sessionScope.MEMBER_ID == diy.DIY_MEMBER_ID}">
<div>
	<input type="button" value="삭제" class="btn btn-primary" id="delete" style="float:right;">
	<input type="button" value="수정" class="btn btn-primary" id="modify" style="float:right;">
	<form 	name="frm" id="frm">
	<input type="hidden" name="DIY_NO" value="${diy.DIY_NO}">
	<input type="hidden" name="DIY_IMAGE" value="${diy.DIY_IMAGE}">
	</form>
</div>
</c:if>


</div>
</body>
</html>