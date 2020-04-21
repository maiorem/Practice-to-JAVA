package phoneBook;

import java.util.Scanner;

public class PhoneMain {

	public static void main(String[] args) {
	
		Scanner kb = new Scanner(System.in);
		PhoneInfor[] phone = new PhoneInfor[100];
		
		for(int i=0; i<phone.length; i++) {
			
			System.out.println("무엇을 할까요?");
			System.out.println("1.저장  2.검색  3.삭제  4.종료");
			int num = kb.nextInt();
			
			if (num==1) {
			
				System.out.print("이름을 입력하세요 : ");
				phone[i].name = kb.nextLine();
				System.out.print("전화번호를 입력하세요 : ");
				phone[i].phoneNumber = kb.nextLine();
				System.out.print("생년월일을 입력하세요 : ");
				phone[i].birthday  = kb.nextLine();
				
				if (phone[i].birthday == null) {
					phone[i] = new PhoneInfor (phone[i].name, phone[i].phoneNumber);
					continue;
				} else {
					phone[i] = new PhoneInfor (phone[i].name, phone[i].phoneNumber, phone[i].birthday);
					continue;
				}

			} else if (num==2) {
		
				continue;
			} else if (num==3) {
				
				continue;
			} else if (num==4) {
				break;
			}
		}
			
			
	}
}

