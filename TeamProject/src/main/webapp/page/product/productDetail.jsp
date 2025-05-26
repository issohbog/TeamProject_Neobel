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
	<div class="detail-wrapper3">
  <div class="content-box3">
    <div class="product-image3">
       <img src="${product.imagePath}" alt="${product.productName}">
    </div>

    <div class="product-options3">
      <div class="product-name3">${product.productName}</div>
      <div class="product-volume3">
        <c:choose>
          <c:when test="${empty product.description}">
            상세정보 없음
          </c:when>
          <c:otherwise>
            ${product.description}
          </c:otherwise>
        </c:choose>
      </div>

      <div class="product-price-box3">
        <span id="unit-price3">${product.price}원</span>
      </div>

      <div class="quantity-box3" id="product3" data-price="${product.price}">
        <div class="quantity-number3" id="quantity3">1</div>
        <div class="quantity-controls3">
          <button onclick="increaseQuantity()">+</button>
          <button onclick="decreaseQuantity()">-</button>
        </div>
      </div>

      <div class="total-price-box3">
        <div class="total3">
          <span>총 상품 금액</span>
        </div>
        <div class="price3">
          <span id="total-price3">${product.price}</span>원
        </div>
      </div>

      <a href="${pageContext.request.contextPath}/page/cart/cart.jsp" class="button3 cart-button3">장바구니 담기</a>
      <a href="${pageContext.request.contextPath}/page/order/orderForm.jsp" class="button3 buy-button3">구매하기</a>
    </div>
  </div>
</div>

	<%-- [Contents] ######################################################### --%>
	
	<jsp:include page="/layout/footer.jsp" />
	<jsp:include page="/layout/script.jsp" />
	<script src="${pageContext.request.contextPath}/static/js/productDetail.js"></script> 
</body>
</html>