CREATE TABLE users
(id VARCHAR(20) PRIMARY KEY,
 first_name VARCHAR(30),
 last_name VARCHAR(30),
 email VARCHAR(30),
 admin BOOLEAN,
 last_login TIMESTAMP,
 is_active BOOLEAN,
 pass VARCHAR(300));

CREATE SEQUENCE note_id;

CREATE TABLE notes
(note_id DEFAULT note_id.nextval primary key,
 auther_id VARCHAR(20),
 title VARCHAR(100),
 content VARCHAR(1000),
 last_updated_at TIMESTAMP,
 created_at TIMESTAMP
)
