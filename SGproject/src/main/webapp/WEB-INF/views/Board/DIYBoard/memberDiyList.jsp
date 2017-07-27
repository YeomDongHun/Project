<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css"><!-- 별모양 폰트 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script type="text/javascript" src="resources/file/js/jquery-2.0.0.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>샐러드 구쁘다</title>
</head>
<style>
@import url('//cdn.rawgit.com/young-ha/webfont-archive/master/css/PureunJeonnam.css');
#diy_wrap{
	width:1500px;
	margin-left:auto;
	margin-right:auto;
	font-family:PureunJeonnam;
}
#diy_wrap th{
	font-size:15px;
	font-family:PureunJeonnam;
	text-align:center;
	background: #f5f5f5;
	
	
}
#diy_wrap table{
	font-size:15px;
	font-family:PureunJeonnam;
	text-align:center;
	font-weight:bold;
}
a{
	text-decoration:none;
	color:black;
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

<script>
$(document).ready(function () {

	
	$("#resister").click(function () {
			alert("후기작성.");
			document.location.href="memberDiyBoardForm";
	});
	//페이지 로드시 버튼 클릭

});
</script>
<body>
<div id="diy_wrap">
<table class="table">
<colgroup>

	<col width="5%"/>
	<col width="10%"/>
	<col width="50%"/>
	<col width="5%"/>
	<col width="15%"/>
	<col width="5%"/>
	<col width="10%"/>
</colgroup>
<div>
	<h3 style="padding-left:20px; text-align:left;">
		<span style="color:black; font-size:30px; font-weight:bold;">나만의 레시피</span> <span style=" font-size:15px; color:#777; font-weight:bold;">이렇게 드셔보세요!</span>
	</h3>
</div>

<div>
	<hr color="#777" width="100%" size="1">
</div>

<tr>
	<th>번호</th>
	<th>이미지</th>
	<th style="text-align:left;">제목</th>
	<th>작성자</th>
	<th>작성일</th>
	<th>조회수</th>
	<th>평점</th>
</tr>
<c:choose>
                 <c:when test="${fn:length(diylist) le 0}">				
						<tr>
							<td colspan="7" style="text-align:center;">등록된 게시글이 없습니다</td>
						</tr>		
                 </c:when>
<c:otherwise>
<c:forEach var="diylist" items="${diylist}" varStatus="stat">
   				 <c:url var="ViewURL" value="/memberDiyBoardDetail" >
					<c:param name="DIY_NO" value="${diylist.DIY_NO}" />
				 </c:url>

	<tr>
		<td style="vertical-align:middle;">${stat.count}</td>
		<td style="vertical-align:middle;"><img src="resources/file/diyFile/${diylist.DIY_IMAGE }" class="img-rounded" style="width:70px; height:70px;"></td>
		<td style="vertical-align:middle; text-align:left;"><a href="${ViewURL}" style="text-decoration:none;">${diylist.DIY_TITLE}</a><span style="color:red;">&nbsp;( ${diylist.DIY_COUNT} )</span></td>
		<td style="vertical-align:middle;">${diylist.DIY_MEMBER_ID }</td>
		<td style="vertical-align:middle;"><fmt:formatDate value="${diylist.DIY_REGDATE}" pattern="YYYY.MM.dd" /></td>
		<td style="vertical-align:middle;">${diylist.DIY_HITCOUNT}</td>
		<td style="vertical-align:middle;">
<p style="color:#fdd66e; font-size:20px;">
<c:choose>
<c:when test="${diylist.DIY_RATE == 1}">
<i class="fa fa-star" aria-hidden="true"></i>
<i class="fa fa-star-o" aria-hidden="true"></i>
<i class="fa fa-star-o" aria-hidden="true"></i>
<i class="fa fa-star-o" aria-hidden="true"></i>
<i class="fa fa-star-o" aria-hidden="true"></i>
</c:when>

<c:when test="${diylist.DIY_RATE == 2}">
<i class="fa fa-star" aria-hidden="true"></i>
<i class="fa fa-star" aria-hidden="true"></i>
<i class="fa fa-star-o" aria-hidden="true"></i>
<i class="fa fa-star-o" aria-hidden="true"></i>
<i class="fa fa-star-o" aria-hidden="true"></i>
</c:when>

<c:when test="${diylist.DIY_RATE == 3}">
<i class="fa fa-star" aria-hidden="true"></i>
<i class="fa fa-star" aria-hidden="true"></i>
<i class="fa fa-star" aria-hidden="true"></i>
<i class="fa fa-star-o" aria-hidden="true"></i>
<i class="fa fa-star-o" aria-hidden="true"></i>
</c:when>

<c:when test="${diylist.DIY_RATE == 4}">
<i class="fa fa-star" aria-hidden="true"></i>
<i class="fa fa-star" aria-hidden="true"></i>
<i class="fa fa-star" aria-hidden="true"></i>
<i class="fa fa-star" aria-hidden="true"></i>
<i class="fa fa-star-o" aria-hidden="true"></i>
</c:when>

<c:when test="${diylist.DIY_RATE == 5}">
<i class="fa fa-star" aria-hidden="true"></i>
<i class="fa fa-star" aria-hidden="true"></i>
<i class="fa fa-star" aria-hidden="true"></i>
<i class="fa fa-star" aria-hidden="true"></i>
<i class="fa fa-star" aria-hidden="true"></i>
</c:when>
<c:otherwise>
<i class="fa fa-star-o" aria-hidden="true"></i>
<i class="fa fa-star-o" aria-hidden="true"></i>
<i class="fa fa-star-o" aria-hidden="true"></i>
<i class="fa fa-star-o" aria-hidden="true"></i>
<i class="fa fa-star-o" aria-hidden="true"></i>
</c:otherwise>
</c:choose>
</p>
		
		
		</td>
	</tr>
</c:forEach>
</c:otherwise>
</c:choose>
 
</table>

<c:if test="${sessionScope.MEMBER_ID != null}">
<div>
		<button type="btn btn-primary" id="resister" class="btn btn-primary" style="float:right;">후기작성</button>
</div>
</c:if>


<div class="paging" style="clear:both;"> <!-- 페이징 관련 -->
${pagingHtml}
</div>


<div class="admin_search" style="clear:both;">

                     		<div style="text-align:center; width:500px; margin-left:auto; margin-right:auto; margin-top:10px;">
								<div id="dataTables-example_filter" class="dataTables_filter">
									<form action="/SG/memberDiyBoardList">
									<select class="form-control" name="searchNum" id="searchNum" style="width:90px; float:left; margin-right:8px;">
										<option value="0">작성자</option>
										<option value="1">제목</option>
									</select>
										<input class="form-control" type="text" name="isSearch" id="isSearch" style="width:300px; float:left;" placeholder="키워드를 입력해 주세요 "/>
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