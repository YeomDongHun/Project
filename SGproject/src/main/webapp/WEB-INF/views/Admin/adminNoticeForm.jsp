<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>샐러드구쁘다</title>
<style>
@import url('//cdn.rawgit.com/young-ha/webfont-archive/master/css/PureunJeonnam.css');
	.NOTICE_resWrap{width:1500px;}
	h2{font-family: PureunJeonnam; font-weight: bold;}
	h5{font-family: PureunJeonnam; font-weight: bold; color: #999;}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script type="text/javascript" src="resources/file/js/common.js"></script>
<script>
$(document).ready(function() {
	$("#res").click(function(e) {
		fn_insertNOTICE();
	});
	
	$("#modify").click(function(e) {
		fn_modifyNOTICE();
	});
	
	$("#list").click(function() {
		document.location.href='adminNoticeAdminList';
	});	
});
/* NOTICE Submit 함수선언 */
function fn_insertNOTICE(){
	var comSubmit = new ComSubmit("noticeform");
	comSubmit.setUrl('/SG/adminNoticeWrite');
	comSubmit.submit();
}

function fn_modifyNOTICE(){
	var comSubmit = new ComSubmit("noticeform");
	comSubmit.setUrl('/SG/adminNoticeModify');
	comSubmit.submit();
}

</script>

</head>
<body>
<div class="NOTICE_resWrap">
<h2>공지사항 및 이벤트 등록 페이지입니다</h2>
<h5>등록 및 수정</h5>
<c:choose>
<c:when test="${modify}">
<form id="noticeform" name="noticeform" enctype="multipart/form-data">
	<input type="hidden" value="${map.NOTICE_IMAGE}" name="ORIGINAL_NOTICE_IMAGE">
	<input type="hidden" value="${map.NOTICE_NO}" name="NOTICE_NO">
  <div class="form-group">
    <label for="NOTICE_TITLE">공지사항&이벤트 제목</label>
    <input type="text" class="form-control" id="title" name="NOTICE_TITLE" value="${map.NOTICE_TITLE}" placeholder="글 제목을 입력해주세요" style="width:700px">
  </div>
  <div class="form-group">
    <label for="NOTICE_TYPE">게시글 분류</label>
    <select name="NOTICE_TYPE" class="form-control" style="width:400px">
  			<option value="0" selected="selected">공지사항</option>
  			<option value="1" >이벤트</option>
	</select>
  </div>

<div class="form-group">
<label for="NOTICE_CONTENT">공지사항&이벤트 상세내용</label>
  <textarea class="form-control" id="NOTICE_CONTENT" name="NOTICE_CONTENT"  rows="10" cols="50" placeholder="상세내용을 입력해주세요" style="width:700px">${map.NOTICE_CONTENT}</textarea>
</div>
  
  <div class="form-group">
    <label for="exampleInputFile">이미지 첨부</label>
    <label for="exampleInputFile">기존 파일:${map.NOTICE_IMAGE}</label>
    <input type="file" id="exampleInputFile" name="NOTICE_IMAGE" value="${map.NOTICE_IMAGE}">
    <p class="help-block">첨부할 이미지를 선택해주세요.</p>
  </div>

  <button type="button" id="modify" class="btn btn-default">수정하기</button>
  <button type="button" id="list"class="btn btn-default">목록으로</button>
</form>
</c:when>
<c:otherwise>
<form id="noticeform" name="noticeform" enctype="multipart/form-data">
  <div class="form-group">
    <label for="NOTICE_TITLE">공지사항&이벤트 제목</label>
    <input type="text" class="form-control" id="title" name="NOTICE_TITLE" placeholder="글 제목을 입력해주세요" style="width:700px">
  </div>
  <div class="form-group">
    <label for="NOTICE_TYPE">게시글 분류</label>
    <select name="NOTICE_TYPE" class="form-control" style="width:400px">
  			<option value="0" selected="selected">공지사항</option>
  			<option value="1" >이벤트</option>
	</select>
  </div>

<div class="form-group">
<label for="NOTICE_CONTENT">공지사항&이벤트 상세내용</label>
  <textarea class="form-control" id="NOTICE_CONTENT" name="NOTICE_CONTENT" rows="10" cols="50" placeholder="상세내용을 입력해주세요" style="width:700px"></textarea>
</div>
  
  <div class="form-group">
    <label for="exampleInputFile">이미지 첨부</label>
    <input type="file" id="exampleInputFile" name="NOTICE_IMAGE">
    <p class="help-block">첨부할 이미지를 선택해주세요.</p>
  </div>

  <button type="button" id="res" class="btn btn-default">등록하기</button>
  <button type="button" id="list"class="btn btn-default">목록으로</button>
</form>
</c:otherwise>
</c:choose>
</div>
</body>
</html>