-- Сначала создайте базу hw3, затем выполните этот файл в ней.
CREATE TABLE app_settings (
    name VARCHAR(50) PRIMARY KEY,
    value INTEGER NOT NULL CHECK (value BETWEEN 1 AND 50)
);
INSERT INTO app_settings VALUES ('users_to_add', 6);

CREATE TABLE users (
    id BIGSERIAL PRIMARY KEY,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    email VARCHAR(200) NOT NULL,
    age INTEGER NOT NULL CHECK (age BETWEEN 0 AND 150),
    city VARCHAR(100) NOT NULL,
    is_active BOOLEAN NOT NULL
);
-- Чтобы на странице было 5 наборов полей:
-- UPDATE app_settings SET value = 5 WHERE name = 'users_to_add';
