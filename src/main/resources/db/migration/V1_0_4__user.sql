INSERT INTO user (id, user_name, password, email,role_id)
VALUES (UNHEX(REPLACE(UUID(), '-', '')), 'a', 'a', 'a@gmail.com',1);

INSERT INTO user (id, user_name, password, email,role_id)
VALUES (UNHEX(REPLACE(UUID(), '-', '')), 'b', 'b', 'b@gmail.com',2);

INSERT INTO user (id, user_name, password, email,role_id)
VALUES (UNHEX(REPLACE(UUID(), '-', '')), 'c', 'c', 'c@gmail.com',3);
