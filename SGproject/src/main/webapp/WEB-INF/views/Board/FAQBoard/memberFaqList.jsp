<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<script type="text/javascript" src="resources/file/js/jquery-2.0.0.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js">
<style type="text/css">
@import url('//cdn.rawgit.com/young-ha/webfont-archive/master/css/PureunJeonnam.css');
#faq_member_wrap {
	width: 1500px;
	font-family: PureunJeonnam;
	margin-left:auto;
	margin-right:auto;
}
.faq_member_title {width:100%; height:200px;border:5px solid #e7e4e4;}
.faq_member_title div {padding-bottom: 10px;}
.title_font1 {font-family: PureunJeonnam; font-size: 20px; font-weight: bold;  padding-top:30px; margin-top:30px;}
.title_font2 {font-family: PureunJeonnam; font-size: 20px; color: #999;}
.table{
	font-family: PureunJeonnam;
	font-weight:bold;
}
.table th {
	border-top: 1px solid #e5e5e5; 
	border-bottom: 1px solid #e5e5e5;
	padding: 8px 0; 
	font-size:15px; 
	background: #f5f5f5;
	font-family: PureunJeonnam;
}

.table td {
	border-top: 1px solid #e5e5e5; 
	border-bottom: 1px solid #e5e5e5; 
	font-family: PureunJeonnam;
	line-height:40px;
}
.faq_member_search{
	width: 60%;
	margin-right: auto;
	margin-left: auto;
	font-family: PureunJeonnam;
}
.faq_member_search input[type=text]{
	width: 300px;
	height: 25px;
}
.faq_member_searchT {
	text-align: center; 
	border-top: 1px solid #e5e5e5; 
	border-bottom: 1px solid #e5e5e5; 
	padding: 8px 0; 
	background: #f5f5f5;
	
}
.faq_select{
	height: 25px;
}
 .category{}
   .category ul{list-style-type: none; padding-bottom:20px;}
   .category ul li
   {
   float:left;
   margin-left:10px;
   
   color:##7e7e7e;
   font-size:15px;
   font-family:PureunJeonnam;
   line-height:15px;
   }
   .category ul li a{
   text-decoration:none;
   color:#7e7e7e;
   font-family:PureunJeonnam;
   font-weight:bold;
   }
   
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

<script type="text/javascript">
$(document).ready(function () {
	//btn클릭 이벤트 처리
	$("#resister").click(function () {
		alert("FAQ등록창으로 이동하겠습니다.") 
		document.location.href="memberFaqForm";	
	});
	
/* 	$("#faq").click(function (){
		
		var btn = $(this).attr("id");
		alert(btn);
	}); */
	//페이지 로드시 버튼 클릭

});

function content(test) {
	var faqid = document.getElementById(test.getAttribute('id')).getAttribute('id') +'f'; //해당 td 아이디를 꺼내어 f를 더함
	
	faqContent(faqid);
};
function faqContent(fq){
    var con = document.getElementById(fq);
    if(con.style.display=='none'){
        con.style.display = 'table-row';
    }else{
        con.style.display = 'none';
    }
};





</script>
</head>

<body>
<div id="faq_member_wrap">
<div class="title_font1">
	FAQ / 자주묻는 질문
</div>
<div class="faq_line">
<hr color="#777" width="100%" size="1">
</div>
         <div class="category">
         <ul>
         	<li><a href="memberFaqList?category=회원안내" class="categoryButton">회원안내</a></li>
         	<li>|</li>
         	<li><a href="memberFaqList?category=배송안내" class="categoryButton">배송안내</a></li>
         	<li>|</li>
         	<li><a href="memberFaqList?category=주문/결제" class="categoryButton">주문/결제</a></li>
         	<li>|</li>
         	<li><a href="memberFaqList?category=주문취소/변경" class="categoryButton">주문취소/변경</a></li>
         	<li>|</li>
         	<li><a href="memberFaqList?category=교환/반품" class="categoryButton">교환/반품</a></li>
         	<li>|</li>
         	<li><a href="memberFaqList?category=환불" class="categoryButton">환불</a></li>
         	<li>|</li>
         	<li><a href="memberFaqList?category=상품" class="categoryButton">상품</a></li>
         	<li>|</li>
         	<li><a href="memberFaqList?category=사이트이용안내" class="categoryButton">사이트이용안내</a></li>
         </ul>
</div>

<table id="faq" class="table" width="100%">
<colgroup>
	<col width="3%" />
	<col width="97%"/>
</colgroup>
<tr style="background: #f5f5f5;">
	<th>번호</th>
    <th>글제목</th>
</tr>

          <c:choose>
               <c:when test="${list} == null">
 					<tr>
                 		<td colspan="2">게시글이 없습니다.</td>
                 	</tr>
                 </c:when>
                 <c:otherwise>

   				 <c:forEach var="list"  items="${list}" varStatus="stat">
                 	<tr> 
                     	<td style="text-align:center;">${stat.count}</td>
                        <td id="faq${list.FAQ_NO}" onclick="content(this)"><span style="color:blue;">[${list.FAQ_CATEGORY}]</span>${list.FAQ_TITLE}</td>
                    </tr>
                    <tr id="faq${list.FAQ_NO}f"style="color:black; display:none;">
                    	<td><img src="resources/file/img/faq_a.gif"></td>
                    	<td>${list.FAQ_CONTENT}</td>
                    </tr>
                 </c:forEach> 
                 </c:otherwise> 
                </c:choose>  
           
</table>

<div class="paging" style="text-align:center; both:clear;">
						${pagingHtml}
					</div>
                     		<div style="text-align:center; width:500px; margin-left:auto; margin-right:auto; margin-top:10px;">
								<div id="dataTables-example_filter" class="dataTables_filter">
									<form action="/SG/memberFaqList">
									<select class="form-control" name="searchNum" id="searchNum" style="width:90px; float:left; margin-right:8px;">
										<option value="0">제목</option>
										<option value="1">내용</option>
									</select>
										<input class="form-control" type="text" name="isSearch" id="isSearch" style="width:300px; float:left;"/>
										<span>
										<button type="submit" class="btn btn-primary" style="float:left;">검색</button>
										</span>
									</form>
								</div>							
							</div>
</div>
</body>
</html>
