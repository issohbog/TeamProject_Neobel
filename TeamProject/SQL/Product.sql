
DROP TABLE IF EXISTS `products`;


CREATE TABLE `products` (
	`product_no` INT NOT NULL AUTO_INCREMENT COMMENT '상품고유번호',
	`product_name` VARCHAR(50) NOT NULL COMMENT '상품명',
	`image_name` VARCHAR(255) NULL COMMENT '상품이미지이름',
	`image_path` VARCHAR(255) NULL COMMENT '상품이미지경로',
	`description` TEXT NULL COMMENT '상품상세설명',
	`price` INT NOT NULL COMMENT '상품가격',
	PRIMARY KEY (`product_no`)
);

TRUNCATE TABLE orders;
TRUNCATE TABLE products;

INSERT INTO products (product_name, image_name, image_path, description, price)
VALUES
('콜라겐 아이패치 부활초 젤리', '콜라겐아이패치 부활초젤리.jpg', 'static/img/콜라겐아이패치 부활초젤리.jpg', '10mm(24매) 2장, 12mm(15매) 2장', 12000),
('콜라겐 아이크림 부활초 튜브', '콜라겐 아이크림 부활초.jpg', 'static/img/콜라겐 아이크림 부활초.jpg', '30ml', 26000),
('에어리 선스틱 스무딩 바 SPF50+ PA++++', '에어리 선스틱 스무딩바.jpg', 'static/img/에어리 선스틱 스무딩바.jpg', '30ml', 26000),
('어성초 흔적 에센스 패드 클리어 터치', '어성초 흔적 에센스 패드.jpg', 'static/img/어성초 흔적 에센스 패드.jpg', '250ml/70pads', 24000),
('어성초 크림 - 미니어쳐 카밍 튜브', '어성초 크림 미니어쳐.jpg', 'static/img/어성초 크림 미니어쳐.jpg', '어성초 크림 카밍 튜브 30ml', 12000),
('어성초 카밍 토너 스킨부스터-미니어쳐', '어성초%20카밍%20토너%20미니어쳐%20스킨부스터.jpg', 'static/img/어성초%20카밍%20토너%20미니어쳐%20스킨부스터.jpg', '어성초 추출물이 함유된 진정용 토너 스킨부스터, 미니어쳐 사이즈.', 23000),
('어성초 에센스 카밍펌프', '어성초 에센스 카밍펌프.jpg', 'static/img/어성초 에센스 카밍펌프.jpg', '진정 효과가 있는 어성초 에센스를 펌프형으로 간편하게 사용.', 27000),
('어성초 선 에센스 카밍드롭 SPF50+ PA++++', '어성초 선 에센스 카밍드롭.jpg', 'static/img/어성초 선 에센스 카밍드롭.jpg', '자외선 차단 기능이 포함된 어성초 카밍 에센스 드롭.', 25000),
('수분초 히알루론 패드 하이드레이팅 터치', '수분초 히알루론 패드 하이드레이팅 터치.jpg', 'static/img/수분초 히알루론 패드 하이드레이팅 터치.jpg', '히알루론산이 함유된 보습용 수분 패드.', 24000),
('부활초 크림 뉴트리션 튜브 - 미니어쳐', '부활초 크림.jpg', 'static/img/부활초 크림.jpg', '영양 공급에 탁월한 부활초 크림, 미니어쳐 튜브형.', 12000),
('부활초 콜라겐 패드 퍼밍 터치', '부활초 콜라겐 패드.jpg', 'static/img/부활초 콜라겐 패드.jpg', '콜라겐 성분이 함유된 퍼밍 케어용 패드.', 15600),
('껌딱지 시트마스크 비타 스티커', '껌딱지 시트마스크 비타 스티커.jpg', 'static/img/껌딱지 시트마스크 비타 스티커.jpg', '비타민 성분이 풍부한 시트 마스크, 1회용.', 4000),
('모델링 크림 마스크 어성초 스쿱', '모델링 크림 마스크 어성초 스쿱.jpg', 'static/img/모델링 크림 마스크 어성초 스쿱.jpg', '75ml / 1EA.', 8000)
;









