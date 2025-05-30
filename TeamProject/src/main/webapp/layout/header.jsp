<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/layout/common.jsp" %>

<header>
  
  <div class="menu">
     <div class="logo">
    <a href="${pageContext.request.contextPath}/index.jsp"><img src="<%= root %>/static/img/네오벨 로고.png" width="278" height="74" alt="NEOBEL 로고"></a>
  </div>
 
  <nav class="nav-menu">
      <a href="${ root }/product"><span>PROMOTION</span></a>
      <a href="${ root }/product"><span>PRODUCT</span></a>
      <a href="${pageContext.request.contextPath}/page/Brand/brand.jsp"><span>BRAND</span></a>
      <a href="${pageContext.request.contextPath}/page/Notice/noticeList.jsp"><span>ABOUT</span></a>
  </nav>
<ul class="icons">
      <li><a href="#"><span class="material-symbols-outlined" >search</span></a></li>
      
      <li class="person-menu">
	      <%	
	          if( session.getAttribute("loginUser") != null ) {
	      %>
          <a href="#"><span class="material-symbols-outlined">person</span></a>
          <ul class="dropdown">
            <li><a href="${ root }/mypage">마이페이지</a></li>
            <li><a href="${ root }/logout">로그아웃</a></li>
          </ul>
          <%
             } else {
          %>
          <a href="#"><span class="material-symbols-outlined">person</span></a>
          <ul class="dropdown">
            <li><a href="${ root }/join">회원가입</a></li>
            <li><a href="${ root }/login">로그인</a></li>
          </ul>
            <%
                 }
            %>
<!--       	<a href="#"><span class="material-symbols-outlined">person</span></a> -->
<!--         <ul class="dropdown"> -->
<%--             <li><a href="${ root }/join">회원가입</a></li> --%>
<%--             <li><a href="${ root }/login">로그인</a></li> --%>
<!--         </ul> -->
      </li>




<%--       <li><a href="${pageContext.request.contextPath}/page/cart/cart.jsp"><span class="material-symbols-outlined">local_mall</span></a></li> --%>
<li><a href="${ root }/cart"><span class="material-symbols-outlined">local_mall</span></a></li>



      <li><a href="#"><span class="material-symbols-outlined">help</span></a></li>
    </ul>

  </div>
 
</header>