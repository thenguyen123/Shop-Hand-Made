create database shop_hand_made;
use shop_hand_made;
create table role (
id int primary key auto_increment,
name varchar(25)
);
create	table app_user(
id bigint  primary key auto_increment,
name varchar(45),
phone_number varchar(45),
address varchar (225),
gender boolean,
day_of_birth date,
email varchar(45) unicode,
password varchar(225)
);
create table user_role (
id bigint  primary key auto_increment,
id_role int,
id_user bigint ,
foreign key (id_role) references `role`(id),
foreign key (id_user) references app_user(id)
);


create table types(
id int primary key auto_increment, 
name varchar (45)
) ;
create table product (
id bigint  primary key auto_increment,
name varchar(45),
is_delete boolean,
prices double,
description text,
date_submitted date,
quantity int ,
type_product int,
foreign key (type_product) references types(id)
);
create table image(
id bigint primary key auto_increment,
img text,
product_id bigint ,
foreign key (product_id) references product(id)
);
create table cart (
id bigint primary key auto_increment ,
date_purchase date ,
total_pay double,
id_user bigint ,
foreign key (id_user) references app_user(id)
);
create table cart_detail(
id bigint auto_increment primary key,
amount int,
is_flag boolean,
order_id bigint,
product_id bigint,
day_pay_pal date,
foreign key (product_id) references product(id),
foreign key (order_id) references order_product(id)
)