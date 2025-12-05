show databases;

create database if not exists kuliah_toko;

use kuliah_toko;

create table `customer`
(
    id_customer int(5),
    name        varchar(50) not null,
    email       varchar(50),
    address     text,
    primary key (id_customer),
    constraint email_unique unique (email)
) engine = innoDB;

desc customer;

create table `company`
(
    id_company int(5),
    name       varchar(50) not null,
    primary key (id_company)
) engine = innoDB;

desc company;

create table `product`
(
    id_product int(5),
    name       varchar(30) not null,
    price      int(8),
    company_id int(5),
    primary key (id_product),
    constraint fk_product_company foreign key (company_id) references company (id_company) on delete restrict on update restrict
) engine = innoDB;

desc product;

create table `order`
(
    id_order    int(5),
    id_customer int(5),
    id_product  int(5),
    date        datetime default current_timestamp,
    quantity    int(3),
    primary key (id_order),
    constraint fk_order_customer foreign key (id_customer) references customer (id_customer) on delete restrict on update restrict,
    constraint fk_order_product foreign key (id_product) references product (id_product) on delete restrict on update restrict
) engine = innoDB;

desc `order`;