package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgresConnectionProvider {

    private Connection connection = null;

    public Connection provide() {
        return connection;
    }

    public boolean connect() throws ClassNotFoundException, SQLException {

        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/GlucoseAppDB","postgres", "mysecretpassword");
            if (connection == null) return false;
        } catch (Exception e){
            return false;
        }
        return true;
    }
}
