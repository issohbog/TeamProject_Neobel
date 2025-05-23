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
	<section class="order-history">
    <h1>주문 내역</h1>
    <hr class="section-line" />
    
    <table class="order-table">
      <thead>
        <tr>
          <th>DATE</th>
          <th>ORDER #</th>
          <th>PRODUCT</th>
          <th>PRICE</th>
          <th>PAYMENT</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <td>2025-05-19</td>
          <td>20250519-0000278</td>
          <td class="orderHistory-product-info">
            <div>
                <span>수분초 힐링토너 패드 하이드로데일리 토너</span>
            </div>
          </td>
          <td>4,000</td>
          <td>신용카드</td>
        </tr>
        <tr>
          <td>2025-05-20</td>
          <td>20250520-0000256</td>
          <td class="orderHistory-product-info">
            <div>
                <span>어성초 혼합 에센스 패드 클리어 터치 외 2개</span>
            </div>
          </td>
          <td>50,230</td>
          <td>무통장입금</td>
        </tr>
        <tr>
          <td>2025-05-25</td>
          <td>20250519-0000278</td>
          <td class="orderHistory-product-info">
            <div>
                <span>모델링 크림 마스크 부활초 쇼크</span>
            </div>
          </td>

          <td>5,600</td>
          <td>신용카드</td>
        </tr>
      </tbody>
    </table>
  </section>	
	
	
	<%-- [Contents] ######################################################### --%>
	<jsp:include page="/layout/footer.jsp" />
	<jsp:include page="/layout/script.jsp" />
</body>
</html>