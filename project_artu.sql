DROP TABLE IF EXISTS widget_details;
DROP TABLE IF EXISTS widgets;

CREATE TABLE widgets
(
    widget_id    INT PRIMARY KEY,
    widget_size  INT         NOT NULL,
    widget_theme VARCHAR(20) NOT NULL DEFAULT 'Light',
    widget_json  JSON
);
CREATE TABLE widget_details
(
    user_id        VARCHAR(50) NOT NULL,
    widget_id      INT         NOT NULL,
    widget_content VARCHAR(100),
    widget_order   INT DEFAULT 0,
    PRIMARY KEY (user_id, widget_id),
    FOREIGN KEY (user_id) REFERENCES users (user_id),
    FOREIGN KEY (widget_id) REFERENCES widgets (widget_id) ON DELETE CASCADE
);

-- 1. 해당 유저 데이터 초기화
DELETE
FROM widget_details
WHERE user_id = 'user1001';

INSERT INTO widgets (widget_id, widget_size, widget_theme, widget_json)
VALUES (1, 1, 'Light', '{
  "type": "memo",
  "label": "메모"
}'),
       (2, 2, 'Light', '{
         "type": "memo",
         "label": "메모"
       }'),
       (3, 3, 'Light', '{
         "type": "memo",
         "label": "메모"
       }'),
       (4, 1, 'Light', '{
         "type": "info",
         "label": "소개"
       }'),
       (5, 2, 'Light', '{
         "type": "info",
         "label": "소개"
       }'),
       (6, 3, 'Light', '{
         "type": "info",
         "label": "소개"
       }'),
       (7, 1, 'Light', '{
         "type": "display",
         "label": "전시대"
       }'),
       (8, 2, 'Light', '{
         "type": "display",
         "label": "전시대"
       }'),
       (9, 3, 'Light', '{
         "type": "display",
         "label": "전시대"
       }'),
       (10, 1, 'Light', '{
         "type": "display",
         "label": "전시대"
       }'),
       (11, 2, 'Light', '{
         "type": "image",
         "label": "이미지"
       }'),
       (12, 3, 'Light', '{
         "type": "image",
         "label": "이미지"
       }');

-- 2. INSERT 다시 실행
INSERT INTO widget_details (user_id, widget_id, widget_content, widget_order)
VALUES ('user1001', 1, '', 1),
       ('user1001', 2, '', 0),
       ('user1001', 3, '', 0),
       ('user1001', 4, '', 0),
       ('user1001', 5, '', 0),
       ('user1001', 6, '', 0),
       ('user1001', 7, '', 0),
       ('user1001', 8, '', 0),
       ('user1001', 9, '', 0),
       ('user1001', 10, '', 0),
       ('user1001', 11, '', 0),
       ('user1001', 12, '', 0);