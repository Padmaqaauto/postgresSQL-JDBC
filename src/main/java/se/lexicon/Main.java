package se.lexicon;

import se.lexicon.db.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {

        String sql = """
                SELECT id, name, class_group
                FROM student
                ORDER BY id
                """;

        try (Connection connection =
                     DatabaseConnection.getDataSource().getConnection()) {

            System.out.println("Database connected successfully!");
            System.out.println("Database: " + connection.getCatalog());

            try (PreparedStatement statement =
                         connection.prepareStatement(sql);
                 ResultSet resultSet = statement.executeQuery()) {

                while (resultSet.next()) {

                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    String classGroup = resultSet.getString("class_group");

                    System.out.println(
                            id + " | " + name + " | " + classGroup
                    );
                }
            }

        } catch (SQLException e) {
            System.out.println("Database connection failed!");
            e.printStackTrace();
        }
    }
}