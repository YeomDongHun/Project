<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>  
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<!DOCTYPE html>
<html>
<head>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
<script src="https://code.jquery.com/jquery-3.0.0.min.js"></script>  
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<style>
@import url('//cdn.rawgit.com/young-ha/webfont-archive/master/css/PureunJeonnam.css');
.type07 th{
	font-family:PureunJeonnam;
	font-weight:bold;
	background: #f5f5f5;
	text-align:center;
}

.type07 td{
	font-family:PureunJeonnam;
	font-weight:bold;
}
</style>
<title>Insert title here</title>

<script type="text/javascript">


</script>
</head>
<body>
 <c:choose>
 	<c:when test="${fn:length(commentList) > 0}">	
<table class="type07" style="width:1000px;">  
	<colgroup>
		<col width="15%"/>
		<col width="50%"/>
		<col width="15%"/>
		<col width="15%"/>
		<col width="5%"/>
	</colgroup>
    <tr>
        <th style="text-align:center;">작성자</th>
        <th style="text-align:center;">내용</th>
        <th style="text-align:center;">평점</th>
        <th style="text-align:center;">작성일</th>
        <th style="text-align:center;">비고</th>
    </tr>
	<c:forEach var="commentList" items="${commentList}" varStatus="stat">

    <tr>
        <td style="text-align:center;">${commentList.DIYCMT_ID}</td>
        <td style="text-align:center;">${commentList.DIYCMT_CONTENT}</td>
        <td style="text-align:center;">
        <c:choose>
        	<c:when test="${commentList.DIYCMT_RATE == 1}">맛없어요</c:when>
        	<c:when test="${commentList.DIYCMT_RATE == 2}">별루에요</c:when>
        	<c:when test="${commentList.DIYCMT_RATE == 3}">좋아요</c:when>
        	<c:when test="${commentList.DIYCMT_RATE == 4}">맛있어요</c:when>
        	<c:otherwise>최고에요</c:otherwise>
        
        </c:choose>
        
        
        
        
        
        </td>
        <td style="color:black; text-align:center;"><fmt:formatDate value="${commentList.DIYCMT_REGDATE}" pattern="YYYY.MM.dd" />
        </td>
        <td>
        <span class="glyphicon glyphicon-remove" aria-hidden="true" id="${commentList.COMMENT_NO}" name="${commentList.COMMENT_ID}" onclick="dComment(this)"></span>
        </td>
    </tr>

   	</c:forEach>
   	</table>
		 </c:when>
                
                <c:otherwise>
                <table class="type07" style="width:1000px;">
                	<colgroup>
						<col width="20%"/>
						<col width="50%"/>
						<col width="15%"/>
						<col width="15%"/>
					</colgroup>
                
                
                <thead> 
   					 <tr>
        				<th style="border-right:3px solid white;">작성자</th>
        				<th style="border-right:3px solid white;">내용</th>
        				<th style="border-right:3px solid white;">평점</th>
        				<th>작성일</th>
   		 			</tr>
      			</thead>  
                    <tr>
                        <td colspan="4" style="text-align:center;">아직 작성된 후기가 없어요</td>
                    </tr>
                   </table>
                </c:otherwise>
   </c:choose>
		
</body>
</html>