
insert into roles(name) values ('admin');
insert into roles values (2 ,'user');



insert into users values (1, 'Kamil','Zeberga','123','kamil');
insert into users values (2, 'Deme','Minyahil','123','Demelash');
insert into users values (3, 'Asteway','Yiheyis','123','Asteway');

insert into user_roles(user_id,role_id) values (1, 1);
insert into user_roles(user_id,role_id) values (1, 2);

insert into user_roles(user_id,role_id) values (2, 1);
insert into user_roles(user_id,role_id) values (3, 2);