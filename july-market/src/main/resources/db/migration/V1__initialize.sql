drop table if exists products cascade;
create table products (id bigserial, title varchar(255), description varchar(5000), price int, primary key(id));
insert into products
(title, description, price) values
('Cheese', 'Fresh cheese', 320),
('Milk', 'Fresh milk', 80),
('Apples', 'Fresh apples', 80),
('Bread', 'Fresh bread', 30)
('Product 1', 'Description 1', 70),
('Product 2', 'Description 2', 80),
('Product 3', 'Description 3', 90),
('Product 4', 'Description 4', 100),
('Product 5', 'Description 5', 120),
('Product 6', 'Description 6', 130),
('Product 7', 'Description 7', 140),
('Product 8', 'Description 8', 150),
('Product 9', 'Description 9', 160),
('Product 10', 'Description 10', 170),
('Product 11', 'Description 11', 180),
('Product 12', 'Description 12', 190),
('Product 13', 'Description 13', 200),
('Product 14', 'Description 14', 700),
('Product 15', 'Description 15', 300),
('Product 16', 'Description 16', 400),
('Product 17', 'Description 17', 7100),
('Product 18', 'Description 18', 500);

drop table if exists categories cascade;
create table categories (id bigserial, title varchar(255), primary key(id));
insert into categories (title) values
('Food'),
('Devices');

drop table if exists products_categories cascade;
create table products_categories (product_id bigint not null, category_id bigint not null, primary key (product_id,
category_id), foreign key (product_id) references products(id), foreign key (category_id) references categories(id));
insert into products_categories (product_id, category_id) values (1, 1), (2, 1), (3, 1), (4, 2);

drop table if exists users;
create table users (id bigserial, phone VARCHAR(100) not null UNIQUE, password VARCHAR(100) not null, email VARCHAR(100)
UNIQUE, first_name VARCHAR(100), last_name VARCHAR(100), PRIMARY KEY (id));
insert into users (phone, password, first_name, last_name, email) values
('79251164883','$2y$12$ncit79OKWixc2tH4Oz6BGuyj7CcHnt/AQCLowXvbFrgEuCb.rKi2.','ivan','ivanov','ivan@mail.ru');
('79253164883','$2y$12$ncit79OKWixc2tH4Oz6BGuyj7CcHnt/AQCLowXvbFrgEuCb.rKi2.','semen','ivanov','semen@mail.ru');

drop table if exists roles;
create table roles (id serial, name VARCHAR(100) not null, primary key (id));
insert into roles (name) values ('ROLE_USER'),('ROLE_ADMIN');

drop table if exists users_roles;
create table users_roles (user_id INT NOT NULL, role_id INT NOT NULL, primary key (user_id, role_id), FOREIGN KEY
(user_id) REFERENCES users (id), FOREIGN KEY (role_id) REFERENCES roles (id));
insert into users_roles (user_id, role_id) values
(1, 1),
(2, 2);