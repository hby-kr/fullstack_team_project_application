-- 더미 데이터 넣기

-- users 테이블에 더미 데이터 추가
INSERT INTO users (user_id, user_email, password, user_name, user_birth, gender)
VALUES ('user1', 'user1@artu.com', 'artuartu', 'Alice', '1990-01-01', 'F'),
       ('user2', 'user2@artu.com', 'artuartu', 'Bob', '1985-05-15', 'M'),
       ('user3', 'user3@artu.com', 'artuartu', 'Charlie', '1992-08-30', 'M'),
       ('user4', 'user4@artu.com', 'artuartu', 'Diana', '1988-03-25', 'F'),
       ('user5', 'user5@artu.com', 'artuartu', 'Eve', '1995-07-10', 'F'),
       ('user6', 'user6@artu.com', 'artuartu', 'devel', '1999-12-30', 'M'),
       ('user7', 'mike_w@email.com', 'artuartu', 'Mike Wilson', '1990-07-15', 'M'),
       ('user8', 'anna_p@email.com', 'artuartu', 'Anna Park', '1988-06-20', 'F'),
       ('user9', 'james_k@email.com', 'artuartu', 'James Kim', '1995-09-12', 'M'),
       ('user10', 'rachel_d@email.com', 'artuartu', 'Rachel Davis', '1985-04-21', 'F'),
       ('user11', 'lucas_h@email.com', 'artuartu', 'Lucas Hill', '1992-12-03', 'M'),
       ('user12', 'sophie_c@email.com', 'artuartu', 'Sophie Chan', '1998-11-22', 'F'),
       ('user13', 'jack_m@email.com', 'artuartu', 'Jack Miller', '1993-05-05', 'M'),
       ('user14', 'olivia_s@email.com', 'artuartu', 'Olivia Smith', '1990-01-17', 'F'),
       ('user15', 'henry_l@email.com', 'artuartu', 'Henry Long', '1982-10-10', 'M'),
       ('user16', 'emma_w@email.com', 'artuartu', 'Emma White', '1996-08-30', 'F'),
       ('user17', 'daniel_r@email.com', 'artuartu', 'Daniel Robinson', '1994-05-14', 'M'),
       ('user18', 'chloe_b@email.com', 'artuartu', 'Chloe Brown', '1989-02-28', 'F'),
       ('user19', 'liam_t@email.com', 'artuartu', 'Liam Turner', '1991-03-12', 'M'),
       ('user20', 'mia_j@email.com', 'artuartu', 'Mia Johnson', '1986-09-19', 'F');

-- 프로필 이미지 테이블에 더미 데이터 추가
INSERT INTO user_img (prf_img_id, prf_img_url, user_id, create_at)
VALUES (1, 'https://dummyimage.com/500X500/808080/fff.jpg', 'user1', '2023-10-01 10:15:00'),
       (2, 'https://dummyimage.com/500X500/808080/fff.jpg', 'user2', '2023-10-02 11:30:00'),
       (3, 'https://dummyimage.com/500X500/808080/fff.jpg', 'user3', '2023-10-03 14:45:00'),
       (4, 'https://dummyimage.com/500X500/808080/fff.jpg', 'user4', '2023-10-04 09:20:00'),
       (5, 'https://dummyimage.com/500X500/808080/fff.jpg', 'user5', '2023-10-05 16:10:00');

INSERT INTO categories (ctgr_name, is_used_main, is_used_oneday)
VALUES ('음악', TRUE, TRUE),
       ('미술', TRUE, TRUE),
       ('춤', TRUE, TRUE),
       ('연기', TRUE, TRUE),
       ('뮤지컬', TRUE, TRUE),
       ('공예', TRUE, TRUE);

INSERT INTO rents (user_id, rt_name, rt_address, rt_capacity, rt_info)
VALUES ('user1', '대여 홀 A', '중앙로 123', 50, '이벤트 및 모임에 적합한 넓은 홀입니다.'),
       ('user2', '대여 방 B', '공원길 456', 20, '소규모 회의에 적합한 아늑한 방입니다.'),
       ('user3', '대여 공간 C', '광화문로 789', 100, '컨퍼런스 및 세미나에 적합한 대형 공간입니다.'),
       ('user4', '대여 지역 D', '센터로 101', 75, '워크숍 및 교육 세션에 적합한 다용도 공간입니다.'),
       ('user5', '대여 시설 E', '동쪽길 202', 30, '개인 행사 및 파티에 적합한 쾌적한 시설입니다.');


INSERT INTO events (ctgr_id, title, location, company, address, age_limit, how_long, is_approved, is_used, user_id)
VALUES (1, '음악 콘서트', '서울', '음악사', '서울 강남구 테헤란로 123', '12', 120, FALSE, TRUE, 'user1'),
       (2, '미술 전시회', '부산', '미술관', '부산 해운대구 해운대로 456', '0', 180, FALSE, TRUE, 'user2'),
       (3, '댄스 공연', '대구', '댄스홀', '대구 수성구 무열로 789', '15', 90, FALSE, TRUE, 'user3'),
       (4, '연극 상영', '인천', '연극단', '인천 남동구 예술로 101', '19', 150, FALSE, TRUE, 'user4'),
       (5, '뮤지컬', '광주', '뮤지컬 컴퍼니', '광주 서구 무진대로 202', '0', 200, FALSE, TRUE, 'user5');

INSERT INTO chatrooms (chat_id, is_private, related_event, created_at, is_used)
VALUES (1, TRUE, 1, '2023-10-05 10:00:00', TRUE),
       (2, FALSE, 2, '2023-10-06 11:15:00', TRUE),
       (3, TRUE, 3, '2023-10-07 09:30:00', FALSE),
       (4, FALSE, 4, '2023-10-08 14:45:00', TRUE),
       (5, TRUE, 5, '2023-10-09 16:00:00', FALSE);

INSERT INTO oneday_classes (tchr_id, od_name, ctgr_id, location, address, min_mem, max_mem, is_aproved, is_used)
VALUES ('user1', '원데이 음악 클래스', 1, '서울', '서울 강남구 테헤란로 123', 5, 20, FALSE, TRUE),
       ('user2', '원데이 미술 클래스', 2, '부산', '부산 해운대구 해운대로 456', 3, 15, FALSE, TRUE),
       ('user3', '원데이 댄스 클래스', 3, '대구', '대구 수성구 무열로 789', 8, 25, FALSE, TRUE),
       ('user4', '원데이 연기 클래스', 4, '인천', '인천 남동구 예술로 101', 4, 12, FALSE, TRUE),
       ('user5', '원데이 뮤지컬 클래스', 5, '광주', '광주 서구 무진대로 202', 6, 18, FALSE, TRUE);

INSERT INTO agency (agency_id, name, address)
VALUES (1, 'Dream Talent Agency', '123 Talent Rd, Seoul'),
       (2, 'Star Entertainment', '456 Entertainment St, Busan'),
       (3, 'Bright Future Casting', '789 Future Ave, Incheon'),
       (4, 'Elite Arts Management', '101 Elite Blvd, Daegu'),
       (5, 'Global Casting Group', '202 Global Dr, Daejeon');

INSERT INTO actors (actor_id, name, prf_img_id, bday, agency_id, is_joined)
VALUES (1, 'Alice Kim', 1, '1976-05-29(', 1, TRUE),
       (2, 'John Park', 2, '2000-12-01', 2, TRUE),
       (3, 'Sophia Lee', 3, '2007-09-01', 3, TRUE),
       (4, 'Meryl Streep', 4, '1950-11-05', 4, FALSE),
       (5, 'Robert De Niro', 5, '1981-03-29', 5, FALSE);

INSERT INTO actors_images (img_id, img_url, actor_id, created_at)
VALUES (1, 'https://dummyimage.com/500X500/808080/fff.jpg', 1, NOW()),
       (2, 'https://dummyimage.com/500X500/808080/fff.jpg', 2, NOW()),
       (3, 'https://dummyimage.com/500X500/808080/fff.jpg', 3, NOW()),
       (4, 'https://dummyimage.com/500X500/808080/fff.jpg', 4, NOW()),
       (5, 'https://dummyimage.com/500X500/808080/fff.jpg', 5, NOW());

INSERT INTO event_cast (event_id, is_joined, user_id, actor_id, actor_role, gender)
VALUES (1, TRUE, 'user1', 1, 'main', 'F'),
       (2, FALSE, 'user2', 2, 'main', 'M'),
       (3, TRUE, 'user3', 3, 'sub', 'F'),
       (4, FALSE, 'user4', 4, 'director', 'F'),
       (5, TRUE, 'user5', 5, 'director', 'M');

INSERT INTO event_dates (date_id, event_id, event_date, event_price, is_used)
VALUES (1, 1, '2023-10-10', 5000, TRUE),
       (2, 2, '2023-10-15', 7000, TRUE),
       (3, 3, '2023-10-20', 10000, TRUE),
       (4, 4, '2023-10-25', 6000, FALSE),
       (5, 5, '2023-10-30', 8000, TRUE);

INSERT INTO event_detail_images (img_id, event_id, img_url, img_order, created_at)
VALUES (1, 1, 'https://dummyimage.com/500X500/808080/fff.jpg', 1, NOW()),
       (2, 2, 'https://dummyimage.com/500X500/808080/fff.jpg', 2, NOW()),
       (3, 3, 'https://dummyimage.com/500X500/808080/fff.jpg', 3, NOW()),
       (4, 4, 'https://dummyimage.com/500X500/808080/fff.jpg', 4, NOW()),
       (5, 5, 'https://dummyimage.com/500X500/808080/fff.jpg', 5, NOW());

INSERT INTO event_images (img_id, event_id, img_url, img_order, created_at)
VALUES (1, 1, 'https://dummyimage.com/500x500/808080/fff.jpg', 1, NOW()),
       (2, 2, 'https://dummyimage.com/500x500/808080/fff.jpg', 2, NOW()),
       (3, 3, 'https://dummyimage.com/500x500/808080/fff.jpg', 3, NOW()),
       (4, 4, 'https://dummyimage.com/500x500/808080/fff.jpg', 4, NOW()),
       (5, 5, 'https://dummyimage.com/500x500/808080/fff.jpg', 5, NOW());

INSERT INTO event_options (opt_id, date_id, opt_name, opt_price, goal_min, dc_rate, created_at)
VALUES (1, 1, 'VIP 패키지', 15000, 10, 10, NOW()),
       (2, 2, '일반 패키지', 10000, 15, 5, NOW()),
       (3, 3, '학생 할인 패키지', 8000, 5, 15, NOW()),
       (4, 4, '단체 패키지', 12000, 20, 20, NOW()),
       (5, 5, '얼리버드', 7000, 25, 30, NOW());

INSERT INTO event_reviews (review_id, user_id, event_id, rate, contents, is_used, created_at)
VALUES (1, 'user1', 1, 5, 'Amazing event! Had a great time.', TRUE, NOW()),
       (2, 'user2', 2, 4, 'Good experience but could improve.', TRUE, NOW()),
       (3, 'user3', 3, 3, 'It was okay, not too exciting.', TRUE, NOW()),
       (4, 'user4', 4, 2, 'Not satisfied with the event.', TRUE, NOW()),
       (5, 'user5', 5, 5, 'Absolutely fantastic! Highly recommend.', TRUE, NOW());

INSERT INTO event_review_images (image_id, user_id, img_url, create_at)
VALUES (1, 'user1', 'https://dummyimage.com/500x500/808080/fff.jpg', NOW()),
       (2, 'user2', 'https://dummyimage.com/500x500/808080/fff.jpg', NOW()),
       (3, 'user3', 'https://dummyimage.com/500x500/808080/fff.jpg', NOW()),
       (4, 'user4', 'https://dummyimage.com/500x500/808080/fff.jpg', NOW()),
       (5, 'user5', 'https://dummyimage.com/500x500/808080/fff.jpg', NOW());

INSERT INTO user_event_likes (user_id, event_related, created_at)
VALUES ('user1', 1, NOW()),
       ('user2', 2, NOW()),
       ('user3', 3, NOW()),
       ('user4', 4, NOW()),
       ('user5', 5, NOW());

INSERT INTO funding_categories (ctgr_id, ctgr_name, ctgr_contents)
VALUES (1, 'Arts & Culture', 'Projects focused on artistic and cultural activities.'),
       (2, 'Community Development', 'Initiatives aimed at improving local communities.'),
       (3, 'Education', 'Programs supporting educational opportunities and resources.'),
       (4, 'Environment', 'Efforts towards environmental preservation and sustainability.'),
       (5, 'Technology', 'Innovations and advancements in the field of technology.');

INSERT INTO fundings (fd_id, user_id, ctgr_id, fd_title, fd_goal_amount, created_at, fd_start_at, fd_end_at,
                      is_approved, is_used)
VALUES (1, 'user1', 1, 'Community Art Project', 100000, NOW(), '2023-11-01', '2023-12-01', TRUE, TRUE),
       (2, 'user2', 2, 'Neighborhood Cleanup Fundraiser', 50000, NOW(), '2023-11-05', '2023-12-15', TRUE, TRUE),
       (3, 'user3', 3, 'Local Music Festival Support', 150000, NOW(), '2023-11-10', '2023-12-20', FALSE, TRUE),
       (4, 'user4', 4, 'Animal Shelter Expansion Funding', 200000, NOW(), '2023-11-15', '2023-12-25', TRUE, FALSE),
       (5, 'user5', 5, 'Tech Education for Kids', 75000, NOW(), '2023-11-20', '2023-12-30', FALSE, TRUE);

INSERT INTO funding_images (fd_img_id, fd_id, fd_img_url, fd_img_order, created_at)
VALUES (1, 1, 'https://dummyimage.com/500x500/808080/fff.jpg', 1, NOW()),
       (2, 2, 'https://dummyimage.com/500x500/808080/fff.jpg', 2, NOW()),
       (3, 3, 'https://dummyimage.com/500x500/808080/fff.jpg', 3, NOW()),
       (4, 4, 'https://dummyimage.com/500x500/808080/fff.jpg', 4, NOW()),
       (5, 5, 'https://dummyimage.com/500x500/808080/fff.jpg', 5, NOW());

INSERT INTO funding_detail_images (img_id, fd_id, img_url, img_order, created_at)
VALUES (1, 1, 'https://dummyimage.com/500x500/808080/fff.jpg', 1, NOW()),
       (2, 2, 'https://dummyimage.com/500x500/808080/fff.jpg', 2, NOW()),
       (3, 3, 'https://dummyimage.com/500x500/808080/fff.jpg', 3, NOW()),
       (4, 4, 'https://dummyimage.com/500x500/808080/fff.jpg', 4, NOW()),
       (5, 5, 'https://dummyimage.com/500x500/808080/fff.jpg', 5, NOW());

INSERT INTO funding_options (opt_id, fd_id, opt_name, extra_fee)
VALUES (1, 1, 'Exclusive Backer Package', 2500),
       (2, 2, 'Early Access Bonus', 1500),
       (3, 3, 'Community Support Gift', 2000),
       (4, 4, 'VIP Contribution Package', 3000),
       (5, 5, 'Limited Edition Perk', 3500);

INSERT INTO funding_reviews (review_id, fd_id, user_id, rate, contents, is_used, created_at)
VALUES (1, 1, 'user1', 5, 'Absolutely loved this funding initiative!', TRUE, NOW()),
       (2, 2, 'user2', 4, 'Great cause, happy to contribute.', TRUE, NOW()),
       (3, 3, 'user3', 3, 'Good effort, but needs more clarity on goals.', TRUE, NOW()),
       (4, 4, 'user4', 2, 'Not what I expected. Could be organized better.', TRUE, NOW()),
       (5, 5, 'user5', 5, 'Fantastic project, exceeded my expectations!', TRUE, NOW());

INSERT INTO funding_review_images (img_id, user_id, img_url, created_at)
VALUES (1, 'user1', 'https://dummyimage.com/500x500/808080/fff.jpg', NOW()),
       (2, 'user2', 'https://dummyimage.com/500x500/808080/fff.jpg', NOW()),
       (3, 'user3', 'https://dummyimage.com/500x500/808080/fff.jpg', NOW()),
       (4, 'user4', 'https://dummyimage.com/500x500/808080/fff.jpg', NOW()),
       (5, 'user5', 'https://dummyimage.com/500x500/808080/fff.jpg', NOW());

INSERT INTO hashtags (tag_id, tagword, user_id, created_in)
VALUES (1, '음악', 'user1', NOW()),
       (2, '미술', 'user2', NOW()),
       (3, '춤', 'user3', NOW()),
       (4, '연기', 'user4', NOW()),
       (5, '뮤지컬', 'user5', NOW());

INSERT INTO messages (msg_id, writer, chatroom_id, msg_body, created_at, is_checked)
VALUES (1, 'user1', 1, 'Hello, how are you?', NOW(), TRUE),
       (2, 'user2', 2, 'I will send you the details soon.', NOW(), FALSE),
       (3, 'user3', 3, 'Looking forward to the meeting.', NOW(), TRUE),
       (4, 'user4', 4, 'Can you please confirm?', NOW(), FALSE),
       (5, 'user5', 5, 'Thank you for your response.', NOW(), TRUE);

INSERT INTO oneday_dates (date_id, od_id, od_price, od_date, is_used)
VALUES (1, 1, 50000, '2023-11-05', TRUE),
       (2, 2, 45000, '2023-11-06', TRUE),
       (3, 3, 60000, '2023-11-07', TRUE),
       (4, 4, 55000, '2023-11-08', TRUE),
       (5, 5, 48000, '2023-11-09', TRUE);

INSERT INTO oneday_images (img_id, od_id, img_url, img_order, created_at)
VALUES (1, 1, 'https://dummyimage.com/500x500/808080/fff.jpg', 1, NOW()),
       (2, 2, 'https://dummyimage.com/500x500/808081/fff.jpg', 2, NOW()),
       (3, 3, 'https://dummyimage.com/500x500/808082/fff.jpg', 3, NOW()),
       (4, 4, 'https://dummyimage.com/500x500/808083/fff.jpg', 4, NOW()),
       (5, 5, 'https://dummyimage.com/500x500/808084/fff.jpg', 5, NOW());

INSERT INTO oneday_detail_images (img_id, od_id, img_url, img_order, created_at)
VALUES (1, 1, 'https://dummyimage.com/650x650/808080/fff.jpg', 1, NOW()),
       (2, 2, 'https://dummyimage.com/650x650/808081/fff.jpg', 2, NOW()),
       (3, 3, 'https://dummyimage.com/650x650/808082/fff.jpg', 3, NOW()),
       (4, 4, 'https://dummyimage.com/650x650/808083/fff.jpg', 4, NOW()),
       (5, 5, 'https://dummyimage.com/650x650/808084/fff.jpg', 5, NOW());

INSERT INTO oneday_options (opt_id, date_id, opt_name, opt_price, created_at)
VALUES (1, 1, 'Beginner Materials Package', 25000, NOW()),
       (2, 2, 'Advanced Tools Package', 30000, NOW()),
       (3, 3, 'Exclusive Class Notes', 20000, NOW()),
       (4, 4, 'VIP Pass', 40000, NOW()),
       (5, 5, 'Post-Class Q&A Session', 15000, NOW());

INSERT INTO oneday_reviews (review_id, user_id, od_id, contents, rate, is_used, created_at)
VALUES (1, 'user1', 1, 'Amazing experience, learned a lot!', 5, TRUE, NOW()),
       (2, 'user2', 2, 'The session was well-organized and fun.', 4, TRUE, NOW()),
       (3, 'user3', 3, 'Good overall, but could use more examples.', 3, TRUE, NOW()),
       (4, 'user4', 4, 'Not as interesting as I hoped.', 2, TRUE, NOW()),
       (5, 'user5', 5, 'Incredible class! Would highly recommend it.', 5, TRUE, NOW());

INSERT INTO oneday_review_images (img_id, user_id, img_url, created_at)
VALUES (1, 'user1', 'https://dummyimage.com/500x500/808080/fff.jpg', NOW()),
       (2, 'user2', 'https://dummyimage.com/500x500/808081/fff.jpg', NOW()),
       (3, 'user3', 'https://dummyimage.com/500x500/808082/fff.jpg', NOW()),
       (4, 'user4', 'https://dummyimage.com/500x500/808083/fff.jpg', NOW()),
       (5, 'user5', 'https://dummyimage.com/500x500/808084/fff.jpg', NOW());

INSERT INTO password_change_histories (change_id, user_id, old_pw, changed_at)
VALUES (1, 'user1', 'oldpassword1', NOW()),
       (2, 'user2', 'oldpassword2', NOW()),
       (3, 'user3', 'oldpassword3', NOW()),
       (4, 'user4', 'oldpassword4', NOW()),
       (5, 'user5', 'oldpassword5', NOW());

INSERT INTO postings (post_id, user_id, contents, location_tag, person_tag_id, visibility_type, created_at, edit_at,
                      is_used)
VALUES (1, 'user1', 'Exploring the city!', 'Central Park', 'user3', 'All', NOW(), NOW(), TRUE),
       (2, 'user2', 'Had a great time at the concert!', 'Madison Square Garden', 'user5', 'Friends', NOW(), NOW(),
        TRUE),
       (3, 'user3', 'Loving this new book I found!', 'Library', 'user2', 'All', NOW(), NOW(), TRUE),
       (4, 'user4', 'Workout session complete!', 'Golds Gym', 'user4', 'Private', NOW(), NOW(), TRUE),
       (5, 'user5', 'Vacation vibes!', 'Hawaii', 'user1', 'All', NOW(), NOW(), TRUE);

INSERT INTO posting_like (user_id, post_id, liked_at)
VALUES ('user1', 1, NOW()),
       ('user2', 2, NOW()),
       ('user3', 3, NOW()),
       ('user4', 4, NOW()),
       ('user5', 5, NOW());

INSERT INTO posting_images (img_id, post_id, img_order, img_url, created_at)
VALUES (1, 1, 1, 'https://dummyimage.com/500x500/808090/fff.jpg', NOW()),
       (2, 2, 1, 'https://dummyimage.com/500x500/808091/fff.jpg', NOW()),
       (3, 3, 1, 'https://dummyimage.com/500x500/808092/fff.jpg', NOW()),
       (4, 4, 1, 'https://dummyimage.com/500x500/808093/fff.jpg', NOW()),
       (5, 5, 1, 'https://dummyimage.com/500x500/808094/fff.jpg', NOW());

INSERT INTO posting_comments (comment_id, user_id, post_id, contents, created_at, is_used)
VALUES (1, 'user5', 1, 'Great post! I love it.', NOW(), TRUE),
       (2, 'user4', 2, 'This is so inspiring!', NOW(), TRUE),
       (3, 'user3', 3, 'Thanks for sharing this.', NOW(), TRUE),
       (4, 'user2', 4, 'Amazing work!', NOW(), TRUE),
       (5, 'user1', 5, 'This made my day!', NOW(), TRUE);

INSERT INTO rents (rt_id, user_id, rt_name, rt_address, rt_capacity, rt_info, created_at)
VALUES (6, 'user1', 'Ocean View Apartment', '123 Beach Road, Miami', 4,
        'A beautiful beachside apartment with stunning views.', NOW()),
       (7, 'user2', 'City Center Condo', '456 Downtown Lane, New York', 3,
        'Convenient location, perfect for exploring the city.', NOW()),
       (8, 'user3', 'Mountain Cabin', '789 Hilltop Drive, Denver', 6,
        'Rustic cabin surrounded by breathtaking mountain scenery.', NOW()),
       (9, 'user4', 'Lakefront Villa', '101 Lakeside Ave, Chicago', 8,
        'Luxurious villa with direct access to the lake.', NOW()),
       (10, 'user5', 'Cozy Studio', '202 Quiet Street, Austin', 2,
        'A small yet cozy studio in a peaceful neighborhood.', NOW());

INSERT INTO rent_rooms (room_id, rt_id, room_name, price_per_unit, rt_unit, ctgr, min_time)
VALUES (1, 1, 'Ocean Suite', 150, 'day', 'Premium', 1),
       (2, 1, 'Balcony Room', 100, 'day', 'Standard', 1),
       (3, 2, 'City View Room', 120, 'hour', 'Standard', 2),
       (4, 3, 'Loft Room', 200, 'hour', 'Deluxe', 3),
       (5, 4, 'Lakeview Master', 300, 'hour', 'Luxury', 2);

INSERT INTO rent_reviews (review_id, rt_id, user_id, rate, contents, is_used, created_at)
VALUES (1, 1, 'user1', 5, 'Beautiful place with an amazing view!', TRUE, NOW()),
       (2, 2, 'user2', 4, 'Very convenient location, but a bit noisy.', TRUE, NOW()),
       (3, 3, 'user3', 5, 'The cabin was cozy and perfect for our getaway!', TRUE, NOW()),
       (4, 4, 'user4', 3, 'The villa was nice, but some amenities were lacking.', TRUE, NOW()),
       (5, 5, 'user5', 5, 'Perfect spot for a peaceful retreat, loved it!', TRUE, NOW());

INSERT INTO rent_review_images (img_id, user_id, img_url, created_at)
VALUES (1, 'user1', 'https://dummyimage.com/500x500/808100/fff.jpg', NOW()),
       (2, 'user2', 'https://dummyimage.com/500x500/808200/fff.jpg', NOW()),
       (3, 'user3', 'https://dummyimage.com/500x500/808300/fff.jpg', NOW()),
       (4, 'user4', 'https://dummyimage.com/500x500/808400/fff.jpg', NOW()),
       (5, 'user5', 'https://dummyimage.com/500x500/808500/fff.jpg', NOW());

INSERT INTO rent_item_options (opt_id, rt_id, opt_name, extra_fee)
VALUES (1, 1, 'Breakfast', 20),
       (2, 2, 'Parking', 15),
       (3, 3, 'Firewood Bundle', 25),
       (4, 4, 'Boat Rental', 50),
       (5, 5, 'Room Cleaning', 30);

INSERT INTO rent_images (rt_img_id, rt_id, img_order, img_url, created_at)
VALUES (1, 1, 1, 'https://dummyimage.com/500x500/809000/fff.jpg', NOW()),
       (2, 2, 1, 'https://dummyimage.com/500x500/809001/fff.jpg', NOW()),
       (3, 3, 1, 'https://dummyimage.com/500x500/809002/fff.jpg', NOW()),
       (4, 4, 1, 'https://dummyimage.com/500x500/809003/fff.jpg', NOW()),
       (5, 5, 1, 'https://dummyimage.com/500x500/809004/fff.jpg', NOW());

INSERT INTO rent_detail_images (img_id, rt_id, img_url, img_order, user_id, created_at)
VALUES (1, 1, 'https://dummyimage.com/600x400/809005/fff.jpg', 1, 'user1', NOW()),
       (2, 2, 'https://dummyimage.com/600x400/809006/fff.jpg', 2, 'user2', NOW()),
       (3, 3, 'https://dummyimage.com/600x400/809007/fff.jpg', 3, 'user3', NOW()),
       (4, 4, 'https://dummyimage.com/600x400/809008/fff.jpg', 4, 'user4', NOW()),
       (5, 5, 'https://dummyimage.com/600x400/809009/fff.jpg', 5, 'user5', NOW());

INSERT INTO rent_dates (rt_date_id, rt_id, rt_date, rt_price)
VALUES (1, 1, '2023-10-01', 200),
       (2, 2, '2023-10-02', 150),
       (3, 3, '2023-10-03', 250),
       (4, 4, '2023-10-04', 300),
       (5, 5, '2023-10-05', 180);

INSERT INTO search_words (key_id, keyword, user_id, search_at)
VALUES (1, 'vacation', 'user1', NOW()),
       (2, 'apartment', 'user2', NOW()),
       (3, 'beach', 'user3', NOW()),
       (4, 'mountain', 'user4', NOW()),
       (5, 'studio', 'user5', NOW());

INSERT INTO user_carts (cart_id, user_id, product_id, product_type, opt_id, opt_count)
VALUES (1, 'user1', 101, 'funding', 1, 2),
       (2, 'user2', 102, 'event', 2, 1),
       (3, 'user3', 103, 'rent', 3, 4),
       (4, 'user4', 104, 'oneday', 4, 1),
       (5, 'user5', 105, 'rent', 5, 3);

INSERT INTO user_coupons (coupon_id, user_id, dc_price, coupon_name, coupon_details, requirement, end_date, is_used)
VALUES (1, 'user1', 20, 'Welcome Discount', 'Get $20 off on your first booking.', TRUE, '2023-12-31',
        FALSE),
       (2, 'user2', 15, 'Holiday Special', 'Enjoy $15 off this holiday season.', FALSE,
        '2024-01-15', FALSE),
       (3, 'user3', 25, 'Loyalty Reward', 'Reward for loyal customers: $25 off.', FALSE,
        '2024-06-30', FALSE),
       (4, 'user4', 10, 'Midweek Promo', 'Save $10 on midweek stays.', TRUE,
        '2024-03-31', FALSE),
       (5, 'user5', 30, 'Special Event Offer', '$30 discount for event participants.', TRUE,
        '2024-02-28', FALSE);

INSERT INTO user_enter_chatroom (chat_id, user_id, entered_at)
VALUES (1, 'user1', NOW()),
       (2, 'user2', NOW()),
       (3, 'user3', NOW()),
       (4, 'user4', NOW()),
       (5, 'user5', NOW());

INSERT INTO user_event_bmarks (user_id, event_related, created_at)
VALUES ('user1', 1, NOW()),
       ('user2', 2, NOW()),
       ('user3', 3, NOW()),
       ('user4', 4, NOW()),
       ('user5', 5, NOW());


INSERT INTO user_follow (follower_id, followee_id, followed_at)
VALUES ('user1', 'user2', NOW()),
       ('user2', 'user3', NOW()),
       ('user3', 'user4', NOW()),
       ('user4', 'user5', NOW()),
       ('user5', 'user1', NOW());

INSERT INTO user_funding_bmarks (fd_id, user_id, created_at)
VALUES (1, 'user1', NOW()),
       (2, 'user2', NOW()),
       (3, 'user3', NOW()),
       (4, 'user4', NOW()),
       (5, 'user5', NOW());


INSERT INTO user_funding_likes (fd_id, user_id, created_at)
VALUES (1, 'user1', NOW()),
       (2, 'user2', NOW()),
       (3, 'user3', NOW()),
       (4, 'user4', NOW()),
       (5, 'user5', NOW());


INSERT INTO user_img (prf_img_id, prf_img_url, user_id, create_at)
VALUES (6, 'https://dummyimage.com/500x500/ff0000/fff.jpg', 'user1', NOW()),
       (7, 'https://dummyimage.com/500x500/00ff00/fff.jpg', 'user2', NOW()),
       (8, 'https://dummyimage.com/500x500/0000ff/fff.jpg', 'user3', NOW()),
       (9, 'https://dummyimage.com/500x500/ffff00/fff.jpg', 'user4', NOW()),
       (10, 'https://dummyimage.com/500x500/ff00ff/fff.jpg', 'user5', NOW());


INSERT INTO user_points (point_id, user_id, point_value, point_reason, is_used)
VALUES (1, 'user1', 100, 'Registration bonus', FALSE),
       (2, 'user2', 200, 'Event participation', FALSE),
       (3, 'user3', 150, 'Coupon redemption', FALSE),
       (4, 'user4', 300, 'Referral reward', TRUE),
       (5, 'user5', 250, 'Purchase cashback', TRUE);

INSERT INTO user_purchase_lists (payment_id, user_id, product_id, product_type, opt_id, opt_count, point_id, coupon_id,
                                 delivery_status)
VALUES (1, 'user1', 1, 'funding', 1, 2, 1, NULL, '구매접수'),
       (2, 'user2', 2, 'event', 2, 1, 2, NULL, '배송준비'),
       (3, 'user3', 3, 'rent', 3, 4, 3, NULL, '배송중'),
       (4, 'user4', 4, 'oneday', 4, 1, 4, 4, '배송완료'),
       (5, 'user5', 5, 'rent', 5, 3, 5, 5, '구매접수');

INSERT INTO user_inquires (inquire_id, user_id, inquire_category, payment_id, title, contents, inquiry_img_url,
                           created_at, inquiry_state, state_updated_at)
VALUES (1, 'user6', '계정', 1, 'Question about pricing', 'Can I have detailed pricing information?',
        'https://dummyimage.com/600x400/808080/fff.jpg', NOW(), 'Completed', NOW()),
       (2, 'user7', '결제', 2, 'Issue with Payment', 'I am unable to process my payment, please assist.',
        'https://dummyimage.com/600x400/808080/fff.jpg', NOW(), 'Pending', NOW()),
       (3, 'user8', '기타', 3, 'Booking Inquiry', 'I need help with my booking confirmation.',
        'https://dummyimage.com/600x400/808080/fff.jpg', NOW(), 'Completed', NOW()),
       (4, 'user9', '데이터등록', 4, 'Cancellation Policy', 'Can you explain the cancellation charges?',
        'https://dummyimage.com/600x400/808080/fff.jpg', NOW(), 'Pending', NOW()),
       (5, 'user10', '계정', 5, 'Feedback on Services', 'Your services are great but can be improved.',
        'https://dummyimage.com/600x400/808080/fff.jpg', NOW(), 'Completed', NOW());

INSERT INTO user_inquire_replies (reply_id, inquire_id, reply_contents, replied_at, counselor_id)
VALUES (1, 1, 'Thank you for reaching out! Here is the information you requested.', NOW(), 'counselor1'),
       (2, 2, 'Please check the attached documents for your requested details.', NOW(), 'counselor2'),
       (3, 3, 'We are working on your inquiry and will update you shortly.', NOW(), 'counselor3'),
       (4, 4, 'Your concern has been forwarded to the appropriate department.', NOW(), 'counselor4'),
       (5, 5, 'Let us know if there is anything else we can help you with.', NOW(), 'counselor5');


INSERT INTO user_interests (user_id, ctgr_id, interest_order)
VALUES ('user1', 1, 1),
       ('user2', 2, 2),
       ('user3', 3, 3),
       ('user4', 4, 4),
       ('user5', 5, 5);

INSERT INTO user_oneday_bmarks (user_id, od_id, created_at)
VALUES ('user1', 1, NOW()),
       ('user2', 2, NOW()),
       ('user3', 3, NOW()),
       ('user4', 4, NOW()),
       ('user5', 5, NOW());

INSERT INTO user_oneday_likes (user_id, od_id, created_at)
VALUES ('user1', 1, NOW()),
       ('user2', 2, NOW()),
       ('user3', 3, NOW()),
       ('user4', 4, NOW()),
       ('user5', 5, NOW());

INSERT INTO user_rent_bmarks (user_id, rt_id, created_at)
VALUES ('user1', 1, NOW()),
       ('user2', 2, NOW()),
       ('user3', 3, NOW()),
       ('user4', 4, NOW()),
       ('user5', 5, NOW());

INSERT INTO user_rent_likes (user_id, rt_id, created_at)
VALUES ('user1', 1, NOW()),
       ('user2', 2, NOW()),
       ('user3', 3, NOW()),
       ('user4', 4, NOW()),
       ('user5', 5, NOW());

INSERT INTO user_settings (setting_id, user_id, display_color, language, set_at)
VALUES (1, 'user1', 'Dark', 'System', NOW()),
       (2, 'user2', 'Light', 'English', NOW()),
       (3, 'user3', 'Dark', 'Korean', NOW()),
       (4, 'user4', 'Light', 'System', NOW()),
       (5, 'user5', 'Dark', 'Korean', NOW());


INSERT INTO userlogin_logs (log_id, user_id, login_at, ip_address, user_agent)
VALUES (1, 'user1', NOW(), '192.168.1.1',
        'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/90.0.4430.212 Safari/537.36'),
       (2, 'user2', NOW(), '192.168.1.2',
        'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.77 Safari/537.36'),
       (3, 'user3', NOW(), '192.168.1.3',
        'Mozilla/5.0 (iPhone; CPU iPhone OS 14_6 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/14.0 Mobile/15E148 Safari/604.1'),
       (4, 'user4', NOW(), '192.168.1.4',
        'Mozilla/5.0 (Linux; Android 11; SM-A515F) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.120 Mobile Safari/537.36'),
       (5, 'user5', NOW(), '192.168.1.5',
        'Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:89.0) Gecko/20100101 Firefox/89.0');


INSERT INTO widgets (widget_id, user_id, widget_size, widget_is_used, widget_theme)
VALUES (1, 'user1', '1', TRUE, 'Light'),
       (2, 'user2', '2', FALSE, 'Dark'),
       (3, 'user3', '3', TRUE, 'Light'),
       (4, 'user4', '1', FALSE, 'Dark'),
       (5, 'user5', '2', TRUE, 'Light');


INSERT INTO widget_details (user_id, widget_id, info_name, widget_json)
VALUES ('user1', 1, 'Calendar Info', '{
  "type": "calendar",
  "data": {
    "format": "monthly",
    "theme": "dark"
  }
}'),
       ('user2', 2, 'Task Widget', '{
         "type": "task",
         "data": {
           "priorityLevel": "high",
           "theme": "light"
         }
       }'),
       ('user3', 3, 'Weather Update', '{
         "type": "weather",
         "data": {
           "location": "New York",
           "unit": "Celsius"
         }
       }'),
       ('user4', 4, 'Notes Widget', '{
         "type": "notes",
         "data": {
           "fontSize": "medium",
           "theme": "dark"
         }
       }'),
       ('user5', 5, 'Finance Tracker', '{
         "type": "finance",
         "data": {
           "currency": "USD",
           "theme": "light"
         }
       }');
