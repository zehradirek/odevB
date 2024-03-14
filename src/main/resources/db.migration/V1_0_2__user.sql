INSERT INTO user (id, user_name, password, email)
VALUES (UNHEX(REPLACE(UUID(), '-', '')), 'a', 'a', 'a@gmail.com');

INSERT INTO user (id, user_name, password, email)
VALUES (UNHEX(REPLACE(UUID(), '-', '')), 'b', 'b', 'b@gmail.com');

INSERT INTO user (id, user_name, password, email)
VALUES (UNHEX(REPLACE(UUID(), '-', '')), 'c', 'c', 'c@gmail.com');
INSERT INTO user (id, user_name, password, email)
VALUES (UNHEX(REPLACE(UUID(), '-', '')), 'd', 'd', 'd@gmail.com');