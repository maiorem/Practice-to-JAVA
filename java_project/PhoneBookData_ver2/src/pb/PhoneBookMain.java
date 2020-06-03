package pb;

import java.util.Scanner;

public class PhoneBookMain {

	static Scanner sc=new Scanner(System.in);
	
	public static void main(String[] args) throws ClassNotFoundException {
		
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		PhoneBookManager manager = PhoneBookManager.getInstance();
		manager.phoneManager();

	}

}
