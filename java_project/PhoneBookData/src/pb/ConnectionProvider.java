package pb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {
	
	public static Connection getConnection() throws SQLException {
		
		Connection conn=null;
		
		String url="jdbc:oracle:thin:@localhost:1521:orcl";
		String user="SCOTT";
		String password="tiger";
		
		conn=DriverManager.getConnection(url, user, password);
		
		return conn;
	}

}
