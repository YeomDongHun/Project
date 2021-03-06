<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>  

<html>

<head>

<link rel="stylesheet" href="resources/file/css/SiderBar.css" type="text/css" />

<script src="resources/file/js/SiderBarJs.js"></script>


<script type="text/javascript">
<!--

//-->


function SideBasket(test){ 

	
	var goodsNo =test.getAttribute("id");
	var topping_name="토핑 없음";

	var theUrl = "BasketAdd";

	
$.ajax({url: theUrl,  
	type : "POST", 
	data : { 
		goodsNo : goodsNo,
		topping_name : topping_name
	},
	success: function(result){ 
		$("#sideBar").html(result); 

		alert("장바구니에 담았습니다");
	},
	error: function(result){ 
		alert("실패"); 
	}   



});

}

function delGoods(test){
	var goodsNo =test.getAttribute("id");
	var str =  "basket_no_"+goodsNo;
	var BASKET_NO = document.getElementById(str).getAttribute("name");
	var theUrl = "BasketDelete";
	
 	$.ajax({url: theUrl,  
   		type : "POST", 
   		data : { 
   			goodsNo : goodsNo,
   			BASKET_NO:BASKET_NO
   		},
   		success: function(result){ 
   			$("#sideBar").html(result); 

   			alert("장바구니에서 제거했습니다");
   		},
   		error: function(result){ 
   			alert("실패"); 
   		}   
    	
    	
    	
    });
}

</script>

<style type="text/css">
@import url('//cdn.rawgit.com/young-ha/webfont-archive/master/css/PureunJeonnam.css');
font-family: PureunJeonnam;
</style>

</head>
<body>
    <div id="wrapper">
        <div class="overlay"></div>
    
        <!-- Sidebar -->
        <nav class="navbar navbar-inverse navbar-fixed-top" id="sidebar-wrapper" role="navigation">
            <ul class="nav sidebar-nav">
                <li class="sidebar-brand">
                    <a href="#">
                       BASKET
                    </a>
                </li>
		          
			  <c:choose>
						<c:when test="${fn:length(basketList) > 0}">
							<c:forEach var="basketList" items="${basketList}" varStatus="stat">
				                <li>
				                    <img alt="" class="" src="resources/file/goodsFile/${basketList.GOODS_THUMBNAIL}" style="width: 70px; margin-bottom: 5px; float: left;">
				                    <div style="background-color: #212121;width250px; float:left; width: 250px;height: 70px; "> 
					                    <table style="width: 250px;">
						                    <tr>
						                    	<td width="200"><div style="font-size: 20px;color: #FFFFFF; ">&nbsp;&nbsp;<strong>${basketList.GOODS_NAME}</strong></div>&nbsp;&nbsp;${basketList.GOODS_AMOUNT}&nbsp;개<br/><div style="color: #FFFFFF;">&nbsp;&nbsp;${basketList.GOODS_PRICE}원 &nbsp;&nbsp;${basketList.GOODS_KCAL }kcal</div></td>
						                    	<c:if test="${sessionScope.MEMBER_NO != 0}">
						                  			<td width="50px;">
						                  				&nbsp;&nbsp;&nbsp;<span class="glyphicon glyphicon-remove" id="${stat.index}" aria-hidden="true" style="color: #FFFFFF;" onclick="delGoods(this);"></span>
						                  				<input type="hidden" id="basket_no_${stat.index}" name="${basketList.BASKET_NO}"/>
						                  			</td>
												</c:if>
						                    	
						                    	<c:if test="${sessionScope.MEMBER_NO == 0}">
						                    		<td width="50px;">
						                    			&nbsp;&nbsp;&nbsp;<span class="glyphicon glyphicon-remove" id="${stat.index}" aria-hidden="true" style="color: #FFFFFF;" onclick="delGoods(this);"></span>
						                    			<input type="hidden" id="basket_no_${stat.index}" name="0"/>
						                    			
						                    		</td>
						                    	</c:if>
						                    </tr>
					                    </table>
				                    </div>
				                </li>
		                         
							</c:forEach>
							          
					      <div style="z-index: 1000;margin-top: 40px;  margin-left: 110px;;margin-right: auto;">
						    <button type="button" class="btn btn-warning" onClick="javascript:location.href='SideBasketOrder';">주문하기</button>
						  </div>
						</c:when>
						                
						<c:otherwise>
						    
						       장바구니가 비었어요
						  
						</c:otherwise>
			</c:choose>
            </ul>
  
        </nav>
        <!-- /#sidebar-wrapper -->

        <!-- Page Content -->
        <div id="page-content-wrapper">
            <button type="button" class="hamburger is-closed" data-toggle="offcanvas">
                <span class="hamb-top"></span>
    			<span class="hamb-middle"></span>
				<span class="hamb-bottom"></span>
            </button>
   
        </div>
        <!-- /#page-content-wrapper -->
        
    

    </div>
    <!-- /#wrapper -->
   </body>
	</html>
    