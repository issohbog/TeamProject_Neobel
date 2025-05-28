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
			<c:forEach var="order" items="${orders}">
				<tr>
					<td><fmt:formatDate value="${order.orderDate}" pattern="yyyy-MM-dd" /></td>
					
					<td class="orderHistory-order-code">
						<div>
						    <a href="${pageContext.request.contextPath}/order/result?orderNo=${order.orderNo}">
						      <span>${order.orderCode}</span>
   							</a>
						</div>
					</td>
					<td class="orderHistory-product-info">
						<div>
						      <span>${order.orderTitle}</span>
						</div>
					</td>
					<td><fmt:formatNumber value="${order.totalPrice}" type="number" /></td>
					<td>${order.payment}</td>
				</tr>
				<tr>
			</c:forEach>
		</tbody>
	</table>
	</section>	
	
	
	<%-- [Contents] ######################################################### --%>
	<jsp:include page="/layout/footer.jsp" />
	<jsp:include page="/layout/script.jsp" />
</body>
</html>