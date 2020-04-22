package phoneBook;

import java.util.Scanner;

public class PhoneMain {

	public static void main(String[] args) {
	
		Scanner kb = new Scanner(System.in);
		PhoneInfor[] phone = new PhoneInfor[100];

		int num = 0;
		
		for(int i=0; i<phone.length; i++) {
			
			System.out.println("무엇을 하시겠습니까?");
			System.out.println("1.저장  2.검색  3.삭제  4.종료");
			num = kb.nextInt();
			
			if (num==1) {			
				
				System.out.println("이름을 입력하세요 : ");
				phone[i].name = kb.nextLine();
				System.out.println("전화번호를 입력하세요 : ");
				phone[i].phoneNumber = kb.nextLine();
				System.out.println("생년월일을 입력하세요 : ");
				phone[i].birthday = kb.nextLine();
				
				phone[i] = new PhoneInfor (phone[i].name, phone[i].phoneNumber, phone[i].birthday);
				continue;
				
			}
			else if (num==2) {
				System.out.println("검색할 이름을 입력하세요 : ");
				phone[i].name = kb.nextLine();
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

