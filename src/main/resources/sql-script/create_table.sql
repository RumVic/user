CREATE TABLE IF NOT EXISTS public.role
(
    id uuid NOT NULL,
    role character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT role_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.role
    OWNER to postgres;

CREATE TABLE IF NOT EXISTS public.users
(
    id uuid NOT NULL,
    date_of_birth date,
    email character varying(255) COLLATE pg_catalog."default",
    name character varying(255) COLLATE pg_catalog."default",
    password character varying(255) COLLATE pg_catalog."default",
    surname character varying(255) COLLATE pg_catalog."default",
    role_id uuid,
    CONSTRAINT users_pkey PRIMARY KEY (id),
    CONSTRAINT fk4qu1gr772nnf6ve5af002rwya FOREIGN KEY (role_id)
        REFERENCES public.role (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.users
    OWNER to postgres;
