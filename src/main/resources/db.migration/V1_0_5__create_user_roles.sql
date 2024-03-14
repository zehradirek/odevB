insert into user_role values (
(select id from user where user_name = 'a'),
                                 (select id from role where role = 'admin'));

insert into user_role values (
                                 (select id from user where user_name = 'b'),
                                 (select id from role where role = 'supervisor'));


insert into user_role values (
                                 (select id from user where user_name = 'c'),
                                 (select id from role where role = 'reporter'));