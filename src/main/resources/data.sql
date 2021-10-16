DROP TABLE IF EXISTS PRICES;
DROP TABLE IF EXISTS BRANDS;

CREATE TABLE BRANDS (
    id bigint NOT NULL AUTO_INCREMENT,
    name varchar(255),
    PRIMARY KEY (id)
);

CREATE TABLE PRICES (
    id bigint NOT NULL AUTO_INCREMENT,
    brand_id bigint NOT NULL,
    start_date datetime,
    end_date datetime,
    price_list int,
    product_id bigint,
    priority int,
    price double,
    curr varchar,
    PRIMARY KEY (id),
    FOREIGN KEY (brand_id) REFERENCES BRANDS(id)
);

INSERT INTO BRANDS (name) VALUES ('ZARA');
INSERT INTO BRANDS (name) VALUES ('BERSKA');

INSERT INTO PRICES (brand_id, product_id, price, start_date, end_date, curr, price_list, priority)
VALUES(1, 35455, 35.50, '2020-06-14 00:00:00', '2020-12-31 23:59:59', 'EUR', 1, 0),
      (1, 35455, 25.45, '2020-06-14 15:00:00', '2020-06-14 18:30:00', 'EUR', 2, 1),
      (1, 35455, 30.50, '2020-06-15 00:00:00', '2020-06-15 11:00:00', 'EUR', 3, 1),
      (1, 35455, 38.95, '2020-06-15 16:00:00', '2020-12-31 23:59:59', 'EUR', 4, 1);

