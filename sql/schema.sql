create table Product(
    id serial primary key,
    name varchar(255) not null unique,
    price numeric(12, 2) not null,
    creation_datetime timestamp not null
);

create table Product_category(
    id serial primary key,
    name varchar(255) not null,
    product_id int references product(id)
);