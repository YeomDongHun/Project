<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<!DOCTYPE html>
<html>
<head>


<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>


<style type="text/css">
	.imgover img:hover{
	
	color:#F6FFCC;
	border:3px solid #86E57F;
	background-color: #86E57F;
	
	}
	
	

</style>


<script type="text/javascript">


(function($){
    $(window).on("load",function(){
        $(".diy").mCustomScrollbar({theme:"rounded-dots"});
    });
})(jQuery);


function addTopping(test){
	var topping =  test.getAttribute("id");
	var theUrl = "ToppingAdd";
	
    	$.ajax({url: theUrl,  
   		type : "POST", 
   		data : { 
   			topping:topping
   		},
   		success: function(result){ 
   			$("#goodsBasket").html(result); 
   			calcurate();
   		},
   		error: function(result){ 
   			alert("실패"); 
   		}   
    	
    });
    	
	
}

function delTopping(test){
	var no =  test.getAttribute("id");
	var theUrl = "ToppingDelete";
	
    	$.ajax({url: theUrl,  
   		type : "POST", 
   		data : { 
   			no:no
   		},
   		success: function(result){ 
   			$("#goodsBasket").html(result);
   			calcurate();

   		},
   		error: function(result){ 
   			alert("실패"); 
   		}   
    	
    });
}


</script>
</head>
<body  >
	<div class="container" style="height: auto; overflow-y:hidden;" id="diy">
	<table border="0" width="100% " >
	<tr >
		<td colspan="2"><br/></td>
	</tr>
		<tr>
			<td>
			
				<div class="goods" style="height: auto; clear:both; ">
				<div class="goodsimg" >
				<img src="resources/file/img/SG_diy.jpg" class="img-circle" style="margin-top: 20px; margin-left: 180px;" >
				</div>
				</div>
			</td>
			<td rowspan="2">
			
			<div id="goodsBasket" class="goodsBasket" style="width: 100%; height: auto; ">
				<jsp:include page="../Diy/goodsTopping.jsp"></jsp:include>
			
			</div>
			</td>
		</tr>
		<tr>
			<td>
				<jsp:include page="../Diy/goodsDiyTopping.jsp"></jsp:include>
			
				
			</td>
		</tr>
	</table>
		
	
	
	
	
	</div>
	
	
</body>
</html>