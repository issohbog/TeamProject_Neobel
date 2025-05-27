<%@ include file="/layout/jstl.jsp" %>
<%@ include file="/layout/common.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
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
	  <div id="slides">
    <div class="slide_active"><a href="${ root }/product?productNo=${product.productNo}"><img src="${pageContext.request.contextPath}/static/img/메인베너01.jpg" alt="첫번째배너"></a></div>
    <div class="slide"><a href="${ root }/product?productNo=${product.productNo}"><img src="${pageContext.request.contextPath}/static/img/메인배너2.jpg" alt=""></a></div>
    <div class="slide"><a href="${ root }/product?productNo=${product.productNo}"><img src="${pageContext.request.contextPath}/static/img/메인베너3.jpg" alt=""></a></div>
  </div>


<!-- BEST SECTION -->
<section class="best-section">
  <h2>BEST</h2>
  
  <div class="scroll-container" id="slider">

   <a href="${ root }/product?productNo=${product.productNo}" class="product-card">
  
      <img src="${pageContext.request.contextPath}/static/img/어성초 흔적 에센스 패드.jpg" alt="Product 1">
      <div class="product-info">
        <p class="product-name">[NEW] 어성초 흔적 에센스 패드</p>
        <p class="product-name-bold">클리어 터치</p>
        <p class="product-desc"> 250ml / 70pads</p>
      </div>
      <div class = "price-box">
      <p class="product-price">24,000</p>
      </div>
  
    </a>

       <a href="${ root }/product?productNo=${product.productNo}" class="product-card">
      <img src="${pageContext.request.contextPath}/static/img/글루타치온좀 cc 선크림.jpg" alt="Product 2">
      <div class="product-info">
        <p class="product-name">글루타치온좀 CC 선크림</p>
        <p class="product-name-bold">토닝 튜브 SPF50+ PA++++</p>
        <p class="product-desc">50ml</p>
      </div>
       <div class = "price-box">
      <p class="product-price">25,000</p>
      </div>
    </a>
    
       <a href="${ root }/product?productNo=${product.productNo}" class="product-card">
      <img src="${pageContext.request.contextPath}/static/img/껌딱지 시트 마스트어성초 스티커.jpg" alt="Product 3">
      <div class="product-info">
        <p class="product-name">껌딱지 시트 마스크 </p>
        <p class="product-name-bold">어성초 스티커</p>
        <p class="product-desc">27ml / 1ea</p>
      </div>
       <div class = "price-box">
      <p class="product-price">4,000</p>
      </div>
    </a>


       <a href="${ root }/product?productNo=${product.productNo}" class="product-card">
      <img src="${pageContext.request.contextPath}/static/img/부활초 크림.jpg" alt="Product 4">
      <div class="product-info">
        <p class="product-name">부활초 크림</p>
        <p class="product-name-bold">뉴트리션 튜브</p>
        <p class="product-desc">75ml</p>
      </div>
       <div class = "price-box">
      <p class="product-price">35,000</p>
      </div>
    </a>

       <a href="${ root }/product?productNo=${product.productNo}" class="product-card">
      <img src="${pageContext.request.contextPath}/static/img/모델링 크림 마스크 어성초 스쿱.jpg" alt="Product 5">
      <div class="product-info">
        <p class="product-name">모델링 크림 마스크</p>
        <p class="product-name-bold">어성초 스쿱</p>
        <p class="product-desc">71ml / 1ea</p>
      </div>
       <div class = "price-box">
      <p class="product-price">8,000</p>
      </div>
    </a>


       <a href="${ root }/product?productNo=${product.productNo}" class="product-card">
      <img src="${pageContext.request.contextPath}/static/img/라이스 오버나이트 마스크 .jpg" alt="Product 6">
      <div class="product-info">
        <p class="product-name">라이스 오버나이트 마스크</p>
        <p class="product-name-bold">베리어 젤리</p>
        <p class="product-desc">80ml</p>
      </div>
       <div class = "price-box">
      <p class="product-price">28,000</p>
      </div>
    </a>



  </div>
</section>


<!-- 배너 1 -->
<section class="banner">
  <h1>HEARTLEAF ESSENCE PAD<br>CLEAR TOUCH</h1>
</section>

<!-- 배너 2 -->
<section class="banner2">
  <h1>ALL PRODUCT</h1>
</section>
	
	
	<%-- [Contents] ######################################################### --%>
	<jsp:include page="/layout/footer.jsp" />
	<jsp:include page="/layout/script.jsp" />
</body>
</html>