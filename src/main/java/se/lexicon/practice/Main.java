package se.lexicon.practice;



import se.lexicon.practice.dao.StudentDAOImpl;
import se.lexicon.practice.db.DatabaseConnection;
import se.lexicon.practice.model.Student;
import se.lexicon.practice.dao.StudentDAO;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        // Get PostgreSQL DataSource
        DataSource dataSource = DatabaseConnection.getDataSource();

        try (Connection connection = dataSource.getConnection()) {

            try {
                // Start transaction
                connection.setAutoCommit(false);

                StudentDAO studentDao = new StudentDAOImpl(connection);

                Student student = new Student(
                        "Mehrdad Javan",
                        "Java-Group-1"
                );

                // Insert student
                Student savedStudent = studentDao.save(student);
                System.out.println("Saved student: " + savedStudent);

                // Retrieve all students
                List<Student> students = studentDao.findAll();
                students.forEach(System.out::println);

                // Commit transaction
                connection.commit();
                System.out.println("Transaction committed successfully!");

            } catch (SQLException | RuntimeException e) {

                // Rollback if something goes wrong
                try {
                    connection.rollback();
                    System.out.println("Transaction rolled back!");
                } catch (SQLException rollbackException) {
                    e.addSuppressed(rollbackException);
                }

                e.printStackTrace();
            }

        } catch (SQLException e) {
            System.out.println("PostgreSQL connection failed!");
            e.printStackTrace();
        }
    }
}