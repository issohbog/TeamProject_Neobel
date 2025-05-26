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
	<!-- 1400px 선 영역 -->
  <div class="order-result-line">Order result.</div>
  <div class="container">
    <h2>ORDER RESULT</h2>
    <table class="info-table">
      <tr>
        <th>주문번호</th>
        <td>${order.orderDate}</td>
      </tr>
      <tr>
        <th>주문일자</th>
        <td>${order.orderDate}</td>
      </tr>
    </table>

    <h2>PAYMENT INFORMATION</h2>
    <table class="info-table">
      <tr>
        <th>최종결제금액</th>
        <td>${order.totalPrice}</td>
      </tr>
      <tr>
        <th>결제수단</th>
        <td>
          ${order.payment}<br>
          입금자 : ${order.name}<br> 
          계좌번호 : 하나은행 183-310033-77004 (주)로컴퍼니
        </td>
      </tr>
    </table>

    <h2>ORDER INFORMATION</h2>
	<table class="product-table">
	  <thead>
	    <tr>
	      <th>PRODUCT</th>
	      <th>PRICE</th>
	    </tr>
	  </thead>
	  <tbody>
	    <c:forEach var="detail" items="${order.detailList}">
	      <c:set var="subtotal" value="${detail.product.price * detail.quantity}" />
	      <tr>
	        <td>${detail.product.productName}</td>
	        <td><fmt:formatNumber value="${subtotal}" type="number" /></td>
	      </tr>
	    </c:forEach>
	  </tbody>
	</table>

    <h2>TOTAL ORDER DETAIL</h2>
    <table class="info-table">
      <tr>
        <th>총 주문 금액</th>
        <td>${order.totalPrice}</td>
      </tr>
    </table>

    <h2>DELEVERY INFORMATION</h2>
    <table class="info-table">
      <tr>
        <th>받으시는 분</th>
        <td>${order.name}</td>
      </tr>
      <tr>
        <th>우편번호</th>
        <td>${order.postCode}</td>
      </tr>
      <tr>
        <th>주소</th>
        <td>${order.addr}</td>
      </tr>
      <tr>
        <th>상세 주소</th>
        <td>${order.addrDetail}</td>
      </tr>
      <tr>
        <th>휴대전화</th>
        <td>${order.phone}</td>
      </tr>
      <tr>
        <th>배송메시지</th>
        <td>${order.req}</td>
      </tr>
    </table>

    <div class="orderList">
        <input type="button" class="btn white" value="주문 목록" >
    </div>

  </div>

</div>	
	
	<div class="modal" id="order-complete-modal">
    <div class="order-popup">
      <div class="order-complete-title"><span>주문완료</span></div>
        <div class="modal-container">
          <img src="${pageContext.request.contextPath}/static/img/12083665_Wavy_Bus-30_Single-08 1.png" alt="주문 완료 이미지" class="popup-img" />
            <p class="popup-message">주문이 완료되었습니다.</p>
            <p class="popup-order-num"><span>주문번호 : </span><span id="order-number"></span></p>
            <div class="popup-buttons">
              <button class="btn primary" onclick="closeModal()">주문상세확인</button>
              <button class="btn secondary" onclick="location.href='${pageContext.request.contextPath}/product'">쇼핑계속하기</button>
            </div>
        </div>
      </div>
  </div>


	<%-- [Contents] ######################################################### --%>
	<jsp:include page="/layout/footer.jsp" />
	<jsp:include page="/layout/script.jsp" />
	
<%-- 	<c:if test="${showModal}"> --%>
		<script>
			window.addEventListener("DOMContentLoaded", openModal);
		</script>
<%-- 	</c:if> --%>
</body>
</html>