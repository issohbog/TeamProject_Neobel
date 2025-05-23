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
		<div class="detail-wrapper">
  <div class="content-box">
    <div class="product-image">
      <img src="${pageContext.request.contextPath}${product.image_path}" alt="${product.ProductName}">
    </div>

    <div class="product-options">
      <div class="product-name">${product.ProductName}</div>
      <div class="product-volume">용량 정보 없음</div> <%-- DTO에 volume 없음 --%>

      <div class="product-price-box">
        <span id="unit-price">${product.price}원</span>
      </div>

      <div class="quantity-box" id="product" data-price="${product.price}">
        <div class="quantity-number" id="quantity">1</div>
        <div class="quantity-controls">
          <button onclick="increaseQuantity()">+</button>
          <button onclick="decreaseQuantity()">-</button>
        </div>
      </div>

      <div class="total-price-box">
        <div class="total">
          <span>총 상품 금액</span>
        </div>
        <div class="price">
          <span id="total-price">${product.price}</span>원
        </div>
      </div>

      <a href="#" class="button cart-button">장바구니 담기</a>
      <a href="#" class="button buy-button">구매하기</a>
    </div>
  </div>
</div>
		
	<%-- [Contents] ######################################################### --%>
	
	<jsp:include page="/layout/footer.jsp" />
	<jsp:include page="/layout/script.jsp" />
	<script src="${pageContext.request.contextPath}/static/js/productDetail.js"></script> 
</body>
</html>