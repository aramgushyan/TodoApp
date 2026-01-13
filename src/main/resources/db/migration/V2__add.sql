CREATE TABLE tasks (
    id BIGSERIAL PRIMARY KEY ,
    column_id BIGINT REFERENCES columns(id) NOT NULL,
    title VARCHAR(50),
    description VARCHAR(100),
    createdAt DATE,
    updatedAt DATE
);

ALTER TABLE types
ALTER COLUMN user_id
      set not null ;
