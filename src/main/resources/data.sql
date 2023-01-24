insert into customer (first_name, last_name) values
('IGNACIO', 'DAVALOS'),
('Jack', 'Bauer'),
('Chloe', 'OBrian'),
('Kim', 'Bauer'),
('David', 'Palmer'),
('Michelle', 'Dessler');


insert into order_sale (amount, customer_id, transaction_date, rewards) values
    (160, 1, '2023-01-21 16:30:01.850', 23),
    (40, 2, '2023-01-21 16:30:01.850', 23),
    (450, 3, '2023-01-21 16:30:01.850', 23),
    (110, 4, '2023-01-21 16:30:01.850', 23),
    (20, 5, '2023-01-21 16:30:01.850', 23);
-- insert into product (name, description, list_price) values

insert into order_sale_product(order_sale_id, name,description, price, quantity) values
    (1,'producto 1', 'description 1', 20,2),
    (1, 'producto 2', 'description 2', 140, 3),
    (2, 'producto 3', 'description 3', 90, 2),
    (2, 'producto 4', 'description 4', 70, 1);
