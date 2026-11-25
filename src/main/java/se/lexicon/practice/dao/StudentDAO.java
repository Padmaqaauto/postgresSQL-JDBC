package se.lexicon.practice.dao;

import se.lexicon.practice.model.Student;

import java.util.List;

public interface StudentDAO {
    Student save(Student student);

    List<Student> findAll();
}
