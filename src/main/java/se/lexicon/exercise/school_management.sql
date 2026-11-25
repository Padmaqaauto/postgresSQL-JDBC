// 1.2 create a table named courses
CREATE TABLE courses (
    id INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    course_name VARCHAR(100) NOT NULL,
    credits INTEGER NOT NULL
);

// Verify table is created
SELECT * FROM courses;

//DML: Data Manipulation Language
// 2.1 Insert Data
INSERT INTO courses (course_name, credits)
VALUES
    ('Java Programming', 5),
    ('SQL Basics', 3),
    ('Web Development', 4);

// Verify rows are added
SELECT * FROM courses;

// 2.2: Update Data
UPDATE courses
SET credits = 6
WHERE course_name = 'Java Programming';

// 2.3: Delete Data
DELETE FROM courses
WHERE id = 2;

SELECT current_database();
// 3.1: Basic Select
SELECT * FROM student;