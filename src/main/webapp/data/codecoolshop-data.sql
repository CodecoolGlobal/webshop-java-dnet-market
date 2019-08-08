ALTER TABLE IF EXISTS ONLY public.products DROP CONSTRAINT IF EXISTS pk_product_id CASCADE;
ALTER TABLE IF EXISTS ONLY public.suppliers DROP CONSTRAINT IF EXISTS pk_supplier_id CASCADE;
ALTER TABLE IF EXISTS ONLY public.categories DROP CONSTRAINT IF EXISTS pk_category_id CASCADE;
ALTER TABLE IF EXISTS ONLY public.cart DROP CONSTRAINT IF EXISTS pk_ordered_product_id CASCADE;

DROP TABLE IF EXISTS public.products;
DROP SEQUENCE IF EXISTS public.product_id_seq;
CREATE TABLE products (
                          id int,
                          supplier_id int,
                          category_id int,
                          name varchar(250),
                          price integer,
                          description varchar(250),
                          image text
);

DROP TABLE IF EXISTS public.suppliers;
DROP SEQUENCE IF EXISTS public.suppplier_id_seq;
CREATE TABLE suppliers (
                            id int,
                            name varchar(250),
                            description varchar(250)
);


DROP TABLE IF EXISTS public.categories;
DROP SEQUENCE IF EXISTS public.category_id_seq;
CREATE TABLE categories (
                            id int,
                            name varchar(250),
                            department varchar(250),
                            description varchar(250)

);

DROP TABLE IF EXISTS public.cart;
CREATE TABLE cart (
                    id serial NOT NULL,
                    product_id int,
                    supplier_id int,
                    name varchar(250),
                    price int,
                    image text

);


ALTER TABLE ONLY products
    ADD CONSTRAINT pk_product_id PRIMARY KEY (id);

ALTER TABLE ONLY suppliers
    ADD CONSTRAINT pk_supplier_id PRIMARY KEY (id);

ALTER TABLE ONLY categories
    ADD CONSTRAINT pk_category_id PRIMARY KEY (id);

ALTER TABLE ONLY cart
    ADD CONSTRAINT pk_ordered_product_id PRIMARY KEY (product_id);

ALTER TABLE ONLY products
    ADD CONSTRAINT fk_supplier_id FOREIGN KEY (supplier_id) REFERENCES suppliers(id);

ALTER TABLE ONLY products
    ADD CONSTRAINT fk_category_id FOREIGN KEY (category_id) REFERENCES categories(id);

ALTER TABLE ONLY cart
    ADD CONSTRAINT fk_ordered_product_id FOREIGN KEY (product_id) REFERENCES products(id);

ALTER TABLE ONLY cart
    ADD CONSTRAINT fk_ordered_supplier_id FOREIGN KEY (supplier_id) REFERENCES suppliers(id);


INSERT INTO suppliers VALUES(1, 'Amazon', 'Digital content and services');
INSERT INTO suppliers VALUES(2, 'Lenovo', 'Computer');
INSERT INTO suppliers VALUES(3, 'HP', 'Computer');


INSERT INTO categories VALUES(1, 'Tablet', 'Hardware', 'A tablet computer, commonly shortened to tablet, is a thin, flat mobile computer with a touchscreen display.');
INSERT INTO categories VALUES (2, 'Laptop', 'Hardware', 'Just a laptop');

INSERT INTO products VALUES (1, 1, 1, 'Amazon Fire', 49.9, 'Fantastic price. Large content ecosystem. Good parental controls. Helpful technical support.');
INSERT INTO products VALUES (2, 2, 1, 'Lenovo IdeaPad Miix 700',  479, 'Keyboard cover is included. Fanless Core m5 processor. Full-size USB ports. Adjustable kickstand.');
INSERT INTO products VALUES (3, 1, 1, 'Amazon Fire HD 8', 89, 'Amazons latest Fire HD 8 tablet is a great value for media consumption.');
INSERT INTO products VALUES (4, 3, 2, 'HP EliteBook 850 G5 Laptop', 599, 'Beautifully crafted with the modern professional in mind, the highly secure and manageable HP EliteBook 850 offers powerful collaboration tools, so you can be as productive as ever, on the go or at the office.');




