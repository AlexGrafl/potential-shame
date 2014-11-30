USE bsdb;

DROP TABLE IF EXISTS t_books;
DROP TABLE IF EXISTS t_user_role;
DROP TABLE IF EXISTS t_user;
DROP TABLE IF EXISTS t_role;

CREATE TABLE t_books (
  newsid INT AUTO_INCREMENT PRIMARY KEY,
  title VARCHAR(100) NOT NULL,
  text TEXT NOT NULL
);

CREATE TABLE t_user (
  userid INT AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(25) NOT NULL,
  password VARCHAR(128) NOT NULL
);

CREATE TABLE t_role (
  roleid INT AUTO_INCREMENT PRIMARY KEY,
  rolename VARCHAR(25) NOT NULL
);

CREATE TABLE t_user_role (
  userroleid INT AUTO_INCREMENT PRIMARY KEY,
  userid INT NOT NULL,
  roleid INT NOT NULL,
  FOREIGN KEY (userid) REFERENCES t_user(userid),
  FOREIGN KEY (roleid) REFERENCES t_role(roleid)
);

INSERT INTO t_books (title, text) VALUES ('title1', 'text1');
INSERT INTO t_books (title, text) VALUES ('title2', 'text2');
INSERT INTO t_books (title, text) VALUES ('title3', 'text3');

INSERT INTO t_user (userid, username, password) VALUES (1, 'myadmin', SHA2('topsecret', 512));
INSERT INTO t_user (userid, username, password) VALUES (2, 'myuser', SHA2('topsecret', 512));

INSERT INTO t_role (roleid, rolename) VALUES (1, 'BooksAdmin');
INSERT INTO t_role (roleid, rolename) VALUES (2, 'BookssUser');

INSERT INTO t_user_role (userid, roleid) VALUES (1, 1);
INSERT INTO t_user_role (userid, roleid) VALUES (2, 2);