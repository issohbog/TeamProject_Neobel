/**
 * 
 */

document.addEventListener("DOMContentLoaded", function () {
  const modal = document.getElementById("order-complete-modal");

  // 모달 열기 함수
  window.openModal = function () {
    modal.style.display = "flex";       // 먼저 보여지게 하고 
    setTimeout(() => {
      modal.classList.add("show");      // 트랜지션 시작
    }, 10);   // 약간의 시간차(브라우저 랜더링 타이밍 보장)
  };

  // 모달 닫기 함수
  window.closeModal = function () {
    modal.classList.remove("show");   // 트랜지션 시작( 서서히 사라짐 )
    setTimeout(() => {
      modal.style.display = "none";   // 사라진 후 완전히 숨김
    }, 400);    // 트랜지션 시간과 일치(0.4초)
  };
});

document.getElementById("buy-btn").addEventListener("click", function (e) {
  // 로딩 스피너 표시
  document.getElementById("loading-overlay").style.display = "flex";

  // 0.8초 후에 결제 페이지로 이동
  setTimeout(function () {
    window.location.href = "${pageContext.request.contextPath}/order"; // 결제페이지 URL
  }, 2500);
});
