    --TODO: use flyway or liquibase

INSERT INTO product (category) VALUES ('TABLET');
INSERT INTO product (category) VALUES ('PHONE');
INSERT INTO product (category) VALUES ('PHONE');
INSERT INTO product (category) VALUES ('TABLET');

INSERT INTO product_detail (id_product, country, price, stock, shipping_fee) VALUES (1, 'PE', 250.5, 55, 10.5);
INSERT INTO product_detail (id_product, country, price, stock, shipping_fee) VALUES (1, 'USA', 72.5, 78, 5.2);
