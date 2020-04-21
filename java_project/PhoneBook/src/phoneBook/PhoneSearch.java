package phoneBook;

public class PhoneSearch {
	
	PhoneInfor[] p = new PhoneInfor[100];

	void searchArr(String name) {
		for (int i=0; i<p.length; i++) {
			if(p[i].name==name) {
				p[i].showInfor();
			}
		}
	
	}
	
}
