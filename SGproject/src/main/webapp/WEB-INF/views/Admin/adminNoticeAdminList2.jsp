<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<script type="text/javascript" src="resources/file/js/jquery-2.0.0.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<style type="text/css">
@import url('//cdn.rawgit.com/young-ha/webfont-archive/master/css/PureunJeonnam.css');
#notice_admin_wrap {
	width: 1500px;
	font-family: PureunJeonnam;
	margin-left:auto;
	margin-right:auto;
}
.notice_admin_title {text-align: left; color: #212121; padding-top: 50px;}
.notice_admin_title div {padding-bottom: 10px;}
.title_font1 {font-family: PureunJeonnam; font-size: 40px; font-weight: bold;}
.title_font2 {font-family: PureunJeonnam; font-size: 15px; font-weight: bold; color: #999;}
.notice_admin_table{
	text-align: center;
	font-family: PureunJeonnam;
	font-size:15px;
	font-weight:bold;	
}
.notice_line {margin: 0 50px 0 50px;}

.notice_admin_table td {
	text-align: center; 
	border-top: 1px solid #e5e5e5; 
	border-bottom: 1px solid #e5e5e5; 
	padding: 8px 0; 
	background: #f5f5f5;
}
.notice_admin_search{
	width:"50%";
	margin-right: auto;
	margin-left: auto;
}
.notice_admin_search input[type=text]{

}
.notice_admin_searchT {
	text-align: center; 
	border-top: 1px solid #e5e5e5; 
	border-bottom: 1px solid #e5e5e5; 
	padding: 8px 0; 
	background: #f5f5f5;
}
.notice_select{
	height: 25px;
}
.paing{text-align:center;}
.paging a:first-child{margin-left:0;}
.paging strong{color:#fff;background:#337AB7;border:1px solid #337AB7;}
.paging .page_arw{font-size:11px;line-height:30px;}

</style>
<script type="text/javascript">
$(document).ready(function () {
	//btn클릭 이벤트 처리
	$("#resister").click(function () {
		alert("등록폼으로 이동하겠습니다.") 
		document.location.href="adminNoticeForm";	
	});
	//페이지 로드시 버튼 클릭

});
</script>

</head>

<body>
<div id="notice_admin_wrap">
<div class="notice_admin_title">
<div class="title_font1"><a href="#" style="text-decoration: none;color:black;">공지사항 관리자페이지</a></div>
<div class="title_font2">공지사항 & 이벤트</div>
</div>

<div class="notice_line">
<hr color="#777" width="100%" size="1">
</div>

<table class="notice_admin_table" width="100%">
<colgroup>
	<col width="10%"/>
	<col width="10%" />
	<col width="30%" />
	<col width="10%" />
    <col width="20%"/>
    <col width="10%"/>
    <col width="10%"/>
</colgroup>
<tr>
	<td>NO</td>
    <td>분류</td>
    <td>글제목</td>
    <td>작성자</td>
    <td>등록날짜</td>
    <td>조회수</td>
    <td>관리</td>
</tr> 

          <c:choose>
               <c:when test="${noticeList} == null">
 					<tr>
                 		<td colspan="7">게시글이 없습니다.</td>
                 	</tr>
                 </c:when>
                 <c:otherwise>

   				 <c:forEach var="noticeList"  items="${noticeList}" varStatus="stat">
                 	<c:url var="ModifyURL" value="/adminNoticeModifyForm" >
						<c:param name="NOTICE_NO" value="${noticeList.NOTICE_NO}" />
				    </c:url>
				    <c:url var="DeleteURL" value="/adminNoticeDelete" >
						<c:param name="NOTICE_NO" value="${noticeList.NOTICE_NO}" />
						<c:param name="NOTICE_IMAGE" value="${noticeList.NOTICE_IMAGE }"/>
				    </c:url>
                 	
                 	<tr> 
                     	<td style="background:white;">${stat.count}</td>
                     <c:choose>
                     	<c:when test="${noticeList.NOTICE_TYPE ==0 }">
                     	<td style="background:white;">공지사항</td>
                     	</c:when>
                     	<c:otherwise>
                     	<td style="background:white;">이벤트</td>
                     	</c:otherwise>
                     </c:choose>	
                        <td style="background:white;"><a href="/SG/adminNoticeDetail?NOTICE_NO=${noticeList.NOTICE_NO}">${noticeList.NOTICE_TITLE}</a></td>
                        <td style="background:white;">SG운영자</td>
                        <td style="background:white;">${noticeList.NOTICE_REGDATE}</td>
                        <td style="background:white;">${noticeList.NOTICE_HITCOUNT}</td>
                        <td style="background:white;">
                        <a href="${ModifyURL}"><span class="glyphicon glyphicon-cog" aria-hidden="true" style="font-size:30px;"></span></a>
                        <a href="${DeleteURL}"><span class="glyphicon glyphicon-remove" aria-hidden="true"style="font-size:30px;"></span></a>
          				</td>
                    </tr>
                 </c:forEach> 
                 </c:otherwise> 
                </c:choose>  
</table>
<div>
	<button type="button" class="btn btn-primary" id="resister">등록하기</button>
</div>


				<div class="paging" style="text-align:center;">
						${pagingHtml}
					</div>
<div class="notice_admin_search">

                     		<div style="text-align:center; width:700px; margin-left:auto; margin-right:auto; margin-top:10px;">
								<div id="dataTables-example_filter" class="dataTables_filter">
									<form action="/SG/adminNoticeAdminList">
									<select class="form-control" name="NOTICE_TYPE" id="NOTICE_TYPE" style="width:120px; float:left; margin-right:8px;">
										<option value="0" selected>공지사항</option>
										<option value="1">이벤트</option>
									</select>
									<select class="form-control" name="searchNum" id="searchNum" style="width:90px; float:left; margin-right:8px;">
										<option value="0">내용</option>
										<option value="1">제목</option>
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
