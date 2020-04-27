package ex;

public class AbstractInterfaceMain {

	public static void main(String[] args) {
		
		//PersonalNumberStorage storage = new PersonalNumberStorageImpl(100);

		PersonalNumber storage = new PersonalNumberStorageImpl(100);
		
		storage.addPersonalInfo("891009-1641457", "홍길동");
		storage.addPersonalInfo("610420-2826423", "김미란");
		
		System.out.println(storage.searchName("610420-2826423"));
		System.out.println(storage.searchName("891009-1641457"));
	}

}
