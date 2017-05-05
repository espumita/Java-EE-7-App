package utils;

import org.omg.CORBA.TRANSACTION_MODE;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgresConnectionProvider {
    public boolean connect() throws ClassNotFoundException, SQLException {

        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = null;
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/GlucoseAppDB","postgres", "mysecretpassword");
            if (connection == null) return false;
        } catch (Exception e){
            return false;
        }
        return true;
    }
}
