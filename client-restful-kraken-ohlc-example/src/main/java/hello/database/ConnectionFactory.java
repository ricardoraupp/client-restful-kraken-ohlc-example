package hello.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    
	public static Connection getConnection() {
        try {
            return DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/kraken", "your_user", "your_password");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
	
}