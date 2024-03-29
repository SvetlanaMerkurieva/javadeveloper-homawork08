package org.example.config;

import org.example.props.PropertyReader;
import org.flywaydb.core.Flyway;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseH2 {
    public static final DatabaseH2 INSTANCE = new DatabaseH2();
    private Connection connection;
    private DatabaseH2 () {
        try { String connectionURL = PropertyReader.getConnectionUrl();
            this.connection = DriverManager.getConnection(connectionURL, "sa", "");
            flywayMigration(connectionURL, "sa", "");
        } catch (SQLException e) {
            throw new RuntimeException("Create connection exception. Reason: " + e.getMessage());
        }
    }
    public static DatabaseH2 getInstance() { return INSTANCE; }
    public Connection getConnection() { return connection; }

    private void flywayMigration(String connectionUrl, String user, String password) {
        Flyway flyway = Flyway.configure().dataSource(connectionUrl, user, password).load();
        flyway.migrate();
    }
}
