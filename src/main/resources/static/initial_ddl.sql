-- DROP SCHEMA public;

CREATE SCHEMA public AUTHORIZATION pg_database_owner;

COMMENT ON SCHEMA public IS 'standard public schema';

-- public.t_city definition
CREATE TABLE public.t_city (
	id serial NOT NULL,
	"name" varchar(255) NULL,
	CONSTRAINT city_pkey PRIMARY KEY (id)
);

-- public.t_movie definition

-- Drop table

-- DROP TABLE public.t_movie;

CREATE TABLE public.t_movie (
	id serial NOT NULL,
	title varchar(255) NULL,
	synopsis varchar(255) NULL,
	genre _varchar NULL,
	start_date timestamptz NULL,
	end_date timestamptz NULL,
	CONSTRAINT movie_pkey PRIMARY KEY (id)
);


-- public.t_seat_element definition

-- Drop table

-- DROP TABLE public.t_seat_element;

CREATE TABLE public.t_seat_element (
	id serial NOT NULL,
	"name" varchar(255) NULL, -- DOOR / SEAT / STAIRS
	CONSTRAINT seat_element_pkey PRIMARY KEY (id)
);

-- Column comments

COMMENT ON COLUMN public.t_seat_element."name" IS 'DOOR / SEAT / STAIRS';


-- public.t_seat_type definition

-- Drop table

-- DROP TABLE public.t_seat_type;

CREATE TABLE public.t_seat_type (
	id serial NOT NULL,
	"name" varchar(255) NULL,
	CONSTRAINT seat_type_pkey PRIMARY KEY (id)
);


-- public.t_studio_type definition

-- Drop table

-- DROP TABLE public.t_studio_type;

CREATE TABLE public.t_studio_type (
	id serial NOT NULL,
	"name" varchar(255) NULL,
	row_seats int4 NULL,
	col_seats int4 NULL,
	CONSTRAINT studio_type_pkey PRIMARY KEY (id)
);


-- public.t_user definition

-- Drop table

-- DROP TABLE public.t_user;

CREATE TABLE public.t_user (
	id serial NOT NULL,
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
	id serial NOT NULL,
	city_id int8 NULL,
	"name" varchar(255) NULL,
	CONSTRAINT cinema_pkey PRIMARY KEY (id),
	CONSTRAINT cinema_city_id_fkey FOREIGN KEY (city_id) REFERENCES public.t_city(id)
);


-- public.t_studio definition

-- Drop table

-- DROP TABLE public.t_studio;

CREATE TABLE public.t_studio (
	id serial NOT NULL,
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
	id serial NOT NULL,
	studio_id int8 NULL,
	movie_id int8 NULL,
	"day" varchar(255) NULL,
	start_time timestamptz NULL,
	end_time timestamptz NULL,
	price numeric NULL,
	CONSTRAINT movie_studio_schedule_pkey PRIMARY KEY (id),
	CONSTRAINT movie_studio_schedule_movie_id_fkey FOREIGN KEY (movie_id) REFERENCES public.t_movie(id),
	CONSTRAINT movie_studio_schedule_studio_id_fkey FOREIGN KEY (studio_id) REFERENCES public.t_studio(id)
);


-- public.t_seat_studio definition

-- Drop table

-- DROP TABLE public.t_seat_studio;

CREATE TABLE public.t_seat_studio (
	id serial NOT NULL,
	seat_type_id int8 NULL,
	seat_element_id int8 NULL,
	studio_id int8 NULL,
	"row" int4 NULL,
	col int4 NULL,
	price int8 NULL,
	is_available bool NULL,
	code varchar(255) NULL,
	CONSTRAINT seat_studio_pkey PRIMARY KEY (id),
	CONSTRAINT seat_studio_seat_element_id_fkey FOREIGN KEY (seat_element_id) REFERENCES public.t_seat_element(id),
	CONSTRAINT seat_studio_seat_type_id_fkey FOREIGN KEY (seat_type_id) REFERENCES public.t_seat_type(id),
	CONSTRAINT seat_studio_studio_id_fkey FOREIGN KEY (studio_id) REFERENCES public.t_studio(id)
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


-- public.t_order_seat definition

-- Drop table

-- DROP TABLE public.t_order_seat;

CREATE TABLE public.t_order_seat (
	booking_id varchar(255) NOT NULL,
	seat_id int8 NOT NULL,
	CONSTRAINT t_order_seat_pkey PRIMARY KEY (booking_id, seat_id),
	CONSTRAINT fkbyoa6eol48aq4ev0u6hmioqt7 FOREIGN KEY (seat_id) REFERENCES public.t_seat_studio(id),
	CONSTRAINT fkpgw3f6tkhiu9tsgkawfiff6kv FOREIGN KEY (booking_id) REFERENCES public.t_booking(id)
);