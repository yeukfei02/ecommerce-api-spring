CREATE INDEX index_users_on_email ON users(email);
CREATE INDEX index_users_on_password ON users(password);
CREATE INDEX index_users_on_created_at ON users(created_at);
CREATE INDEX index_users_on_updated_at ON users(updated_at);

CREATE INDEX index_shops_on_name ON shops(name);
CREATE INDEX index_shops_on_address ON shops(address);
CREATE INDEX index_shops_on_created_at ON shops(created_at);
CREATE INDEX index_shops_on_updated_at ON shops(updated_at);

CREATE INDEX index_books_on_name ON books(name);
CREATE INDEX index_books_on_author ON books(author);
CREATE INDEX index_books_on_price ON books(price);
CREATE INDEX index_books_on_quantity ON books(quantity);
CREATE INDEX index_books_on_user_id ON books(user_id);
CREATE INDEX index_books_on_shop_id ON books(shop_id);
CREATE INDEX index_books_on_created_at ON books(created_at);
CREATE INDEX index_books_on_updated_at ON books(updated_at);

CREATE INDEX index_orders_on_order_detail ON orders(order_detail);
CREATE INDEX index_orders_on_user_id ON orders(user_id);
CREATE INDEX index_orders_on_shop_id ON orders(shop_id);
CREATE INDEX index_orders_on_created_at ON orders(created_at);
CREATE INDEX index_orders_on_updated_at ON orders(updated_at);