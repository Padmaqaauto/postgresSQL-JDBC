package se.lexicon.practice.db;

import org.postgresql.ds.PGSimpleDataSource;

import javax.sql.DataSource;

public class DatabaseConnection {

    private static final DataSource DATA_SOURCE = createDataSource();

    private static DataSource createDataSource() {

        PGSimpleDataSource dataSource = new PGSimpleDataSource();

        dataSource.setServerName("localhost");
        dataSource.setPortNumber(5432);
        dataSource.setDatabaseName("student_db");
        dataSource.setUser("postgres");
        dataSource.setPassword("root");

        return dataSource;
    }

    public static DataSource getDataSource() {
        return DATA_SOURCE;
    }
}
