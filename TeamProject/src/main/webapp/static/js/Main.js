/**
 * 
 */
 const slides = document.querySelectorAll('#slides .slide, #slides .slide_active');
  let currentIndex = 0;

  setInterval(() => {
    slides[currentIndex].classList.remove('slide_active');
    currentIndex = (currentIndex + 1) % slides.length;
    slides[currentIndex].classList.add('slide_active');
  }, 3000); 

//드롭다운 메뉴

    const personMenu = document.querySelector('.person-menu > a');
const dropdown = document.querySelector('.person-menu .dropdown');

personMenu.addEventListener('click', (e) => {
  e.preventDefault();
  const isVisible = dropdown.style.display === 'block';
  // 토글
  dropdown.style.display = isVisible ? 'none' : 'block';
});

// 페이지 아무곳 클릭 시 드롭다운 닫기
document.addEventListener('click', (e) => {
  if (!e.target.closest('.person-menu')) {
    dropdown.style.display = 'none';
  }
});

const slider = document.getElementById('slider');

let isDragging = false;
let startX;
let scrollLeft;

slider.addEventListener('mousedown', (e) => {
  isDragging = true;
  startX = e.pageX - slider.offsetLeft;
  scrollLeft = slider.scrollLeft;
  slider.style.cursor = 'grabbing';
});

slider.addEventListener('mouseleave', () => {
  isDragging = false;
  slider.style.cursor = 'grab';
});

slider.addEventListener('mouseup', () => {
  isDragging = false;
  slider.style.cursor = 'grab';
});

slider.addEventListener('mousemove', (e) => {
  if (!isDragging) return;
  e.preventDefault();
  const x = e.pageX - slider.offsetLeft;
  const walk = (x - startX) * 1.5; // 드래그 민감도
  slider.scrollLeft = scrollLeft - walk;
});