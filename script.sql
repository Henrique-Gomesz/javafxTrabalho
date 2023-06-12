--
-- PostgreSQL database dump
--

-- Dumped from database version 14.4
-- Dumped by pg_dump version 14.4

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

SET default_table_access_method = heap;

--
-- Name: banco; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.banco (
    bco_id integer NOT NULL,
    bco_numero numeric(3,0),
    bco_nome character varying(30)
);


ALTER TABLE public.banco OWNER TO postgres;

--
-- Name: banco_bco_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.banco_bco_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.banco_bco_id_seq OWNER TO postgres;

--
-- Name: banco_bco_id_seq1; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.banco_bco_id_seq1
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.banco_bco_id_seq1 OWNER TO postgres;

--
-- Name: banco_bco_id_seq1; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.banco_bco_id_seq1 OWNED BY public.banco.bco_id;


--
-- Name: cheque; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.cheque (
    che_id integer NOT NULL,
    che_agencia integer,
    che_conta integer,
    che_documento numeric(14,0),
    che_correntista character varying(40),
    che_valor numeric(9,2),
    che_data timestamp without time zone,
    bco_id integer,
    op_id integer
);


ALTER TABLE public.cheque OWNER TO postgres;

--
-- Name: cheque_che_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.cheque_che_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.cheque_che_id_seq OWNER TO postgres;

--
-- Name: cheque_che_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.cheque_che_id_seq OWNED BY public.cheque.che_id;


--
-- Name: cliente; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.cliente (
    cli_id integer NOT NULL,
    cli_documento numeric(14,0),
    cli_nome character varying(40),
    cli_cep numeric(8,0),
    cli_endereco character varying(50),
    cli_numero character varying(10),
    cli_cidade character varying(30),
    cli_uf character varying(2),
    cli_bairro character varying(30),
    cli_fone character varying(15),
    cli_email character varying(50),
    cli_juros numeric(3,1)
);


ALTER TABLE public.cliente OWNER TO postgres;

--
-- Name: cliente_cli_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.cliente_cli_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.cliente_cli_id_seq OWNER TO postgres;

--
-- Name: cliente_cli_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.cliente_cli_id_seq OWNED BY public.cliente.cli_id;


--
-- Name: empresa; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.empresa (
    emp_id integer NOT NULL,
    emp_razao character varying(40),
    emp_fantasia character varying(40)
);


ALTER TABLE public.empresa OWNER TO postgres;

--
-- Name: empresa_emp_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.empresa_emp_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.empresa_emp_id_seq OWNER TO postgres;

--
-- Name: empresa_emp_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.empresa_emp_id_seq OWNED BY public.empresa.emp_id;


--
-- Name: operacao; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.operacao (
    op_id integer NOT NULL,
    op_data timestamp without time zone,
    op_juros numeric(3,1),
    "op_valor-liquido" numeric(9,2),
    cli_id integer
);


ALTER TABLE public.operacao OWNER TO postgres;

--
-- Name: operacao_op_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.operacao_op_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.operacao_op_id_seq OWNER TO postgres;

--
-- Name: operacao_op_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.operacao_op_id_seq OWNED BY public.operacao.op_id;


--
-- Name: banco bco_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.banco ALTER COLUMN bco_id SET DEFAULT nextval('public.banco_bco_id_seq1'::regclass);


--
-- Name: cheque che_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cheque ALTER COLUMN che_id SET DEFAULT nextval('public.cheque_che_id_seq'::regclass);


--
-- Name: cliente cli_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cliente ALTER COLUMN cli_id SET DEFAULT nextval('public.cliente_cli_id_seq'::regclass);


--
-- Name: empresa emp_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.empresa ALTER COLUMN emp_id SET DEFAULT nextval('public.empresa_emp_id_seq'::regclass);


--
-- Name: operacao op_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.operacao ALTER COLUMN op_id SET DEFAULT nextval('public.operacao_op_id_seq'::regclass);


--
-- Data for Name: banco; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.banco VALUES (1, 104, 'Caixa Economica Federal');
INSERT INTO public.banco VALUES (3, 33, 'Santander');
INSERT INTO public.banco VALUES (4, 1, 'Banco do Brasil');
INSERT INTO public.banco VALUES (2, 237, 'Bradesco SA');


--
-- Data for Name: cheque; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- Data for Name: cliente; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- Data for Name: empresa; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- Data for Name: operacao; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- Name: banco_bco_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.banco_bco_id_seq', 3, true);


--
-- Name: banco_bco_id_seq1; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.banco_bco_id_seq1', 4, true);


--
-- Name: cheque_che_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.cheque_che_id_seq', 1, false);


--
-- Name: cliente_cli_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.cliente_cli_id_seq', 1, false);


--
-- Name: empresa_emp_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.empresa_emp_id_seq', 1, false);


--
-- Name: operacao_op_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.operacao_op_id_seq', 1, false);


--
-- Name: banco banco_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.banco
    ADD CONSTRAINT banco_pkey PRIMARY KEY (bco_id);


--
-- Name: cheque cheque_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cheque
    ADD CONSTRAINT cheque_pkey PRIMARY KEY (che_id);


--
-- Name: cliente cliente_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cliente
    ADD CONSTRAINT cliente_pkey PRIMARY KEY (cli_id);


--
-- Name: empresa empresa_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.empresa
    ADD CONSTRAINT empresa_pkey PRIMARY KEY (emp_id);


--
-- Name: operacao operacao_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.operacao
    ADD CONSTRAINT operacao_pkey PRIMARY KEY (op_id);


--
-- Name: cheque cheque_bco_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cheque
    ADD CONSTRAINT cheque_bco_id_fkey FOREIGN KEY (bco_id) REFERENCES public.banco(bco_id);


--
-- Name: cheque cheque_op_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cheque
    ADD CONSTRAINT cheque_op_id_fkey FOREIGN KEY (op_id) REFERENCES public.operacao(op_id) NOT VALID;


--
-- Name: operacao operacao_cli_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.operacao
    ADD CONSTRAINT operacao_cli_id_fkey FOREIGN KEY (cli_id) REFERENCES public.cliente(cli_id);


--
-- PostgreSQL database dump complete
--

