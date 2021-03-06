<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="/SG/resources/file/css/myBasket.css">
<script type="text/javascript">

function writeform()
{
    
	//나의 정보보기 팝업 창
	window.open('/SG/myQnaWriteForm','','toolbar=no,menubar=no,location=no,height=950,width=1200'); 
}

//myqnalist paging
function ajaxPaging(page)
{	
		
		var dataList =
		({"PAGE" : page});	

		var url1 = "/SG/myQnaList";
		
	    $.ajax({    
	     
	    	type : "POST",
	        url : url1,
	        data : dataList,
	        dataType : "text",      
	        
	        error : function() {
	      	  
	      		alert('오류임!');     	
	        },
	       
	        success : function(data) 
	        {  
	      		 $("#wish_wrap").html(data);          		
	        }
	        
	      });        

	}
</script> 

</head>

<body>
<div id="wish_wrap">
<div class="wish_title">
<div class="wish_title_font" style="margin-left:40px; margin-bottom:20px;">
나의 QNA 게시판
</div>
</div>


<table class="wish_table" width="94%" style="margin-left:40px; line-height:50px;">
<colgroup>
	<col width="10%" />
	<col width="20%"/>
	<col width="30%" />
	<col width="7%" />
	<col width="20%" />
    <col width="10%" />
</colgroup>
<tr style="line-height:20px;">
	<th>글 번호</th>
	<th>카테고리</th>
	<th>글 제목</th>
    <th>조회수</th>
    <th>등록날짜</th>
    <th>답변상태</th>
</tr>

          <c:choose>
               <c:when test="${fn:length(qnalist) le 0}">
 					<tr>
                 		<td colspan="6" style="text-align:center;">등록된 게시글이 존재하지 않습니다.</td>
                 	</tr>
               </c:when>
                 <c:otherwise>

   				 <c:forEach var="qnalist" items="${qnalist}" varStatus="stat">
   				 <c:url var="qnaview" value="/myQnaView">
   				  <c:param name="QNA_NO" value="${qnalist.QNA_NO}"/>
   				 </c:url>
                 	<tr> 
                     	<td>${qnalist.RNUM}</td>
                     	<td>${qnalist.QNA_CATEGORY}</td>
                     	<td><a onclick="javascript:window.open('${qnaview}','','toolbar=no,menubar=no,location=no,height=950,width=1200');">
                     	${qnalist.QNA_TITLE}</a>
                     	</td>
                     	<td>${qnalist.QNA_HITCOUNT}</td>
                        <td>${qnalist.QNA_REGDATE}</td>
                        <td>${qnalist.QNA_REPSTATE}</td>
                    </tr>
                 </c:forEach> 
                 </c:otherwise> 
                </c:choose> 
                
           
</table>

<div class="board_search_table" style="float:left; margin-left:1100px; margin-top:20px;">
<input type="button" id="writeform" name="writeform" value="글 등록" onclick="javascript:writeform();">
</div>

<div class="wish_bottom">
<div class="wish_bottom_font">
<font color="green">${sessionScope.MEMBER_ID}님이 질문하신 답변을 보시려면 글 제목을 눌러주세요</font></div>
</div>

<div class="paging">${pagingHtml}</div>
</div>


</body>

</html>
