
-- password: 123
insert into app_user (username, email, encryted_password, enabled)
values ('admin','admin@gmail.com', '$2a$10$Ospln.DGhNmOQe6ilKSxT.YRBdxvLsMxlngIYCGPcnaGHllYNpDQ.', true);



insert into  role ( role_name)
values ( 'ROLE_ADMIN'),
( 'ROLE_DRIVER');

insert into  user_role (app_user_user_id, role_role_id)
values ((SELECT user_id FROM app_user WHERE username = 'admin'),(SELECT role_id FROM role WHERE role_name = 'ROLE_ADMIN'));

