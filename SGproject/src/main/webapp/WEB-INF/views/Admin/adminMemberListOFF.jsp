<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script type="text/javascript" src="resources/file/js/jquery-2.0.0.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>샐러드 구쁘다</title>
</head>
<style>
@import url('//cdn.rawgit.com/young-ha/webfont-archive/master/css/PureunJeonnam.css');
#member_wrap{
	width:1500px;
	margin-left:auto;
	margin-right:auto;
	font-family:PureunJeonnam;
}
#member_wrap th{
	font-size:15px;
	font-family:PureunJeonnam;
	text-align:center;
	background: #f5f5f5
	
	
}
#member_wrap table{
	font-size:15px;
	font-family:PureunJeonnam;
	text-align:center;
	font-weight:bold;
}
a{
	text-decoration:none;
	color:black;
}
.member_line {margin: 0 50px 0 50px;}
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


<body>
<div id="member_wrap">
<table class="table table-hover">
<colgroup>

	<col width="5%"/>
	<col width="10%"/>
	<col width="15%"/>
	<col width="10%"/>
	<col width="15%"/>
	<col width="35%"/>
	<col width="10%"/>
	

	
</colgroup>
<div>
<h3 style="text-align:center;">
<span style="color:black; font-size:30px; font-weight:bold;">관리자 페이지/</span> <span style="color:#777; font-weight:bold;">회원 목록 관리</span>
</h3>
</div>

<div class="member_line">
	<hr color="#777" width="100%" size="1">
</div>

<tr>
	<th>번호</th>
	<th>아이디</th>
	<th>등급</th>
	<th>이름</th>
	<th>생일</th>
	<th>주소</th>
	<th>가입날자</th>

	
</tr>

<c:choose>
	<c:when test="${fn:length(adminmemberlistoff) > 0}">

		<c:forEach var="adminmemberlistoff" items="${adminmemberlistoff}" varStatus="stat">
				 
	<tr style="border:1px solid black;">
		<td style="vertical-align:middle;border:1px solid black;">${stat.count}</td>
		<td style="vertical-align:middle;border:1px solid black;">${adminmemberlistoff.MEMBER_ID}</td>
		<td style="vertical-align:middle;border:1px solid black;">
		<c:choose>
            
            <c:when test="${(adminmemberlistoff.MEMBER_GRADE)==0}">
         
            <span style="margin-left:5px;">               
            <img id="grade" style="height:60px;" src="./resources/file/img/grade/green0.png"/>
            </span>
            </c:when>
            
            <c:when test="${(adminmemberlistoff.MEMBER_GRADE)==1}">
            
            <span style="margin-left:15px;">
            <img id="grade" style="height:60px;" src="./resources/file/img/grade/pink1.png"/></span> 
            </c:when>
            
            <c:when test="${(adminmemberlistoff.MEMBER_GRADE)==2}">
            
            <span style="margin-left:15px;">
            <img id="grade" style="height:60px;"src="./resources/file/img/grade/gold2.png"/>
            </span>
            </c:when>
            
            <c:when test="${(adminmemberlistoff.MEMBER_GRADE)==3}">
            
            <img id="grade" src="./resources/file/img/grade/dia3.png"/>   
            </c:when>
            
            <c:when test="${(adminmemberlistoff.MEMBER_GRADE)==4}">
            
            <span style="margin-left:15px;">   
            <img id="grade" style="height:60px;"src="./resources/file/img/grade/vip4.png"/>
            </span> 
            </c:when>
            
            <c:otherwise>
            admin
            </c:otherwise>
            </c:choose>
		</td>
		
		
		
		<td style="vertical-align:middle;border:1px solid black;">${adminmemberlistoff.MEMBER_NAME}</td>
		<td style="vertical-align:middle;border:1px solid black;">${adminmemberlistoff.MEMBER_BIRTHDAY}</td>
		<td style="vertical-align:middle;border:1px solid black;">${adminmemberlistoff.MEMBER_ZIP} ${adminmemberlistoff.MEMBER_ADDR1} ${adminmemberlistoff.MEMBER_ADDR2}</td>
		<td style="vertical-align:middle;border:1px solid black;"><fmt:formatDate value="${adminmemberlistoff.MEMBER_REGDATE}" pattern="YY.MM.dd" /></td>

 	</tr>
 	</c:forEach>
	</c:when>

	<c:otherwise>
	<tr>
	       <td colspan="9">조회된 결과가 없습니다.</td>
	    </tr>
	    
		
	</c:otherwise>
	                
</c:choose>
</table>


<div class="paging" style="clear:both;"> <!-- 페이징 관련 -->
${pagingHtml}
</div>

<div class="admin_searchoff" style="clear:both;">

		<div style="text-align:center; width:500px; margin-left:auto; margin-right:auto; margin-top:10px;">
			<div id="dataTables-example_filter" class="dataTables_filter">
				<form action="/SG/adminMemberListOFF">
				<select class="form-control" name="searchNum" id="searchNum" style="width:90px; float:left; margin-right:8px;">
					<option value="0">아이디</option>
					<option value="1">이름</option>
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