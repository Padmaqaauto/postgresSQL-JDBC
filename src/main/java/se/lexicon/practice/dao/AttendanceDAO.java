package se.lexicon.practice.dao;

import se.lexicon.practice.model.Attendance;

import java.util.List;

public interface AttendanceDAO {
    Attendance save(Attendance attendance);
    List<Attendance> findAll();
}
