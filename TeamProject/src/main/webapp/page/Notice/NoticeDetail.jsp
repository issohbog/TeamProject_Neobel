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
		
	<div class="notice-detail-wrapper">
	
	
	
  <div class="notice-box">
  
  
  	<div class ="title2">
		  <h1>공지사항</h1>
		</div>
  
    <div class="notice-content-container">
      
      <!-- 제목 영역 -->
      <div class="notice-title-box">
        <div class="notice-subtitle">배송지 정책 변경 안내</div>
        <div class="notice-date">2025.05.27</div>
      </div>

      <!-- 내용 -->
      <div class="notice-body-box">
        적립금 사용 기준 변경안내 <br>
	
		2023년 5월 2일(화)부터 아비브 공식 홈페이지 적립금 사용 기준 방법이 변경됨에 따라 안내드립니다.
		기존 공식 홈페이지 적립금 사용 시, 즉시 사용 가능하였으나
		 다양한 멤버십 혜택을 제공하기 위하여 누적 적립금 3,000원 이상 보유 시 사용 가능한 시스템으로 변경되었습니다.
		 많은 양해 부탁드립니다.
		감사합니다.
      </div>

      <!-- 버튼 -->
      <div class="notice-button-box">
        <button onclick="location.href='${pageContext.request.contextPath}/page/Notice/noticeList.jsp'">목록</button>
      </div>

    </div>
  </div>
</div>
	
	<%-- [Contents] ######################################################### --%>
	<jsp:include page="/layout/footer.jsp" />
	<jsp:include page="/layout/script.jsp" />
</body>
</html>