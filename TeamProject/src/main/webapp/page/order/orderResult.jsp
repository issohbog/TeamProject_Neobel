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
        <td>20250919-0000278</td>
      </tr>
      <tr>
        <th>주문일자</th>
        <td>2025-09-19 11:17:16</td>
      </tr>
    </table>

    <h2>PAYMENT INFORMATION</h2>
    <table class="info-table">
      <tr>
        <th>최종결제금액</th>
        <td>5,400</td>
      </tr>
      <tr>
        <th>결제수단</th>
        <td>
          무통장 입금<br>
          입금자 : 김조은<br>
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
        <tr>
          <td>약산성 시트 마스크 여성초 핏</td>
          <td>16,800</td>
        </tr>
        <tr>
          <td>수분초 히알루론 패드<br>하이드레이팅 터치</td>
          <td>16,800</td>
        </tr>
        <tr>
          <td>깜딱지 시트 마스크 여성초 스티커</td>
          <td>2,400</td>
        </tr>
      </tbody>
    </table>

    <h2>TOTAL ORDER DETAIL</h2>
    <table class="info-table">
      <tr>
        <th>총 주문 금액</th>
        <td>36,000</td>
      </tr>
    </table>

    <h2>DELEVERY INFORMATION</h2>
    <table class="info-table">
      <tr>
        <th>받으시는 분</th>
        <td>김조은</td>
      </tr>
      <tr>
        <th>우편번호</th>
        <td>12345</td>
      </tr>
      <tr>
        <th>주소</th>
        <td>인천광역시 부평구 부평1동 534-48</td>
      </tr>
      <tr>
        <th>휴대전화</th>
        <td>010-0000-1111</td>
      </tr>
      <tr>
        <th>배송메시지</th>
        <td>문앞에 두고 벨 눌러주세요</td>
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