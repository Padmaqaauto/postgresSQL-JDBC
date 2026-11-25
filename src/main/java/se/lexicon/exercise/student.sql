
// 1.1: Create a Database
CREATE DATABASE school_management;

// DQL: Data Query Language
// 3.1: Basic Select
SELECT * from student;

// 3.2: Filtering
SELECT *
FROM student
WHERE class_group = 'G2';

//3.3: Pattern Matching
SELECT *
FROM student
WHERE name LIKE 'J%';

// Joins and Relationships
//4.1: Inner Join
SELECT
    s.name,
    a.status
FROM student s
         INNER JOIN attendance a
         ON s.id = a.student_id;

//4.2: Left Join
SELECT
    s.name,
    a.status
FROM student s
         LEFT JOIN attendance a
         ON s.id = a.student_id;

//Aggregation and Grouping
//5.1: Count
SELECT COUNT(*) AS total_students
FROM student;

// 5.2: Group By
SELECT
    status,
    COUNT(*) AS total
FROM attendance
GROUP BY status;

// 5.3: Group By with Join
SELECT
    s.name,
    COUNT(a.id) AS present_days
FROM student s
         LEFT JOIN attendance a
         ON s.id = a.student_id
         AND a.status = 'PRESENT'
GROUP BY s.id, s.name
ORDER BY s.name
