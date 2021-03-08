-- SEQUENCE: public.feadback_id_seq

-- DROP SEQUENCE public.feadback_id_seq;

CREATE SEQUENCE public.feadback_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE public.feadback_id_seq
    OWNER TO postgres;
-- Table: public.reviews

-- DROP TABLE public.reviews;

CREATE TABLE public.reviews
(
    id bigint NOT NULL DEFAULT nextval('feadback_id_seq'::regclass),
    text character varying(1000) COLLATE pg_catalog."default",
    score integer NOT NULL,
    name character varying(250) COLLATE pg_catalog."default",
    gender character varying(1) COLLATE pg_catalog."default",
    CONSTRAINT feadback_pkey PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.reviews
    OWNER to postgres;