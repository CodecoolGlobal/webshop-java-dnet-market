--
-- PostgreSQL database dump
--

-- Dumped from database version 10.10 (Ubuntu 10.10-0ubuntu0.18.04.1)
-- Dumped by pg_dump version 10.10 (Ubuntu 10.10-0ubuntu0.18.04.1)

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: cart; Type: TABLE; Schema: public; Owner: kruppa
--

CREATE TABLE public.cart (
    id integer NOT NULL,
    product_id integer NOT NULL,
    supplier_id integer,
    name character varying(250),
    price integer,
    image text
);


ALTER TABLE public.cart OWNER TO kruppa;

--
-- Name: cart_id_seq; Type: SEQUENCE; Schema: public; Owner: kruppa
--

CREATE SEQUENCE public.cart_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.cart_id_seq OWNER TO kruppa;

--
-- Name: cart_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: kruppa
--

ALTER SEQUENCE public.cart_id_seq OWNED BY public.cart.id;


--
-- Name: categories; Type: TABLE; Schema: public; Owner: kruppa
--

CREATE TABLE public.categories (
    id integer NOT NULL,
    name character varying(250),
    department character varying(250),
    description character varying(250)
);


ALTER TABLE public.categories OWNER TO kruppa;

--
-- Name: categories_id_seq; Type: SEQUENCE; Schema: public; Owner: kruppa
--

CREATE SEQUENCE public.categories_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.categories_id_seq OWNER TO kruppa;

--
-- Name: categories_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: kruppa
--

ALTER SEQUENCE public.categories_id_seq OWNED BY public.categories.id;


--
-- Name: orderdao; Type: TABLE; Schema: public; Owner: kruppa
--

CREATE TABLE public.orderdao (
    name character varying(40),
    defaultprice double precision
);


ALTER TABLE public.orderdao OWNER TO kruppa;

--
-- Name: products; Type: TABLE; Schema: public; Owner: kruppa
--

CREATE TABLE public.products (
    id integer NOT NULL,
    supplier_id integer,
    category_id integer,
    name character varying(250),
    price integer,
    description character varying(250),
    image text
);


ALTER TABLE public.products OWNER TO kruppa;

--
-- Name: products_id_seq; Type: SEQUENCE; Schema: public; Owner: kruppa
--

CREATE SEQUENCE public.products_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.products_id_seq OWNER TO kruppa;

--
-- Name: products_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: kruppa
--

ALTER SEQUENCE public.products_id_seq OWNED BY public.products.id;


--
-- Name: registration; Type: TABLE; Schema: public; Owner: kruppa
--

CREATE TABLE public.registration (
    username character varying(40),
    password character varying(100)
);


ALTER TABLE public.registration OWNER TO kruppa;

--
-- Name: suppliers; Type: TABLE; Schema: public; Owner: kruppa
--

CREATE TABLE public.suppliers (
    id integer NOT NULL,
    name character varying(250),
    description character varying(250)
);


ALTER TABLE public.suppliers OWNER TO kruppa;

--
-- Name: cart id; Type: DEFAULT; Schema: public; Owner: kruppa
--

ALTER TABLE ONLY public.cart ALTER COLUMN id SET DEFAULT nextval('public.cart_id_seq'::regclass);


--
-- Name: categories id; Type: DEFAULT; Schema: public; Owner: kruppa
--

ALTER TABLE ONLY public.categories ALTER COLUMN id SET DEFAULT nextval('public.categories_id_seq'::regclass);


--
-- Name: products id; Type: DEFAULT; Schema: public; Owner: kruppa
--

ALTER TABLE ONLY public.products ALTER COLUMN id SET DEFAULT nextval('public.products_id_seq'::regclass);


--
-- Data for Name: cart; Type: TABLE DATA; Schema: public; Owner: kruppa
--

COPY public.cart (id, product_id, supplier_id, name, price, image) FROM stdin;
\.


--
-- Data for Name: categories; Type: TABLE DATA; Schema: public; Owner: kruppa
--

COPY public.categories (id, name, department, description) FROM stdin;
1	Tablet	Hardware	A tablet computer, commonly shortened to tablet, is a thin, flat mobile computer with a touchscreen display.
2	Laptop	Hardware	Just a laptop
\.


--
-- Data for Name: orderdao; Type: TABLE DATA; Schema: public; Owner: kruppa
--

COPY public.orderdao (name, defaultprice) FROM stdin;
első termék	30.3999999999999986
második termék	11.3000000000000007
pista	69
pista	69
pista	69
kecske	1
cica	2
kakas	3
\.


--
-- Data for Name: products; Type: TABLE DATA; Schema: public; Owner: kruppa
--

COPY public.products (id, supplier_id, category_id, name, price, description, image) FROM stdin;
1	1	1	Amazon Fire	50	Fantastic price. Large content ecosystem. Good parental controls. Helpful technical support.	\N
2	2	1	Lenovo IdeaPad Miix 700	479	Keyboard cover is included. Fanless Core m5 processor. Full-size USB ports. Adjustable kickstand.	\N
3	1	1	Amazon Fire HD 8	89	Amazons latest Fire HD 8 tablet is a great value for media consumption.	\N
4	3	2	HP EliteBook 850 G5 Laptop	599	Beautifully crafted with the modern professional in mind, the highly secure and manageable HP EliteBook 850 offers powerful collaboration tools, so you can be as productive as ever, on the go or at the office.	\N
0	1	1	Amazon Fire	50	Fantastic price. Large content ecosystem. Good parental controls. Helpful technical support.	képlófasz
5	\N	\N	new Laptop	0	This is a nice free Laptop	\N
\.


--
-- Data for Name: registration; Type: TABLE DATA; Schema: public; Owner: kruppa
--

COPY public.registration (username, password) FROM stdin;
+name+	+password+
unametest	ptest
ttt	aa
tomikahash	$2a$12$4sdjS5SBYkjUiUMyt9fg9exR8rkKAk4cbJjSvCP.clQQt8XIPhwAu
tomialegjobb	$2a$12$y770oAWNO8MrTqn7xKu8CeBAtaK2SmvQWokr0jSJCmPfMNViU6UrO
\.


--
-- Data for Name: suppliers; Type: TABLE DATA; Schema: public; Owner: kruppa
--

COPY public.suppliers (id, name, description) FROM stdin;
1	Amazon	Digital content and services
2	Lenovo	Computer
3	HP	Computer
\.


--
-- Name: cart_id_seq; Type: SEQUENCE SET; Schema: public; Owner: kruppa
--

SELECT pg_catalog.setval('public.cart_id_seq', 1, false);


--
-- Name: categories_id_seq; Type: SEQUENCE SET; Schema: public; Owner: kruppa
--

SELECT pg_catalog.setval('public.categories_id_seq', 1, false);


--
-- Name: products_id_seq; Type: SEQUENCE SET; Schema: public; Owner: kruppa
--

SELECT pg_catalog.setval('public.products_id_seq', 5, true);


--
-- Name: categories pk_category_id; Type: CONSTRAINT; Schema: public; Owner: kruppa
--

ALTER TABLE ONLY public.categories
    ADD CONSTRAINT pk_category_id PRIMARY KEY (id);


--
-- Name: cart pk_ordered_product_id; Type: CONSTRAINT; Schema: public; Owner: kruppa
--

ALTER TABLE ONLY public.cart
    ADD CONSTRAINT pk_ordered_product_id PRIMARY KEY (product_id);


--
-- Name: products pk_product_id; Type: CONSTRAINT; Schema: public; Owner: kruppa
--

ALTER TABLE ONLY public.products
    ADD CONSTRAINT pk_product_id PRIMARY KEY (id);


--
-- Name: suppliers pk_supplier_id; Type: CONSTRAINT; Schema: public; Owner: kruppa
--

ALTER TABLE ONLY public.suppliers
    ADD CONSTRAINT pk_supplier_id PRIMARY KEY (id);


--
-- Name: products fk_category_id; Type: FK CONSTRAINT; Schema: public; Owner: kruppa
--

ALTER TABLE ONLY public.products
    ADD CONSTRAINT fk_category_id FOREIGN KEY (category_id) REFERENCES public.categories(id);


--
-- Name: cart fk_ordered_product_id; Type: FK CONSTRAINT; Schema: public; Owner: kruppa
--

ALTER TABLE ONLY public.cart
    ADD CONSTRAINT fk_ordered_product_id FOREIGN KEY (product_id) REFERENCES public.products(id);


--
-- Name: cart fk_ordered_supplier_id; Type: FK CONSTRAINT; Schema: public; Owner: kruppa
--

ALTER TABLE ONLY public.cart
    ADD CONSTRAINT fk_ordered_supplier_id FOREIGN KEY (supplier_id) REFERENCES public.suppliers(id);


--
-- Name: products fk_supplier_id; Type: FK CONSTRAINT; Schema: public; Owner: kruppa
--

ALTER TABLE ONLY public.products
    ADD CONSTRAINT fk_supplier_id FOREIGN KEY (supplier_id) REFERENCES public.suppliers(id);


--
-- PostgreSQL database dump complete
--

