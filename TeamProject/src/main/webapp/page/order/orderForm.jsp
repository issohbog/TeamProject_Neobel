<%@ include file="/layout/jstl.jsp" %>
<%@ include file="/layout/common.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<title>project💻 - ALOHA CLASS🌴</title>
	<jsp:include page="/layout/meta.jsp" />
	<jsp:include page="/layout/link.jsp" />
</head>
<body>
	<jsp:include page="/layout/header.jsp" />
	<%-- [Contents] ######################################################### --%>
	<form action="${root}/order/orderDetail" method="post">
		<div class="payment-container">
			
		    <!-- 제목 -->
		    <h1 class="payment-title">Order form.</h1>
		
		    <!-- 주문 리뷰 테이블 -->
		    <section class="order-review">
		      <h2>ORDER REVIEW</h2>
		      <table class="review-table">
		        <thead>
		          <tr>
		            <th>PRODUCT</th>
		            <th>UNIT PRICE</th>
		            <th>QUANTITY</th>
		            <th>SUBTOTAL</th>
		          </tr>
		        </thead>
		        <tbody>
		        
		        <c:set var="totalPrice" value="0" />
		        
		        <c:forEach var="cart" items="${cartList}" varStatus="status">	
		          <tr>
		            <td class="order-product-info">
		                <img src="${pageContext.request.contextPath}/static/${cart.product.imagePath}" alt="product" />
		                <div>
		                    <span>${cart.product.productName}</span>
		                </div>
		                
		                <input type="hidden" name="productNo" value="${cart.product.productNo}"/>
		                <input type="hidden" name="quantity" value="${cart.quantity}"/>
		                <input type="hidden" name="price" value="${cart.product.price}"/>
		                
		            </td>
		            <td>
		              <strong>
		              	<fmt:formatNumber value="${cart.product.price}" type="number" groupingUsed="true" />
		              </strong>
		            </td>
		            <td>${cart.quantity}</td> 
		            <td>
		            	<fmt:formatNumber value="${cart.product.price * cart.quantity}" type="number" groupingUsed="true" />
		            	<c:set var="totalPrice" value="${totalPrice + (cart.product.price * cart.quantity)}" />
		           	</td>
		          </tr>
		        </c:forEach>
		          
		        </tbody>
		      </table>
		    </section>
		
		    <!-- 총 결제 섹션 -->
		    <section class="total-payment">
		      <h2>TOTAL PAYMENT</h2>
		      <div class="total-amount">
		        <span>최종 결제예정 금액</span>
		        <strong><fmt:formatNumber value="${totalPrice}" type="number" groupingUsed="true" /></strong>
		      </div>
		      <!-- 총합 숨겨서 전송  -->
		      <input type="hidden" name="totalPrice" value="${totalPrice}" />
		    </section>
		
		    <!-- 결제 방법 선택 -->
		    <section class="payment-method">
		      <h2>PAYMENT METHOD</h2>
		      <div class="radio-group">
		        <p>
		        <span>
		            <input type="radio" id="card" name="payment" value="신용카드" checked>
		            <label for="card"> 카드 결제</label>
		        </span>
		        <span>
		            <input type="radio" id="bank" name="payment" value="무통장입금"> 
		            <label for="bank">무통장 입금</label>
		        </span>
		        </p>
		      </div>
		    </section>
		
		    <!-- 결제 버튼 -->
		    <div class="submit-box">
		      <button type="submit" class="submit-btn" onclick="openModal()">결제하기</button>
		    </div>
	  </div>
  </form>

  <!-- 주문 완료 modal -->
   <!-- 주문 페이지 내에 이 모달을 미리 삽입해두기 -->
  <div class="modal" id="order-complete-modal">
    <div class="order-popup">
      <div class="order-complete-title"><span>주문완료</span></div>
        <div class="container">
          <img src="${pageContext.request.contextPath}/static/img/12083665_Wavy_Bus-30_Single-08 1.png" alt="주문 완료 이미지" class="popup-img" />
            <p class="popup-message">주문이 완료되었습니다.</p>
            <p class="popup-order-num"><span>주문번호 : </span><span>25125132-165496431</span></p>
            <div class="popup-buttons">
              <button class="btn primary">주문상세확인</button>
              <button class="btn secondary" onclick="closeModal()">쇼핑계속하기</button>
            </div>
        </div>
      </div>
  </div>	
	
	
	<%-- [Contents] ######################################################### --%>
	<jsp:include page="/layout/footer.jsp" />
	<%--<jsp:include page="/layout/script.jsp" /> --%>
	<script src="<%= root %>/static/js/orderForm.js"></script> 
</body>
</html>