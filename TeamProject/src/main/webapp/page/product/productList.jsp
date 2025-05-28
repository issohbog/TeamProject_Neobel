<%@ include file="/layout/jstl.jsp" %>
<%@ include file="/layout/common.jsp" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

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
			
<!-- 		<div id="list" class="row row-cols-1 row-cols-sm-2 row-cols-md-3 row-cols-lg-4 g-3"> -->
		<div id="list">
	    	<c:forEach var="product" items="${productList}">
              	<div class="col">
			        <a href="${ root }/product?productNo=${product.productNo}" class="product-card2">
			            <img src="${product.imagePath}" alt="${product.productName}">
			            <div class="product-info2">
			                <p class="product-name2">${product.productName}</p>
			                <p class="product-desc2">${product.description}</p>
			            </div>
			            <div class="price-box2">
			                <p class="product-price2">${product.price}</p>
			            </div>
			        </a>
		        </div>
			</c:forEach>
			
			 
		</div>

	
	
	<%-- [Contents] ######################################################### --%>
	<jsp:include page="/layout/footer.jsp" />
	<jsp:include page="/layout/script.jsp" />
</body>
</html>