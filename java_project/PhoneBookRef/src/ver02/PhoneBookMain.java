package ver02;

public class PhoneBookMain {

	public static void main(String[] args) {
		
		PhoneBookManager manager = new PhoneBookManager();
		PhoneInfor infor = null;
		
		while (true) {
			infor = manager.createInst();
			infor.showInfo();
		}
	}

}
