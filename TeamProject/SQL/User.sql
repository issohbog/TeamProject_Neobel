DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
	`user_no` INT NOT NULL AUTO_INCREMENT COMMENT '회원고유번호',
	`user_id` VARCHAR(64) NOT NULL COMMENT 'UK/UNIQUE',
	`user_pw` VARCHAR(100) NOT NULL COMMENT '비밀번호',
	`user_name` VARCHAR(50) NOT NULL COMMENT '이름',
	`email` VARCHAR(200) NOT NULL COMMENT '이메일/UNIQUE',
	`phone` VARCHAR(200) NOT NULL COMMENT '휴대폰 번호',
	`birth` DATE NULL COMMENT '생년월일',
	`is_admin` TINYINT NOT NULL DEFAULT 0 COMMENT '관리자1 일반사용자0',
	`addr` VARCHAR(200) NOT NULL COMMENT '주소',
	`post_code` VARCHAR(10) NOT NULL COMMENT '우편번호',
	`req` VARCHAR(100) NULL DEFAULT '조심히 안전하게 와주세요' COMMENT '배송요청사항',
	`addr_detail` VARCHAR(100) NULL COMMENT '상세주소(동,호수)',
	PRIMARY KEY (`user_no`)
);


INSERT INTO users (user_id, user_pw, user_name, email, phone, birth, is_admin, addr, post_code, req, addr_detail)
VALUES ('johndoe', '1234abcd', 'John Doe', 'john@example.com', '010-1234-5678', '1990-01-01', 0, '서울시 강남구 테헤란로 123', '06100', '부재 시 문 앞에 두세요', '101동 202호');
