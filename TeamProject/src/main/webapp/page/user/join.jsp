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
	    <link rel="script" href="/static/js/join.js" />
	

</head>
<body>

	<jsp:include page="/layout/header.jsp" />

	<%-- [Contents] ######################################################### --%>


    <main class="mypage">
      <section class="mypage-container">
        <h1 class="mypage-title">회원가입</h1>
        <hr class="mypage-divider" />
        <form class="mypage-form" name="joinForm">
          <div class="mypage-group">
            <label for="user-id">아이디</label>
            <div class="input-group">
              <input type="text" id="userId" name="user_id" placeholder="ID" required />
              <button type="button" class="btn-checkId" onclick="checkUser()">중복체크</button>

           </div>
            <small>(영문소문자/숫자, 4~16자)</small>
          </div>
          <div class="form-group">
            <label for="password">비밀번호</label>
            <input type="password" id="password" name="password" placeholder="PASSWORD" required />

            <small>(영문 대소문자/숫자/특수문자 중 2가지 이상 조합, 8~16자)</small>
          </div>
          <div class="form-group">
            <label for="password-confirm">비밀번호 확인</label>
            <input type="password" id="password-confirm" name="password-confirm" placeholder="PASSWORD" required />
          </div>
          <div class="form-group">
            <label for="name">이름</label>
            <input type="text" id="name" name="name" placeholder="이름" required />
          </div>
          <div class="form-group">
            <label for="post">우편번호</label>
            <input type="text" id="postal" name="postalnumber" placeholder="우편번호" required />
          </div>
          <div class="form-group">
            <label for="address">주소</label>
            <input type="text" id="address" name="address" placeholder="주소" required />
          </div>
          <div class="form-group">
            <label for="detailed-address">상세주소</label>
            <input type="text" id="detailed-address" name="detailed-address" placeholder="상세주소" required />
          </div>
           <div class="form-group">
             <label for="delivery-message">배송요청사항</label>
             <input type="text" id="delivery-message" name="delivery-message" placeholder="배송요청사항" />
           </div>
          <div class="form-group">
            <label>휴대폰</label>
            <div class="phone-group">
              <input type="tel" id="phone-1" name="phone-1" placeholder="NUMBER 1" required />
              <input type="tel" id="phone-2" name="phone-2" placeholder="NUMBER 2" required />
              <input type="tel" id="phone-3" name="phone-3" placeholder="NUMBER 3" required />
            </div>
          </div>
          <div class="form-group">
            <label>생년월일</label>
            <div class="birth-group">
              <input type="number" id="birth-year" name="birth-year" placeholder="NUMBER 1" required />
              <span>년</span>
              <input type="number" id="birth-month" name="birth-month" placeholder="NUMBER 2" required />
              <span>월</span>
              <input type="number" id="birth-day" name="birth-day" placeholder="NUMBER 3" required />
              <span>일</span>
            </div>
          </div>
          <div class="form-group">
            <label>이메일</label>
            <div class="email-group">
              <input type="text" id="email-id" name="email-id" placeholder="이메일" required />
              <span>@</span>
              <input type="text" id="email-domain" name="email-domain" placeholder="이메일" required />
            </div>
          </div>
          <div class="form-group">
            <label for="referral-code">결제방법</label>
            <input type="text" id="referral-code" name="referral-code" placeholder="결제방법" />
          </div>
          <div class="form-group">
          <button type="submit" class="btn-join">회원가입</button>
          <button type="submit" class="btn-cancel" id="btn-cancel">취소</button>
		  </div>            
          
        </form>
      </section>
    </main>



	
	<%-- [Contents] ######################################################### --%>
	<jsp:include page="/layout/footer.jsp" />
	<jsp:include page="/layout/script.jsp" />
</body>
</html>