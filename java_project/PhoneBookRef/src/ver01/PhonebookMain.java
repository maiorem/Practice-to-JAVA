package ver01;

public class PhonebookMain {

	public static void main(String[] args) {

		PhoneInfor info = new PhoneInfor("홍세영", "010-4607-1669", "871012");
		info.showInfo();

		System.out.println("---------------------------");
		
		info = new PhoneInfor("김소연", "010-2296-3048");
		info.showInfo();
		
	}
}
