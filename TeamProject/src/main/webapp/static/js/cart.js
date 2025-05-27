/**
 * 
 */


/*장바구니 수량 up, down 조절 가능 함수 */
document.addEventListener("DOMContentLoaded", function() {
	
	// Basket 객체 생성(장바구니 관련 기능 메서드로 정리)
    const Basket = {
	
	// 수량 증가 함수 	
    addQuantityShortcut: function (root, inputId, index, cartNo) {
		
      const input = document.getElementById(inputId);		// ID로 수량 input요소 찾기
      let current = parseInt(input.value, 10);				// 현재 수량을 숫자로 파싱
      input.value = current + 1;							// 수량 1 증가
	  Basket.updateRowAndTotal(input);						// 해당 상품 줄의 금액, 전체 합계 다시 계산
	  Basket.updateQuantityAjax(root,cartNo, current + 1);		// 바뀐 수량 서버에 반영
    },

    outQuantityShortcut: function (root, inputId, index, cartNo) {
      const input = document.getElementById(inputId);
      let current = parseInt(input.value, 10);
      if (current > 1) {
        input.value = current - 1;
		Basket.updateRowAndTotal(input);
		Basket.updateQuantityAjax(root, cartNo, current - 1);		// 바뀐 수량 서버에 반영
      }
    }, 
	
	updateRowAndTotal: function (inputElement) {			// 한줄의 소계 계산 + 전체 합계 업데이트
		const row = inputElement.closest("tr");				// input이 포함된 tr 찾기
		const unitPriceText = row.querySelector(".sale-price").innerText;	// 단가 가져오기
		const quantity = parseInt(inputElement.value, 10);					// 수량 숫자 변환
		
		// 숫자 추출 및 쉼표 제거 
		const unitPrice = parseInt(unitPriceText.replace(/,/g, ""));		// 쉼표 제거 후 숫자 변환
		const subtotal = unitPrice * quantity;								// 소계 계산
		
		// 개별 subtotal 업데이트 
		row.querySelector("td:nth-child(5)").innerText= subtotal.toLocaleString();	// 소계 출력
		
		// 전체 총합 재계산 
		Basket.updateAllTotals();	// 모든 상품 합계 다시 계산
	},
	
	// 장바구니 전체 총액 계산 함수 
	updateAllTotals: function () {
	     let total = 0;
	     document.querySelectorAll(".cart-table tbody tr").forEach(function (row) {
	       const subtotalCell = row.querySelector("td:nth-child(5)");			// 각 줄의 소계 셀 
	       if (subtotalCell) {
	         const subtotal = parseInt(subtotalCell.innerText.replace(/,/g, ""));	// 쉼표 제거 
	         total += subtotal;		// 총합 누적
	       }
	     });

	     const totalElement = document.querySelector(".cart-summary strong");		// 총액 표시 영역
	     if (totalElement) {
	       totalElement.innerText = total.toLocaleString();			// 총액 표시
	     }
	   },
	   
	   initialize: function () {
	     document.querySelectorAll(".cart-table tbody tr").forEach(function (row) {
	       const input = row.querySelector(".quantity-input");
	       if (input) {
	         Basket.updateRowAndTotal(input);
	       }
	     });
	   }, 
	   
	   updateQuantityAjax: function (root, cartNo, newQuantity) {
		
		console.log("전송할 값 → root: " , root, "cartNo:", cartNo, "quantity:", newQuantity); 
	     fetch(root + '/cart/updateQuantity', {
	       method: 'POST',
	       headers: {
	         'Content-Type': 'application/json'
	       },
	       body: JSON.stringify({
	         cartNo: cartNo,
	         quantity: newQuantity
	       })
	     })
	     .then(response => {
	       if (!response.ok) throw new Error("서버 오류");
	       return response.json();
	     })
	     .then(data => {
	       console.log("서버 수량 업데이트 성공:", data);
	     })
	     .catch(error => {
	       console.error("서버 수량 업데이트 실패:", error);
	       alert("서버와 통신 중 문제가 발생했습니다.");
	     });
	   }

	   
	   
  };

  
  // Basket 객체를 전역에서 사용할 수 있도록 등록 
  window.Basket = Basket;
  
  // 페이지 로드 시 초기 총합 계산 
  Basket.initialize();
});
  
 
// 장바구니 개별 삭제
function deleteCart(url, element) {
	// 삭제 요청

    $.ajax({
        url : url,
        type : 'DELETE',
        success : function(response) {
            if( response == 'SUCCESS' ) {
				//alert("장바구니 삭제")
				// 삭제 성공 시, 해당 장바구니 항목 지우기
				element.remove()
				
				// 삭제 후 총액 다시 계산 	
				Basket.updateAllTotals()
				
				// 남은 행 수 체크 (tbody > tr 중, "조회된 데이터가 없습니다" 아닌 것만)
				const $tbody = $(".cart-table tbody");
				const remainingRows = $tbody.find("tr").length;

				if (remainingRows === 0) {
				    $tbody.html(`
				        <tr>
				            <td colspan="6">조회된 데이터가 없습니다.</td>
				        </tr>
				    `);
				}
				
			

				//alert("장바구니 삭제 성공!");
            }
        },
        error : function(error) {
				alert("삭제 실패");
				console.log(error);
        }
    })
}

 










