<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>  


<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">

function basket(){
	alert("장바구니에 담았셈");
}


function imgToggle(test){
	
var wish = document.getElementById(test.getAttribute("id")).getAttribute("src");


if(wish=="resources/file/img/wishoff.png"){
	test.setAttribute( "src", "resources/file/img/wish.ico" );
alert("위시리스트에 담았셈");
}else{
test.setAttribute( "src", "resources/file/img/wishoff.png" );
alert("위시리스트에서 삭제");
}



}


</script>
</head>
<body>

<div class="searchBar" style="width:1000px; height:100px; padding:auto; margin:auto;">
<form action="goodsSearch?keyword=${keyword}" method="GET">
<center>
<input type="text" name="keyword">
<input type ="submit" value="상품검색">
</center>
</form>
</div>

<div style="margin-left:200px; margin-right:200px; padding-left:50px; padding-right: 50px;">
 <c:choose>
      	  <c:when test="${fn:length(goodsList) > 0}">

			<c:forEach var="list" items="${goodsList}" varStatus="stat">
						<c:url var="viewURL" value="view" >
							<c:param name="no" value="${list.GOODS_NO}" />
						    <c:param name="currentPage" value="${currentPage}" />
						</c:url>
	
	
		<div class="box" style="border:1px solid black; list-style:none; width:300px; height:370px; float:left; margin:auto;">	
			
			<div class="box_image"  style=" width:300px; height:300px; margin:auto;">
			<img src="/test/img/94_shop1_490874.jpg" width="284" height="284" onclick="javascript:location.href='/goodsDetail?goodsNo=${list.GOODS_NO}&currentPage=${currentPage}'"/></div>
			<center>
			<div class="name">${list.GOODS_NAME}</div>
			<div class="price">${list.GOODS_PRICE }</div>
			</center>
			
			<div class="basketWish" style="float:left;">
			<div class="basket" style="margin:auto; padding-left:10px;float:left;">
			<img src="resources/file/img/basket.ico" width="20" height="20" onclick="basket()"/>
			</div>
			<div class="wish" style="margin:auto; padding-left:10px;float:left">
			<img id="wishoff${stat.index}" src="resources/file/img/wishoff.png" width="20" height="20" onclick="imgToggle(this)"/>
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





<div class="goods_list" style="width:1000px; height:3000px; padding:auto; margin:10px;">
	

	

</div>

</div>


</body>

</html>