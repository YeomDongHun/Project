<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="resources/file/js/jquery-2.0.0.min.js"></script>
<style type="text/css">
@import url('//cdn.rawgit.com/young-ha/webfont-archive/master/css/PureunJeonnam.css');
#faq_admin_wrap {
	width: 1500px;
	font-family: PureunJeonnam;
	margin-left:auto;
	margin-right:auto;
}
.faq_admin_title {text-align: left; color: #212121; padding-top: 50px;}
.faq_admin_title div {padding-bottom: 10px;}
.title_font1 {font-family: PureunJeonnam; font-size: 40px; font-weight: bold;}
.title_font2 {font-family: PureunJeonnam; font-size: 15px; font-weight: bold; color: #999;}
.faq_admin_table{
	text-align: center;
	font-family: PureunJeonnam;
	font-size:15px;
	font-weight:bold;	
}
.faq_line {margin: 0 50px 0 50px;}

.faq_admin_table td {
	text-align: center; 
	border-top: 1px solid #e5e5e5; 
	border-bottom: 1px solid #e5e5e5; 
	padding: 8px 0; 
	background: #f5f5f5;
}
.faq_admin_search{
	width: 60%;
	margin-right: auto;
	margin-left: auto;
}
.faq_admin_search input[type=text]{
	width: 300px;
	height: 25px;
}
.faq_admin_searchT {
	text-align: center; 
	border-top: 1px solid #e5e5e5; 
	border-bottom: 1px solid #e5e5e5; 
	padding: 8px 0; 
	background: #f5f5f5;
}
.faq_select{
	height: 25px;
}
.paging{text-align:center; padding-top: 20px;}
.paging a{text-decoration: none; color:black;}

</style>
<script type="text/javascript">
$(document).ready(function () {
	//btn클릭 이벤트 처리
	$("#list").click(function () {
		document.location.href="adminfaqAdminList";	
	});
	//페이지 로드시 버튼 클릭

});
</script>


</head>

<body>
<div id="faq_admin_wrap">
<div class="faq_admin_title">
<div class="title_font1"><a href="#" style="text-decoration: none;color:black;">공지사항 관리자페이지</a></div>
<div class="title_font2">공지사항 & 이벤트</div>
</div>

<div class="faq_line">
<hr color="#777" width="100%" size="1">
</div>

<table class="faq_admin_table" width="100%">
<colgroup>
	<col width="15%" />
	<col width="35%"/>
	<col width="15%" />
	<col width="35%" />
</colgroup>
<tr>
	<td>제목</td>
    <td colspan=3 style="background:white;">${faq.FAQ_TITLE}</td>
</tr>
<tr>
	<td>작성자</td>
    <td colspan=3 style="background:white;">SG 홈페이지관리자</td>
</tr>

<tr>
	<td>등록일</td>
    <td style="background:white;">${faq.FAQ_REGDATE}</td>
    <td>조회수</td>
    <td style="background:white;">${faq.FAQ_HITCOUNT}</td>
</tr>

<tr>
	<td colspan=4 style="background:white;"><img src="./resources/file/faqFile/${faq.FAQ_IMAGE}"></td>
</tr>

<tr>
	<td colspan=4 style="background:white;">${faq.FAQ_CONTENT}</td>
</tr> 
</table>
<input type="button" id="list" value="목록으로">

</div>

</body>
</html>
