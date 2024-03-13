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
    PRIMARY KEY (id)
);


CREATE TABLE user_role (
  user_id BINARY(16) NOT NULL,
  role_id BINARY(16) NOT NULL,
  PRIMARY KEY (user_id, role_id),
  INDEX user_role_role_fk_idx (role_id ASC) VISIBLE,
  CONSTRAINT user_role_user_fk
    FOREIGN KEY (user_id)
    REFERENCES user (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT user_role_role_fk
    FOREIGN KEY (role_id)
    REFERENCES role (id));

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
    
    PRIMARY KEY (id)
);



CREATE TABLE category
(
    id            BINARY(16)  NOT NULL,
    category_name  VARCHAR(45) NOT NULL,
   
    PRIMARY KEY (id)
);

CREATE TABLE product_category (
  product_id BINARY(16) NOT NULL,
  category_id BINARY(16) NOT NULL,
  PRIMARY KEY (product_id, category_id),
  INDEX product_category_category_fk_idx (category_id ASC) VISIBLE,
  CONSTRAINT product_category_product_fk
    FOREIGN KEY (product_id)
    REFERENCES product (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT product_category_category_fk
    FOREIGN KEY (category_id)
    REFERENCES category (id));