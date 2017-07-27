<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>  


                  
<input type="hidden" id="currentPage" value="${currentPage }"/>
                
<c:choose>
	<c:when test="${fn:length(goodsList) > 0}">
		<c:forEach var="goodsList" items="${goodsList}" varStatus="stat">
	                   
			  <div class="SG_ItemBox" style=" width:240px; height:360px; float:left; margin-left: 20px; margin-right: 20px; margin-bottom: 30px;"> 
			    <div class="thumbnail" style="height:360px;">
			    <c:if test="${goodsList.COMMENT_RATE ==0 }">
			    			    	<div style="width:40px;height:40px;background-color: #C90000;color:#FFFFFF; text-align: center; padding-top: 10px; position: absolute;z-index: 0;"><strong>NEW</strong></div>
			    </c:if>
			    <c:if test="${goodsList.COMMENT_RATE !=0 }">
			    
			    	<c:if test="${goodsList.COMMENT_RATE == 5 }">
			    		<div style="width:40px;height:40px;background-color: #C90000;color:#FFFFFF; text-align: center; padding-top: 10px; position: absolute;z-index: 0;"><strong>BEST</strong></div>
			    	</c:if>
			    	<c:if test="${goodsList.COMMENT_RATE != 5 }">
			    		<div style="width:40px;height:40px;background-color: #C90000;color:#FFFFFF; text-align: center; padding-top: 10px; position: absolute;z-index: 0;"><strong>${goodsList.COMMENT_RATE}</strong></div>
					
					</c:if>			   
			    </c:if>  
			 	 <div style="margin-left:15px;margin-top:70px;; position: absolute;">
				     <c:if test="${goodsList.GOODS_AMOUNT == 0 }">
				    	 <img src="resources/file/img/sorry.png" alt="..." onclick="javascript:location.href='goodsDetail?goodsNo=${goodsList.GOODS_NO}&currentPage=${currentPage}'" width="200px;"/>
				    </c:if>
			    </div>
			      <img src="resources/file/goodsFile/${goodsList.GOODS_THUMBNAIL}" alt="..." onclick="javascript:location.href='goodsDetail?goodsNo=${goodsList.GOODS_NO}&currentPage=${currentPage}'"/>
			    
			      <div class="caption">
			      
			        <div style="text-align: center;font-family: PureunJeonnam;"><h4>${goodsList.GOODS_NAME}</h4></div>
			        <div style="text-align: right;font-family: PureunJeonnam;"><h5>${goodsList.GOODS_PRICE }원</h5></div>
			     
			          <div class="basketWish" style="float:left; margin-top: 10px;">
			          
			    	<c:if test="${goodsList.GOODS_AMOUNT != 0 }">
			         	<div class="basket" style="margin:auto; padding-left:10px;float:left;">
			        		 <img id="${goodsList.GOODS_NO}" src="resources/file/img/basket.ico" width="20" height="20" onclick="SideBasket(this)"/>
			        	</div>
			         </c:if>
			              <c:if test="${sessionScope.MEMBER_NO !=0 }">
			        		<c:choose>
			        
			        		 	<c:when test="${goodsList.WISH_NO==0}">
			         	
			         				<div class="wish" style="margin:auto; padding-left:10px;float:left">
			       						<img id="w_${goodsList.GOODS_NO}" src="resources/file/img/wishoff.png" width="20" height="20" onclick="imgToggle(this)"/>
			        				</div>
			         			</c:when>
			         	
			         			<c:otherwise>
			         				<div class="wish" style="margin:auto; padding-left:10px;float:left">
			       						<img id="w_${goodsList.GOODS_NO}" src="resources/file/img/wish.ico" width="20" height="20" onclick="imgToggle(this)"/>
			        				</div>
			         	
			         			</c:otherwise>
			         		</c:choose>
			         </c:if>
			       </div>
			      </div>
			    </div>
			  </div>
			
	   
	         
		</c:forEach>
	</c:when>
	                
	<c:otherwise>
	    <tr>
	       <td colspan="4">조회된 결과가 없습니다.</td>
	    </tr>
	</c:otherwise>
</c:choose>





   

   
