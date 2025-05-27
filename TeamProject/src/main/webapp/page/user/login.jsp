<%@ include file="/layout/jstl.jsp" %>
<%@ include file="/layout/common.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<title>neobel 로그인</title>
	<jsp:include page="/layout/meta.jsp" />
	<jsp:include page="/layout/link.jsp" />

	    <link rel="stylesheet" href="/static/css/join.css" />
	    <link rel="script" href="/static/js/join.js" />
	

</head>
<body>
	<jsp:include page="/layout/header.jsp" />
	<%-- [Contents] ######################################################### --%>
		


<main class="login">
<section class="login-container">
 	<h1 class="login-title">로그인</h1>
 	<hr class="login-divider" />
 	<form class="login-form" action="/loginServlet" method="post" enctype="application/x-www-form-urlencoded">
 	<div class="form-group">
 		<label for="username">아이디</label>
	 		<div class="input-group">
	 			<input type="text" id="userId" name="userId" placeholder="ID" required />
	 		</div>
	 			<label for="password">비밀번호</label>
		 			<div class="input-group">
		 				<input type="password" id="password" name="password" placeholder="PASSWORD" required />

 			</div>
		 			<div class="login">
		 				<button type="submit" class="btn-login">로그인</button>
		 			</div>
		 			
		 			<!-- 경고 메시지 출력 -->
                    <c:if test="${not empty errorMessage}">
                        <div class="alert alert-danger">
                            ${errorMessage}
                        </div>
                    </c:if>
		 			
		 				<br>
		 				<div class="group-form">
		 				<p><small>
		 					<a href="http://localhost:8080/TeamProject/page/user/searchid.jsp">아이디 찾기</a>
		 				</small>
		 				<small>|</small>
		 				<small>
		 				<a href="http://localhost:8080/TeamProject/page/user/searchpw.jsp">비밀번호 찾기</a></small>
		 				<span style="margin-left: 520px;">
		 				<small><a href="http://localhost:8080/TeamProject/page/user/join.jsp">회원가입</a></small>
		 				</span>
	 			        </div>
		 	</div>
		</form>
	</section>
</main>


	
	<%-- [Contents] ######################################################### --%>
	<jsp:include page="/layout/footer.jsp" />
	<jsp:include page="/layout/script.jsp" />
</body>
</html>