<%@ include file="/layout/jstl.jsp" %>
<%@ include file="/layout/common.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<title>neobel 마이페이지</title>
	<jsp:include page="/layout/meta.jsp" />
	<jsp:include page="/layout/link.jsp" />

	    <link rel="stylesheet" href="/static/css/mypage.css" />
	

</head>
<body>

	<jsp:include page="/layout/header.jsp" />

	<%-- [Contents] ######################################################### --%>


    <main>
      <section class="container my-5">
        <h1 class="fs-2 text-center">마이페이지</h1>
        <hr class="mypage-divider" />
        <form id="form" class="mypage-form" method="post" action="${ root }/mypage/update">
          <input type="hidden" name="userNo" value="${user.userNo}" />
		  <div class="mypage-group">
		    <label for="user-id">아이디</label>
		    <div class="input-group">
		      <input type="text" id="user-id" name="userId" value="${user.userId}" class="form-control" placeholder="ID" required />
		      <button type="submit" class="btn btn-outline-secondary">중복확인</button>
		    </div>
		    <small>(영문소문자/숫자, 4~16자)</small>
		  </div>
		
		  <div class="form-group">
		    <label for="password">비밀번호</label>
		    <input type="password" id="password" name="userPw" value="${user.userPw}" class="form-control" placeholder="PASSWORD" required />
		    <small>(영문 대소문자/숫자/특수문자 중 2가지 이상 조합, 8~16자)</small>
		  </div>
		
		  <div class="form-group">
		    <label for="password-confirm">비밀번호 확인</label>
		    <input type="password" id="password-confirm" name="password-confirm" class="form-control" placeholder="PASSWORD"  />
		  </div>
		
		  <div class="form-group">
		    <label for="name">이름</label>
		    <input type="text" id="name" name="userName" value="${user.userName}" class="form-control" placeholder="이름" required />
		  </div>
		
		  <div class="form-group">
		    <label for="post">우편번호</label>
		    <input type="text" id="postal" name="postCode" value="${user.postCode}" class="form-control" placeholder="우편번호" required />
		  </div>
		
		  <div class="form-group">
		    <label for="address">주소</label>
		    <input type="text" id="address" name="addr" value="${user.addr}" class="form-control" placeholder="주소" required />
		  </div>
		
		  <div class="form-group">
		    <label for="detailed-address">상세주소</label>
		    <input type="text" id="detailed-address" name="addrDetail" value="${user.addrDetail}" class="form-control" placeholder="상세주소" required />
		  </div>
		
		  <div class="form-group">
		    <label for="delivery-message">배송요청사항</label>
		    <input type="text" id="delivery-message" name="req" value="${user.req}" class="form-control" placeholder="배송요청사항" />
		  </div>
		
		  <div class="form-group">
		    <label>휴대폰</label>
		    <div class="phone-group d-flex gap-2">
		      <input type="tel" id="phone-1" name="phone1" value="${fn:split(user.phone, '-')[0]}" class="form-control" required />
		      <input type="tel" id="phone-2" name="phone2" value="${fn:split(user.phone, '-')[1]}" class="form-control" required />
		      <input type="tel" id="phone-3" name="phone3" value="${fn:split(user.phone, '-')[2]}" class="form-control" required />
		    </div>
		  </div>
		
		  <div class="form-group">
		    <label>생년월일</label>
		    <div class="birth-group d-flex align-items-center gap-2">
		      <input type="number" id="birth-year" name="birth1" value="${fn:split(user.birth, '-')[0]}" class="form-control" required />
		      <span>년</span>
		      <input type="number" id="birth-month" name="birth2" value="${fn:split(user.birth, '-')[1]}" class="form-control" required />
		      <span>월</span>
		      <input type="number" id="birth-day" name="birth3" value="${fn:split(user.birth, '-')[2]}" class="form-control" required />
		      <span>일</span>
		    </div>
		  </div>
		
		  <div class="form-group">
		    <label>이메일</label>
		    <div class="email-group d-flex gap-2 align-items-center">
		      <input type="text" id="email-id" name="email1" value="${fn:split(user.email, '@')[0]}" class="form-control" placeholder="이메일" required />
		      <span>@</span>
		      <input type="text" id="email-domain" name="email2" value="${fn:split(user.email, '@')[1]}" class="form-control" placeholder="도메인" required />
		    </div>
		  </div>
		
		  <div class="form-group">
		    <label for="referral-code">결제방법</label>
		    <input type="text" id="referral-code" name="referral-code" class="form-control" placeholder="결제방법" />
		  </div>
		
		  
		  <div class="d-grid gap-2 my-4">
				<button type="submit" class="btn btn-dark">저장</button>
         		<button type="button" class="btn btn-danger" id="btn-delete">탈퇴</button>
			</div>
		</form>


      </section>
    </main>



	
	<%-- [Contents] ######################################################### --%>
	<jsp:include page="/layout/footer.jsp" />
	<jsp:include page="/layout/script.jsp" />
	
	
	<script>
	    const form = $('#form');
	    
		$('#btn-delete').on('click', function() {
            if (confirm('정말로 탈퇴하시겠습니까?')) {
                form.attr('action', '${root}/mypage/delete');
                form.submit();
            }
        });
	</script>
</body>
</html>














