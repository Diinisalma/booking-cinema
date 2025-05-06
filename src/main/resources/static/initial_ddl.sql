CREATE TABLE "movie" (
  "id" integer PRIMARY KEY,
  "title" varchar,
  "synopsis" text,
  "genre" varchar[],
  "start_date" timestamptz,
  "end_date" timestamptz
);

CREATE TABLE "city" (
  "id" integer PRIMARY KEY,
  "name" varchar
);

CREATE TABLE "cinema" (
  "id" integer PRIMARY KEY,
  "city_id" integer,
  "name" varchar
);

CREATE TABLE "studio" (
  "id" integer PRIMARY KEY,
  "cinema_id" integer,
  "type_id" integer,
  "name" varchar
);

CREATE TABLE "studio_type" (
  "id" integer PRIMARY KEY,
  "name" varchar,
  "row_seats" integer,
  "col_seats" integer
);

CREATE TABLE "seat_type" (
  "id" integer PRIMARY KEY,
  "name" varchar
);

CREATE TABLE "seat_element" (
  "id" integer PRIMARY KEY,
  "name" varchar
);

CREATE TABLE "seat_studio" (
  "id" integer PRIMARY KEY,
  "seat_type_id" integer,
  "seat_element_id" integer,
  "studio_id" integer,
  "row" integer,
  "col" integer,
  "price" decimal,
  "is_available" boolean,
  "code" varchar
);

CREATE TABLE "user" (
  "id" integer PRIMARY KEY,
  "name" varchar,
  "email" varchar,
  "mobile_no" varchar,
  "password" varchar,
  "type" varchar
);

CREATE TABLE "movie_studio_schedule" (
  "id" integer PRIMARY KEY,
  "studio_id" integer,
  "movie_id" integer,
  "day" varchar,
  "start_time" timestamptz,
  "end_time" timestamptz,
  "price" decimal
);

CREATE TABLE "order" (
  "id" integer PRIMARY KEY,
  "user_id" integer,
  "schedule_id" integer,
  "status" varchar,
  "order_timestamp" timestamptz,
  "payment_timestamp" timestamptz
);

CREATE TABLE "seat_order" (
  "id" integer PRIMARY KEY,
  "order_id" integer,
  "seat_id" integer
);

COMMENT ON COLUMN "seat_element"."name" IS 'DOOR / SEAT / STAIRS';

COMMENT ON COLUMN "user"."type" IS 'ADMIN / USER';

ALTER TABLE "cinema" ADD FOREIGN KEY ("city_id") REFERENCES "city" ("id");

ALTER TABLE "studio" ADD FOREIGN KEY ("cinema_id") REFERENCES "cinema" ("id");

ALTER TABLE "studio" ADD FOREIGN KEY ("type_id") REFERENCES "studio_type" ("id");

ALTER TABLE "seat_studio" ADD FOREIGN KEY ("seat_type_id") REFERENCES "seat_type" ("id");

ALTER TABLE "seat_studio" ADD FOREIGN KEY ("seat_element_id") REFERENCES "seat_element" ("id");

ALTER TABLE "seat_studio" ADD FOREIGN KEY ("studio_id") REFERENCES "studio" ("id");

ALTER TABLE "movie_studio_schedule" ADD FOREIGN KEY ("studio_id") REFERENCES "studio" ("id");

ALTER TABLE "movie_studio_schedule" ADD FOREIGN KEY ("movie_id") REFERENCES "movie" ("id");

ALTER TABLE "order" ADD FOREIGN KEY ("user_id") REFERENCES "user" ("id");

ALTER TABLE "seat_order" ADD FOREIGN KEY ("order_id") REFERENCES "order" ("id");

ALTER TABLE "seat_order" ADD FOREIGN KEY ("seat_id") REFERENCES "seat_studio" ("id");

ALTER TABLE "order" ADD FOREIGN KEY ("schedule_id") REFERENCES "movie_studio_schedule" ("id");
