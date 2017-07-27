<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
		fn_openGoodsList();
	});
	
	$("#modify").on("click", function(e){ //목록으로 버튼
		e.preventDefault();
		fn_openGoodsModify();
	});
	
	$("#write").on("click", function(e){ //작성하기 버튼
		e.preventDefault();
		 if($('#GOODS_NAME').val()==""){
			alert("상품명을 입력해 주세요.");
			return false;
		 } else if($('#GOODS_PRICE').val()==""){
			 alert("상품가격을 입력해 주세요.");
				return false;
		 } else if($('#GOODS_TYPE').val()==''){
			 alert("상품 타입을 선택해 주세요.");
				return false;
		 } else if($('#GOODS_THUMBNAIL').val()==""){
			 alert("썸네일이미지를 등록해 주세요.");
				return false;
		 } else if($('#GOODS_DETAIL').val()==""){
			 alert("상품 상세설명을 입력해 주세요.");
				return false;
		 } else if($('#GOODS_AMOUNT').val()==""){
			 alert("상품 수량을 입력해 주세요.");
				return false;
		 } else if($('#IMAGE').val()==""){
			 alert("상품이미지를 등록해 주세요.");
				return false;
		 }
		 else{
		fn_insertGood();
		}
	});
	
	$("#addFile").on("click", function(e){ //파일 추가 버튼
		e.preventDefault();
		fn_addFile();
	});
	
	$("#addKind").on("click", function(e){ //파일 추가 버튼
		e.preventDefault();
		fn_addKind();
	});
	
	$("a[name='delete']").on("click", function(e){ //삭제 버튼
		e.preventDefault();
		fn_deleteKind($(this));
	});
});

function fn_openGoodsList(){
	var comSubmit = new ComSubmit();
	comSubmit.setUrl("/SG/adminGoodsList");
	comSubmit.submit();
}

function fn_openGoodsModify(){
	var comSubmit = new ComSubmit("frm");
	comSubmit.setUrl("/SG/adminGoodsModify");
	comSubmit.submit();
}

function fn_insertGood(){
	var comSubmit = new ComSubmit("frm");
	comSubmit.setUrl('/SG/adminGoodsInsert');
	comSubmit.submit();
}


function fn_addFile(){
	
	var tbody = document.getElementById("adgoods_table"); //tbody 저장
	var tr = document.createElement("tr"); //tr태그 생성 후 저장
	var td1 = document.createElement("td"); //td태그 생성 후 저장
	var td2 = document.createElement("td"); //td태그 생성 후 저장
	var td3 = document.createElement("td"); //td태그 생성 후 저장
	
	td1.innerHTML='<a href="#this" class="btn" id="addFile">이미지 추가</a>';
	td2.innerHTML='<input type="file" id="fileDiv" name="IMAGE_IMAGE">';
	td3.innerHTML='<a href="#this" class="btn" id="delete" name="delete">삭제</a>';
	
	tr.appendChild(td1); //tr태그에 td1 추가
	tr.appendChild(td2); //tr태그에 td1 추가
	tr.appendChild(td3); //tr태그에 td1 추가
	
	tbody.appendChild(tr); //tbody태그에 tr 저장
	
	$("a[name='delete']").on("click", function(e){ //삭제 버튼
		e.preventDefault();
		fn_deleteFile($(this));
	});
}

function fn_deleteFile(obj){
	obj.parent().remove();
}

</script>
</head>
<body>
<c:choose>
<c:when test="${modify}">
<div class="row" style="padding-left:15px;width:900px;">    
	<h1 class="page-header">상품수정</h1>
</div>
	<form id="frm" name="frm" enctype="multipart/form-data">
	<input type="hidden" name="GOODS_NO" value="${goods.GOODS_NO}">
	<input type="hidden" name="ORIGINAL_GOODS_THUMBNAIL" value="${goods.GOODS_THUMBNAIL}">
	<input type="hidden" name="ORIGINAL_IMAGE_IMAGE" value="${goods.IMAGE_IMAGE }">
		<table class="board_view">
			<colgroup>
				<col width="15%">
				<col width="*"/>
			</colgroup>
			<caption>상품 등록</caption>
			<tbody id="adgoods_table">
			    <tr>
					<th scope="row">카테고리</th>
					<td>
						<select id="GOODS_TYPE" name="GOODS_TYPE" size=1>
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
						<select id="GOODS_ONOFF" name="GOODS_ONOFF" size=1>
						<OPTION value=''>---ON/OFF를 선택하세요---</OPTION>
						<OPTION value='0'>ON</OPTION>
						<OPTION value='1'>OFF</OPTION>
						</select>
					</td>
				</tr>


				<tr>
					<th scope="row">상품명</th>
					<td><input type="text" id="GOODS_NAME" name="GOODS_NAME" value="${goods.GOODS_NAME}"class="wdp_90"></input></td>
				</tr>
				<tr>
					<th scope="row">가격</th>
					<td><input type="text" id="GOODS_PRICE" name="GOODS_PRICE" value="${goods.GOODS_PRICE }"class="wdp_90"></input></td>
				</tr>

				<tr>
					<th scope="row">썸네일 이미지</th>
					<td>
					<input type="file" id="GOODS_THUMBNAIL" value="${goods.GOODS_THUMBNAIL}" name="GOODS_THUMBNAIL">
					<p style="color:red;">기존이미지 : ${goods.GOODS_THUMBNAIL}</p>
					</td>
				</tr>
				<tr>
					<th scope="row">수량</th>
					<td><input type="text" id="GOODS_AMOUNT" value="${goods.GOODS_AMOUNT}" name="GOODS_AMOUNT" class="wdp_90"></input></td>
				</tr>
				<tr>
					<th scope="row">칼로리</th>
					<td><input type="text" id="GOODS_KCAL" value="${goods.GOODS_KCAL}" name="GOODS_KCAL" class="wdp_90"></input></td>
				</tr>
				<tr>
					<td colspan="2" class="view_text">
						<textarea rows="10" cols="100" title="내용" id="GOODS_DETAIL" name="GOODS_DETAIL" placeholder="상세 설명">${goods.GOODS_DETAIL}</textarea>
					</td>
				</tr>
				
				<tr>
					<td colspan="2">					
					<a href="#this" class="btn" id="addFile">이미지 추가</a>
						<div id="fileDiv" style="float:right;">
							<p><input type="file" id="IMAGE" name="IMAGE_IMAGE"></p>
							<p style="color:red;">기존이미지 : ${goods.IMAGE_IMAGE}</p>													
						</div>
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
	<h1 class="page-header">상품등록</h1>
</div>
	<form id="frm" name="frm" enctype="multipart/form-data">
		<table class="board_view">
			<colgroup>
				<col width="15%">
				<col width="*"/>
			</colgroup>
			<caption>상품 등록</caption>
			<tbody id="adgoods_table">
			    <tr>
					<th scope="row">카테고리</th>
					<td>
						<select id="GOODS_TYPE" name="GOODS_TYPE" size=1>
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
						<select id="GOODS_ONOFF" name="GOODS_ONOFF" size=1>
						<OPTION value=''>---ON/OFF를 선택하세요---</OPTION>
						<OPTION value='0'>ON</OPTION>
						<OPTION value='1'>OFF</OPTION>
						</select>
					</td>
				</tr>

				<tr>
					<th scope="row">상품명</th>
					<td><input type="text" id="GOODS_NAME" name="GOODS_NAME" class="wdp_90"></input></td>
				</tr>
				<tr>
					<th scope="row">가격</th>
					<td><input type="text" id="GOODS_PRICE" name="GOODS_PRICE" class="wdp_90"></input></td>
				</tr>

				<tr>
					<th scope="row">썸네일 이미지</th>
					<td><input type="file" id="GOODS_THUMBNAIL" name="GOODS_THUMBNAIL"></td>
				</tr>
				<tr>
					<th scope="row">수량</th>
					<td><input type="text" id="GOODS_AMOUNT" name="GOODS_AMOUNT" class="wdp_90"></input></td>
				</tr>
				<tr>
					<th scope="row">칼로리</th>
					<td><input type="text" id="GOODS_KCAL" name="GOODS_KCAL" class="wdp_90"></input></td>
				</tr>
				<tr>
					<td colspan="2" class="view_text">
						<textarea rows="10" cols="100" title="내용" id="GOODS_DETAIL" name="GOODS_DETAIL" placeholder="상세 설명"></textarea>
					</td>
				</tr>
				<tr>
					<td colspan="2">
					
					<a href="#this" class="btn" id="addFile">이미지 추가</a>
						<div id="fileDiv" style="float:right;">
							<p><input type="file" id="IMAGE" name="IMAGE_IMAGE"></p>													
						</div>
					</td>
				</tr>

			</tbody>
		</table>
		
		<br/><br/>
		<a href="#this" class="btn" id="write">등록하기</a>
		<a href="#this" class="btn" id="list">목록으로</a>
	</form>
</c:otherwise>	
</c:choose>
</body>
</html>