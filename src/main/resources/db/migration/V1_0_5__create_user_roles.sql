insert into user_role values (
(select id from user where user_name = 'a'),
(select id from roles where role = 'admin'));

insert into user_role values (
(select id from user where user_name = 'b'),
(select id from roles where role = 'supervisor'));


insert into user_role values (
(select id from user where user_name = 'c'),
(select id from roles where role = 'reporter'));