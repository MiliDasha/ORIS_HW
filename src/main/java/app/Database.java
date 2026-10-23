package app;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class Database {
    private static Connection connection;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                Properties props = new Properties();
                InputStream in = Database.class.getClassLoader().getResourceAsStream("db.properties");
                props.load(in);

                Class.forName("org.postgresql.Driver");
                connection = DriverManager.getConnection(
                        props.getProperty("db.url"),
                        props.getProperty("db.username"),
                        props.getProperty("db.password")
                );
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
}