<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$("#list").on("click", function(e){ //목록으로 버튼
		e.preventDefault();
		fn_openToppingList();
	});
	
	$("#modify").on("click", function(e){ //목록으로 버튼
		e.preventDefault();
		fn_modifyTopping();
	});
	
	$("#write").on("click", function(e){ //작성하기 버튼
		e.preventDefault();
		 if($('#TOPPING_NAME').val()==""){
			alert("상품명을 입력해 주세요.");
			return false;
		 } else if($('#TOPPING_PRICE').val()==""){
			 alert("상품가격을 입력해 주세요.");
				return false;
		 } else if($('#TOPPING_TYPE').val()==''){
			 alert("상품 타입을 선택해 주세요.");
				return false;
		 } else if($('#TOPPING_THUMBNAIL').val()==""){
			 alert("썸네일이미지를 등록해 주세요.");
				return false;
		 } else if($('#TOPPING_DETAIL').val()==""){
			 alert("상품 상세설명을 입력해 주세요.");
				return false;
		 } else if($('#TOPPING_AMOUNT').val()==""){
			 alert("상품 수량을 입력해 주세요.");
				return false;
		 } else if($('#IMAGE').val()==""){
			 alert("상품이미지를 등록해 주세요.");
				return false;
		 }
		 else{
		fn_insertTopping();
		}
	});
	
});

function fn_openTOPPINGList(){
	var comSubmit = new ComSubmit();
	comSubmit.setUrl("/SG/adminToppingList");
	comSubmit.submit();
}

function fn_insertTopping(){
	var comSubmit = new ComSubmit("frm");
	comSubmit.setUrl('/SG/adminToppingInsert');
	comSubmit.submit();
}

function fn_modifyTopping(){
	var comSubmit = new ComSubmit("frm");
	comSubmit.setUrl('/SG/adminToppingModify');
	comSubmit.submit();
}



</script>
</head>
<body>
<c:choose>
<c:when test="${modify}">
<div class="row" style="padding-left:15px;width:900px;">    
	<h1 class="page-header">재료수정</h1>
</div>
	<form id="frm" name="frm" enctype="multipart/form-data">
			<input type="hidden" name="ORIGINAL_TOPPING_IMG" value="${topping.TOPPING_IMG }">
			<input type="hidden" name="TOPPING_IMG" value="${topping.TOPPING_IMG}">
			<input type="hidden" name="TOPPING_NO" value="${topping.TOPPING_NO }">
		<table class="board_view">
			<colgroup>
				<col width="15%">
				<col width="*"/>
			</colgroup>
			<caption>재료등록</caption>
			<tbody>
			    <tr>
					<th scope="row">카테고리</th>
					<td>
						<select id="TOPPING_TYPE" name="TOPPING_TYPE" size=1>
						<OPTION value=''>---TYPE을 선택하세요---</OPTION>
						<OPTION value='0'>샐러드</OPTION>
						<OPTION value='1'>드레싱</OPTION>
						<OPTION value='2'>음료수</OPTION>
						</select>
					</td>
				</tr>
				
				<tr>
					<th scope="row">상품 노출 여부</th>
					<td>
						<select id="TOPPING_ONOFF" name="TOPPING_ONOFF" size=1>
						<OPTION value=''>---ON/OFF를 선택하세요---</OPTION>
						<OPTION value='0'>ON</OPTION>
						<OPTION value='1'>OFF</OPTION>
						</select>
					</td>
				</tr>


				<tr>
					<th scope="row">상품명</th>
					<td><input type="text" id="TOPPING_NAME" name="TOPPING_NAME"  value="${topping.TOPPING_NAME}" class="wdp_90"></input></td>
				</tr>
				<tr>
					<th scope="row">가격</th>
					<td><input type="text" id="TOPPING_PRICE" name="TOPPING_PRICE" value="${topping.TOPPING_PRICE }" class="wdp_90"></input></td>
				</tr>

				<tr>
					<th scope="row">토핑이미지</th>
					<td>
					<input type="file" id="TOPPING_IMG" name="TOPPING_IMG" value="${topping.TOPPING_IMG }">
					<span>기존이미지 : ${topping.TOPPING_IMG}</span>	
					</td>

				</tr>
				<tr>
					<th scope="row">수량</th>
					<td><input type="text" id="TOPPING_AMOUNT" name="TOPPING_AMOUNT" value="${topping.TOPPING_AMOUNT}" class="wdp_90"></input></td>
				</tr>
				<tr>
					<th scope="row">칼로리</th>
					<td><input type="text" id="TOPPING_KCAL" name="TOPPING_KCAL"  value="${topping.TOPPING_KCAL }" class="wdp_90"></input></td>
				</tr>
				<tr>
					<td colspan="2" class="view_text">
						<textarea rows="10" cols="100" title="내용" id="TOPPING_DETAIL" name="TOPPING_DETAIL" placeholder="상세 설명">${topping.TOPPING_DETAIL}</textarea>
					</td>
				</tr>
			</tbody>
		</table>
		<br/><br/>
		<a href="#this" class="btn" id="modify">수정하기</a>
		<a href="#this" class="btn" id="list">목록으로</a>
	</form>
</c:when>
<c:otherwise>
<div class="row" style="padding-left:15px;width:900px;">    
	<h1 class="page-header">재료수정</h1>
</div>
	<form id="frm" name="frm" enctype="multipart/form-data">
		<table class="board_view">
			<colgroup>
				<col width="15%">
				<col width="*"/>
			</colgroup>
			<caption>재료등록</caption>
			<tbody>
			    <tr>
					<th scope="row">카테고리</th>
					<td>
						<select id="TOPPING_TYPE" name="TOPPING_TYPE" size=1>
						<OPTION value=''>---TYPE을 선택하세요---</OPTION>
						<OPTION value='0'>육류</OPTION>
						<OPTION value='1'>채소</OPTION>
						<OPTION value='2'>기타</OPTION>
						</select>
					</td>
				</tr>
				
				<tr>
					<th scope="row">상품 노출 여부</th>
					<td>
						<select id="TOPPING_ONOFF" name="TOPPING_ONOFF" size=1>
						<OPTION value=''>---ON/OFF를 선택하세요---</OPTION>
						<OPTION value='0'>ON</OPTION>
						<OPTION value='1'>OFF</OPTION>
						</select>
					</td>
				</tr>


				<tr>
					<th scope="row">상품명</th>
					<td><input type="text" id="TOPPING_NAME" name="TOPPING_NAME" class="wdp_90"></input></td>
				</tr>
				<tr>
					<th scope="row">가격</th>
					<td><input type="text" id="TOPPING_PRICE" name="TOPPING_PRICE" class="wdp_90"></input></td>
				</tr>

				<tr>
					<th scope="row">썸네일 이미지</th>
					<td><input type="file" id="TOPPING_IMG" name="TOPPING_IMG"></td>
				</tr>
				<tr>
					<th scope="row">수량</th>
					<td><input type="text" id="TOPPING_AMOUNT" name="TOPPING_AMOUNT" class="wdp_90"></input></td>
				</tr>
				<tr>
					<th scope="row">칼로리</th>
					<td><input type="text" id="TOPPING_KCAL" name="TOPPING_KCAL" class="wdp_90"></input></td>
				</tr>
				<tr>
					<td colspan="2" class="view_text">
						<textarea rows="10" cols="100" title="내용" id="TOPPING_DETAIL" name="TOPPING_DETAIL" placeholder="상세 설명"></textarea>
					</td>
				</tr>
			</tbody>
		</table>
		<br/><br/>
		<a href="#this" class="btn" id="write">작성하기</a>
		<a href="#this" class="btn" id="list">목록으로</a>
	</form>
</c:otherwise>	
</c:choose>
</body>
</html>