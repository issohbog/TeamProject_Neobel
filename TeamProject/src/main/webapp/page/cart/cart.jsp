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
	<div class="cart-container">

		<h1 class="cart-title">Cart.</h1>
		
					
		<div class="cart-container-inner">
			<!-- 장바구니 영역 -->
			<table class="cart-table">
				<thead>
					<tr>
						<th><input type="checkbox" /></th>
						<th>PRODUCT</th>
						<th>UNIT PRICE</th>
						<th>QUANTITY</th>
						<th>SUBTOTAL</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:if test="${ cartList == null ||  cartList.isEmpty()  }">
						<tr>
							<td colspan="6">
								조회된 데이터가 없습니다.
							</td>
						</tr>
					</c:if>
					<c:forEach var="cart" items="${cartList}" varStatus="status">	
						<tr>
							<td><input type="checkbox" /></td>
							<td class="cart-product-info"><img src="${pageContext.request.contextPath}/static/${cart.product.imagePath}" alt="product" />
								<div>
									<span>${cart.product.productName}</span> 
								</div>
							</td>
							<td class="price-info">
								
								<div class="sale-price">${cart.product.price}</div>
							</td>
							<td>
								<div class="quantity-container"> 
									<input id="quantity_num_${status.index}" name="quantity_num_name" type="text"	class="quantity-input" value="${cart.quantity}" min="1">
									<div class="quantity-button">
										<a href="javascript:;" class="up"
											onclick="Basket.addQuantityShortcut('${root}','quantity_num_${status.index}', ${status.index}, ${cart.cartNo});">
											<img src="${pageContext.request.contextPath}/static/img/btn_quantity_up.gif" alt="수량증가">
										</a> 
										<a href="javascript:;" class="down"
											onclick="Basket.outQuantityShortcut('${root}','quantity_num_${status.index}', ${status.index}, ${cart.cartNo});">
											<img src="${pageContext.request.contextPath}/static/img/btn_quantity_down.gif" alt="수량감소">
										</a>
									</div>
								</div>
							</td>
							<td class="subtotal"></td>
							<td><button class="delete-btn" onclick="remove( this, '${cart.cartNo}' )">삭제</button></td>
						</tr>
					</c:forEach>
					
	
				</tbody>
			</table>

			<div class="cart-delete">
				<a href="javascript:void(0)" onclick="removeSelected()">선택삭제</a> 
				<a href="javascript:void(0)" onclick="clearCart()">장바구니 비우기</a>
			</div>

			<div class="cart-summary">
				총 상품 금액 = <strong id="total-price"></strong>
			</div>
		</div>
		<div class="cart-footer">
			<form action="${root}/order" method="get">
				<button type="submit" class="buy-btn">구매하기</button>
			</form>
		</div>
	</div>


	<%-- [Contents] ######################################################### --%>
	<jsp:include page="/layout/footer.jsp" />
	<jsp:include page="/layout/script.jsp" /> 


	<script type="text/javascript">
		const root = "${ root }"
		// 장바구니 개별삭제
		function remove( event, cartNo ) {
			const url = root + "/cart?cartNo=" + cartNo
			const check = confirm("정말로 삭제하시겠습니까?")
			if( !check ) return
			
			const $tr = $(event).parent().parent()
			//const $tr = $(event.target).closet("tr");		// 가장 가까운 <tr>
			console.log($tr)
			deleteCart(url, $tr)
		}
		
		// 장바구니 선택 삭제
		function removeSelected() {
		    const root = "${root}";
		    const checkedBoxes = document.querySelectorAll(".cart-table tbody input[type='checkbox']:checked");

		    if (checkedBoxes.length === 0) {
		        alert("삭제할 항목을 선택하세요.");
		        return;
		    }

		    const check = confirm("선택한 항목을 삭제하시겠습니까?");
		    if (!check) return;

		    const cartNos = Array.from(checkedBoxes).map(cb => {
		        const tr = cb.closest("tr");
		        return tr.querySelector(".delete-btn").getAttribute("onclick").match(/\d+/)[0]; // cartNo 추출
		    });

		    const url = root + "/cart?cartNo=" + cartNos.join(",");

		    $.ajax({
		        url: url,
		        type: "DELETE",
		        success: function(response) {
		            if (response === "SUCCESS") {
		                checkedBoxes.forEach(cb => cb.closest("tr").remove());
		                Basket.updateAllTotals();

		                const tbody = document.querySelector(".cart-table tbody");
		                if (tbody.querySelectorAll("tr").length === 0) {
		                    tbody.innerHTML = `
		                        <tr>
		                            <td colspan="6">조회된 데이터가 없습니다.</td>
		                        </tr>
		                    `;
		                    document.querySelector(".cart-summary strong").innerText = "0";
		                }

		                alert("선택한 항목 삭제 완료!");
		            }
		        },
		        error: function() {
		            alert("삭제 실패!");
		            console.err(err);
		        }
		    });
		}
		
		// 장바구니 전체 삭제 
		function clearCart() {
			const root = "${root}";
			
			const url = root + "/cart/clear";
			
		  if (!confirm("정말로 장바구니를 모두 비우시겠습니까?")) return;
		
		  fetch(url, {
		    method: "DELETE"
		  })
		  .then(response => {
		    if (!response.ok) throw new Error("서버 오류");
		    return response.text();
		  })
		  .then(result => {
		    if (result === "SUCCESS") {
		      alert("장바구니가 모두 비워졌습니다.");
		      location.reload(); // 화면 새로고침
		    } else {
		      alert("장바구니 비우기에 실패했습니다.");
		    }
		  })
		  .catch(err => {
		    console.error(err);
		    alert("서버 통신 중 오류가 발생했습니다.");
		  });
		}

		
	
	</script>
	
	
</body>
</html>





