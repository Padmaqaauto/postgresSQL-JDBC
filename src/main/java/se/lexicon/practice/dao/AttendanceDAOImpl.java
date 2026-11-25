package se.lexicon.practice.dao;

import se.lexicon.practice.model.Attendance;

import java.sql.Connection;
import java.util.List;

public class AttendanceDAOImpl implements AttendanceDAO{
    private Connection connection;

    public void AttendanceDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Attendance save(Attendance attendance) {
        return null;
    }

    @Override
    public List<Attendance> findAll() {
        return List.of();
    }
}
