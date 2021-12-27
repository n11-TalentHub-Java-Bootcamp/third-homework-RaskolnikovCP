create table IF NOT EXISTS category  (id bigint not null, name varchar(50) not null, refraction bigint, id_top_category bigint, primary key (id));
create table IF NOT EXISTS product  (id bigint not null, name varchar(50), price decimal(19,2), register_date timestamp, id_category bigint, primary key (id));
create sequence IF NOT EXISTS category_id_seq  start with 10 increment by 100;
create sequence IF NOT EXISTS product_id_seq  start with 10 increment by 100;
alter table category add constraint FK634b48g2infjssbxao4kyf88b foreign key (id_top_category) references category;
alter table product add constraint FK_PRODUCT_CATEGORY_ID foreign key (id_category) references category;
