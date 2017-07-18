<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session = "true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="/SG/resources/file/css/main.min.css">
<link rel="stylesheet" href="/SG/resources/file/css/joinForm.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script charset="UTF-8" type="text/javascript" src="http://s1.daumcdn.net/svc/attach/U03/cssjs/postcode/1484723365148/170118.js"></script>
<style type="text/css">
@import url('//cdn.rawgit.com/young-ha/webfont-archive/master/css/PureunJeonnam.css');
#ordert_wrap 
{
   font-family: PureunJeonnam;
}
.ordert_title div {padding-top: 20px; padding-bottom: 10px;}
.title_font2 {font-family: PureunJeonnam; font-size: 20px; color: #999;}
.ordert_table{
   text-align: center;
   font-family: PureunJeonnam;

   font-weight:bold;
}
.faq_line {margin: 0 50px 0 50px;}

.ordert_table th {
   text-align: center; 
   border-top: 1px solid #e5e5e5; 
   border-bottom: 1px solid #e5e5e5;
   padding: 8px 0; 
   background: #f5f5f5;
   font-family: PureunJeonnam;
}

.ordert_table td {
   text-align: center; 
   border-top: 1px solid #e5e5e5; 
   border-bottom: 1px solid #e5e5e5; 
   font-family: PureunJeonnam;
}
</style>

</head>
     <body>
<div class="body_center" style="height:185px;"> 
<section class="input-horizontal list-horizontal section box-shadow">
<div style="height:180px; width:660px;">
<div style="float:left; height:150px; width:170px; margin: 10px;">
<img id="tku" src="/ordertest/style2/thankU.png"> 
</div>
<div style="float:left; height:150px; width:420px; margin: 10px;">
<h2>고객님의 주문이 완료 되었습니다.</h2> <br>
<h3>주문 내역 및 배송에 관한 안내는 <a href ='OrderInfo';> 주문조회 </a> 를 통하여 확인 가능합니다.</h3><br><br>
주문번호 : ${orderInfo.ORDER_NO}<br>
주문일자 : ${orderInfo.ORDER_DATE} <br>

<div>
</div>
</div>
</div>
</div>
<form name="frm" action="goodsOrderSuccess" method="post" >
<div class="body_center" style="height:225px;">
<section class="input-horizontal list-horizontal section box-shadow">
<div class="main_subject">
               <h2>상품 정보</h2>
            </div>
            
<div id="ordert_wrap">
<table class="ordert_table">
<colgroup>
   <col width="150px" />
   <col width="150"/>
   <col width="130px" />
   <col width="120px" />
   <col width="70px" />
</colgroup>
<tr>
   <th>이미지</th>
   <th>상품정보</th>
   <th>토핑</th>
    <th>판매가</th>
    <th>수량</th>
</tr>
<tr> 
   <td height="150px">${orderGoodsInfo.GOODS_THUMBNAI}</td>
   <td>${orderGoodsInfo.GOODS_NAME}</td>
   <td>${orderInfo.ORDER_TOPPING_NAME}</td>
   <td>${orderGoodsInfo.GOODS_PRICE}</td>
   <td>${orderInfo.ORDER_GOODS_AMOUNT}</tr>
</table>
<div style="height:10px;"></div>
</div>
</section>
</div>


<div class="body_center" style="height:125px;">
<section class="input-horizontal list-horizontal section box-shadow">
<div class="main_subject">
               <h2>결제 정보</h2>
            </div>
<div id="ordert_wrap">
<table class="ordert_table">
<colgroup>
   <col width="153px" />
   <col width="153px"/>
   <col width="153px" />
   <col width="153px" />
</colgroup>
<tr>
   <th>총 주문 금액</th>
   <th>포인트 할인 금액</th>
   <th>총 결제 금액</th>
    <th>적립 포인트</th>
</tr>
<tr> 
   <td height="50px"><p id="totalMoney">${totalMoney}</p></td>
   <td><p id="dcPoint">${dcPoint}</p></td>
   <td><p id="dcMoney">${orderInfo.ORDER_MONEY}</p></td>
   <td><p id="plusPoint">${plusPoint}</p></td>

</table>
<table class="ordert_table">
<colgroup>
   <col width="153px" />
   <col width="153px"/>
   <col width="153px" />
   <col width="153px" />
</colgroup>

</table>
<div style="height:10px;"></div>
</div>    
</div>



   <div class="body_center" style="height:270px;">
   <section class="input-horizontal list-horizontal section box-shadow">
               <div class="main_subject"><h2>수령자 정보</h2></div>
      <div>
         <ul class="section-body">
            <li class="name">
            
               <div class="item-label col-lg-3 col-md-4" style="height:23px; font-size:12px; vertical-align:middle;">
                  <label for="input-name">
                     <strong>* 수령자 이름</strong>
                  </label>
               </div>
               
               <div style="height:5px;"></div>
                  
               <div class="col-lg-21 col-md-20">
                  <input type="text" id="DELI_RECEIVE_NAME" class="xx-control" name="DELI_RECEIVE_NAME"  readonly="" value="${deliInfo.DELI_RECEIVE_NAME}" required="required" label="이름">
               </div>
               
               <div style="height:5px;"></div>
               
            </li>
            
            <li class="address">
               <div class="item-label col-lg-3 col-md-4" style="height:23px; font-size:12px; vertical-align:middle;">
                  <strong>* 수령자 주소</strong>
               </div>
               
               <div class="col-lg-21 col-md-20">
               
                  <div class="input-box">
                  <input type="text" id="DELI_RECEIVE_ZIP" class="xx-control" name="DELI_RECEIVE_ZIP" label="주소" value="${deliInfo.DELI_RECEIVE_ZIP}" size="48" readonly="" required="">
                  </div>
                  
                  <input type="text" id="DELI_RECEIVE_ADDR1" class="xx-control" name="DELI_RECEIVE_ADDR1" label="주소" value="${deliInfo.DELI_RECEIVE_ADDR1}" size="48" readonly="" required="">
                  <input type="text" id="DELI_RECEIVE_ADDR2" class="xx-control" name="DELI_RECEIVE_ADDR2" value="${deliInfo.DELI_RECEIVE_ADDR2}" label="주소" readonly="" required="">
               </div>
               
               <div style="height:5px;"></div>
            </li>
            
            <li class="cell-phone">
               <div class="item-label col-lg-3 col-md-4" style="height:23px; font-size:12px; vertical-align:middle;">
                  <label for="input-cell-phone01">
                     <strong>* 수령자 핸드폰</strong>
                  </label>
               </div>
               <div class="col-lg-21 col-md-20">
                  <div class="input-box" style="height:23px; font-size:12px;">
                     <input type="text" name="DELI_RECEIVE_PHONE" id="DELI_RECEIVE_PHONE" label="휴대폰" value="${deliInfo.DELI_RECEIVE_PHONE}"  maxlength="11" class="xx-control" readonly="" required="required">
                  </div>
                  <div style="height:20px;"></div>
               </div>
            </li>
         </ul>
      </div>
</section>
</div>

 <div class="body_center" style="clear:both;" class="btnArea">
  <!-- <a class="effect effect-5" title="배송 확인" onclick="">배송 확인</a> -->
  <div style="margin-left:200px;">
  <input class="effect effect-5" type="submit" onclick="window.location='/SG/main'" value="메인으로"/>
  <input class="effect effect-5" type="submit" onclick="window.location='/SG/goodsList'" value="계속쇼핑하기"/>
  </div>
 </div>
</section>
</form> 
</body>
</html>