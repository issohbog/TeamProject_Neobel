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
		
	<main class="notice-page">
    <section class="notice-box">
      <h1>공지사항</h1>
      <div class="title">
      	<p class="subtitle">SUBTITLE</p>
     	 <p class="title-date">DATE</p>
      </div>
      
      <div class="notice-list">
        <!-- 예시 목록 -->
        <div class="notice-item">
          <span class="subject"><a href="${pageContext.request.contextPath}/page/Notice/NoticeDetail.jsp">배송지 정책 변경 안내</a></span>
          <span class="date">2025-05-27</span>
        </div>
        <div class="notice-item">
          <span class="subject"><a href="${pageContext.request.contextPath}/page/Notice/NoticeDetail.jsp">네오벨 온라인 공식 판매처 안내</a></span>
          <span class="date">2025-05-25</span>
        </div>
        <!-- 추가 항목들 -->
      </div>
    </section>
  </main>
	
	
	<%-- [Contents] ######################################################### --%>
	<jsp:include page="/layout/footer.jsp" />
	<jsp:include page="/layout/script.jsp" />
</body>
</html>