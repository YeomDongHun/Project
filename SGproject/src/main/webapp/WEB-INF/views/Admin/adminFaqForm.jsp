<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>샐러드구쁘다</title>
<style>
@import url('//cdn.rawgit.com/young-ha/webfont-archive/master/css/PureunJeonnam.css');
	.faq_resWrap{width:1500px;}
	h2{font-family: PureunJeonnam; font-weight: bold;}
	h5{font-family: PureunJeonnam; font-weight: bold; color: #999;}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script type="text/javascript" src="resources/file/js/common.js"></script>
<script>
$(document).ready(function(){
	$("#resister").click(function(){
		fn_insertFAQ();
	});
	
	$("#list").click(function(){
		document.location.href='adminFaq';
	});
	
	$("#modify").click(function(){
		fn_modifyFAQ();
	});
});
/* FAQ Submit 함수선언 */
function fn_insertFAQ(){
	var comSubmit = new ComSubmit("faqform");
	comSubmit.setUrl('/SG/adminFaqWrite');
	comSubmit.submit();
}
function fn_modifyFAQ(){
	var comSubmit = new ComSubmit("faqform");
	comSubmit.setUrl('/SG/adminFaqModify');
	comSubmit.submit();
	
}
</script>

</head>
<body>
<div class="faq_resWrap">
<h2>FAQ 등록 페이지입니다</h2>
<h5>등록 및 수정</h5>
<c:choose>
<c:when test="${modify}">
<form id="faqform" name="faqform" enctype="multipart/form-data">
	<input type="hidden" name="ORIGINAL_FAQ_IMAGE" value="${map.FAQ_IMAGE }">
  <div class="form-group">
    <label for="FAQ_TITLE">FAQ 제목</label>
    <input type="text" class="form-control" id="title" name="FAQ_TITLE" value="${map.FAQ_TITLE }" placeholder="글 제목을 입력해주세요" style="width:700px">
  </div>
  <div class="form-group">
    <label for="FAQ_CATEGORY">FAQ 카테고리</label>
    <select name="FAQ_CATEGORY" class="form-control" style="width:400px">
  			<option selected="selected">회원안내</option>
  			<option>배송안내</option>
            <option>주문/결제</option>
            <option>주문취소/변경</option>
            <option>교환/반품</option>
            <option>환불</option>
            <option>상품</option>
            <option>사이트 이용안내</option>
	</select>
  </div>

<div class="form-group">
<label for="FAQ_CONTENT">FAQ 상세내용</label>
  <textarea class="form-control" id="FAQ_CONTENT" name="FAQ_CONTENT" rows="10" cols="50" placeholder="상세내용을 입력해주세요" style="width:700px">${map.FAQ_CONTENT}</textarea>
</div>
  
  <div class="form-group">
    <label for="exampleInputFile">기존 이미지 : ${map.FAQ_IMAGE}</label>
    <input type="file" id="exampleInputFile" name="FAQ_IMAGE">
    <p class="help-block">수정할 이미지를 첨부해주세요.</p>
  </div>

  <button type="button" id="modify" class="btn btn-default">수정하기</button>
  <button type="button" id="list"class="btn btn-default">목록으로</button>
</form>
</c:when>
<c:otherwise>
<form id="faqform" name="faqform" enctype="multipart/form-data">
  <div class="form-group">
    <label for="FAQ_TITLE">FAQ 제목</label>
    <input type="text" class="form-control" id="title" name="FAQ_TITLE" placeholder="글 제목을 입력해주세요" style="width:700px">
  </div>
  <div class="form-group">
    <label for="FAQ_CATEGORY">FAQ 카테고리</label>
    <select name="FAQ_CATEGORY" class="form-control" style="width:400px">
  			<option selected="selected">회원안내</option>
  			<option>배송안내</option>
            <option>주문/결제</option>
            <option>주문취소/변경</option>
            <option>교환/반품</option>
            <option>환불</option>
            <option>상품</option>
            <option>사이트 이용안내</option>
	</select>
  </div>

<div class="form-group">
<label for="FAQ_CONTENT">FAQ 상세내용</label>
  <textarea class="form-control" id="FAQ_CONTENT" name="FAQ_CONTENT" rows="10" cols="50" placeholder="상세내용을 입력해주세요" style="width:700px"></textarea>
</div>
  
  <div class="form-group">
    <label for="exampleInputFile">이미지 첨부</label>
    <input type="file" id="exampleInputFile" name="FAQ_IMAGE">
    <p class="help-block">첨부할 이미지를 선택해주세요.</p>
  </div>

  <button type="button" id="resister" class="btn btn-default">등록하기</button>
  <button type="button" id="list"class="btn btn-default">목록으로</button>
</form>
</c:otherwise>
</c:choose>
</div>
</body>
</html>