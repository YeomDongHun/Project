<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<script type="text/javascript" src="resources/file/js/jquery-2.0.0.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js">
<style type="text/css">
@import url('//cdn.rawgit.com/young-ha/webfont-archive/master/css/PureunJeonnam.css');
#faq_admin_wrap {
	width: 1500px;
	font-family: PureunJeonnam;
}
.faq_admin_title {text-align: left; color: #212121; padding-top: 50px;}
.faq_admin_title div {padding-bottom: 10px;}
.title_font1 {font-family: PureunJeonnam; font-size: 40px; font-weight: bold;}
.title_font2 {font-family: PureunJeonnam; font-size: 20px; color: #999;}
.faq_admin_table{
	text-align: center;
	font-family: PureunJeonnam;
	font-size:15px;
	font-weight:bold;
}
.faq_line {margin: 0 50px 0 50px;}

.faq_admin_table th {
	text-align: center; 
	border-top: 1px solid #e5e5e5; 
	border-bottom: 1px solid #e5e5e5;
	padding: 8px 0; 
	font-size:15px; 
	background: #f5f5f5;
	font-family: PureunJeonnam;
}

.faq_admin_table td {
	text-align: center; 
	border-top: 1px solid #e5e5e5; 
	border-bottom: 1px solid #e5e5e5; 
	font-family: PureunJeonnam;
}
.faq_admin_search{
	width: 60%;
	margin-right: auto;
	margin-left: auto;
	font-family: PureunJeonnam;
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
 .category{}
   .category ul{margin-left:10px; list-style-type: none;}
   .category ul li
   {
   float:left;
   padding-right:15px;
   padding-left:15px;
   margin-left:2px;
   
   background-color:#5bc0de;
   color:white;
   font-size:12px;
   font-family:PureunJeonnam;
   line-height:30px;
   }
   .category ul li a{
   text-decoration:none;
   color:white;
   }
   
.paging{text-align:center;height:32px;margin-top:5px;margin-bottom:15px;}
.paging a,
.paging strong{display:inline-block;width:36px;height:32px;line-height:28px;font-size:14px;border:1px solid #e0e0e0;margin-left:5px;
-webkit-border-radius:3px;
   -moz-border-radius:3px;
		border-radius:3px;
-webkit-box-shadow:1px 1px 1px 0px rgba(235,235,235,1);
	-moz-box-shadow:1px 1px 1px 0px rgba(235,235,235,1);
		  box-shadow:1px 1px 1px 0px rgba(235,235,235,1);
}
.paging a:first-child{margin-left:0;}
.paging strong{color:#fff;background:#337AB7;border:1px solid #337AB7;}
.paging .page_arw{font-size:11px;line-height:30px;}
</style>

<script type="text/javascript">
$(document).ready(function () {
	//btn클릭 이벤트 처리
	$("#resister").click(function () {
		alert("FAQ등록창으로 이동하겠습니다.") 
		document.location.href="adminFaqForm";	
	});
	//페이지 로드시 버튼 클릭

});







</script>
</head>

<body>
<div id="faq_admin_wrap">
<div class="faq_admin_title">
<div class="title_font1"><a href="#" style="text-decoration: none;color:black;">FAQ 관리페이지</a></div>
<div class="title_font2">등록 및 수정이 가능합니다.</div>
</div>

<div class="faq_line">
<hr color="#777" width="100%" size="1">
</div>
         <div class="category">
         <ul>
         	<li><a href="adminFaq?category=회원안내" class="categoryButton">회원안내</a></li>
         	<li><a href="adminFaq?category=배송안내" class="categoryButton">배송안내</a></li>
         	<li><a href="adminFaq?category=주문/결제" class="categoryButton">주문/결제</a></li>
         	<li><a href="adminFaq?category=주문취소/변경" class="categoryButton">주문취소/변경</a></li>
         	<li><a href="adminFaq?category=교환/반품" class="categoryButton">교환/반품</a></li>
         	<li><a href="adminFaq?category=환불" class="categoryButton">환불</a></li>
         	<li><a href="adminFaq?category=상품" class="categoryButton">상품</a></li>
         	<li><a href="adminFaq?category=사이트이용안내" class="categoryButton">사이트이용안내</a></li>
         </ul>
</div>

<table class="faq_admin_table" width="100%">
<colgroup>
	<col width="10%" />
	<col width="20%"/>
	<col width="20%" />
	<col width="10%" />
	<col width="10%" />
	<col width="10%" />
    <col width="10%"/>
</colgroup>
<tr>
	<th>NO</th>
    <th>카테고리</th>
    <th>글제목</th>
    <th>작성자</th>
    <th>등록일자</th>
    <th>조회수</th>
    <th>관리</th>
</tr>

          		<c:choose>
                 <c:when test="${fn:length(list) le 0}">
									
						<tr>
							<td colspan="6" style="text-align:center;">등록된 게시글이 없습니다</td>
						</tr>
							
                 </c:when>
                 <c:otherwise>

   				 <c:forEach var="list"  items="${list}" varStatus="stat">
   				 <c:url var="ModifyURL" value="/adminFaqModifyForm" >
					<c:param name="FAQ_NO" value="${list.FAQ_NO}" />
				 </c:url>
				  <c:url var="DeleteURL" value="/SG/adminFaqModify" >
					<c:param name="FAQ_NO" value="${list.FAQ_NO}" />
					<c:param name="FAQ_IMAGE" value="${list.FAQ_IMAGE }"/>
				 </c:url>
                 	<tr> 
                     	<td>${stat.count}</td>
                     	<td>${list.FAQ_CATEGORY}</td>
                        <td><a href="#">${list.FAQ_TITLE}</a></td>
                        <td>SG운영자</td>
                        <td>${list.FAQ_REGDATE}</td>
                        <td>${list.FAQ_HITCOUNT}</td>
                        <td>
							<a href="${ModifyURL}"><span class="glyphicon glyphicon-cog" aria-hidden="true" style="font-size:30px;"></span></a>
							<a href="${DeleteURL}"><span class="glyphicon glyphicon-remove" aria-hidden="true"style="font-size:30px;"></span></a>
						</td>
                    </tr>
                 </c:forEach> 
                 </c:otherwise> 
                </c:choose>  
           
</table>

							<div>
								<input type="button" value="등록하기" class="btn btn-primary" id="resister" style="float:right;">
							</div>
<div class="paging" style="text-align:center; both:clear;">
						${pagingHtml}
					</div>
<div class="admin_search">

                     		<div style="text-align:center; width:500px; margin-left:auto; margin-right:auto; margin-top:10px;">
								<div id="dataTables-example_filter" class="dataTables_filter">
									<form action="/SG/adminFaq">
									<select class="form-control" name="searchNum" id="searchNum" style="width:90px; float:left; margin-right:8px;">
										<option value="0">제목</option>
										<option value="1">내용</option>
									</select>
										<input class="form-control" type="text" name="isSearch" id="isSearch" style="width:300px; float:left;"/>
										<span>
										<button type="submit" class="btn btn-primary" style="float:left;">검색</button>
										</span>
									</form>
								</div>							
							</div>
</div>

</div>
</body>
</html>
