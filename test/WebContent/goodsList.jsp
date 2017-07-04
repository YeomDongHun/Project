<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">

function basket(){
	alert("장바구니에 담았셈");
}


function imgToggle(test){
var wish = document.getElementById(test.getAttribute("id")).getAttribute("src");


if(wish=="/test/img/wishoff.ico"){
	test.setAttribute( "src", "/test/img/wishon.ico" );
alert("위시리스트에 담았셈");
}else{
test.setAttribute( "src", "/test/img/wishoff.ico" );
alert("위시리스트에서 삭제");
}



}


</script>
</head>
<div class="searchBar" style="width:1000px; height:100px; margin:0 auto;">
<form action="goodsSearch?keyword=${keyword}" method="GET">
<center>
<input type="text" name="keyword">
<input type ="submit" value="상품검색">
</center>
</form>
</div>

<div class="goods_list" style="width:1000px; height:3000px; padding:auto; margin:10px;border:1px solid black;">
	
	<div class="box" style="list-style:none; width:300px; height:370px; float:left; margin:0 auto;">	
			
			<div class="box_image"  style=" width:300px; height:300px; margin:0 auto; align:center;">
			<img src="/test/img/94_shop1_490874.jpg" width="284" height="284" onclick="javascript:location.href='/test/goodsDetail.jsp'"/>
			</div>
			<center>
			<div class="name">상품이름</div>
			<div class="price">500원</div>
			</center>
			
			<div class="basketWish" style="float:left;">
			<div class="basket" style="margin:auto; padding-left:10px;float:left;">
			<img src="/test/img/Elegantthemes-Beautiful-Flat-Cart.ico" width="20" height="20" onclick="basket()"/>
			</div>
			<div class="wish" style="margin:auto; padding-left:10px;float:left">
			<img id="wishoff1" src="/test/img/wishoff.ico" width="20" height="20" onclick="imgToggle(this)"/>
			</div>
			</div>

	</div>
	
	<div class="box" style="list-style:none; width:300px; height:370px; float:left; margin:auto;">	
			
			<div class="box_image"  style=" width:300px; height:300px; margin:0 auto; align:center;">
			<img src="/test/img/94_shop1_490874.jpg" width="284" height="284" onclick="javascript:location.href='/test/goodsDetail.jsp'"/>
			</div>
			<center>
			<div class="name">상품이름</div>
			<div class="price">500원</div>
			</center>
			
			<div class="basketWish" style="float:left;">
			<div class="basket" style="margin:auto; padding-left:10px;float:left;">
			<img src="/test/img/Elegantthemes-Beautiful-Flat-Cart.ico" width="20" height="20" onclick="basket()"/>
			</div>
			<div class="wish" style="margin:auto; padding-left:10px;float:left">
			<img id="wishoff2" src="/test/img/wishoff.ico" width="20" height="20" onclick="imgToggle(this)"/>
			</div>
			</div>

	</div>
	
	<div class="box" style="list-style:none; width:300px; height:370px; float:left; margin:auto;">	
			
			<div class="box_image"  style=" width:300px; height:300px; margin:0 auto; align:center;">
			<img src="/test/img/94_shop1_490874.jpg" width="284" height="284" onclick="javascript:location.href='/test/goodsDetail.jsp'"/>
			</div>
			<center>
			<div class="name">상품이름</div>
			<div class="price">500원</div>
			</center>
			
			<div class="basketWish" style="float:left;">
			<div class="basket" style="margin:auto; padding-left:10px;float:left;">
			<img src="/test/img/Elegantthemes-Beautiful-Flat-Cart.ico" width="20" height="20" onclick="basket()"/>
			</div>
			<div class="wish" style="margin:auto; padding-left:10px;float:left">
			<img id="wishoff3" src="/test/img/wishoff.ico" width="20" height="20" onclick="imgToggle(this)"/>
			</div>
			</div>

	</div>
	
	<div class="box" style="list-style:none; width:300px; height:370px; float:left; margin:auto;">	
			
			<div class="box_image"  style=" width:300px; height:300px; margin:0 auto; align:center;">
			<img src="/test/img/94_shop1_490874.jpg" width="284" height="284" onclick="javascript:location.href='/test/goodsDetail.jsp'"/>
			</div>
			<center>
			<div class="name">상품이름</div>
			<div class="price">500원</div>
			</center>
			
			<div class="basketWish" style="float:left;">
			<div class="basket" style="margin:auto; padding-left:10px;float:left;">
			<img src="/test/img/Elegantthemes-Beautiful-Flat-Cart.ico" width="20" height="20" onclick="basket()"/>
			</div>
			<div class="wish" style="margin:auto; padding-left:10px;float:left">
			<img id="wishoff4" src="/test/img/wishoff.ico" width="20" height="20" onclick="imgToggle(this)"/>
			</div>
			</div>

	</div>
	
	<div class="box" style="list-style:none; width:300px; height:370px; float:left; margin:auto;">	
			
			<div class="box_image"  style=" width:300px; height:300px; margin:0 auto; align:center;">
			<img src="/test/img/94_shop1_490874.jpg" width="284" height="284" onclick="javascript:location.href='/test/goodsDetail.jsp'"/>
			</div>
			<center>
			<div class="name">상품이름</div>
			<div class="price">500원</div>
			</center>
			
			<div class="basketWish" style="float:left;">
			<div class="basket" style="margin:auto; padding-left:10px;float:left;">
			<img src="/test/img/Elegantthemes-Beautiful-Flat-Cart.ico" width="20" height="20" onclick="basket()"/>
			</div>
			<div class="wish" style="margin:auto; padding-left:10px;float:left">
			<img id="wishoff5" src="/test/img/wishoff.ico" width="20" height="20" onclick="imgToggle(this)"/>
			</div>
			</div>

	</div>
	
	<div class="box" style="list-style:none; width:300px; height:370px; float:left; margin:auto;">	
			
			<div class="box_image"  style=" width:300px; height:300px; margin:0 auto; align:center;">
			<img src="/test/img/94_shop1_490874.jpg" width="284" height="284" onclick="javascript:location.href='/test/goodsDetail.jsp'"/>
			</div>
			<center>
			<div class="name">상품이름</div>
			<div class="price">500원</div>
			</center>
			
			<div class="basketWish" style="float:left;">
			<div class="basket" style="margin:auto; padding-left:10px;float:left;">
			<img src="/test/img/Elegantthemes-Beautiful-Flat-Cart.ico" width="20" height="20" onclick="basket()"/>
			</div>
			<div class="wish" style="margin:auto; padding-left:10px;float:left">
			<img id="wishoff6" src="/test/img/wishoff.ico" width="20" height="20" onclick="imgToggle(this)"/>
			</div>
			</div>

	</div>
	
	<div class="box" style="list-style:none; width:300px; height:370px; float:left; margin:auto;">	
			
			<div class="box_image"  style=" width:300px; height:300px; margin:0 auto; align:center;">
			<img src="/test/img/94_shop1_490874.jpg" width="284" height="284" onclick="javascript:location.href='/test/goodsDetail.jsp'"/>
			</div>
			<center>
			<div class="name">상품이름</div>
			<div class="price">500원</div>
			</center>
			
			<div class="basketWish" style="float:left;">
			<div class="basket" style="margin:auto; padding-left:10px;float:left;">
			<img src="/test/img/Elegantthemes-Beautiful-Flat-Cart.ico" width="20" height="20" onclick="basket()"/>
			</div>
			<div class="wish" style="margin:auto; padding-left:10px;float:left">
			<img id="wishoff1" src="/test/img/wishoff.ico" width="20" height="20" onclick="imgToggle(this)"/>
			</div>
			</div>

	</div>
	
	<div class="box" style="list-style:none; width:300px; height:370px; float:left; margin:auto;">	
			
			<div class="box_image"  style=" width:300px; height:300px; margin:0 auto; align:center;">
			<img src="/test/img/94_shop1_490874.jpg" width="284" height="284" onclick="javascript:location.href='/test/goodsDetail.jsp'"/>
			</div>
			<center>
			<div class="name">상품이름</div>
			<div class="price">500원</div>
			</center>
			
			<div class="basketWish" style="float:left;">
			<div class="basket" style="margin:auto; padding-left:10px;float:left;">
			<img src="/test/img/Elegantthemes-Beautiful-Flat-Cart.ico" width="20" height="20" onclick="basket()"/>
			</div>
			<div class="wish" style="margin:auto; padding-left:10px;float:left">
			<img id="wishoff1" src="/test/img/wishoff.ico" width="20" height="20" onclick="imgToggle(this)"/>
			</div>
			</div>

	</div>
	
	<div class="box" style="list-style:none; width:300px; height:370px; float:left; margin:auto;">	
			
			<div class="box_image"  style=" width:300px; height:300px; margin:0 auto; align:center;">
			<img src="/test/img/94_shop1_490874.jpg" width="284" height="284" onclick="javascript:location.href='/test/goodsDetail.jsp'"/>
			</div>
			<center>
			<div class="name">상품이름</div>
			<div class="price">500원</div>
			</center>
			
			<div class="basketWish" style="float:left;">
			<div class="basket" style="margin:auto; padding-left:10px;float:left;">
			<img src="/test/img/Elegantthemes-Beautiful-Flat-Cart.ico" width="20" height="20" onclick="basket()"/>
			</div>
			<div class="wish" style="margin:auto; padding-left:10px;float:left">
			<img id="wishoff1" src="/test/img/wishoff.ico" width="20" height="20" onclick="imgToggle(this)"/>
			</div>
			</div>

	</div>
	
	
	
	
	

</div>






</html>