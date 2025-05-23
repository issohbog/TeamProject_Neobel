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
		        <a href="#" class="product-card2">
		            <img src="${product.image_path}" alt="${product.productName}">
		            <div class="product-info2">
		                <p class="product-name2">${product.productName}</p>
		                <p class="product-desc2">${product.description}</p>
		            </div>
		            <div class="price-box2">
		                <p class="product-price2">${product.price}</p>
		            </div>
		        </a>
		
		</div>

	
	
	<%-- [Contents] ######################################################### --%>
	<jsp:include page="/layout/footer.jsp" />
	<jsp:include page="/layout/script.jsp" />
</body>
</html>