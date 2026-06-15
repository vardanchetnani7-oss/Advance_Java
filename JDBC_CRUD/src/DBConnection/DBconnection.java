package DBConnection;
import java.sql.*;

public class DBconnection {
public static Connection dbConnect(){
		
		Connection conn = null;
		String url = "jdbc:postgresql://localhost:5432/CRUD";
		String username = "postgres";
		String pass = "new_password";
		//load and register
		try {
			Class.forName("org.postgresql.Driver");
			 conn  = DriverManager.getConnection(url,username,pass);
			System.out.println("connection successful");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn; 
}
}

