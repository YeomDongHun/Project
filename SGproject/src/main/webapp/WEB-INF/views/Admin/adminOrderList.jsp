<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>   
<html>
<head>
<script type="text/javascript" src="resources/file/js/jquery-2.0.0.min.js"></script>
<script type="text/javascript">
/* $(document).ready(function () {
	$("#state0").click(function (){ 
		var order_no = document.getElementById("state0").value;
		var order_state = $(this).children("#state").text();
		
		alert("입금완료 처리 했습니다."); 
		alert(order_no);
		alert(order_state);
		document.location.href="adminOrderStateUpdate?"+"order_no="+order_no+"&order_state="+order_state;
	});
	
	
	$("#state1").click(function (){ 
		var order_no = document.getElementById("state1").value;
		var order_state = $(this).children("#state").text();
	
		alert("입금완료 처리 했습니다."); 
		alert(order_no);
		alert(order_state);
		document.location.href="adminOrderStateUpdate?"+"order_no="+order_no+"&order_state="+order_state;
	});
	});
	//페이지 로드시 버튼 클릭 
}); */

$( document ).ready(function() 
	       
        {
           $('#dataTables-example').rowspan(0);
           $('#dataTables-example').rowspan(9);
        });

        $.fn.rowspan = function(colIdx, isStats) 
        {       
           return this.each(function()
            {      
              var that;     
              $('tr', this).each(function(row) 
              {      
                 $('td:eq('+colIdx+')', this).filter(':visible').each(function(col) 
                 {
                    
                    if ($(this).html() == $(that).html()
                       && (!isStats || isStats && $(this).prev().html() == $(that).prev().html()
                             )
                       ) {            
                       rowspan = $(that).attr("rowspan") || 1;
                       rowspan = Number(rowspan)+1;

                       $(that).attr("rowspan",rowspan);        
                       // do your action for the colspan cell here            
                       $(this).hide();
                       //alert(rowspan);
                       //$(this).remove(); 
                       // do your action for the old cell here
                       
                    } else {            
                       that = this;         
                    }          
                    
                    // set the that if not already set
                    that = (that == null) ? this : that;
                    
                    

                 });     
              });    
           });
           
 
};


</script>
<style type="text/css">
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
</head>
<body>
<div class="row" style="padding-left:15px;width:900px;">    
	<h1 class="page-header">주문목록</h1>
</div>
<div class="row">
	<div class="panel panel-default">
		<div class="panel-heading">
                         [주문목록 페이지] 주문을 검색, 수정, 조회 기능하는 페이지입니다.
        </div>
        <div class="panel-body">
			<div class="dataTable_wrapper">
				<div id="dataTables-example_wrapper"
					class="dataTables_wrapper form-inline dt-bootstrap no-footer">
					<div class="row" style="margin-bottom:5px;">
						<div class="col-sm-6">
							<a href="/SG/adminOrderList"><button type="button" class="btn btn-outline btn-default">전체주문</button></a>
							<select class="form-control" name="select" onchange="window.open(value,'_self');">
								<option value ="">--주문상태--</option>
								<option value ="/SG/adminOrderList?searchNum=0&isSearch=0">입금전</option>
								<option value ="/SG/adminOrderList?searchNum=0&isSearch=1">배송준비중</option>
								<option value ="/SG/adminOrderList?searchNum=0&isSearch=2">배송중</option>
								<option value ="/SG/adminOrderList?searchNum=0&isSearch=3">배송완료</option>
							</select>
							<select class="form-control" name="select" onchange="window.open(value,'_self');">
								<option value ="">--주문방법--</option>
								<option value ="/SG/adminOrderList?searchNum=1&isSearch=0">무통장</option>
								<option value ="/SG/adminOrderList?searchNum=1&isSearch=1">카드결제</option>
							</select>																			
						</div>
						<div class="col-sm-6" style="text-align:right;">
							<div class="dataTables_info" id="dataTables-example_info" role="status" aria-live="polite">총 주문수 : ${totalCount}</div>
						</div>
						
					</div>
					<div class="row">
						<div class="col-sm-12">
							<table class="table  table-bordered table-hover dataTable no-footer" id="dataTables-example" role="grid"
								aria-describedby="dataTables-example_info">
								<thead>
									<tr id="bt" role="row" style="vertical-align:middle;">
										<th style="width: 5%; text-align:center;vertical-align:middle;">배송번호</th>
										<th style="width: 8%; text-align:center;vertical-align:middle;">주문번호</th>										
										<th style="width: 20%; text-align:center;vertical-align:middle;">상품이름/상품번호</th>
										<th style="width: 14%; text-align:center;vertical-align:middle;">DIY상품</th>
										<th style="width: 8%; text-align:center;vertical-align:middle;">주문가격</th>
										<th style="width: 7%; text-align:center;vertical-align:middle;">주문상태</th>
										<th style="width: 6%; text-align:center;vertical-align:middle;">주문자</th>
										<th style="width: 7%; text-align:center;vertical-align:middle;">결제방법</th>
										<th style="width: 12%; text-align:center;vertical-align:middle;">주문날짜</th>									
										<th style="width: 13%; text-align:center;vertical-align:middle;">관리</th>
									</tr>
								</thead>
								<tbody>
								<c:forEach var="order"  items="${order}" varStatus="stat">
								<c:url var="OrderView" value="/adminOrderVeiw" > <!-- 주문상세 -->
									<c:param name="ORDER_DELI_NO" value="${order.DELI_NO}"/>
									<c:param name="MEMBER_ID" value="${order.ORDER_MEMBER_ID}"/>
								</c:url>
								<c:url var="StateUpdate" value="/adminOrderStateUpdate">
									<%-- <c:param name="ORDER_NO" value="${order.ORDER_NO}"/> --%>
									<c:param name="ORDER_STATE" value="${order.ORDER_STATE}"/>
									<c:param name="ORDER_MEMBER_ID" value="${order.ORDER_MEMBER_ID}"/>
									<c:param name="ORDER_DELI_NO" value="${order.DELI_NO}"/>
								</c:url>									
									<tr class="gradeA even" role="row">
										<td style="text-align:center;vertical-align:middle;"><a onclick="javascript:window.open('${OrderView}','','toolbar=no,menubar=no,location=no,height=950,width=1200');">${order.DELI_NO}</a></td>										
										<td style="text-align:center;vertical-align:middle;">${order.ORDER_NO}</td>
										<td style="text-align:center;vertical-align:middle;">${order.GOODS_NAME}/<span>${order.GOODS_NO}</span></td>
										<td style="text-align:center;vertical-align:middle;">${order.ORDER_TOPPING_NAME}</td>
										<td style="text-align:center;vertical-align:middle;"><fmt:formatNumber value="${order.ORDER_MONEY}" type="number"/>원</td>
										<c:choose>
											<c:when test="${order.ORDER_STATE == 0}">
												<td style="text-align:center;vertical-align:middle;">입금 대기</td>
											</c:when>
											
											<c:when test="${order.ORDER_STATE == 1 }">
												<td style="text-align:center;vertical-align:middle;">배송 준비중</td>
											</c:when>
											
											<c:when test="${order.ORDER_STATE == 2 }">
												<td style="text-align:center;vertical-align:middle;">배송중</td>
											</c:when>
											
											<c:otherwise>
												<td style="text-align:center;vertical-align:middle;">배송완료</td>
											</c:otherwise>
										</c:choose>
										
										<td style="text-align:center;vertical-align:middle;">${order.ORDER_MEMBER_ID}</td>							
										
										<c:choose>
											<c:when test="${order.ORDER_TRADE_TYPE == 0}">
												<td style="text-align:center;vertical-align:middle;">무통장입금</td>											
											</c:when>
											
											<c:otherwise>
												<td style="text-align:center;vertical-align:middle;">카드결제</td>
											</c:otherwise>
										</c:choose>
										
										<td style="text-align:center;vertical-align:middle;"><fmt:formatDate value="${order.ORDER_DATE}" pattern="YY.MM.dd HH:mm" /></td>										
										<td id="bt_1" style="text-align:center;vertical-align:middle;">
										
								<c:choose>
									<c:when test="${order.ORDER_STATE == 0}"> <!-- (입금대기 -> 배송준비중으로 변경 & 결제테이블에 입력) -->
										<%-- <div id="${order.DELI_NO}"><a href="${StateUpdate}" class="btn btn-primary">입금완료</a></div> --%>
										<%-- <a href="${StateUpdate}" class="btn btn-primary">입금완료</a> --%>
										<input type="button" value="${order.DELI_NO }" style="display:none;">
										<input type="button" class="btn btn-primary" value="입금완료"onclick="javascript:location.href='${StateUpdate}'">
										
									</c:when>
									
									<c:when test="${order.ORDER_STATE == 1}"> <!-- (배송준비중 -> 배송중)으로 변경 -->
										<input type="button" class="btn btn-primary" value="배송시작" onclick="javascript:location.href='${StateUpdate}'">
										<input type="button" value="${order.DELI_NO }" style="display:none;">
									</c:when>
									
									<c:when test="${order.ORDER_STATE == 2}"> <!-- (배송중-> 배송완료)으로 변경 -->
										<input type="button" class="btn btn-primary" value="배송완료" onclick="javascript:location.href='${StateUpdate}'">
										<input type="button" value="${order.DELI_NO }" style="display:none;">
									</c:when>
									
									<c:otherwise>
											${order.DELI_NO}번=상품전달완료
									</c:otherwise>									
										
										
								</c:choose>								
										</td>
								</c:forEach>
								<!--  주문내역이 없을때 -->
									<c:if test="${fn:length(order) le 0}">
										<tr><td colspan="10" style="text-align:center;">주문내역이 없습니다.</td></tr>
									</c:if> 
								</tbody>
							</table>
						</div>
					</div>
					<div class="paging">
						${pagingHtml}
					</div>
					<div class="row">
							<div style="text-align:center;">
								<div id="dataTables-example_filter" class="dataTables_filter">
									<form action="/SG/adminOrderList">
									<select class="form-control" name="searchNum" id="searchNum">
										<option value="2">주문자</option>
										<option value="3">배송번호</option>
									</select>
										<input class="form-control" type="text" name="isSearch" id="isSearch"/>
										<span>
											<button type="submit" class="btn btn-primary">검색</button>
										</span>
									</form>
								</div>							
							</div>							
					</div>
				</div>
			</div>
									
		</div>
	</div>
    
</div>
</body>
</html>