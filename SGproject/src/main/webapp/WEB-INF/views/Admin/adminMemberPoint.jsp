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
	h4{font-family: PureunJeonnam; font-weight: bold;}
	h5{font-family: PureunJeonnam; font-weight: bold; color: #999;}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script type="text/javascript" src="resources/file/js/common.js"></script>
<script>
$(document).ready(function() {
	
	$("#modify").click(function(e) {
		admin_point(); 
	});
	
	$("#list").click(function() {
		document.location.href='/SG/adminMemberListON';
	});	
});

function admin_point(){
	var comSubmit = new ComSubmit("adminform");
	comSubmit.setUrl('/SG/adminMemberPointInsert');
	comSubmit.submit();

	
}

</script>
  
</head>
<body>
<div class="NOTICE_resWrap">
<h4>회원 포인트 적립</h4>

<form id="adminform" name="adminform" enctype="multipart/form-data" action="adminMemberListON">
  <div class="form-group">
    <label for="NOTICE_TITLE">회원아이디</label>
    <input type="text" class="form-control" id="MEMBER_ID" name="MEMBER_ID" value="${adminmemberpoint[0].MEMBER_ID}" placeholder="" style="width:250px">
    <input type="hidden" name="POINT_MEMBER_NO" value="${adminmemberpoint[0].MEMBER_NO}"/> 
  </div>
  <div class="form-group">
    <label for="NOTICE_TITLE">보유 포인트</label>
    <input type="text" class="form-control" id="SUM_POINT_MONEY" name="SUM_POINT_MONEY" value="${adminmemberpoint[0].SUM_POINT_MONEY}" placeholder="" style="width:250px">
  </div>
  <div class="form-group">
    <label for="NOTICE_TITLE">적립 사유</label>
    <input type="text" class="form-control" id="POINT_CONTENT" name="POINT_CONTENT" value="" placeholder="적립 사유를 입력해주세요" style="width:250px">
  </div>
  <div class="form-group">
    <label for="NOTICE_TITLE">적립 할 포인트</label>
    <input type="text" class="form-control" id="POINT_MONEY" name="POINT_MONEY" value="" placeholder="적립 할 포인트를 입력해주세요" style="width:250px">
  </div>

  <button type="button" id="modify" class="btn btn-default">적립 완료</button>
  <button type="button" id="list"class="btn btn-default">닫기</button>
</form>

</div>
</body>
</html>