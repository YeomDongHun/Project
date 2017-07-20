<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<%@ page session = "true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="/SG/resources/file/css/main.min.css">
<link rel="stylesheet" href="/SG/resources/file/css/joinForm.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script charset="UTF-8" type="text/javascript" src="http://s1.daumcdn.net/svc/attach/U03/cssjs/postcode/1484723365148/170118.js"></script>
<script type="text/javascript">
function sameDeli(){
   var check = document.getElementById("check");
   
   var compare=check.checked;

    var RECEIVERNAME = document.getElementById("MEMBER_NAME").value;
      var RECEIVERZIP = document.getElementById("MEMBER_ZIP").value;
      var RECEIVERADDR1 = document.getElementById("MEMBER_ADDR1").value;
      var RECEIVERADDR2 = document.getElementById("MEMBER_ADDR2").value;
      var RECEIVERPHONE =document.getElementById("MEMBER_PHONE").value;

   if(compare==true){
      
      
      $("#RECEIVERNAME").val(RECEIVERNAME);
      $("#RECEIVERZIP").val(RECEIVERZIP);
      $("#RECEIVERADDR1").val(RECEIVERADDR1);
      $("#RECEIVERADDR2").val(RECEIVERADDR2);
      $("#RECEIVERPHONE").val(RECEIVERPHONE);

   }if(compare==false){
      $("#RECEIVERNAME").val("");
      $("#RECEIVERZIP").val("");
      $("#RECEIVERADDR1").val("");
      $("#RECEIVERADDR2").val("");
      $("#RECEIVERPHONE").val("");
   }
};

function zipfinds() 
{
    new daum.Postcode
    ({
        oncomplete: function(data) 
        {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

            // 각 주소의 노출 규칙에 따라 주소를 조합한다.
            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
            var fullAddr = ''; // 최종 주소 변수
            var extraAddr = ''; // 조합형 주소 변수

            // 사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
            if (data.userSelectedType === 'R') 
            { // 사용자가 도로명 주소를 선택했을 경우
                fullAddr = data.roadAddress;

            } 
            else 
            { // 사용자가 지번 주소를 선택했을 경우(J)
                fullAddr = data.jibunAddress;
            }

            // 사용자가 선택한 주소가 도로명 타입일때 조합한다.
            if(data.userSelectedType === 'R')
            {
                //법정동명이 있을 경우 추가한다.
                if(data.bname !== '')
                {
                    extraAddr += data.bname;
                }
                // 건물명이 있을 경우 추가한다.
                if(data.buildingName !== '')
                {
                    extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 조합형주소의 유무에 따라 양쪽에 괄호를 추가하여 최종 주소를 만든다.
                fullAddr += (extraAddr !== '' ? ' ('+ extraAddr +')' : '');
            }

            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            document.getElementById('RECEIVERZIP').value = data.zonecode; //5자리 새우편번호 사용
            document.getElementById('RECEIVERADDR1').value = fullAddr;

            // 커서를 상세주소 필드로 이동한다.
            document.getElementById('RECEIVERADDR2').focus();
        }
    }).open();
}



function change()
{

var usePoint  = document.getElementById("usePoint").value;//사용포인트 
var myPoint = ${myPoint};//보유포인트 2000
var totalMoney=${totalMoney};//총주문금액 24000
var dcPoint;//포인트 할인금액 =usingPoint
var plusPoint;//적립금 dcMoney/100
var dcMoney;//총 결제 금액 =totalMoney-dcPoint

//컨트롤러에 보낼 값 
var dcPointPost=document.getElementById("dcPointPost");
var dcMoneyPost=document.getElementById("dcMoneyPost");
var plusPointPost=document.getElementById("plusPointPost");



if(usePoint=="")
   usePoint=0;
if(usePoint>myPoint){
   alert("포인트가 부족합니다. 최대 포인트가 적용됩니다."); 
   usePoint=myPoint;
}
if(usePoint>totalMoney){
	usePoint=totalMoney;
}
   
dcPoint = eval(usePoint);
dcMoney= totalMoney-dcPoint;
plusPoint = parseInt(dcMoney/100);

dcPointPost.setAttribute('value', dcPoint);
dcMoneyPost.setAttribute('value', dcMoney);
plusPointPost.setAttribute('value', plusPoint);
  
  $("#usePoint").html(usePoint);
  $("#dcPoint").html(dcPoint);
  $("#dcMoney").html(dcMoney);
  $("#plusPoint").html(plusPoint);
};  

function zipfind() 
    {
        new daum.Postcode
        ({
            oncomplete: function(data) 
            {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var fullAddr = ''; // 최종 주소 변수
                var extraAddr = ''; // 조합형 주소 변수

                // 사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') 
                { // 사용자가 도로명 주소를 선택했을 경우
                    fullAddr = data.roadAddress;

                } 
                else 
                { // 사용자가 지번 주소를 선택했을 경우(J)
                    fullAddr = data.jibunAddress;
                }

                // 사용자가 선택한 주소가 도로명 타입일때 조합한다.
                if(data.userSelectedType === 'R')
                {
                    //법정동명이 있을 경우 추가한다.
                    if(data.bname !== '')
                    {
                        extraAddr += data.bname;
                    }
                    // 건물명이 있을 경우 추가한다.
                    if(data.buildingName !== '')
                    {
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 조합형주소의 유무에 따라 양쪽에 괄호를 추가하여 최종 주소를 만든다.
                    fullAddr += (extraAddr !== '' ? ' ('+ extraAddr +')' : '');
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('MEMBER_ZIP').value = data.zonecode; //5자리 새우편번호 사용
                document.getElementById('MEMBER_ADDR1').value = fullAddr;

                // 커서를 상세주소 필드로 이동한다.
                document.getElementById('MEMBER_ADDR2').focus();
            }
        }).open();
    }
    


</script>

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





<div class="body_center" style=" width:710px; height:auto;">
<form name="frm" action="goodsOrderSuccess" method="post" >
<div class="body_center" style="height:auto; padding-top:0px;">         
<section class="input-horizontal list-horizontal section box-shadow">
<div class="main_subject">
               <h3>상품 정보</h3>
            </div>
<div class="body_center" style=" width:680px; height:auto; padding-top:0px;">            
<div id="ordert_wrap">

<c:choose>
           <c:when test="${fn:length(orderGoods) > 0}">   
<table class="ordert_table">
           <thead> 
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
         </thead>
   <c:forEach var="orderGoods" items="${orderGoods}" varStatus="stat">
   
   
      <input type="hidden" name="ORDER_GOODS_NO" value="${orderGoods.GOODS_NO}"/>
      <input type="hidden" name="ORDER_TRADE_TYPE" value="0"/>
      <input type="hidden" name="ORDER_TOPPING_NAME" value="${orderGoods.TOPPING_NAME}"/>
      <input type="hidden" name="ORDER_GOODS_AMOUNT" value="${orderGoods.GOODS_AMOUNT}"/>   
      <input type="hidden" id="dcPointPost" name="dcPoint" value="0"/>
      <input type="hidden" id="dcMoneyPost" name="dcMoney" value="${totalMoney}"/>
      <input type="hidden" id="plusPointPost" name="plusPoint" value="${plusPoint}"/>
      <input type="hidden" name="totalMoney" value="${totalMoney}"/>    

   <tr> 

      <td><img src="resources/file/goodsFile/${orderGoods.GOODS_THUMBNAIL}" style="width:148px; height:148px" /></td>
      <td>${orderGoods.GOODS_NAME}</td>
      <td>${orderGoods.TOPPING_NAME }
      <td>${orderGoods.GOODS_PRICE}</td>
      <td>${orderGoods.GOODS_AMOUNT}</td>
   </tr>


      </c:forEach>
      </table>
       </c:when>
                
                <c:otherwise>
                    <tr>
                        <td colspan="5">주문 상품이 없습니다.</td>
                    </tr>
                </c:otherwise>
   </c:choose>
      


<div style="height:15px;"></div>
</div>
</div>
</section>
</div>





<div class="body_center" style="height:250px; padding-top:0px;">
<section class="input-horizontal list-horizontal section box-shadow">
<div class="main_subject">
               <h3>결제 정보</h3>
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
   <td><p id="dcPoint">0</p></td>
   <td><p id="dcMoney">${totalMoney}</p></td>
   <td><p id="plusPoint">${plusPoint}</p>
   
   
   </td>

</table>
<table class="ordert_table">
<colgroup>
   <col width="153px" />
   <col width="153px"/>
   <col width="153px" />
   <col width="153px" />
</colgroup>
<tr>
   <th height="40px">보유포인트</th>
   <th><p id="myPoint">${myPoint}</p></th>
   <th>사용 포인트</th>
    <th><input type="text" size="16" maxlength="10" id="usePoint" value="0" onclick="this.value = ''" onKeypress="if(event.keyCode < 45 || event.keyCode > 57) event.returnValue = false;" style="IME-MODE:disabled;">
    <div style="height:5px;"></div>
<span class="button button-dimmed" style="width:100px;" onclick="change()">포인트사용</span>
</tr>

</table>
<div style="height:10px;"></div>
</div>    
</section>
</div>


<div class="body_center" style="height:355px; padding-top:0px;">
<section class="input-horizontal list-horizontal section box-shadow">
            <div class="main_subject">
               <h3>주문자 정보</h3>
            </div>
            
            
<div>
<ul class="section-body">
     <li class="id">
      <div class="item-label col-lg-3 col-md-4" style="width:630px;height:23px; font-size:12px;">
         <label for="mi">
            <strong>* 주문자 아이디</strong>
         </label>
         <div style="height:5px;"></div>
      </div>
      <div class="col-lg-21 col-md-20" style="width:630px; height:25px">
         <input type="text" name="MEMBER_ID" id="" value="${sessionScope.MEMBER_ID}" maxlength="20" class="xx-control" label="" required="required">
         <p class="alert alert-positive"></p>
         <div style="height:5px;"></div>
      </div>
 
      
   </li>
    
   <li class="name">
      <div class="item-label col-lg-3 col-md-4" style=" width:630px;height:23px; font-size:12px; vertical-align:middle;">
      <div style="height:5px;"></div>
         <label for="input-name">
            <strong>* 주문자 이름</strong>
         </label>
      </div>
      <div class="col-lg-21 col-md-20" style="width:630px;">
         <input type="text" id="MEMBER_NAME" class="xx-control" name="DELI_ORDER_NAME" value="${sessionScope.MEMBER_NAME}" required="required" label="이름">
      </div>
      <div style="height:5px;"></div>
   </li>
   <li class="address">
      <div class="item-label col-lg-3 col-md-4" style=" width:630px;height:23px; font-size:12px; vertical-align:middle;">
         <strong>* 주문자 주소</strong>
      </div>
      <div class="col-lg-21 col-md-20" style="width:630px;">
         <div class="input-box" >
         <input type="text" id="MEMBER_ZIP"  name="DELI_ORDER_ZIP"  label="우편번호" value="${orderDeli.MEMBER_ZIP}" maxlength="6" required="">
            <span class="button button-dimmed" onclick="zipfind()">주소 찾기</span>
         </div>
         <input type="text" id="MEMBER_ADDR1" class="xx-control" name="DELI_ORDER_ADDR1" label="주소" value="${orderDeli.MEMBER_ADDR1}" size="48" readonly="" required="">
         <input type="text" id="MEMBER_ADDR2" class="xx-control" name="DELI_ORDER_ADDR2" value="${orderDeli.MEMBER_ADDR2}" label="주소" required="">
      </div>
      <div style="height:5px;"></div>
   </li>
   <li class="cell-phone">
      <div class="item-label col-lg-3 col-md-4" style=" width:630px;height:23px; font-size:12px; vertical-align:middle;">
         <label for="input-cell-phone01">
            <strong>* 주문자 핸드폰</strong>
         </label>
      </div>
      <div class="col-lg-21 col-md-20" style="width:630px;">
         <div class="input-box">
            <input type="text" name="DELI_ORDER_PHONE" id="MEMBER_PHONE" label="휴대폰" value="${orderDeli.MEMBER_PHONE}"  maxlength="11" class="xx-control" required="required">
         </div>  
         <div style="height:10px;"></div>       
      </div>
   </li>
</ul>
</div>
</section>
</div>


   <div class="body_center" style="height:300px; padding-top:0px;">
   <section class="input-horizontal list-horizontal section box-shadow">
               <div class="main_subject"><h3>수령자 정보</h3><input type="checkbox"id="check"onclick="sameDeli()"><strong>주문자 정보와 동일</strong></div>
      <div>
         <ul class="section-body">
            <li class="name">
            
               <div class="item-label col-lg-3 col-md-4" style="width:630px;height:23px; font-size:12px; vertical-align:middle;">
                  <label for="input-name">
                     <strong>* 수령자 이름</strong>
                  </label>
               </div>
               
               <div style="height:5px;"></div>
                  
               <div class="col-lg-21 col-md-20" style="width:630px;">
                  <input type="text" id="RECEIVERNAME" class="xx-control" name="DELI_RECEIVE_NAME" value="${RECEIVERNAME}" required="required" label="이름">
               </div>
               
               <div style="height:5px;"></div>
               
            </li>
            
            <li class="address">
               <div class="item-label col-lg-3 col-md-4" style="width:630px; height:23px; font-size:12px; vertical-align:middle;">
                  <strong>* 수령자 주소</strong>
               </div>
               
               <div class="col-lg-21 col-md-20" style="width:630px;">
               
                  <div class="input-box">
                  <input type="text" id="RECEIVERZIP"  name="DELI_RECEIVE_ZIP"  label="우편번호" value="${RECEIVERZIP}" maxlength="6" required="">
                     <span class="button button-dimmed" onclick="zipfinds()">주소 찾기</span>
                  </div>
                  
                  <input type="text" id="RECEIVERADDR1" class="xx-control" name="DELI_RECEIVE_ADDR1" label="주소" value="${RECEIVERADDR1}" size="48" readonly="" required="">
                  <input type="text" id="RECEIVERADDR2" class="xx-control" name="DELI_RECEIVE_ADDR2" value="${RECEIVERADDR2}" label="주소" required="">
               </div>
               
               <div style="height:5px;"></div>
            </li>
            
            <li class="cell-phone">
               <div class="item-label col-lg-3 col-md-4" style=" width:630px;height:23px; font-size:12px; vertical-align:middle;">
                  <label for="input-cell-phone01">
                     <strong>* 수령자 핸드폰</strong>
                  </label>
               </div>
               <div class="col-lg-21 col-md-20" style="width:630px;">
                  <div class="input-box">
                     <input type="text" name="DELI_RECEIVE_PHONE" id="RECEIVERPHONE" label="휴대폰" value="${RECEIVERPHONE}"  maxlength="11" class="xx-control" required="required">
                  </div>
                  <div style="height:10px;"></div> 
               </div>
            </li>
         </ul> 
      </div>
</section>
</div>

 <div class="body_center" style="clear:both; height:100px;" class="btnArea">
 <div style="margin-left:250px;">
<!--  <a class="effect effect-5" title="배송 확인" onclick="">주문 완료</a>
 -->  
 <input class="effect effect-5" type="submit" onclick="" value="주문완료"/>

 </div>
 </div>
 </form>
</div>

</body>
</html>