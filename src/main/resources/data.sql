insert into hospital_Department(hosp_dept_name) values ('Cardiology');
insert into hospital_Department(hosp_dept_name) values ('Intensive Care');
insert into hospital_Department(hosp_dept_name) values ('Neurology');
insert into hospital_Department(hosp_dept_name) values ('Orthopedics');

insert into patient(first_name, last_name, sickness) values ('Adithya', 'Varma', 'Chest Pain');
insert into patient(first_name, last_name, sickness) values ('Gopal', 'Sara', 'Accident');
insert into patient(first_name, last_name, sickness) values ('Thevan', 'Neymar', 'Stroke' );
insert into patient(first_name, last_name, sickness) values ('Cristiano', 'Bava', 'Knee Pain');

update patient
set hosp_dept_id = 1
where patient_id = 1;

update patient
set hosp_dept_id = 2
where patient_id = 2;

update patient
set hosp_dept_id = 3
where patient_id = 3;

update patient
set hosp_dept_id = 4
where patient_id = 4;


insert into medicine (medicine_name) values ('Antibiotics');
insert into medicine (medicine_name) values ('Albuterol');
insert into medicine (medicine_name) values ('Losartan');
insert into medicine (medicine_name) values ('Omeprazole');
insert into medicine (medicine_name) values ('Atorvastatin');
insert into medicine (medicine_name) values ('Gabapentin');

INSERT INTO users(email, name, password) VALUES
    ('admin@gmail.com','admin','$2a$12$JGriZzgFwZNEeuIzFcocjug9wb0/G0EJ1nco27FZoCvVLmfpfiiWe');
INSERT INTO users(email, name, password) VALUES
    ('staff@gmail.com','John','$2a$12$F2QRPx07EsQTswGmyxB4sOw7RLCnIDqux/LWhO5vfegs42OS2LE.C');
insert into users(email, name, password) values ('dummy@example.com', 'Dummy', 'Worldw@r3');


INSERT INTO roles(name) VALUES ('ROLE_ADMIN');
INSERT INTO roles(name) VALUES ('ROLE_USER');

INSERT INTO users_roles(role_id, user_id) VALUES (1,1);
INSERT INTO users_roles(role_id, user_id) VALUES (2,2);

