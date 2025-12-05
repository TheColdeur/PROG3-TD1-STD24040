create database product_management_db;

create user product_manager_user with password '123456';
\c product_management_db
grant create on schema public to product_manager_user;
grant select, insert, update, delete on all tables schema public to product_manager_user; 
grant all privileges on database "product_management_db" to product_manager_user;

\c product_management_db product_manager_user; -- connect to the database product_management_db as product_manager_user