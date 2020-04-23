package phoneBook;

import java.util.Scanner;

public class PhoneMain {

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		PhoneInfor[] phone = new PhoneInfor[100];

		int num = 0;
		
		for(int i=0; i<phone.length; i++) {
			
			System.out.println("무엇을 하시겠습니까?");
			System.out.println("1.저장  2.검색  3.삭제  4.종료");
			num = sc.nextInt();
			sc.nextLine();
			
			if (num==1) {			
				
				System.out.println("이름을 입력하세요 : ");
				String name = sc.nextLine();
				
				System.out.println("전화번호를 입력하세요 : ");
				String phoneNumber = sc.nextLine();
				
				System.out.println("생년월일을 입력하세요 : ");
				String birthday = sc.nextLine();
				
				phone[i] = new PhoneInfor (name, phoneNumber, birthday);
				continue;
				
			}
			else if (num==2) {
				System.out.println("검색할 이름을 입력하세요 : ");
				phone[i].name = sc.nextLine();
				phone[i].search(phone[i].name);
				continue;
			}
			
			
//			else if (num==3) {
//				System.out.println("삭제할 이름을 입력하세요 : ");
//				name = kb.nextLine();
//				continue;
//			}
			
			else if (num==4) {
				break;
			}

		}
			
	}
}

