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
#diy_wrap{
	width:1000px;
	margin-left:auto;
	margin-right:auto;
	font-family:PureunJeonnam;
}


.diy_line {margin: 0 50px 0 50px;}
</style>
<script>
$(document).ready(function(){
	$("#resister").click(function(){
		fn_insertDIY();
	});
	
	$("#list").click(function(){
		document.location.href='DiyBoardList';
	});
	
	$("#modify").click(function(){
		fn_modifyDIY();
	});
	
});

function fn_insertDIY(){
	var comSubmit = new ComSubmit("diyform");
	comSubmit.setUrl('/SG/memberDiyBoardInsert');
	comSubmit.submit();
}
function fn_modifyDIY(){
	var comSubmit = new ComSubmit("diyform");
	comSubmit.setUrl('/SG/memberDiyBoardModify');
	comSubmit.submit();
	
}

</script>
</head>
<body>
<div id="diy_wrap">
<div>
<h3 style="text-align:center;">
<span style="color:black; font-size:30px; font-weight:bold;">후기를 작성해주세요 / </span> <span style="color:#777; font-weight:bold; font-size:15px;">샐러드 구쁘다</span>
</h3>
</div>

<div class="diy_line">
	<hr color="#777" width="100%" size="1">
</div>

<c:choose>
<c:when test="${modify}">
<form id="diyform" name="diyform" method="post" enctype="multipart/form-data">
<div>
<div style="font-family:PureunJeonnam; font-weight:bold; margin-bottom:10px; margin-top:10px;">작성자</div>
<input type="text" class="form-control" value= "${diy.DIY_MEMBER_ID}"  disabled="disabled" style="width:500px;">
<input type="hidden" value="${diy.DIY_NO }" name="DIY_NO">
<input type="hidden" value="${diy.DIY_MEMBER_ID}" name="DIY_MEMBER_ID">
</div>

<div>
<div style="font-family:PureunJeonnam; font-weight:bold; margin-bottom:10px; margin-top:10px;">제목</div>
<input type="text" class="form-control" name="DIY_TITLE" value="${diy.DIY_TITLE}"  style="width:500px;">
</div>

<div>
<div style="font-family:PureunJeonnam; font-weight:bold; margin-bottom:10px; margin-top:10px;">내용</div>
<textarea class="form-control" name="DIY_CONTENT" rows="10" cols="50">${diy.DIY_CONTENT}</textarea>
</div>
<div>
<div style="font-family:PureunJeonnam; font-weight:bold; margin-bottom:10px; margin-top:10px;">첨부된 이미지 :${diy.DIY_IMAGE} </div>
    <input type="file" name="DIY_IMAGE" style="font-family:PureunJeonnam; font-weight:bold;">
    <input type="hidden" name="ORIGINAL_DIY_IMAGE" value="${diy.DIY_IMAGE}">
    <p class="help-block" style="font-family:PureunJeonnam; font-weight:bold;">바꾸실 이미지를 선택하세요.</p>
</div>		

<div style="float:right;">
	<button type="button" id="modify" class="btn btn-info">수정하기</button>

	<button type="button" id="list" class="btn btn-info">목록으로</button>
</div>	
</form>
</c:when>
<c:otherwise>
<form id="diyform" name="diyform" method="post" enctype="multipart/form-data">
<div>
<div style="font-family:PureunJeonnam; font-weight:bold; margin-bottom:10px; margin-top:10px;">작성자</div>
<input type="text" class="form-control" value= "${sessionScope.MEMBER_ID}"  disabled="disabled" style="width:500px;">
<input type="hidden" value="${sessionScope.MEMBER_ID}" name="DIY_MEMBER_ID">
</div>

<div>
<div style="font-family:PureunJeonnam; font-weight:bold; margin-bottom:10px; margin-top:10px;">제목</div>
<input type="text" class="form-control" name="DIY_TITLE" placeholder="제목을 입력해주세요" style="width:500px;">
</div>

<div>
<div style="font-family:PureunJeonnam; font-weight:bold; margin-bottom:10px; margin-top:10px;">내용</div>
<textarea class="form-control" name="DIY_CONTENT" rows="10" cols="50" placeholder="내용을 입력해주세요" ></textarea>
</div>
<div>
<div style="font-family:PureunJeonnam; font-weight:bold; margin-bottom:10px; margin-top:10px;">이미지 첨부 </div>
    <input type="file" name="DIY_IMAGE" style="font-family:PureunJeonnam; font-weight:bold;">
    <p class="help-block" style="font-family:PureunJeonnam; font-weight:bold;">첨부할 이미지를 선택하세요.</p>
</div>		

<div style="float:right;">"

<button type="button" id="resister" class="btn btn-info">등록하기</button>

<button type="button" id="list" class="btn btn-info">목록으로</button>
</div>	
</form>
</c:otherwise>
</c:choose>
</div>
</body>
</html>