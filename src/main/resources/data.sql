DROP TABLE IF EXISTS users;

CREATE TABLE users (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	username VARCHAR(255),
	password VARCHAR(255),
	role VARCHAR(255)
);

/* password */
INSERT INTO users (username, password, role) VALUES ('admin', '$2a$10$XURPShQNCsLjp1ESc2laoObo9QZDhxz73hJPaEv7/cBha4pk0AgP.','admin');

/* passuser */
INSERT INTO users (username, password, role) VALUES ('user', '$2a$12$HMMJCGrP8wHUNUgiyizjVOUniSkN2.1EhuVSF5opSK2K4qcY07tN.','user');