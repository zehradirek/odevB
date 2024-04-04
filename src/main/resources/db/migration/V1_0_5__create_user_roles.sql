# insert into user_role (user_id, role_id)
# values ((select id from user where username = 'a'),
#         (select id from role where role = 'admin'));
#
# insert into user_role (user_id, role_id)
# values ((select id from user where username = 'b'),
#         (select id from role where role = 'supervisor'));
#
#
# insert into user_role (user_id, role_id)
# values ((select id from user where username = 'c'),
#         (select id from role where role = 'reporter'))