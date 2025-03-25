--	
-- project_artU.sql	
--	
-- Project of group1 in Fullstack course at TJ Academy	
--	
-- memebers: 고현, 김기원, 서미란, 이상혁, 이수정, 황보영
--	
-- title: ArtU _ 공연플랫폼	
--	
-- 프로젝트 내 서비스 소개:	
--	
--	
	
-- 새로운 데이터베이스 생성	
DROP SCHEMA IF EXISTS artu;	
CREATE SCHEMA artu DEFAULT CHARACTER SET utf8mb4;	
	
-- Role 생성	
DROP ROLE IF EXISTS 'dev_role';	
DROP ROLE IF EXISTS 'user_role'; -- 있으면 삭제하고	
CREATE ROLE 'dev_role'; -- 새롭게 또는 다시 만든다.	
CREATE ROLE 'user_role';	
	
-- 권한을 Role에 부여	
GRANT SELECT, INSERT, UPDATE, DELETE, CREATE, ALTER, DROP, TRIGGER ON artu.* TO 'dev_role';	
GRANT SELECT, INSERT, UPDATE, DELETE, TRIGGER ON artu.* TO 'user_role';	
	
-- 개발자 계정 생성, 역할할당, 권한부여	
DROP USER IF EXISTS 'artu_dev'@'localhost'; -- 사용자 계정 삭제 (기존 계정이 존재하면 삭제)	
CREATE USER 'artu_dev'@'localhost' IDENTIFIED BY 'mysql'; -- 개발자 계정 생성	
GRANT 'dev_role' TO 'artu_dev'@'localhost'; -- 'dev_role'을 'artu_dev'에 부여	
SET DEFAULT ROLE 'dev_role' TO 'artu_dev'@'localhost'; -- 'artu_dev'에 대해 'dev_role'을 기본 역할로 설정	
FLUSH PRIVILEGES;	
	
-- 유저 계정 생성, 역할할당, 권한부여	
DROP USER IF EXISTS 'artu_user'@'localhost'; -- 사용자 계정 삭제 (기존 계정이 존재하면 삭제)	
CREATE USER 'artu_user'@'localhost' IDENTIFIED BY 'mysql'; -- 일반 사용자 계정 생성	
GRANT 'user_role' TO 'artu_user'@'localhost'; -- 'user_role'을 'artu_user'에 부여	
SET DEFAULT ROLE 'user_role' TO 'artu_user'@'localhost'; -- 권한을 설정하고 활성화	
FLUSH PRIVILEGES;	
	
	
-- 데이터베이스 사용	
USE artu;	
	
--	
-- Table structure for table `users`	
-- 회원DB	
--	
CREATE TABLE users	
(	
user_id VARCHAR(50) PRIMARY KEY, -- 회원가입에서의 아이디가 곧 pk값이 된다.	
user_email VARCHAR(100) NOT NULL UNIQUE,	
password VARCHAR(255) NOT NULL,	
user_name VARCHAR(50) NOT NULL,	
user_birth DATE NOT NULL,	
gender ENUM ('M', 'F') NOT NULL,	
created_at timestamp DEFAULT CURRENT_TIMESTAMP,	
is_used BOOLEAN DEFAULT TRUE NOT NULL, -- 탈퇴시 boolea은 false가 되고, dropout_at에 탈퇴시점이 적힌다.	
dropout_at timestamp NULL	
);	
	
CREATE TABLE userlogin_logs	
(	
log_id INT AUTO_INCREMENT PRIMARY KEY,	
user_id VARCHAR(50) NOT NULL,	
login_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,	
ip_address VARCHAR(45),	
user_agent TEXT,
is_used BOOLEAN DEFAULT TRUE NOT NULL,
FOREIGN KEY (user_id) REFERENCES users (user_id) ON DELETE CASCADE	
);	
	
	
CREATE TABLE password_change_histories	
(	
change_id INT PRIMARY KEY AUTO_INCREMENT,	
user_id VARCHAR(50) NOT NULL,	
old_pw VARCHAR(255) NOT NULL,	
changed_at timestamp DEFAULT CURRENT_TIMESTAMP,	
is_used BOOLEAN DEFAULT TRUE NOT NULL,
FOREIGN KEY (user_id) REFERENCES users (user_id) ON DELETE CASCADE	
);	
	
	
CREATE TABLE categories	
(	
ctgr_id TINYINT PRIMARY KEY AUTO_INCREMENT,	
ctgr_name VARCHAR(50) NOT NULL,	
is_used_main BOOLEAN NOT NULL, -- true여야지만 사용할 수 있게 로직짜기	
is_used_oneday BOOLEAN NOT NULL -- true여야지만 사용할 수 있게 로직짜기	
);	
	
	
CREATE TABLE user_interests	
(	
user_id VARCHAR(50) NOT NULL,	
ctgr_id TINYINT NOT NULL,	
interest_order INT NOT NULL, -- 순서 천단위로 넣고 디폴트를 설정한다. 그리고 순서를 바꾸면1001로 설정하는 방식으로 만든다.	
is_used BOOLEAN DEFAULT TRUE NOT NULL,
PRIMARY KEY (user_id, ctgr_id),	
FOREIGN KEY (user_id) REFERENCES users (user_id) ON DELETE CASCADE,	
FOREIGN KEY (ctgr_id) REFERENCES categories (ctgr_id)	
);	
	
	
CREATE TABLE rents	
(	
rt_id INT PRIMARY KEY AUTO_INCREMENT,	
user_id VARCHAR(50) NOT NULL, -- 만든사람	
rt_name VARCHAR(50) NOT NULL,	
rt_address VARCHAR(50) NOT NULL,	
rt_capacity INT NOT NULL, -- 가용인원	
rt_info VARCHAR(255) NOT NULL, -- 왜 필요하지??	
created_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,	
is_used BOOLEAN DEFAULT TRUE NOT NULL,
FOREIGN KEY (user_id) REFERENCES users (user_id) ON DELETE CASCADE	
);	
	
	
CREATE TABLE events	
(	
event_id INT PRIMARY KEY AUTO_INCREMENT,	
ctgr_id TINYINT NOT NULL,	
title VARCHAR(100) NOT NULL,	
location VARCHAR(50) NULL,	
company VARCHAR(50) NOT NULL, -- 주최사	
address VARCHAR(100) NOT NULL,	
age_limit ENUM ('0', '12', '15', '19') DEFAULT '0' NOT NULL,	
how_long INT NOT NULL,	
is_approved BOOLEAN DEFAULT FALSE NOT NULL, -- 관리자 승인 여부	
is_used BOOLEAN DEFAULT TRUE NOT NULL, -- 삭제 여부	
user_id VARCHAR(50) NOT NULL,	
FOREIGN KEY (ctgr_id) REFERENCES categories (ctgr_id),	
FOREIGN KEY (user_id) REFERENCES users (user_id) ON DELETE CASCADE	
);	
	
	
CREATE TABLE chatrooms	
(	
chat_id INT PRIMARY KEY AUTO_INCREMENT,	
is_private BOOLEAN NOT NULL, -- false면 관련 이벤트related_event가 무엇인지 적어야함	
related_event INT NULL,	
created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,	
is_used BOOLEAN DEFAULT TRUE NOT NULL,	
FOREIGN KEY (related_event) REFERENCES events (event_id)	
);	
	
	
CREATE TABLE user_enter_chatroom (	
chat_id INT NOT NULL,	
user_id VARCHAR(50) NOT NULL, -- 만든사람	
entered_at TIMESTAMP NOT NULL,	
is_used BOOLEAN DEFAULT TRUE NOT NULL,
PRIMARY KEY (chat_id, user_id),	
FOREIGN KEY (chat_id) REFERENCES chatrooms (chat_id),	
FOREIGN KEY (user_id) REFERENCES users (user_id)	
);	
	
	
CREATE TABLE messages	
(	
msg_id INT PRIMARY KEY AUTO_INCREMENT,	
writer VARCHAR(50) NOT NULL,	
chatroom_id INT NOT NULL,	
msg_body TEXT NOT NULL,	
created_at timestamp NOT NULL,	
is_checked BOOLEAN DEFAULT FALSE NOT NULL, -- entered_at(user_enter_chatroom)와 created_at를 비교	
is_used BOOLEAN DEFAULT TRUE NOT NULL,
FOREIGN KEY (writer) REFERENCES users (user_id),	
FOREIGN KEY (chatroom_id) REFERENCES chatrooms (chat_id)	
);	
	
	
CREATE TABLE search_words	
(	
key_id INT PRIMARY KEY AUTO_INCREMENT,	
keyword VARCHAR(50) NOT NULL,	
user_id VARCHAR(50) NOT NULL,	
search_at timestamp DEFAULT CURRENT_TIMESTAMP,	
is_used BOOLEAN DEFAULT TRUE NOT NULL,
FOREIGN KEY (user_id) REFERENCES users (user_id)	
);	
	
CREATE TABLE hashtags	
(	
tag_id INT PRIMARY KEY AUTO_INCREMENT,	
tagword VARCHAR(50) NOT NULL,	
user_id VARCHAR(50) NOT NULL,	
created_in timestamp DEFAULT CURRENT_TIMESTAMP,	
is_used BOOLEAN DEFAULT TRUE NOT NULL,
FOREIGN KEY (user_id) REFERENCES users (user_id)	
);	
	
	
CREATE TABLE user_settings	
(	
setting_id INT PRIMARY KEY AUTO_INCREMENT,	
user_id VARCHAR(50) NOT NULL,	
display_color ENUM ('Light', 'Dark') DEFAULT 'Light',	
language ENUM ('System', 'English', 'Korean') DEFAULT 'System',	
set_at timestamp DEFAULT CURRENT_TIMESTAMP,	
is_used BOOLEAN DEFAULT TRUE NOT NULL,
FOREIGN KEY (user_id) REFERENCES users (user_id) ON DELETE CASCADE	
);	
	
	
CREATE TABLE user_follow	
(	
follower_id VARCHAR(50) NOT NULL,	
followee_id VARCHAR(50) NOT NULL,	
followed_at timestamp DEFAULT CURRENT_TIMESTAMP,	
is_used BOOLEAN DEFAULT TRUE NOT NULL,
PRIMARY KEY (follower_id, followee_id),	
FOREIGN KEY (follower_id) REFERENCES users (user_id) ON DELETE CASCADE,	
FOREIGN KEY (followee_id) REFERENCES users (user_id) ON DELETE CASCADE	
);	
	
	
CREATE TABLE user_img	
(	
prf_img_id INT PRIMARY KEY AUTO_INCREMENT,	
prf_img_url VARCHAR(255) NOT NULL,	
user_id VARCHAR(50) NOT NULL,	
create_at timestamp DEFAULT CURRENT_TIMESTAMP,	
is_used BOOLEAN DEFAULT TRUE NOT NULL,
FOREIGN KEY (user_id) REFERENCES users (user_id) ON DELETE CASCADE	
);	
	
	
CREATE TABLE widgets	
(	
widget_id INT PRIMARY KEY AUTO_INCREMENT,	
user_id VARCHAR(50) NOT NULL,	
widget_size INT NOT NULL, -- 타입 int 맞나?	
widget_is_used BOOLEAN NOT NULL,	
widget_theme ENUM ('Light', 'Dark') DEFAULT 'Light',	
is_used BOOLEAN DEFAULT TRUE NOT NULL,
FOREIGN KEY (user_id) REFERENCES users (user_id)	
);	
	
	
CREATE TABLE widget_details	
(	
user_id VARCHAR(50) NOT NULL,	
widget_id INT NOT NULL,	
info_name VARCHAR(50) NOT NULL,	
widget_json JSON NULL,	
is_used BOOLEAN DEFAULT TRUE NOT NULL,
PRIMARY KEY (user_id, widget_id),	
FOREIGN KEY (user_id) REFERENCES users (user_id),	
FOREIGN KEY (widget_id) REFERENCES widgets (widget_id)	
);	
	
	
CREATE TABLE postings	
(	
post_id INT PRIMARY KEY AUTO_INCREMENT,	
user_id VARCHAR(50) NOT NULL,	
contents TEXT NOT NULL,	
location_tag VARCHAR(255) NULL, -- 해시태그 테이블에 있는지 확인 후 없으면 create	
person_tag_id VARCHAR(50) NULL,	
visibility_type ENUM ('All', 'Friends', 'Private') DEFAULT 'All',	
created_at timestamp DEFAULT CURRENT_TIMESTAMP,	
edit_at timestamp NULL,	
is_used BOOLEAN DEFAULT TRUE NOT NULL,
FOREIGN KEY (user_id) REFERENCES users (user_id) ON DELETE CASCADE,	
FOREIGN KEY (person_tag_id) REFERENCES users (user_id) ON DELETE CASCADE	
);	
	
CREATE TABLE posting_images -- 영상 올릴 수 있게 합시당!!!	
(	
img_id INT PRIMARY KEY AUTO_INCREMENT,	
post_id INT NOT NULL,	
img_order INT NOT NULL, -- 여러장일 때 순서	
img_url VARCHAR(255) NOT NULL,	
created_at timestamp DEFAULT CURRENT_TIMESTAMP,	
is_used BOOLEAN DEFAULT TRUE NOT NULL,
FOREIGN KEY (post_id) REFERENCES postings (post_id) ON DELETE CASCADE	
);	
	
CREATE TABLE posting_comments	
(	
comment_id INT PRIMARY KEY AUTO_INCREMENT,	
user_id VARCHAR(50) NOT NULL,	
post_id INT NOT NULL,	
contents TEXT NOT NULL,	
created_at timestamp DEFAULT CURRENT_TIMESTAMP,	
is_used BOOLEAN DEFAULT TRUE NOT NULL,
FOREIGN KEY (user_id) REFERENCES users (user_id) ON DELETE CASCADE,	
FOREIGN KEY (post_id) REFERENCES postings (post_id) ON DELETE CASCADE	
);	
	
CREATE TABLE posting_like	
(	
user_id VARCHAR(50) NOT NULL,	
post_id INT NOT NULL,	
liked_at timestamp DEFAULT CURRENT_TIMESTAMP,	
is_used BOOLEAN DEFAULT TRUE NOT NULL,
PRIMARY KEY (user_id, post_id),	
FOREIGN KEY (user_id) REFERENCES users (user_id) ON DELETE CASCADE,	
FOREIGN KEY (post_id) REFERENCES postings (post_id) ON DELETE CASCADE	
);	
	
	
CREATE TABLE funding_categories	
(	
ctgr_id INT PRIMARY KEY AUTO_INCREMENT,	
ctgr_name VARCHAR(50) NOT NULL,	
ctgr_contents VARCHAR(255) NOT NULL,
is_used BOOLEAN DEFAULT TRUE NOT NULL
);	
	
	
CREATE TABLE fundings	
(	
fd_id INT PRIMARY KEY AUTO_INCREMENT,	
user_id VARCHAR(50) NOT NULL,	
ctgr_id INT NOT NULL,	
fd_title VARCHAR(150) NOT NULL,	
fd_goal_amount INT NOT NULL,	
created_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,	
fd_start_at timestamp NOT NULL,	
fd_end_at timestamp NOT NULL,	
is_approved BOOLEAN NOT NULL DEFAULT FALSE,	
is_used BOOLEAN DEFAULT TRUE NOT NULL,	
FOREIGN KEY (user_id) REFERENCES users (user_id) ON DELETE CASCADE,	
FOREIGN KEY (ctgr_id) REFERENCES funding_categories (ctgr_id) ON DELETE CASCADE	
);	
	
	
CREATE TABLE funding_options	
(	
opt_id INT PRIMARY KEY AUTO_INCREMENT,	
fd_id INT NOT NULL,	
opt_name VARCHAR(50) NOT NULL,	
extra_fee INT NOT NULL,	
is_used BOOLEAN DEFAULT TRUE NOT NULL,
FOREIGN KEY (fd_id) REFERENCES fundings (fd_id) ON DELETE CASCADE	
);	
	
	
CREATE TABLE funding_images	
(	
fd_img_id INT PRIMARY KEY AUTO_INCREMENT,	
fd_id INT NOT NULL,	
fd_img_url VARCHAR(255) NOT NULL,	
fd_img_order INT NOT NULL,	
created_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,	
is_used BOOLEAN DEFAULT TRUE NOT NULL,
FOREIGN KEY (fd_id) REFERENCES fundings (fd_id) ON DELETE CASCADE	
);	
	
CREATE TABLE funding_detail_images -- 상세 정보를 이미지로 받는다.	
(	
img_id INT PRIMARY KEY AUTO_INCREMENT,	
fd_id INT NOT NULL,	
img_url VARCHAR(255) NOT NULL,	
img_order INT NOT NULL,	
created_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,	
is_used BOOLEAN DEFAULT TRUE NOT NULL,
FOREIGN KEY (fd_id) REFERENCES fundings (fd_id) ON DELETE CASCADE	
);	
	
CREATE TABLE user_funding_likes	
(	
fd_id INT NOT NULL,	
user_id VARCHAR(50) NOT NULL,	
created_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,	
is_used BOOLEAN DEFAULT TRUE NOT NULL,
PRIMARY KEY (fd_id, user_id),	
FOREIGN KEY (fd_id) REFERENCES fundings (fd_id) ON DELETE CASCADE,	
FOREIGN KEY (user_id) REFERENCES users (user_id) ON DELETE CASCADE	
);	
	
	
CREATE TABLE user_funding_bmarks	
(	
fd_id INT NOT NULL,	
user_id VARCHAR(50) NOT NULL,	
created_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,	
is_used BOOLEAN DEFAULT TRUE NOT NULL,
PRIMARY KEY (fd_id, user_id),	
FOREIGN KEY (fd_id) REFERENCES fundings (fd_id) ON DELETE CASCADE,	
FOREIGN KEY (user_id) REFERENCES users (user_id) ON DELETE CASCADE	
);	
	
	
CREATE TABLE funding_reviews	
(	
review_id INT PRIMARY KEY AUTO_INCREMENT,	
fd_id INT NOT NULL,	
user_id VARCHAR(50) NOT NULL,	
rate INT NOT NULL,	
contents TEXT NOT NULL,	
is_used BOOLEAN NOT NULL DEFAULT TRUE,	
created_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,	
FOREIGN KEY (fd_id) REFERENCES fundings (fd_id) ON DELETE CASCADE,	
FOREIGN KEY (user_id) REFERENCES users (user_id) ON DELETE CASCADE	
);	
	
CREATE TABLE funding_review_images	
(	
img_id INT PRIMARY KEY AUTO_INCREMENT,	
user_id VARCHAR(50) NOT NULL,	
img_url VARCHAR(255) NOT NULL,	
created_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,	
is_used BOOLEAN DEFAULT TRUE NOT NULL,
FOREIGN KEY (user_id) REFERENCES users (user_id) ON DELETE CASCADE	
);	
	
	
CREATE TABLE rent_detail_images	
(	
img_id INT PRIMARY KEY AUTO_INCREMENT,	
rt_id INT NOT NULL,	
img_url VARCHAR(255) NOT NULL,	
img_order INT NOT NULL,	
user_id VARCHAR(50) NOT NULL,	
created_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,	
is_used BOOLEAN DEFAULT TRUE NOT NULL,
FOREIGN KEY (rt_id) REFERENCES rents (rt_id) ON DELETE CASCADE,	
FOREIGN KEY (user_id) REFERENCES users (user_id) ON DELETE CASCADE	
);	
	
CREATE TABLE rent_dates	
(	
rt_date_id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,	
rt_id INT NOT NULL,	
rt_date timestamp NOT NULL,	
rt_price INT NOT NULL,	
is_used BOOLEAN DEFAULT TRUE NOT NULL,
FOREIGN KEY (rt_id) REFERENCES rents (rt_id)	
);	
	
CREATE TABLE rent_item_options	
(	
opt_id INT PRIMARY KEY AUTO_INCREMENT,	
rt_id INT NOT NULL,	
opt_name VARCHAR(50) NOT NULL,	
extra_fee INT NOT NULL,	
is_used BOOLEAN DEFAULT TRUE NOT NULL,
FOREIGN KEY (rt_id) REFERENCES rents (rt_id) ON DELETE CASCADE	
);	
	
CREATE TABLE rent_rooms	
(	
room_id INT PRIMARY KEY AUTO_INCREMENT,	
rt_id INT NOT NULL,	
room_name VARCHAR(100) NOT NULL,	
price_per_unit INT NOT NULL,	
rt_unit ENUM ('hour', 'day') NOT NULL,	
ctgr VARCHAR(255) NOT NULL,	
min_time TINYINT NOT NULL,	
is_used BOOLEAN DEFAULT TRUE NOT NULL,
FOREIGN KEY (rt_id) REFERENCES rents (rt_id) ON DELETE CASCADE	
);	
	
CREATE TABLE rent_images	
(	
rt_img_id INT PRIMARY KEY AUTO_INCREMENT,	
rt_id INT NOT NULL,	
img_order INT NULL,	
img_url VARCHAR(255) NOT NULL,	
created_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,	
is_used BOOLEAN DEFAULT TRUE NOT NULL,
FOREIGN KEY (rt_id) REFERENCES rents (rt_id) ON DELETE CASCADE	
);	
	
	
CREATE TABLE user_rent_likes	
(	
user_id VARCHAR(50) NOT NULL,	
rt_id INT NOT NULL,	
created_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
is_used BOOLEAN DEFAULT TRUE NOT NULL,	
PRIMARY KEY (user_id, rt_id),	
FOREIGN KEY (rt_id) REFERENCES rents (rt_id) ON DELETE CASCADE,	
FOREIGN KEY (user_id) REFERENCES users (user_id) ON DELETE CASCADE	
);	
	
	
CREATE TABLE user_rent_bmarks	
(	
user_id VARCHAR(50) NOT NULL,	
rt_id INT NOT NULL,	
created_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
is_used BOOLEAN DEFAULT TRUE NOT NULL,	
PRIMARY KEY (user_id, rt_id),	
FOREIGN KEY (rt_id) REFERENCES rents (rt_id) ON DELETE CASCADE,	
FOREIGN KEY (user_id) REFERENCES users (user_id) ON DELETE CASCADE	
);	
	
	
CREATE TABLE rent_reviews	
(	
review_id INT PRIMARY KEY AUTO_INCREMENT,	
rt_id INT NOT NULL,	
user_id VARCHAR(50) NOT NULL,	
rate int NOT NULL,	
contents TEXT NULL,	
is_used BOOLEAN NOT NULL DEFAULT TRUE,	
created_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,	
FOREIGN KEY (rt_id) REFERENCES rents (rt_id) ON DELETE CASCADE,	
FOREIGN KEY (user_id) REFERENCES users (user_id) ON DELETE CASCADE	
);	
	
CREATE TABLE rent_review_images	
(	
img_id INT PRIMARY KEY AUTO_INCREMENT,	
user_id VARCHAR(50) NOT NULL,	
img_url VARCHAR(255) NOT NULL,	
created_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,	
is_used BOOLEAN DEFAULT TRUE NOT NULL,
FOREIGN KEY (user_id) REFERENCES users (user_id) ON DELETE CASCADE	
);	
	
	
CREATE TABLE oneday_classes	
(	
od_id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,	
tchr_id VARCHAR(50) NOT NULL, -- 원데이 개설자	
od_name VARCHAR(100) NOT NULL,	
ctgr_id TINYINT NOT NULL,	
location VARCHAR(50) NOT NULL,	
address VARCHAR(255) NOT NULL,	
min_mem INT NOT NULL,	
max_mem INT NOT NULL,	
is_aproved BOOLEAN NOT NULL,	
is_used BOOLEAN DEFAULT TRUE NOT NULL,	
FOREIGN KEY (ctgr_id) REFERENCES categories (ctgr_id),	
FOREIGN KEY (tchr_id) REFERENCES users (user_id)	
);	
	
	
CREATE TABLE oneday_dates	
(	
date_id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,	
od_id INT NOT NULL,	
od_price INT NOT NULL,	
od_date timestamp NOT NULL,	
is_used BOOLEAN DEFAULT TRUE NOT NULL,	
FOREIGN KEY (od_id) REFERENCES oneday_classes (od_id)	
);	
	
CREATE TABLE oneday_images	
(	
img_id INT AUTO_INCREMENT PRIMARY KEY,	
od_id INT NOT NULL,	
img_url VARCHAR(255) NOT NULL UNIQUE,	
img_order INT NOT NULL,	
created_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,	
is_used BOOLEAN DEFAULT TRUE NOT NULL,
FOREIGN KEY (od_id) REFERENCES oneday_classes (od_id)	
);	
	
	
CREATE TABLE oneday_detail_images	
(	
img_id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,	
od_id INT NOT NULL,	
img_url VARCHAR(255) NOT NULL UNIQUE,	
img_order INT NOT NULL,	
created_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,	
is_used BOOLEAN DEFAULT TRUE NOT NULL,
FOREIGN KEY (od_id) REFERENCES oneday_classes (od_id)	
);	
	
	
CREATE TABLE oneday_options	
(	
opt_id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,	
date_id INT NOT NULL,	
opt_name VARCHAR(100) NOT NULL,	
opt_price INT NOT NULL,	
created_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,	
is_used BOOLEAN DEFAULT TRUE NOT NULL,
FOREIGN KEY (date_id) REFERENCES oneday_dates (date_id)	
);	
	
	
CREATE TABLE oneday_reviews	
(	
review_id INT PRIMARY KEY AUTO_INCREMENT,	
user_id VARCHAR(50) NOT NULL,	
od_id INT NOT NULL,	
contents TEXT NULL,	
rate int NOT NULL,	
is_used BOOLEAN NOT NULL DEFAULT TRUE,	
created_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,	
FOREIGN KEY (user_id) REFERENCES users (user_id),	
FOREIGN KEY (od_id) REFERENCES oneday_classes (od_id)	
);	
	
CREATE TABLE oneday_review_images	
(	
img_id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,	
img_url VARCHAR(255) NULL UNIQUE,	
user_id VARCHAR(50) NOT NULL,	
created_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,	
is_used BOOLEAN DEFAULT TRUE NOT NULL,
FOREIGN KEY (user_id) REFERENCES users (user_id)	
);	
	
CREATE TABLE user_oneday_bmarks	
(	
user_id VARCHAR(50) NOT NULL,	
od_id INT NOT NULL,	
created_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,	
is_used BOOLEAN DEFAULT TRUE NOT NULL,
PRIMARY KEY (user_id, od_id),	
FOREIGN KEY (user_id) REFERENCES users (user_id),	
FOREIGN KEY (od_id) REFERENCES oneday_classes (od_id)	
);	
	
CREATE TABLE user_oneday_likes	
(	
user_id VARCHAR(50) NOT NULL,	
od_id INT NOT NULL,	
created_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
is_used BOOLEAN DEFAULT TRUE NOT NULL,	
PRIMARY KEY (user_id, od_id),	
FOREIGN KEY (user_id) REFERENCES users (user_id),	
FOREIGN KEY (od_id) REFERENCES oneday_classes (od_id)	
);	
	
	
CREATE TABLE event_dates -- 하루하루의	
(	
date_id INT PRIMARY KEY AUTO_INCREMENT,	
event_id INT NOT NULL,	
event_date timestamp NOT NULL,	
event_price INT NOT NULL,	
is_used BOOLEAN DEFAULT TRUE NOT NULL,	
FOREIGN KEY (event_id) REFERENCES events (event_id) ON DELETE CASCADE	
);	
	
CREATE TABLE event_images	
(	
img_id INT PRIMARY KEY AUTO_INCREMENT,	
event_id INT NOT NULL,	
img_url VARCHAR(255) NOT NULL,	
img_order INT NOT NULL,	
created_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,	
is_used BOOLEAN DEFAULT TRUE NOT NULL,
FOREIGN KEY (event_id) REFERENCES events (event_id) ON DELETE CASCADE	
);	
	
CREATE TABLE event_detail_images	
(	
img_id INT PRIMARY KEY AUTO_INCREMENT,	
event_id INT NOT NULL,	
img_url VARCHAR(255) NOT NULL,	
img_order INT NOT NULL,	
created_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,	
is_used BOOLEAN DEFAULT TRUE NOT NULL,
FOREIGN KEY (event_id) REFERENCES events (event_id) ON DELETE CASCADE	
);	
	
CREATE TABLE event_options	
(	
opt_id INT PRIMARY KEY AUTO_INCREMENT,	
date_id INT NOT NULL,	
opt_name VARCHAR(50) NOT NULL,	
opt_price INT NOT NULL,	
goal_min TINYINT NOT NULL, -- 이게 여기 들어가는게 맞나?	
dc_rate FLOAT NOT NULL, -- 이게 여기 들어가는게 맞나?	
created_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
is_used BOOLEAN DEFAULT TRUE NOT NULL,	
FOREIGN KEY (date_id) REFERENCES event_dates (date_id) ON DELETE CASCADE	
);	
	
	
CREATE TABLE agency	
(	
agency_id INT PRIMARY KEY AUTO_INCREMENT,	
name VARCHAR(50) NOT NULL,	
address VARCHAR(100) NOT NULL,
is_used BOOLEAN DEFAULT TRUE NOT NULL
);	
	
CREATE TABLE actors	
(	
actor_id INT PRIMARY KEY AUTO_INCREMENT,	
name VARCHAR(50) NOT NULL,	
prf_img_id INT NOT NULL,	
bday DATE NOT NULL,	
agency_id INT NOT NULL,	
is_joined INT NOT NULL, -- 가입했는가? yes -> 안보임
is_used BOOLEAN DEFAULT TRUE NOT NULL,
FOREIGN KEY (prf_img_id) REFERENCES user_img (prf_img_id) ON DELETE CASCADE,	
FOREIGN KEY (agency_id) REFERENCES agency (agency_id) ON DELETE CASCADE	
);	
	
CREATE TABLE actors_images	
(	
img_id INT PRIMARY KEY AUTO_INCREMENT,	
img_url VARCHAR(255) NOT NULL,	
actor_id INT NOT NULL,	
created_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,	
is_used BOOLEAN DEFAULT TRUE NOT NULL,
FOREIGN KEY (actor_id) REFERENCES actors (actor_id) ON DELETE CASCADE	
);	
	
CREATE TABLE event_cast (	
cast_id INT AUTO_INCREMENT PRIMARY KEY,	
event_id INT NOT NULL,	
is_joined BOOLEAN NOT NULL, -- 배우가 가입했는가? yes면 user_id, no면 actor_id	
user_id VARCHAR(50) NULL,	
actor_id INT NULL,	
actor_role ENUM ('main', 'sub', 'director') NOT NULL,	
gender ENUM ('M', 'F') NOT NULL,	
is_used BOOLEAN DEFAULT TRUE NOT NULL,
FOREIGN KEY (event_id) REFERENCES events(event_id) ON DELETE CASCADE,	
FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE SET NULL,	
FOREIGN KEY (actor_id) REFERENCES actors(actor_id) ON DELETE CASCADE	
);	
	
CREATE TABLE event_reviews	
(	
review_id INT PRIMARY KEY AUTO_INCREMENT,	
user_id VARCHAR(50) NOT NULL,	
event_id INT NOT NULL UNIQUE,	
rate INT NOT NULL,	
contents TEXT NOT NULL,	
is_used BOOLEAN DEFAULT TRUE NOT NULL,	
created_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,	
FOREIGN KEY (user_id) REFERENCES users (user_id),	
FOREIGN KEY (event_id) REFERENCES events (event_id)	
);	
	
CREATE TABLE event_review_images	
(	
image_id INT PRIMARY KEY AUTO_INCREMENT,	
user_id VARCHAR(50) NOT NULL,	
img_url VARCHAR(255) NOT NULL,	
create_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,	
is_used BOOLEAN DEFAULT TRUE NOT NULL,
FOREIGN KEY (user_id) REFERENCES users (user_id) ON DELETE CASCADE	
);	
	
CREATE TABLE user_event_bmarks	
(	
user_id VARCHAR(50) NOT NULL,	
event_related INT NOT NULL,	
created_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
is_used BOOLEAN DEFAULT TRUE NOT NULL,	
FOREIGN KEY (user_id) REFERENCES users (user_id),	
FOREIGN KEY (event_related) REFERENCES events (event_id),	
PRIMARY KEY (user_id, event_related)	
);	
	
	
CREATE TABLE user_event_likes	
(	
user_id VARCHAR(50) NOT NULL,	
event_related INT NOT NULL,	
created_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,	
is_used BOOLEAN DEFAULT TRUE NOT NULL,
FOREIGN KEY (event_related) REFERENCES event_reviews (event_id) ON DELETE CASCADE,	
FOREIGN KEY (user_id) REFERENCES users (user_id) ON DELETE CASCADE,	
PRIMARY KEY (user_id, event_related)	
);	
	
	
-- 결제관련	
CREATE TABLE user_points	
(	
point_id INT PRIMARY KEY AUTO_INCREMENT,	
user_id VARCHAR(50),	
point_value INT NOT NULL,	
point_reason VARCHAR(50), -- 왜 포인트가 발생했는가	
is_used BOOLEAN DEFAULT TRUE NOT NULL,	
FOREIGN KEY (user_id) REFERENCES users (user_id) ON DELETE CASCADE	
);	
	
	
CREATE TABLE user_coupons	
(	
coupon_id INT PRIMARY KEY AUTO_INCREMENT,	
user_id VARCHAR(50),	
dc_price INT,	
coupon_name VARCHAR(100),	
coupon_details VARCHAR(255),	
requirement BOOLEAN,	
end_date TIMESTAMP,	
is_used BOOLEAN DEFAULT TRUE NOT NULL,	
FOREIGN KEY (user_id) REFERENCES users (user_id) ON DELETE CASCADE	
);	
	
	
CREATE TABLE user_carts	
(	
cart_id INT PRIMARY KEY AUTO_INCREMENT,	
user_id VARCHAR(50),	
product_id INT NOT NULL,	
product_type ENUM ('funding', 'event', 'rent', 'oneday') NOT NULL,	
opt_id INT NULL,	
opt_count INT NULL,	
is_used BOOLEAN DEFAULT TRUE NOT NULL,
FOREIGN KEY (user_id) REFERENCES users (user_id) ON DELETE CASCADE	
);	
	
	
CREATE TABLE user_purchase_lists	
(	
payment_id INT PRIMARY KEY AUTO_INCREMENT,	
user_id VARCHAR(50),	
product_id INT NOT NULL,	
product_type ENUM ('funding', 'event', 'rent', 'oneday') NOT NULL,	
opt_id INT NULL,	
opt_count INT NULL,	
point_id INT, -- 사용된 포인트	
coupon_id INT, -- 사용된 쿠폰	
delivery_status ENUM ('구매접수', '배송준비', '배송중', '배송완료') DEFAULT '구매접수',	
is_used BOOLEAN DEFAULT TRUE NOT NULL,
FOREIGN KEY (user_id) REFERENCES users (user_id) ON DELETE CASCADE,	
FOREIGN KEY (point_id) REFERENCES user_points (point_id) ON DELETE CASCADE,	
FOREIGN KEY (coupon_id) REFERENCES user_coupons (coupon_id) ON DELETE CASCADE	
);	
	
	
-- 문의 관련	
CREATE TABLE user_inquires	
(	
inquire_id INT PRIMARY KEY AUTO_INCREMENT,	
user_id VARCHAR(50) NOT NULL,	
inquire_category ENUM ('계정', '결제', '데이터등록', '기타' ) DEFAULT '기타',	
payment_id INT NULL,	
title VARCHAR(255) NOT NULL,	
contents TEXT NOT NULL,	
inquiry_img_url VARCHAR(255) NULL,	
created_at timestamp DEFAULT CURRENT_TIMESTAMP,	
inquiry_state ENUM ('Pending', 'Completed') DEFAULT 'Pending',	
state_updated_at timestamp NULL,	
is_used BOOLEAN DEFAULT TRUE NOT NULL,
FOREIGN KEY (user_id) REFERENCES users (user_id) ON DELETE CASCADE,	
FOREIGN KEY (payment_id) REFERENCES user_purchase_lists (payment_id) ON DELETE SET NULL	
);	
	
CREATE TABLE user_inquire_replies	
(	
reply_id INT PRIMARY KEY AUTO_INCREMENT,	
inquire_id INT,	
reply_contents TEXT NOT NULL,	
replied_at timestamp DEFAULT CURRENT_TIMESTAMP,	
counselor_id VARCHAR(255) NOT NULL,	
is_used BOOLEAN DEFAULT TRUE NOT NULL,
FOREIGN KEY (reply_id) REFERENCES user_inquires (inquire_id) ON DELETE CASCADE	
);	
	