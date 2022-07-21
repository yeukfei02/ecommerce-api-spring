CREATE TABLE "users" (
    "id" int8 PRIMARY KEY,
    "email" VARCHAR,
    "password" VARCHAR,
    "created_at" TIMESTAMP NOT NULL default CURRENT_TIMESTAMP,
    "updated_at" TIMESTAMP NOT NULL default CURRENT_TIMESTAMP
);

CREATE TABLE "shops" (
    "id" int8 PRIMARY KEY,
    "name" VARCHAR,
    "address" VARCHAR,
    "created_at" TIMESTAMP NOT NULL default CURRENT_TIMESTAMP,
    "updated_at" TIMESTAMP NOT NULL default CURRENT_TIMESTAMP
);

CREATE TABLE "books" (
    "id" int8 PRIMARY KEY,
    "name" VARCHAR,
    "author" VARCHAR,
    "price" float8,
    "quantity" int4,
    "created_at" TIMESTAMP NOT NULL default CURRENT_TIMESTAMP,
    "updated_at" TIMESTAMP NOT NULL default CURRENT_TIMESTAMP,
    "shop_id" int8,
    "user_id" int8
);

CREATE TABLE "orders" (
    "id" int8 PRIMARY KEY,
    "created_at" TIMESTAMP NOT NULL default CURRENT_TIMESTAMP,
    "updated_at" TIMESTAMP NOT NULL default CURRENT_TIMESTAMP,
    "order_detail" VARCHAR,
    "shop_id" int8,
    "user_id" int8
);

ALTER TABLE "books" ADD FOREIGN KEY ("shop_id") REFERENCES "shops"("id");
ALTER TABLE "books" ADD FOREIGN KEY ("user_id") REFERENCES "users"("id");
ALTER TABLE "orders" ADD FOREIGN KEY ("user_id") REFERENCES "users"("id");
ALTER TABLE "orders" ADD FOREIGN KEY ("shop_id") REFERENCES "shops"("id");
