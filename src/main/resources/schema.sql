CREATE TABLE customer(
  customer_id BIGINT AUTO_INCREMENT PRIMARY KEY,
  first_name VARCHAR(100),
  last_name VARCHAR(100)
);
-- CREATE SEQUENCE customer_sequence_id start with (select max(customer_id) + 1 from customer);

CREATE TABLE order_sale(
                           order_sale_id BIGINT AUTO_INCREMENT PRIMARY KEY,
                           amount DECIMAL(10,2) NOT NULL ,
                           customer_id BIGINT,
                           transaction_date TIMESTAMP NOT NULL,
                           rewards INT
);

ALTER TABLE order_sale ADD FOREIGN KEY (customer_id) REFERENCES customer(customer_id);
-- ALTER TABLE order_sale ADD FOREIGN KEY (order_sale_product_id) REFERENCES order_sale_product(id);


CREATE TABLE order_sale_product(
    order_sale_product_id BIGINT AUTO_INCREMENT ,
    order_sale_id BIGINT,
    name VARCHAR(100),
    description VARCHAR(200),
    price DECIMAL(10,2) NOT NULL ,
    quantity INT
);

ALTER TABLE order_sale_product ADD FOREIGN KEY (order_sale_id) REFERENCES order_sale(order_sale_id);
-- ALTER TABLE order_sale_product ADD FOREIGN KEY (product_id) REFERENCES product(product_id);