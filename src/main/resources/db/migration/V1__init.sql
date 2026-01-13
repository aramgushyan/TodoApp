CREATE TABLE users (
    id BIGSERIAL PRIMARY KEY ,
    username VARCHAR(50)
);

CREATE TABLE types(
    id BIGSERIAL PRIMARY KEY ,
    name VARCHAR(50),
    description VARCHAR(50),
    user_id BIGINT REFERENCES users(id)
);

CREATE TABLE boards
(
    id BIGSERIAL PRIMARY KEY ,
    name VARCHAR(50) ,
    user_id BIGINT REFERENCES users(id)
);

CREATE TABLE columns
(
    id BIGSERIAL PRIMARY KEY ,
    orderNumber INT,
    board_id BIGINT REFERENCES boards(id) ,
    type_id BIGINT  REFERENCES types(id)
);