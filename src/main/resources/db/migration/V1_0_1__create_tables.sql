CREATE TABLE user
(
    id            BINARY(16)   NOT NULL,
    user_name 		VARCHAR(45)  NULL,
    password      VARCHAR(200) NOT NULL,
    email         VARCHAR(200) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE role
(
    id           BINARY(16)  NOT NULL,
    role         VARCHAR(45) NOT NULL,
    user_id  BINARY(16),
    FOREIGN KEY (user_id) REFERENCES user (id),
    PRIMARY KEY (id)
);

CREATE TABLE product
(
    id            BINARY(16)  NOT NULL,
    product_name  VARCHAR(45) NOT NULL,
    unit_in_stock INT(3) NOT NULL,
    unit_price    DECIMAL(5,2) NOT NULL,
    min_stock     INT(2) NOT NULL,
    product_desc  VARCHAR(200) NULL,

    PRIMARY KEY (id)
);

CREATE TABLE rack
(
    id           BINARY(16)  NOT NULL,
    rack_coloumn         VARCHAR(45) NOT NULL,
    rack_row         VARCHAR(45) NOT NULL,
    rack_count         INT(1)  NULL,
    rack_capacity         INT(1) NOT NULL,
	 FOREIGN KEY (product_id) REFERENCES product (id),
    PRIMARY KEY (id)
);



CREATE TABLE category
(
    id            BINARY(16)  NOT NULL,
    category_name  VARCHAR(45) NOT NULL,
    
    FOREIGN KEY (product_id) REFERENCES product (id),
    PRIMARY KEY (id)
);