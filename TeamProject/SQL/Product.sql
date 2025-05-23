
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


INSERT INTO products (product_name, image_name, image_path, description, price)
VALUES
('콜라겐 아이패치 부활초 젤리', '콜라겐아이패치 부활초젤리.jpg', 'static/img/콜라겐아이패치 부활초젤리.jpg', '10mm(24매) 2장, 12mm(15매) 2장', 12000),
('콜라겐 아이크림 부활초 튜브', '콜라겐 아이크림 부활초.jpg', 'static/img/콜라겐 아이크림 부활초.jpg', '30ml', 26000),
('에어리 선스틱 스무딩 바 SPF50+ PA++++', '콜라겐 아이크림 부활초.jpg', 'static/img/콜라겐 아이크림 부활초.jpg', '30ml', 26000),
('어성초 흔적 에센스 패드 클리어 터치', '어성초 흔적 에센스 패드.jpg', 'static/img/어성초 흔적 에센스 패드.jpg', '250ml/70pads', 24000),
('어성초 크림 - 미니어쳐 카밍 튜브', '어성초 크림 미니어쳐.jpg', 'static/img/어성초 크림 미니어쳐.jpg', '어성초 크림 카밍 튜브 30ml', 12000),



;






