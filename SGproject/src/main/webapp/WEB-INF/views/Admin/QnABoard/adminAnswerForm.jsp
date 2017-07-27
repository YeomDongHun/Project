<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="resources/file/js/jquery-2.0.0.min.js"></script>
<script type="text/javascript" src="resources/file/js/common.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<title>Insert title here</title>
<style>
@import url('//cdn.rawgit.com/young-ha/webfont-archive/master/css/PureunJeonnam.css');
#qna_wrap{
	width:1000px;
	margin-left:auto;
	margin-right:auto;
	font-family:PureunJeonnam;
}


.qna_line {margin: 0 50px 0 50px;}
</style>
<script>
$(document).ready(function(){
	$("#resister").click(function(){
		fn_insertQna();
	});
	
	$("#represister").click(function(){
		fn_insertQnaRep();
	});
	
	$("#list").click(function(){
		document.location.href='qnaBoardList';
	});
	
});

function fn_insertQnaRep(){
	var comSubmit = new ComSubmit("qnaform");
	comSubmit.setUrl('/SG/adminAnswer');
	comSubmit.submit();
}

function fn_insertQna(){
	var comSubmit = new ComSubmit("qnaform");
	comSubmit.setUrl('#');
	comSubmit.submit();
}
function fn_modifyqna(){
	var comSubmit = new ComSubmit("qnaform");
	comSubmit.setUrl('/SG/memberqnaBoardModify');
	comSubmit.submit();
	
}

</script>
</head>
<body>
<div id="qna_wrap">
<div>
<h3 style="text-align:center;">
<span style="color:black; font-size:30px; font-weight:bold;">관리자페이지 / </span> <span style="color:#777; font-weight:bold; font-size:15px;">답변작성</span>
</h3>
</div>

<div class="qna_line">
	<hr color="#777" width="100%" size="1">
</div>

<form id="qnaform" name="qnaform" method="post" enctype="multipart/form-data">
<input type="hidden" name="QNA_NO" value="${qna.QNA_NO }">
<div>
<div style="font-family:PureunJeonnam; font-weight:bold; margin-bottom:10px; margin-top:10px;">문의 아이디</div>
<input type="text" class="form-control" value= "${qna.MEMBER_ID}"  disabled="disabled" style="width:480px; margin-right:20px;">
</div>

<div>
	<div style="width:50%; float:left;">
		<div style="font-family:PureunJeonnam; font-weight:bold; margin-bottom:10px; margin-top:10px;">문의 제목</div>
		<input type="text" class="form-control" value= "${qna.QNA_TITLE}"  disabled="disabled" style="width:480px; margin-right:20px;">

	</div>
	<div style="width:50%; float:left;">
		<div style="font-family:PureunJeonnam; font-weight:bold; margin-bottom:10px; margin-top:10px;">문의 카테고리</div>
		<input type="text" class="form-control" value= "${qna.QNA_CATEGORY}"  disabled="disabled" style="width:500px;">
	
	</div>

</div>


<div>
	<div style="width:50%; float:left;">
		<div style="font-family:PureunJeonnam; font-weight:bold; margin-bottom:10px; margin-top:10px;">답변 상태</div>
		<input type="text" class="form-control" value= "${qna.QNA_REPSTATE}"  disabled="disabled" style="width:480px; margin-right:20px;">

	</div>
	<div style="width:50%; float:left;">
		<div style="font-family:PureunJeonnam; font-weight:bold; margin-bottom:10px; margin-top:10px;">답변 날짜</div>
		<input type="text" class="form-control" value= "${qna.QNA_REPDATE}"  disabled="disabled" style="width:500px;">
	
	</div>

</div>


<div>
<div style="font-family:PureunJeonnam; font-weight:bold; margin-bottom:10px; margin-top:10px;">문의 내용</div>
<textarea class="form-control" name="QNA_CONTENT" rows="10" cols="50" disabled="disabled">${qna.QNA_CONTENT}</textarea>
</div>

<div style="font-family:PureunJeonnam; font-weight:bold; margin-bottom:10px; margin-top:10px;">답변 내용</div>
<textarea class="form-control" name="QNA_REPCONTENT" rows="10" cols="50" >${qna.QNA_REPCONTENT}</textarea>

</form>
<div>

<div style="float:right; margin-top:20px;">
<c:choose>
<c:when test="${sessionScope.MEMBER_ID == null }">
<button type="button" id="represister" class="btn btn-info">답변하기</button>
</c:when>
<c:otherwise>
<button type="button" id="resister" class="btn btn-info">문의하기</button>
</c:otherwise>

</c:choose>
<button type="button" id="list" class="btn btn-info">목록으로</button>
</div>	
</div>
</div>
</body>
</html>