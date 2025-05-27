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
        <div class="notice-subtitle">공지사항 제목</div>
        <div class="notice-date">2025.05.27</div>
      </div>

      <!-- 내용 -->
      <div class="notice-body-box">
        	 <textarea class="notice-textarea" placeholder="공지사항 내용을 입력하세요.">
				
  				</textarea>
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