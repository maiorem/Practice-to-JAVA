package ex;

public class MethodDefAdd {

	public static void main(String[] args) {
		
		System.out.println("프로그램 시작");
		
		hiEveryOne(7, 110);
		hiEveryOne(26, 173.5);
		hiEveryOne(19, 163.4);
		hiEveryOne(40, 181);
		
		System.out.println("프로그램 종료");
	}

	//인사말 출력, 나이값을 받아서 나이를 출력하는 메서드.
	static void hiEveryOne(int age, double height) {
		System.out.println("안녕하세요.");
		
		if (age<10) {
			return; // 10세 이하면 종료.
		}
		System.out.println("제 나이는 "+age+"세 입니다.");
		System.out.println("저의 키는 "+height+"cm 입니다.");
	}
}
