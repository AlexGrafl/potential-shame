/* CREATE DATABASE news; */
USE news;

DROP TABLE IF EXISTS t_news;
CREATE TABLE t_news (
  newsid INT AUTO_INCREMENT PRIMARY KEY,
  title VARCHAR(100) NOT NULL,
  text TEXT NOT NULL
);

INSERT INTO t_news (title, text) VALUES ('title1', 'text1');
INSERT INTO t_news (title, text) VALUES ('title2', 'text2');
INSERT INTO t_news (title, text) VALUES ('title3', 'text3');