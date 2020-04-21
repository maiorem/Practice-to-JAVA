package phoneBook;

import java.util.Scanner;

public class PhoneMain {

	public static void main(String[] args) {
	

		Scanner kb = new Scanner(System.in);
		
		while (true) {
			System.out.print("이름을 입력하세요 : ");
			String name = kb.nextLine();
			System.out.print("전화번호를 입력하세요 : ");
			String phoneNumber = kb.nextLine();
			System.out.print("생년월일을 입력하세요 : ");
			String birthday  = kb.nextLine();
			
			PhoneInfor p = new PhoneInfor(name, phoneNumber, birthday);
			p.outputData();
		}
			
	}
}

