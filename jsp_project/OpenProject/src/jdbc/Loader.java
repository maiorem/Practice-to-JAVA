package jdbc;

import java.util.StringTokenizer;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class Loader extends HttpServlet {

	@Override
	public void init(ServletConfig config) throws ServletException {
		
		String jdbcDrivers=config.getInitParameter("jdbcDriver");
		StringTokenizer st=new StringTokenizer(jdbcDrivers, ",");
		
	try {
		while(st.hasMoreTokens()) {
			String driver=st.nextToken();
					
			Class.forName(driver);
			System.out.println(driver+" Driver Load 성공");
		}
		
	} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("Driver Load 실패");
		}
		
	}

	
	
}
