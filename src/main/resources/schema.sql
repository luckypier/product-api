CREATE TABLE product (
    id INTEGER NOT NULL AUTO_INCREMENT,
    category VARCHAR(20) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE product_detail (
    id INTEGER NOT NULL AUTO_INCREMENT,
    id_product   INTEGER NOT NULL,
    country VARCHAR(10) NOT NULL,
    price FLOAT NOT NULL,
    stock INT NOT NULL,
    shipping_fee FLOAT,
    PRIMARY KEY (id)
);

