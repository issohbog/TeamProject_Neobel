<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/layout/common.jsp" %>

<header>
  
  <div class="menu">
     <div class="logo">
    <a href="Main.HTML"><img src="<%= root %>/static/img/네오벨 로고.png" width="278" height="74" alt="NEOBEL 로고"></a>
  </div>
 
  <nav class="nav-menu">
      <a href=""><span>PROMOTION</span></a>
      <a href="productList.jsp"><span>PRODUCT</span></a>
      <a href="브랜드소개"><span>BRAND</span></a>
      <a href="공지사항"><span>ABOUT</span></a>
  </nav>
<ul class="icons">
      <li><a href="#"><span class="material-symbols-outlined" >search</span></a></li>
      
      <li class="person-menu">
        <a href="#"><span class="material-symbols-outlined">person</span></a>
            <ul class="dropdown">
            <li><a href="#">회원가입</a></li>
            <li><a href="#">로그인</a></li>
         </ul>
      </li>

      <li><a href="#"><span class="material-symbols-outlined">local_mall</span></a></li>
      <li><a href="#"><span class="material-symbols-outlined">help</span></a></li>
    </ul>

  </div>
 
</header>