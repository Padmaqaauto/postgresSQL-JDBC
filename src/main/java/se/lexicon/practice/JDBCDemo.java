package se.lexicon.practice;

import se.lexicon.practice.db.DatabaseConnection;

import java.sql.*;
import java.time.LocalDateTime;

public class JDBCDemo {

    public static void main(String[] args) {

        ex2();
    }

    // Exercise 1: Fetch all student records using Statement
    public static void ex1() {

        String query = """
                SELECT id, name, class_group, create_date
                FROM student
                """;

        try (
                // Establish PostgreSQL connection
                Connection connection = DatabaseConnection.getDataSource().getConnection();

                // Create Statement
                Statement statement = connection.createStatement();

                // Execute SELECT query
                ResultSet resultSet = statement.executeQuery(query)
        ) {

            while (resultSet.next()) {

                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String classGroup = resultSet.getString("class_group");

                Timestamp timestamp = resultSet.getTimestamp("create_date");
                LocalDateTime createDate = timestamp != null
                        ? timestamp.toLocalDateTime()
                        : null;

                IO.println(
                        "ID: " + id +
                                " | Name: " + name +
                                " | Class: " + classGroup +
                                " | Created At: " + createDate
                );
            }

        } catch (SQLException e) {
            IO.println("❌ Database error: " + e.getMessage());
        }
    }

    // Exercise 2: Fetch students based on class_group using PreparedStatement
    public static void ex2() {

        String query = """
                SELECT id, name, class_group, create_date
                FROM student
                WHERE class_group LIKE ?
                """;

        try (
                Connection connection = DatabaseConnection.getDataSource().getConnection();

                PreparedStatement preparedStatement = connection.prepareStatement(query)
        ) {

            // Set parameter value
            preparedStatement.setString(1, "%G1%");

            try (ResultSet resultSet = preparedStatement.executeQuery()) {

                while (resultSet.next()) {

                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    String classGroup = resultSet.getString("class_group");

                    Timestamp timestamp = resultSet.getTimestamp("create_date");
                    LocalDateTime createDate = timestamp != null
                            ? timestamp.toLocalDateTime()
                            : null;

                    IO.println(
                            "ID: " + id +
                                    " | Name: " + name +
                                    " | Class: " + classGroup +
                                    " | Created At: " + createDate
                    );
                }
            }

        } catch (SQLException e) {
            IO.println("❌ Database error: " + e.getMessage());
        }
    }
}