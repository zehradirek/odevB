CREATE TABLE role
(
    id   INT UNSIGNED AUTO_INCREMENT NOT NULL PRIMARY KEY,
    role VARCHAR(45)                 NOT NULL
);

CREATE TABLE user
(
    id        BINARY(16)   NOT NULL,
    user_name VARCHAR(45)  NULL,
    password  VARCHAR(200) NOT NULL,
    email     VARCHAR(200) NOT NULL,
    role_id   INT UNSIGNED NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT fk_role_id
        FOREIGN KEY (role_id)
            REFERENCES role (id)
);

CREATE TABLE category
(
    id            INT UNSIGNED AUTO_INCREMENT  NOT NULL,
    category_name VARCHAR(45)  NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE rack
(
    id            INT UNSIGNED AUTO_INCREMENT NOT NULL,
    rack_column   VARCHAR(45)                 NOT NULL,
    rack_row      VARCHAR(45)                 NOT NULL,
    rack_count    INT                         NULL,
    rack_capacity INT                         NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE product
(
    id            INT UNSIGNED AUTO_INCREMENT NOT NULL,
    product_name  VARCHAR(45)                 NOT NULL,
    unit_in_stock INT                         NOT NULL,
    unit_price    DECIMAL(5, 2)               NOT NULL,
    min_stock     INT                         NOT NULL,
    product_desc  VARCHAR(200)                NULL,
    category_id   INT UNSIGNED                NOT NULL, -- Kategoriye ait dış anahtar
    rack_id       INT UNSIGNED                NULL,     -- Raf id
    PRIMARY KEY (id),
    CONSTRAINT fk_category_id
    FOREIGN KEY (category_id)
    REFERENCES category (id),
    CONSTRAINT fk_rack_id
    FOREIGN KEY (rack_id)
    REFERENCES rack (id)
    );



