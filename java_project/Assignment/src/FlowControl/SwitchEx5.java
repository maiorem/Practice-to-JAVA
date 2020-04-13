package FlowControl;

public class SwitchEx5 {

	public static void main(String[] args) {
		/*
		 * 문제 5.
문제 2의 답안 코드를 switch 문으로 변경하여 보자.
		 * 
		 */
//		int num=300;
//		
//		if (num<0) {
//			System.out.println("0미만");
//		} else if (0<=num && num<100) {
//			System.out.println("0이상 100미만");
//		} else if (100<=num && num<200) {
//			System.out.println("100이상 200미만");
//		} else if (200<=num && num<300) {
//			System.out.println("200이상 200미만");
//		} else if (300<=num) {
//			System.out.println("300이상");
//		}
//		
		int num=300;
		
		if (num<0) {
			System.out.println("0미만");
		}
		switch (num/100) {
		
		case 0:
			System.out.println("0이상 100미만");
			break;
		case 1:
			System.out.println("100이상 200미만");
			break;
		case 2:
			System.out.println("200이상 300미만");
			break;
		default :
			System.out.println("300이상");
			
		}
		
		
		
	}

}
