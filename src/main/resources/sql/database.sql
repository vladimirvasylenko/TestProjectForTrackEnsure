CREATE TABLE IF NOT EXISTS clients
(
    id       serial
    CONSTRAINT clients_pk
    PRIMARY KEY,
    name     varchar(20)
    NOT NULL

    );

CREATE TABLE messages
(
    id   serial
        CONSTRAINT roles_pk
            PRIMARY KEY,
    client_id int
        NOT NULL,

    text text
        NOT NULL,
    FOREIGN KEY (client_id)
        REFERENCES clients (id)
);