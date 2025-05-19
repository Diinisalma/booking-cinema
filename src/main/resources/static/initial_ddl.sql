-- DROP SCHEMA public;

CREATE SCHEMA public AUTHORIZATION pg_database_owner;

COMMENT ON SCHEMA public IS 'standard public schema';

-- DROP SEQUENCE public.t_booking_seat_id_seq;

CREATE SEQUENCE public.t_booking_seat_id_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;
-- DROP SEQUENCE public.t_cinema_id_seq;

CREATE SEQUENCE public.t_cinema_id_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 2147483647
	START 1
	CACHE 1
	NO CYCLE;
-- DROP SEQUENCE public.t_city_id_seq;

CREATE SEQUENCE public.t_city_id_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 2147483647
	START 1
	CACHE 1
	NO CYCLE;
-- DROP SEQUENCE public.t_movie_id_seq;

CREATE SEQUENCE public.t_movie_id_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 2147483647
	START 1
	CACHE 1
	NO CYCLE;
-- DROP SEQUENCE public.t_movie_studio_schedule_id_seq;

CREATE SEQUENCE public.t_movie_studio_schedule_id_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 2147483647
	START 1
	CACHE 1
	NO CYCLE;
-- DROP SEQUENCE public.t_seat_element_id_seq;

CREATE SEQUENCE public.t_seat_element_id_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 2147483647
	START 1
	CACHE 1
	NO CYCLE;
-- DROP SEQUENCE public.t_seat_studio_id_seq;

CREATE SEQUENCE public.t_seat_studio_id_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 2147483647
	START 1
	CACHE 1
	NO CYCLE;
-- DROP SEQUENCE public.t_seat_type_id_seq;

CREATE SEQUENCE public.t_seat_type_id_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 2147483647
	START 1
	CACHE 1
	NO CYCLE;
-- DROP SEQUENCE public.t_studio_id_seq;

CREATE SEQUENCE public.t_studio_id_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 2147483647
	START 1
	CACHE 1
	NO CYCLE;
-- DROP SEQUENCE public.t_studio_type_id_seq;

CREATE SEQUENCE public.t_studio_type_id_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 2147483647
	START 1
	CACHE 1
	NO CYCLE;
-- DROP SEQUENCE public.t_user_id_seq;

CREATE SEQUENCE public.t_user_id_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 2147483647
	START 1
	CACHE 1
	NO CYCLE;-- public.t_city definition

-- Drop table

-- DROP TABLE public.t_city;

CREATE TABLE public.t_city (
	id bigserial NOT NULL,
	"name" varchar(255) NULL,
	CONSTRAINT city_pkey PRIMARY KEY (id)
);


-- public.t_movie definition

-- Drop table

-- DROP TABLE public.t_movie;

CREATE TABLE public.t_movie (
	id bigserial NOT NULL,
	title varchar(255) NULL,
	synopsis varchar(200) NULL,
	genre _varchar NULL,
	duration int2 NULL,
	CONSTRAINT movie_pkey PRIMARY KEY (id)
);


-- public.t_seat_element definition

-- Drop table

-- DROP TABLE public.t_seat_element;

CREATE TABLE public.t_seat_element (
	id bigserial NOT NULL,
	"name" varchar(255) NULL, -- DOOR / SEAT / STAIRS
	CONSTRAINT seat_element_pkey PRIMARY KEY (id)
);

-- Column comments

COMMENT ON COLUMN public.t_seat_element."name" IS 'DOOR / SEAT / STAIRS';


-- public.t_seat_type definition

-- Drop table

-- DROP TABLE public.t_seat_type;

CREATE TABLE public.t_seat_type (
	id bigserial NOT NULL,
	"name" varchar(255) NULL,
	CONSTRAINT seat_type_pkey PRIMARY KEY (id)
);


-- public.t_studio_type definition

-- Drop table

-- DROP TABLE public.t_studio_type;

CREATE TABLE public.t_studio_type (
	id bigserial NOT NULL,
	"name" varchar(255) NULL,
	row_seats int4 NULL,
	col_seats int4 NULL,
	CONSTRAINT studio_type_pkey PRIMARY KEY (id)
);


-- public.t_user definition

-- Drop table

-- DROP TABLE public.t_user;

CREATE TABLE public.t_user (
	id bigserial NOT NULL,
	"name" varchar(255) NULL,
	email varchar(255) NULL,
	mobile_no varchar(255) NULL,
	"password" varchar(255) NULL,
	"type" varchar(255) NULL, -- ADMIN / USER
	CONSTRAINT user_pkey PRIMARY KEY (id)
);

-- Column comments

COMMENT ON COLUMN public.t_user."type" IS 'ADMIN / USER';


-- public.t_cinema definition

-- Drop table

-- DROP TABLE public.t_cinema;

CREATE TABLE public.t_cinema (
	id bigserial NOT NULL,
	city_id int8 NULL,
	"name" varchar(255) NULL,
	CONSTRAINT cinema_pkey PRIMARY KEY (id),
	CONSTRAINT cinema_city_id_fkey FOREIGN KEY (city_id) REFERENCES public.t_city(id)
);


-- public.t_studio definition

-- Drop table

-- DROP TABLE public.t_studio;

CREATE TABLE public.t_studio (
	id bigserial NOT NULL,
	cinema_id int8 NULL,
	type_id int8 NULL,
	"name" varchar(255) NULL,
	col_seats int4 NULL,
	row_seats int4 NULL,
	CONSTRAINT studio_pkey PRIMARY KEY (id),
	CONSTRAINT studio_cinema_id_fkey FOREIGN KEY (cinema_id) REFERENCES public.t_cinema(id),
	CONSTRAINT studio_type_id_fkey FOREIGN KEY (type_id) REFERENCES public.t_studio_type(id)
);


-- public.t_movie_studio_schedule definition

-- Drop table

-- DROP TABLE public.t_movie_studio_schedule;

CREATE TABLE public.t_movie_studio_schedule (
	id bigserial NOT NULL,
	studio_id int8 NULL,
	movie_id int8 NULL,
	start_time timestamptz NULL,
	price numeric(38, 2) NULL,
	CONSTRAINT movie_studio_schedule_pkey PRIMARY KEY (id),
	CONSTRAINT movie_studio_schedule_movie_id_fkey FOREIGN KEY (movie_id) REFERENCES public.t_movie(id),
	CONSTRAINT movie_studio_schedule_studio_id_fkey FOREIGN KEY (studio_id) REFERENCES public.t_studio(id)
);


-- public.t_booking definition

-- Drop table

-- DROP TABLE public.t_booking;

CREATE TABLE public.t_booking (
	id varchar(255) NOT NULL,
	user_id int8 NULL,
	schedule_id int8 NULL,
	status varchar(255) NULL,
	payment_timestamp timestamptz NULL,
	order_timestamp timestamp(6) NULL,
	CONSTRAINT order_pkey PRIMARY KEY (id),
	CONSTRAINT order_schedule_id_fkey FOREIGN KEY (schedule_id) REFERENCES public.t_movie_studio_schedule(id),
	CONSTRAINT order_user_id_fkey FOREIGN KEY (user_id) REFERENCES public.t_user(id)
);


-- public.t_seat_studio definition

-- Drop table

-- DROP TABLE public.t_seat_studio;

CREATE TABLE public.t_seat_studio (
	id bigserial NOT NULL,
	seat_type_id int8 NULL,
	seat_element_id int8 NULL,
	studio_id int8 NULL,
	"row" int4 NULL,
	col int4 NULL,
	price numeric(38, 2) NULL,
	is_available bool NULL,
	code varchar(255) NULL,
	booking_id varchar(255) NULL,
	CONSTRAINT seat_studio_pkey PRIMARY KEY (id),
	CONSTRAINT fk6ptnm6nnk81nw9hsbuercqivd FOREIGN KEY (booking_id) REFERENCES public.t_booking(id),
	CONSTRAINT seat_studio_seat_element_id_fkey FOREIGN KEY (seat_element_id) REFERENCES public.t_seat_element(id),
	CONSTRAINT seat_studio_seat_type_id_fkey FOREIGN KEY (seat_type_id) REFERENCES public.t_seat_type(id),
	CONSTRAINT seat_studio_studio_id_fkey FOREIGN KEY (studio_id) REFERENCES public.t_studio(id)
);


-- public.t_booking_seat definition

-- Drop table

-- DROP TABLE public.t_booking_seat;

CREATE TABLE public.t_booking_seat (
	id int8 GENERATED BY DEFAULT AS IDENTITY( INCREMENT BY 1 MINVALUE 1 MAXVALUE 9223372036854775807 START 1 CACHE 1 NO CYCLE) NOT NULL,
	booking_id varchar(255) NOT NULL,
	seat_id int8 NOT NULL,
	CONSTRAINT t_booking_seat_pkey PRIMARY KEY (id),
	CONSTRAINT fklm4quwdia6d35gkqyjym8lo5b FOREIGN KEY (booking_id) REFERENCES public.t_booking(id),
	CONSTRAINT fkof764lclj7cjjg7pmq1otrrii FOREIGN KEY (seat_id) REFERENCES public.t_seat_studio(id)
);