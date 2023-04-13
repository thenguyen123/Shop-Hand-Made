create database shop_hand_made;
use shop_hand_made;
create table role (
id int primary key auto_increment,
name varchar(25)
);
create table account(
id bigint primary key auto_increment,
password varchar(225)
);
create table account_role (
id bigint  primary key auto_increment,
id_role int,
id_account bigint ,
foreign key (id_role) references `role`(id),
foreign key (id_account) references account(id)
);
create table position (
id int primary key auto_increment,
name varchar(45)
);
create	table salesman(
id bigint  primary key auto_increment,
name varchar(45),
phone_number varchar(45),
id_card varchar(45) unique,
address varchar (225),
gender boolean,
day_of_birth date,
position_id int,
email_account varchar(45) unicode,
id_account bigint,
foreign key (id_account) references account(id),
foreign key (position_id) references `position`(id)
);
create table customer (
id bigint  primary key auto_increment,
name varchar(45),
day_of_birth varchar(45),
phone_number varchar(45),
id_card varchar(45) unicode,
address varchar (225),
gender boolean,
email varchar(45) unique,
id_account bigint,
foreign key (id_account) references account(id)
);
create table types(
id int primary key auto_increment, 
name varchar (45)
) ;
create table product (
id bigint  primary key auto_increment,
image varchar(300),
name varchar(45),
prices double,
description varchar(400),
date_submitted date,
quantity int ,
type_product int,
salesman_id bigint ,
foreign key (salesman_id) references salesman(id),
foreign key (type_product) references types(id)
);
create table `order` (
id int primary key auto_increment ,
code_oder varchar(45) unique,
date_purchase date ,
total_pay double,
product_id bigint ,
customer_id bigint ,
foreign key (product_id) references product(id),
foreign key (customer_id) references customer(id)
);