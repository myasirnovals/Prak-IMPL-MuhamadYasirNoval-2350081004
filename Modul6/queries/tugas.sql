show databases;

create database kuliah_akademik;

use kuliah_akademik;

CREATE TABLE address
(
    address_id    INT(5),
    house_number  INT(3)      NOT NULL,
    street_number INT(3)      NOT NULL,
    town          VARCHAR(30) NOT NULL,
    city          VARCHAR(30) NOT NULL,
    PRIMARY KEY (address_id)
) ENGINE = InnoDB;

desc address;

CREATE TABLE department
(
    department_id VARCHAR(5),
    name          VARCHAR(30) NOT NULL,
    PRIMARY KEY (department_id)
) ENGINE = InnoDB;

desc department;

CREATE TABLE student
(
    student_id    CHAR(10),
    name          VARCHAR(50)             NOT NULL,
    phone_number  VARCHAR(13)             NOT NULL,
    date_of_birth DATE                    NOT NULL,
    gender        ENUM ('male', 'female') NOT NULL,
    address_id    INT(5),
    department_id VARCHAR(5),
    PRIMARY KEY (student_id),
    CONSTRAINT fk_student_address
        FOREIGN KEY (address_id)
            REFERENCES address (address_id)
            ON DELETE RESTRICT ON UPDATE RESTRICT,
    CONSTRAINT fk_student_department
        FOREIGN KEY (department_id)
            REFERENCES department (department_id)
            ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB;

desc student;

CREATE TABLE studies
(
    student_id CHAR(10),
    course_id  VARCHAR(5),
    semester   INT(1) NOT NULL,
    PRIMARY KEY (student_id, course_id),
    CONSTRAINT fk_studies_student
        FOREIGN KEY (student_id)
            REFERENCES student (student_id)
            ON DELETE RESTRICT ON UPDATE RESTRICT,
    CONSTRAINT fk_studies_course
        FOREIGN KEY (course_id)
            REFERENCES course (course_id)
            ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB;

desc studies;

CREATE TABLE course
(
    course_id     VARCHAR(5),
    name          VARCHAR(30) NOT NULL,
    code          CHAR(6)     NOT NULL,
    department_id VARCHAR(5),
    PRIMARY KEY (course_id),
    CONSTRAINT fk_course_department
        FOREIGN KEY (department_id)
            REFERENCES department (department_id)
            ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB;

desc course;

CREATE TABLE teaches
(
    faculty_id VARCHAR(5),
    course_id  VARCHAR(5),
    PRIMARY KEY (faculty_id, course_id),
    CONSTRAINT fk_teaches_faculty
        FOREIGN KEY (faculty_id)
            REFERENCES faculty (faculty_id)
            ON DELETE RESTRICT ON UPDATE RESTRICT,
    CONSTRAINT fk_teaches_course
        FOREIGN KEY (course_id)
            REFERENCES course (course_id)
            ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB;

desc teaches;

CREATE TABLE faculty
(
    faculty_id    VARCHAR(5),
    name          VARCHAR(30)             NOT NULL,
    gender        ENUM ('male', 'female') NOT NULL,
    salary        INT(8)                  NOT NULL,
    date_of_birth DATE                    NOT NULL,
    grade         CHAR(1)                 NOT NULL,
    designation   VARCHAR(30)             NOT NULL,
    department_id VARCHAR(5),
    PRIMARY KEY (faculty_id),
    CONSTRAINT fk_faculty_department
        FOREIGN KEY (department_id)
            REFERENCES department (department_id)
            ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB;

desc faculty;

CREATE TABLE works
(
    faculty_id VARCHAR(5),
    project_id VARCHAR(5),
    PRIMARY KEY (faculty_id, project_id),
    CONSTRAINT fk_works_faculty
        FOREIGN KEY (faculty_id)
            REFERENCES faculty (faculty_id)
            ON DELETE RESTRICT ON UPDATE RESTRICT,
    CONSTRAINT fk_works_project
        FOREIGN KEY (project_id)
            REFERENCES research_project (project_id)
            ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB;

desc works;

CREATE TABLE research_project
(
    project_id VARCHAR(5),
    name       VARCHAR(30) NOT NULL,
    area       VARCHAR(30) NOT NULL,
    duration   INT(3)      NOT NULL,
    PRIMARY KEY (project_id)
) ENGINE = InnoDB;

desc research_project;