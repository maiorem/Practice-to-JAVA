package emp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {
	
	
	public static Connection getConnection() throws SQLException {
		
		Connection conn=null;
		
		String url="jdbc:oracle:thin:@localhost:1521:orcl";
		String user="scott";
		String pw="tiger";
		

		conn=DriverManager.getConnection(url, user, pw);

		
		return conn;
		
	}
	

}
