INSERT INTO users (username, password, enabled) VALUES ('user', '$2a$10$wPHxwfsfTnOJAdgYcerBt.utdAvC24B/DWfuXfzKBSDHO0etB1ica', TRUE);
INSERT INTO users (username, password, enabled) VALUES ('admin', '$2a$10$wPHxwfsfTnOJAdgYcerBt.utdAvC24B/DWfuXfzKBSDHO0etB1ica', TRUE);
INSERT INTO users (username, password, enabled) VALUES ('bart', '$2a$10$wPHxwfsfTnOJAdgYcerBt.utdAvC24B/DWfuXfzKBSDHO0etB1ica', TRUE);
INSERT INTO users (username, password, enabled) VALUES ('peter', '$2a$10$wPHxwfsfTnOJAdgYcerBt.utdAvC24B/DWfuXfzKBSDHO0etB1ica', TRUE);

INSERT INTO authorities (username, authority) VALUES ('user', 'ROLE_USER');
INSERT INTO authorities (username, authority) VALUES ('admin', 'ROLE_USER');
INSERT INTO authorities (username, authority) VALUES ('admin', 'ROLE_ADMIN');
INSERT INTO authorities (username, authority) VALUES ('bart', 'ROLE_USER');
INSERT INTO authorities (username, authority) VALUES ('peter', 'ROLE_USER');

INSERT INTO course (code, name) VALUES ('SPR', 'Springboot');
INSERT INTO course (code, name) VALUES ('DON', 'Database Ontwikkeling');

INSERT INTO student (name) VALUES ('Tom de Boer');
INSERT INTO student (name) VALUES ('Yassine Azdad');
INSERT INTO student (name) VALUES ('Debby Huismans');
INSERT INTO student (name) VALUES ('Jay Richardson');
INSERT INTO student (name) VALUES ('Maninder Singh');
INSERT INTO student (name) VALUES ('Ilias al Gris');
INSERT INTO student (name) VALUES ('Eghbol Sarwar');
INSERT INTO student (name) VALUES ('Bart Heijenk');
INSERT INTO student (name) VALUES ('Quincy Soerkarso');
INSERT INTO student (name) VALUES ('Asare Twum');

INSERT INTO student_course_results (course_id, student_id, date, score) VALUES ('1', '1', '2020-10-10', '9');
INSERT INTO student_course_results (course_id, student_id, date, score) VALUES ('1', '2', '2020-10-10', '8');
INSERT INTO student_course_results (course_id, student_id, date, score) VALUES ('1', '3', '2020-10-10', '7');
INSERT INTO student_course_results (course_id, student_id, date, score) VALUES ('2', '1', '2020-10-15', '9');
INSERT INTO student_course_results (course_id, student_id, date, score) VALUES ('2', '3', '2020-10-15', '8');
INSERT INTO student_course_results (course_id, student_id, date, score) VALUES ('2', '4', '2020-10-15', '9');
INSERT INTO student_course_results (course_id, student_id, date, score) VALUES ('2', '5', '2020-10-15', '8');
