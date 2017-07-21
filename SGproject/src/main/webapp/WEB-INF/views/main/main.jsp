<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<!-- Place somewhere in the <head> of your document -->

<link rel="stylesheet" href="resources/file/css/flexslider.css" type="text/css">
<link rel="stylesheet" href="resources/file/css/main.css" type="text/css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.6.2/jquery.min.js"></script>
<script src="resources/file/js/jquery.flexslider.js"></script>
<style type="text/css">
@import url('//cdn.rawgit.com/young-ha/webfont-archive/master/css/PureunJeonnam.css');
</style>



<!-- Place in the <head>, after the three links -->
<script type="text/javascript" charset="utf-8">
  $(window).load(function() {
    $('.flexslider').flexslider({
    	animation: "slider"
    });
  });
  

</script>
	 
</head>
<body style="overflow-x:hidden; overflow-y:auto;">

<!-- Place somewhere in the <body> of your page -->
<div class="container">	
	<div class="flexslider" style="width: 100%; margin:auto; z-index: -10;">
	
	  <ul class="slides">
	    <li>
	   		 <img src="resources/file/img/Slide4.jpg" style="height: 300px"/>
	   </li>
	    
	    <li>
	         <img src="resources/file/img/Slide2.jpg" style="height: 300px"/>
	                 
	    </li>
	    <li>
	      <img src="resources/file/img/Slide3.jpg" style="height: 300px"/>
	    </li>
	  </ul>
	</div>
</div>

<!-- body 부분 리스트  -->
<div style="margin-top: 60px; overflow-x:hidden; overflow-y:auto;">
  <div class="container" style="overflow-x:hidden; overflow-y:auto;" >
  <input type="hidden" id="currentPage" value="${currentPage }"/>
                
<c:choose>
	<c:when test="${fn:length(goodsList) > 0}">
		<c:forEach var="goodsList" items="${goodsList}" varStatus="stat">
	                   
			  <div class="SG_ItemBox" style=" width:240px; height:310px; float:left; margin-left: 20px; margin-right: 20px; margin-bottom: 30px;"> 
			    <div class="thumbnail" style="height:310px;">
			    <c:if test="${goodsList.COMMENT_RATE ==0 }">
			    			    	<div style="width:40px;height:40px;background-color: #C90000;color:#FFFFFF; text-align: center; padding-top: 10px; position: absolute;z-index: 0;"><strong>NEW</strong></div>
			    </c:if>
			    <c:if test="${goodsList.COMMENT_RATE !=0 }">
			    			    	<div style="width:40px;height:40px;background-color: #C90000;color:#FFFFFF; text-align: center; padding-top: 10px; position: absolute;z-index: 0;"><strong>${goodsList.COMMENT_RATE}</strong></div>
			    </c:if>
			      <img src="resources/file/goodsFile/${goodsList.GOODS_THUMBNAIL}" alt="..." onclick="javascript:location.href='goodsDetail?goodsNo=${goodsList.GOODS_NO}&currentPage=${currentPage}'"/>
			      <div class="caption">
			      
			        <div style="text-align: center;font-family: PureunJeonnam;"><h4>${goodsList.GOODS_NAME}</h4></div>
			        <div style="text-align: right;font-family: PureunJeonnam;"><h5>${goodsList.GOODS_PRICE }원</h5></div>
			     
			          
			      </div>
			    </div>
			  </div>
			
	   
	         
		</c:forEach>
	</c:when>
	                
	<c:otherwise>
	    <tr>
	       <td colspan="4">조회된 결과가 없습니다.</td>
	    </tr>
	</c:otherwise>
</c:choose>
</div>

</body>
</html>