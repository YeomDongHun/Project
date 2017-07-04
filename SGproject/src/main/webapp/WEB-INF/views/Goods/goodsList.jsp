<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
/* 숫자 , 표시 함수 */
	var funcSetCurrency = function($) {
		$('.price-prdc').each(
				function() {
					if (!isNaN(Number($(this).text())) && $(this).text())
						$(this).text(
								Number($(this).text()).toLocaleString().split('.')[0]);
				});
	};

	$(document).ready(function() {
		funcSetCurrency($);
	});
	
/* 위시리스트 checked  */
$(document).ready(function(){
	$('#wish').toggle(function(){
		$(this).parent().css('height', 'auto');
	}, function(){
		$(this).parent().css('height', '18px');
	});
});
	

</script>
</head>


<div class="goods_list">

	
<c:forEach var="goodsList"  items="${goodsList}" varStatus="stat">	
<c:url var="viewURL" value="goodsView">
<c:param name="GOODS_NO" value="${goodsList.GOODS_NO}"/>
<c:param name="currentPage" value="${currentPage}"/>
</c:url>	

<ul>
<li class="box">
<a href="${viewURL}"> 
<div class="box_image">
<img src="/resources/goods_upload/${goodsList.GOODS_THUMBNAIL}" width="100" height="100" />
</a>

<dl class="name">
<dt class="name">>${goodsList.GOODS_NAME}</dt>
</dl>

<dd class="price">
<p>${goodsList.GOODS_PRICE}원</p> 
</dd>

</div>
</li>
</ul>

<ul>
<!-- 구매평갯수  -->

<!-- wish -->

<!-- basket -->
</ul>


</c:forEach>

<!--  등록된 상품이 없을때 -->
<c:if test="${fn:length(goodsList) le 0}">
	등록된 상품이 없습니다
</c:if> 
</div>

</html>