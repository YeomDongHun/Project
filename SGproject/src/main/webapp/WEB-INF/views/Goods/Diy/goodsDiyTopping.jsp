<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<!DOCTYPE html>
<div class="diy" style="clear:both">
					<div class="container" style="  width: 500px; height: 300px; padding-top: 20px;margin-top: 20px; "> 
					
						<c:choose>
							<c:when test="${fn:length(topping) > 0}">
								<c:forEach var="topping" items="${topping}" varStatus="stat">
							                          
									    <div class="thumbnail imgover" style="width: 100px; height: 115px; float: left; margin-right: 20px;">
									      <img src="resources/file/goodsFile/${topping.TOPPING_IMG}" id="${topping.TOPPING_NO }" name="${topping.TOPPING_NAME }" alt="..." onclick="addTopping(this)" class="img-circle" style="width: 70px; height: 70px; "/>
									      <div class="caption">
									      
									        <div style="text-align: center; margin-bottom: 5px;"><h5><strong>${topping.TOPPING_NAME}</strong></h5></div>
									        <div style="text-align: center;"><h5>${topping.TOPPING_PRICE }원</h5></div>
									 		<div style="text-align: center;"><h6>${topping.TOPPING_KCAL }kcal</h6></div>
									     
									         
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
					
					</div>
			
				</div>