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
			
	<div id="list">
		  <c:forEach var="product" items="${productList}">
		    <a href="${product.link}" class="product-card">
		      <img src="${pageContext.request.contextPath}/static/img/${product.image}" alt="${product.name}">
		      <div class="product-info">
		        <p class="product-name">${product.name}</p>
		        <p class="product-name-bold">${product.brand}</p>
		        <p class="product-desc">${product.volume}</p>
		      </div>
		      <div class="price-box">
		        <p class="product-price">${product.price}</p>
		      </div>
		    </a>
		  </c:forEach>
	</div>
			

	
	
	<%-- [Contents] ######################################################### --%>
	<jsp:include page="/layout/footer.jsp" />
	<jsp:include page="/layout/script.jsp" />
</body>
</html>