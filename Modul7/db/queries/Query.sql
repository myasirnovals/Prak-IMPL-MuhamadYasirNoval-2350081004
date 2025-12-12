SHOW DATABASES;

CREATE DATABASE IF NOT EXISTS dbImpal;

USE dbImpal;

CREATE TABLE IF NOT EXISTS pesan
(
    idPesan    INT(5) AUTO_INCREMENT PRIMARY KEY,
    idPenerima INT(5)      NOT NULL,
    idPengirim INT(5)      NOT NULL,
    Judul      VARCHAR(30) NOT NULL,
    TextPesan  TEXT        NOT NULL,
    WktPesan   DATETIME    NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS user
(
    id       INT(5) AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50)  NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    nama     VARCHAR(50)  NULL
) ENGINE = InnoDB;

ALTER TABLE pesan
    ADD CONSTRAINT fk_pesan_penerima
        FOREIGN KEY (idPenerima) REFERENCES user (id)
            ON DELETE RESTRICT ON UPDATE RESTRICT,
    ADD CONSTRAINT fk_pesan_pengirim
        FOREIGN KEY (idPengirim) REFERENCES user (id)
            ON DELETE RESTRICT ON UPDATE RESTRICT;

INSERT INTO user (username, password, nama)
VALUES ('user1', 'passwordhash1', 'User Satu'),
       ('user2', 'passwordhash2', 'User Dua');

