--
-- project_artU.sql
--
-- Project of group1 in Fullstack course at TJ Academy
--
-- memebers: 고현, 김기현, 서미란, 이상혁, 채수정, 황보영
--
-- title: ArtU _ 공연플랫폼
--
-- 프로젝트 내 서비스 소개:
--
--

-- 새로운 데이터베이스 생성
drop table if exists widget_details;
drop table if exists widgets;


-- 데이터베이스 사용
USE
    artu;

CREATE TABLE widgets
(
    widget_id      INT PRIMARY KEY AUTO_INCREMENT,
    user_id        VARCHAR(50) NOT NULL,
    widget_size    INT         NOT NULL,
    widget_is_used BOOLEAN     NOT NULL,
    widget_theme   ENUM ('Light', 'Dark') DEFAULT 'Light',
    FOREIGN KEY (user_id) REFERENCES users (user_id)
);


CREATE TABLE widget_details
(
    user_id     VARCHAR(50) NOT NULL,
    widget_id   INT         NOT NULL,
    widget_json JSON NULL,
    widget_content TEXT,
    PRIMARY KEY (user_id, widget_id),
    FOREIGN KEY (user_id) REFERENCES users (user_id),
    FOREIGN KEY (widget_id) REFERENCES widgets (widget_id)
);

INSERT INTO widgets (widget_id, user_id, widget_size, widget_is_used, widget_theme)
VALUES (1, 'user1001', '1', TRUE, 'Light'),
       (2, 'user1001', '2', TRUE, 'Light'),
       (3, 'user1001', '3', TRUE, 'Light'),
       (4, 'user1001', '1', TRUE, 'Light'),
       (5, 'user1001', '2', TRUE, 'Light'),
       (6, 'user1001', '3', TRUE, 'Light'),
       (7, 'user1001', '1', TRUE, 'Light'),
       (8, 'user1001', '2', TRUE, 'Light'),
       (9, 'user1001', '3', TRUE, 'Light'),
       (10, 'user1001', '1', TRUE, 'Light'),
       (11, 'user1001', '2', TRUE, 'Light'),
       (12, 'user1001', '3', TRUE, 'Light');


INSERT INTO widget_details (user_id, widget_id, widget_json, widget_content)
VALUES ('user1001', 1, '{
  "type": "memo",
  "label": "메모"
}', ''),
       ('user1001', 2, '{
         "type": "memo",
         "label": "메모"
       }', ''),
       ('user1001', 3, '{
         "type": "memo",
         "label": "메모"
       }', ''),
       ('user1001', 4, '{
         "type": "info",
         "label": "소개"
       }', ''),
       ('user1001', 5, '{
         "type": "info",
         "label": "소개"
       }', ''),
       ('user1001', 6, '{
         "type": "info",
         "label": "소개"
       }', ''),
       ('user1001', 7, '{
         "type": "display",
         "label": "전시대"
       }', ''),
       ('user1001', 8, '{
         "type": "display",
         "label": "전시대"
       }', ''),
       ('user1001', 9, '{
         "type": "display",
         "label": "전시대"
       }', ''),
       ('user1001', 10, '{
         "type": "image",
         "label": "이미지"
       }', ''),
       ('user1001', 11, '{
         "type": "image",
         "label": "이미지"
       }', ''),
       ('user1001', 12, '{
         "type": "image",
         "label": "이미지"
       }', '');
