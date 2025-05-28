<%@ include file="/layout/jstl.jsp" %>
<%@ include file="/layout/common.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<title>neobel 회원가입</title>
	<jsp:include page="/layout/meta.jsp" />
	<jsp:include page="/layout/link.jsp" />

	    <link rel="stylesheet" href="/static/css/join.css" />
	

</head>
<body>

	<jsp:include page="/layout/header.jsp" />

	<%-- [Contents] ######################################################### --%>

    <main>
    	<div class="container my-5">
            <h1 class="fs-4 text-center">회원가입</h1>
            <div class="mt-4 mb-5">
	            <hr>
            </div>
            <form class="my-5" method="post" action="${ root }/join">
           	    <label class="" for="userId">아이디</label>
            	<div class="input-group mb-3">
				  <input type="text" name="userId" class="form-control" placeholder="아이디" aria-label="아이디" aria-describedby="button-addon2">
				  <button class="btn btn-outline-secondary" type="button" id="button-addon2">중복확인</button>
				</div>
				
				<div class="row">
					<div class="col">
					    <label class="" for="userPw">비밀번호</label>
					    <div class="input-group mb-3">
				  			<input type="password" name="userPw" class="form-control" placeholder="비밀번호" aria-label="비밀번호">
				  		</div>
					</div>
					<div class="col">
					    <label class="" for="userPw">비밀번호 확인</label>
					    <div class="input-group mb-3">
				  			<input type="password" name="userPw" class="form-control" placeholder="비밀번호 확인" aria-label="비밀번호 확인">
				  		</div>
					</div>
				</div>
				
				<div class="row">
					<div class="col">
					    <label class="" for="userName">이름</label>
					    <div class="input-group mb-3">
				  			<input type="text" name="userName" class="form-control" placeholder="이름" aria-label="이름">
				  		</div>
					</div>
				</div>
				
				<div class="row">
					<div class="col">
					    <label class="" for="postCode">우편번호</label>
					    <div class="input-group mb-3">
				  			<input type="text" name="postCode" class="form-control" placeholder="우편번호" aria-label="우편번호">
				  		</div>
					</div>
				</div>
				
				<div class="row">
					<div class="col">
					    <label class="" for="addr">주소</label>
					    <div class="input-group mb-3">
				  			<input type="text" name="addr" class="form-control" placeholder="주소" aria-label="주소">
				  		</div>
					</div>
				</div>
				
				<div class="row">
					<div class="col">
					    <label class="" for="addrDetail">상세주소</label>
					    <div class="input-group mb-3">
				  			<input type="text" name="addrDetail" class="form-control" placeholder="상세주소" aria-label="상세주소">
				  		</div>
					</div>
				</div>
				
				<div class="row">
					<div class="col">
					    <label class="" for="req">배송요청사항</label>
					    <div class="input-group mb-3">
				  			<input type="text" name="req" class="form-control" placeholder="배송요청사항" aria-label="배송요청사항">
				  		</div>
					</div>
				</div>
				
				<div class="row">
					<div class="col">
					    <label class="" for="phone1">휴대폰</label>
					    <div class="input-group mb-3">
				  			<input type="text" name="phone1" class="form-control" placeholder="" aria-label="휴대폰1">
				  		</div>
					</div>
					<div class="col">
						<label class="" for="phone2"></label>
					    <div class="input-group mb-3">
				  			<input type="text" name="phone2" class="form-control" placeholder="" aria-label="휴대폰2">
				  		</div>
					</div>
					<div class="col">
						<label class="" for="phone3"></label>
					    <div class="input-group mb-3">
				  			<input type="text" name="phone3" class="form-control" placeholder="" aria-label="휴대폰3">
				  		</div>
					</div>
				</div>
				
				<div class="d-flex align-items-center justify-content-start gap-2">
					<div class="">
					    <label class="" for="birth1">생년월일</label>
					    <div class="input-group mb-3">
				  			<input type="text" name="birth1" class="form-control" placeholder="" aria-label="생년월일">
				  		</div>
					</div>
					<div class="">
						<label class="" for=""></label>
					    <p>년</p>
					</div>
					<div class="">
						<label class="" for="birth2"></label>
					    <div class="input-group mb-3">
				  			<input type="text" name="birth2" class="form-control" placeholder="" aria-label="생년월일">
				  		</div>
					</div>
					<div class="">
						<label class="" for=""></label>
					    <p>월</p>
					</div>
					<div class="">
						<label class="" for="birth3"></label>
					    <div class="input-group mb-3">
				  			<input type="text" name="birth3" class="form-control" placeholder="" aria-label="생년월일">
				  		</div>
					</div>
					<div class="">
						<label class="" for=""></label>
					    <p>일</p>
					</div>
				</div>
				
				
				<div class="d-flex align-items-center justify-content-start gap-2">
					<div class="">
					    <label class="" for="email1">이메일</label>
					    <div class="input-group mb-3">
				  			<input type="text" name="email1" class="form-control" placeholder="" aria-label="이메일1">
				  		</div>
					</div>
					<div class="">
						<label class="" for=""></label>
					    <p class="text-center">@</p>
					</div>
					<div class="">
						<label class="" for="email2"></label>
					    <div class="input-group mb-3">
				  			<input type="text" name="email2" class="form-control" placeholder="" aria-label="이메일2">
				  		</div>
					</div>
					
				</div>
				
				<div class="d-grid gap-2 my-4">
					<button type="submit" class="btn btn-dark">회원가입</button>
	          		<button type="submit" class="btn btn-light">취소</button>
				</div>
            </form>
        </div>
    </main>

	
	<%-- [Contents] ######################################################### --%>
	<jsp:include page="/layout/footer.jsp" />
	<jsp:include page="/layout/script.jsp" />
</body>
</html>












