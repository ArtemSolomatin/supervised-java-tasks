CREATE TABLE faculty
(
    faculty_id serial PRIMARY KEY NOT NULL,
    faculty_num INTEGER,
    faculty_name VARCHAR(40)

);

CREATE TABLE subject
(
    subject_id serial PRIMARY KEY NOT NULL,
    subject_num INTEGER,
    subject_name VARCHAR(40)
);

CREATE TABLE student
(
    student_id serial PRIMARY KEY NOT NULL,
    faculty_id INTEGER,
    recordbook_num INTEGER,
    full_name VARCHAR(50),
    group_num INTEGER,
    CONSTRAINT fk_faculty_id FOREIGN KEY (faculty_id) REFERENCES faculty (faculty_id)
);

CREATE TABLE assessment
(
    assessment_id serial PRIMARY KEY NOT NULL,
    student_id INTEGER NOT NULL,
    subject_id INTEGER NOT NULL,
    semester_num INTEGER,
    mark INTEGER,
    examiner_surname VARCHAR(40),
    CONSTRAINT fk1_student_id FOREIGN KEY (student_id) REFERENCES student (student_id),
    CONSTRAINT fk2_subject_id FOREIGN KEY (subject_id) REFERENCES subject (subject_id)
);

Insert into faculty values(1, 1, 'FRTK');
Insert into faculty values(2, 2, 'FIVT');
Insert into faculty values(3, 3, 'FAKI');
Insert into subject values(1, 1, 'Math');
Insert into subject values(2, 2, 'IT');
Insert into student values(1, 2, 1, 'Zippo Petr Alexeevich', 616);
Insert into assessment values(1, 1, 1, 1, 7, 'Smilga');