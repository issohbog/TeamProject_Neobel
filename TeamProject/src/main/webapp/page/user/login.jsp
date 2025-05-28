<%@ include file="/layout/jstl.jsp" %>
<%@ include file="/layout/common.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
    
    <%
	request.setCharacterEncoding("UTF-8");
	Integer result = (Integer) session.getAttribute("result");
%>


<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<c:set var="user_id" value="${param.user_id}" />


<!DOCTYPE html>
<html>
<head>
	<title>neo-로그인</title>
	<jsp:include page="/layout/meta.jsp" />
	<jsp:include page="/layout/link.jsp" />
	<link rel="stylesheet" href="/static/css/login.css" />
		
	<script type="text/javascript">
	function sendCheckValue() {
		var openJoinfrm = opener.document.joinForm;
		
		if (document.checkIdForm.chResult.value=="N") {
			alert("다른 아이디를 입력해주세요.");
			openJoinfrm.id.focus();
			
			window.close();
		}else {
			// 중복체크 결과인 idCheck 값을 전달
			openJoinfrm.idDuplication.value="idCheck";
			openJoinfrm.dbCheckId.disabled=true;
			openJoinfrm.dbCheckId.style.opacity=0.6;
			openJoinfrm.dbCheckId.style.cursor="default";
			window.close();
		}
		
	}
	</script>
    
</head>
<body>
	<jsp:include page="/layout/header.jsp" />
	<%-- [Contents] ######################################################### --%>

	<main class="login">
		<section class="container my-5">
		 	<h1 class="text-center fs-2">로그인</h1>
		 	<hr class="login-divider" />
		 	<form class="login-form" action="${ root }/login" method="post">
			 	<div class="form-group">
						<div class="input-group my-3">
							<input type="text" class="form-control" id="userId" name="userId" placeholder="ID"
								required />
						</div>
						<div class="input-group my-3">
							<input type="password" class="form-control" id="userPw" name="userPw"
								placeholder="userPw" required />
						</div>
						<div class="d-grid gap-2 my-3">
							<button type="submit" class="btn btn-dark">로그인</button>
						</div>
						<br>
						<div class="d-flex justify-content-between align-items-center mb-5">
							<div>
								<small> 
									<a href="http://localhost:8080/TeamProject/page/user/searchid.jsp">아이디 찾기</a>
								</small> 
								<small>|</small> 
								<small> 
									<a href="http://localhost:8080/TeamProject/page/user/searchpw.jsp">비밀번호 찾기</a>
								</small> 
							</div>
							<div>
								<span> 
									<small>
										<a href="http://localhost:8080/TeamProject/page/user/join.jsp">회원가입</a>
									</small>
								</span>
							</div>
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