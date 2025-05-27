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
<<<<<<< HEAD
    <jsp:include page="/layout/header.jsp" />

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
                        <button type="button" onclick="increaseQuantity()">+</button>
                        <button type="button" onclick="decreaseQuantity()">-</button>
                    </div>
                </div>

                <div class="total-price-box3">
                    <div class="total3"><span>총 상품 금액</span></div>
                    <div class="price3">
                        <span id="total-price3">${product.price}</span>원
                    </div>
                </div>

                <!-- 장바구니 & 구매하기 폼 -->
                <form id="cartForm" method="post" action="${root}/cart/insert">
                    <input type="hidden" name="productNo" value="${product.productNo}">
                    <input type="hidden" name="quantity" id="cartQuantity" value="1">
                    <button type="submit" id="cart-btn" class="button3 cart-button3">장바구니 담기</button>
                </form>

                <form id="buyForm" method="get" action="${root}/order">
                    <input type="hidden" name="productNo" value="${product.productNo}">
                    <input type="hidden" name="quantity" id="buyQuantity" value="1">
                    <button type="submit" id="buy-btn" class="button3 buy-button3">구매하기</button>
                </form>
                
                
            </div>
            
            
        </div>
    </div>
	<%-- 화면 로딩 --%>
	<div id="loading-overlay"
		style="display: none; position: fixed; top: 0; left: 0; width: 100%; height: 100%; background: rgba(255, 255, 255, 0.8); z-index: 9999; justify-content: center; align-items: center;">
		<div class="spinner"></div>
	</div>

	<script type="text/javascript">
	document.getElementById("buy-btn").addEventListener("click", function (e) {
		  e.preventDefault(); // ✅ 기본 submit 막기

		  // 로딩 스피너 표시
		  document.getElementById("loading-overlay").style.display = "flex";

		  // 0.3초 후 수동으로 이동
		  setTimeout(function () {
		    // form 수동 전송
			  document.getElementById("buyForm").submit();
		  }, 300);
		});
	
	document.getElementById("cart-btn").addEventListener("click", function (e) {
		  e.preventDefault(); // ✅ 기본 submit 막기

		  // 로딩 스피너 표시
		 	document.getElementById("loading-overlay").style.display = "flex";

		  // 0.3초 후 수동으로 이동
		  setTimeout(function () {
		    // form 수동 전송
			  document.getElementById("cartForm").submit();
		  }, 300);
		});
	</script>


	<jsp:include page="/layout/footer.jsp" />
    <jsp:include page="/layout/script.jsp" />
    <script src="${pageContext.request.contextPath}/static/js/productDetail.js"></script>

=======
	<jsp:include page="/layout/header.jsp" />
	<%-- [Contents] ######################################################### --%>
		
	
	
	<%-- [Contents] ######################################################### --%>
	<jsp:include page="/layout/footer.jsp" />
	<jsp:include page="/layout/script.jsp" />
>>>>>>> refs/heads/Hong
</body>
</html>