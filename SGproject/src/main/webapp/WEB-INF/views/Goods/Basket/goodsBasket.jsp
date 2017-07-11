<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/ordertest/css3.css" type="text/css">
<style type="text/css">
@import url('//cdn.rawgit.com/young-ha/webfont-archive/master/css/PureunJeonnam.css'); 
</style>
<style type="text/css">
@import url('//cdn.rawgit.com/young-ha/webfont-archive/master/css/PureunJeonnam.css'); 

.body_center {
 width:900px;
 height:1000px;
 margin-left:auto;
 margin-right:auto;
 padding-top:50px;
 font-family: PureunJeonnam;

}
.main_subject {
 color:000000;
 text-align:left;
 margin-left:10px;
 margin-bottom:10px;
}
.join_submit {
   float:left;
   width: 418px;
   height:40px;
   background-color:#00CCCF;
   text-align: right;
   font-size: 1%;
   line-height: 1%;
   font-family: PureunJeonnam;
}
.join_submit input[type='submit'] {
   width: 418px;
   border: 0;
   border-radius: 4px;
   color: #FFFFFF;
    background-color:#00CCCF;
   font-size: 18px;
   line-height: inherit;
   text-transform: uppercase;
   cursor: pointer;
   height: 40px;
    font-weight: bold;
}
</style> 
</head>
<body>
<div class="bkform" style="font-family: PureunJeonnam;">
<div class="bk" style="height:45px; font-size:35px;">장바구니</div>


<div class="bkgoodsform">
<div class="bkgoodsname"><strong>Goods Name : ${basketList.BASKET_GOODS_NAME}</strong></div>
<div class="bkdiy"><strong>diy1 : </strong></div>
 

<div class="bkamprice">
<div class="bkamount"><strong>amount : </strong></div>
<div class="bkprice"><strong>price : </strong></div>
</div>
</div>

<div class="bkcalorie"><strong>예상 칼로리</strong></div>
<div class="bktotalgp">
<div class="bkpoint"><strong>point : </strong></div>
<div class="bktotalprice"><strong>totalprice : </strong></div>
</div>
<div class="btsubmit" style="background-color:#00CCCF;">
<div class="join_submit">   
       <input type="submit" id="submit" value="주 문 완 료" onclick="location.href=''">
         </div>
         </div>
</div>
</body>
</html>
