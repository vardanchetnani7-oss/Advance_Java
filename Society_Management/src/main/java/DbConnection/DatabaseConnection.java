package DbConnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
	public static Connection createConnection() {
		String url = "jdbc:postgresql://localhost:5432/SocietyDb";
		String username = "postgres";
		String password = "new_password";
		Connection conn = null;
		//load and register
		try {
			Class.forName("org.postgresql.Driver");
			 conn  = DriverManager.getConnection(url,username,password);
			System.out.println("connection successful");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn; 

	}
}
