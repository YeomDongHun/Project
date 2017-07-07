<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>상품 상세 보기</title>

<link rel="stylesheet" href="resources/file/css/css3.css" type="text/css" />


</head>
<body>
<div id="wrap" style="height:400px; width:1000px; margin-left:auto;
   			margin-right:auto;">

<div class="img" style=" float:left; width: 400px; height: 400px;">


<img src="resources/file/img/${goodsDetail.GOODS_THUMBNAIL}" style="width: 400px;">
</div>

	<div class="inform" style="float:right; width:300px;height:300px; background:#FFFFFF; margin-right: 100px;padding-top:15px;margin-top:15px; font-family: PureunJeonnam; ">

	
		<div>상품 이름</div>
		<div>${goodsDetail.GOODS_NAME}</div>
		<div>상품 가격</div>
		<div>${goodsDetail.GOODS_PRICE }</div>
		<div>포인트</div>
		<div>${point}</div>
		<div>원산지</div>
		<div>국내산</div>
		<div>상세 설명</div>
		${goodsDetail.GOODS_DETAIL}
		
		<div>배송방법</div>
				<div><select>
				<optgroup label="----배송 방법----">
					<option>트럭</option>
					<option>비행기</option>
				</optgroup></select>
	</div>
	
	<br/>
	
	
	<input type="button" value="BUY"/>&nbsp;&nbsp;&nbsp;
	<input type="button" value="basket"/>
	</div>
</div>

<div class="content" style="margin-left:auto;
   			margin-right:auto; width:1000px;">
	
	<center>
	<img src="resources/file/img/${image}" style="width: 600px;">
	</center>
	
	
	</div>




<center>
<div class="comment" style="background:#F6F6F6;padding: 20px;width:1000px;margin-left:auto;
   			margin-right:auto;">
<form>
<input type="text" name="commentCon" size="50">
<input type="submit" value="후기 작성"/>
</form>
</div>

<div class="commentList" style="background: #FFBB00;width:1000px;margin-left:auto;
   			margin-right:auto;">
코맨트 리스트 영역
</div>
</center>
</body>
</html>