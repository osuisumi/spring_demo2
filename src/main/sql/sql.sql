create database if NOT EXISTS spring_demo default character set utf8;
use spring_demo;
show engines;

create table if not exists user(id int primary key not null auto_increment, username varchar(12) not null, password varchar(20), score int, ranking int, essay_count int, UNIQUE(username)) engine=InnoDB;
show table status like 'user'\G;

create table if not exists essay(id int primary key not null auto_increment, title varchar(40) not null, create_date datetime, user_id int, reading_count int, comment_count int, tag varchar(40), UNIQUE(title)) engine=InnoDB;
show table status like 'essay'\G;

create table if not exists comment(id int PRIMARY KEY NOT NULL AUTO_INCREMENT, content TEXT, user_id int, essay_id int, comment_date DATETIME) ENGINE=InnoDB;
show table status like 'comment'\G;