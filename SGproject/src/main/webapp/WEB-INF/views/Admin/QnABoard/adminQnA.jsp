<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
    
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
#qna_wrap{
	font-family:PureunJeonnam;
}
#qna_wrap th{
	font-size:15px;
	font-family:PureunJeonnam;
	text-align:center;
	background: #f5f5f5
	
	
}
#qna_wrap table{
	font-size:15px;
	font-family:PureunJeonnam;
	text-align:center;
	font-weight:bold;
}
a{
	text-decoration:none;
	color:black;
}
.qna_line {margin: 0 50px 0 50px;}
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
<div id="qna_wrap">
<table class="table table-hover">
<colgroup>
	<col width="5%"/>
	<col width="10%"/>
	<col width="10%"/>
	<col width="20%"/>
	<col width="15%"/>
	<col width="10%"/>
	<col width="15%"/>
	<col width="15%"/>
</colgroup>
<div>
<h3 style="text-align:left;">
<span style="color:black; font-size:30px; font-weight:bold;">관리자 페이지/</span> <span style="color:#777; font-weight:bold;">Q&A 관리</span>
</h3>
</div>

<div class="qna_line">
	<hr color="#777" width="100%" size="1">
</div>

<tr>
	<th>번호</th>
	<th>카테고리</th>
	<th>문의 아이디</th>
	<th>글제목</th>
	<th>문의날짜</th>
	<th>답변상태</th>
	<th>답변날짜</th>
	<th>관리</th>
</tr>
<c:choose>
            <c:when test="${qnalist} == null">
 					<tr>
                 		<td colspan="8">게시글이 없습니다.</td>
                 	</tr>
           </c:when>
<c:otherwise>
<c:forEach var="qnalist" items="${qnalist}" varStatus="stat">
   				 <c:url var="AnswerURL" value="/adminAnswerForm" >
					<c:param name="QNA_NO" value="${qnalist.QNA_NO}" />
				 </c:url>
	<tr>
		<td style="vertical-align:middle;">${stat.count}</td>
		<td style="vertical-align:middle;">${qnalist.QNA_CATEGORY}</td>
		<td style="vertical-align:middle;">${qnalist.MEMBER_ID }</td>
		<td style="vertical-align:middle;">${qnalist.QNA_TITLE}</td>
		<td style="vertical-align:middle;"><fmt:formatDate value="${qnalist.QNA_REGDATE}" pattern="YY.MM.dd" /></td>
		<td style="vertical-align:middle;">${qnalist.QNA_REPSTATE}</td>
	<c:choose>
		<c:when test="${qnalist.QNA_REPDATE==null}">
			<td style="vertical-align:middle;">
			-미답변-
			</td>	
		</c:when>
		<c:otherwise>	
			<td style="vertical-align:middle;">
			${qnalist.QNA_REPDATE}	
			</td>
		</c:otherwise>
	</c:choose>	
		<td style="vertical-align:middle;">
			<a href="${AnswerURL}"><span class="glyphicon glyphicon-comment" aria-hidden="true" style="font-size:30px; color:black; text-align:center; margin-right:10px"></span></a>
		</td>
 	</tr>
</c:forEach>
</c:otherwise>
</c:choose>
</table>


<div class="paging" style="clear:both;"> <!-- 페이징 관련 -->
${pagingHtml}
</div>


<div class="admin_search" style="clear:both;">

                     		<div style="text-align:center; width:500px; margin-left:auto; margin-right:auto; margin-top:10px;">
								<div id="dataTables-example_filter" class="dataTables_filter">
									<form action="/SG/memberqnaBoardList">
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