

DROP TABLE IF EXISTS `notice`;

CREATE TABLE `notice` (
	`notice_no` INT NOT NULL AUTO_INCREMENT COMMENT '공지사항고유번호',
	`user_no` INT NOT NULL COMMENT '회원고유번호',
	`title` VARCHAR(100) NOT NULL COMMENT '공지사항제목',
	`content` TEXT NOT NULL COMMENT '공지사항내용',
	`created_at` TIMESTAMP NOT NULL DEFAULT now() COMMENT '공지사항작성일자',
	PRIMARY KEY (`notice_no`),
	FOREIGN KEY (`user_no`) REFERENCES `users`(`user_no`)
);

INSERT INTO notice (user_no, title, content)
VALUES (1, '배송 지연 안내', '설 연휴로 인해 배송이 다소 지연될 수 있습니다. 양해 부탁드립니다.');
