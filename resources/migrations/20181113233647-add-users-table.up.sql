CREATE TABLE users
(id VARCHAR(20) PRIMARY KEY,
 first_name VARCHAR(30),
 last_name VARCHAR(30),
 email VARCHAR(30),
 admin BOOLEAN,
 last_login TIMESTAMP,
 is_active BOOLEAN,
 pass VARCHAR(300));


CREATE TABLE notes
(id bigint auto_increment primary key,
 author_id VARCHAR(20),
 title VARCHAR(100),
 context VARCHAR(1000)
 )
