package membership;

public class MembershipMain {

	public static void main(String[] args) {
		
		//회원정보 5개를 저장할 수 있는 배열을 생성
		//Member 타입의 인스턴스의 참조값을 저장하는 메모리 공간
		//Member m1, m2, m3, m4, m5 변수를 만든 것과 같음
		Member[] members = new Member[5]; 
		
		members[0] = new Member("maiorem", "홍세영", "maiorem00@gmail.com"); //Member 타입의 인스턴스 주소
		members[1] = new Member("kr4120", "김미현", "yogurt@naver.com"); //Member 타입의 인스턴스 주소
		members[2] = new Member("mireena", "홍기정", "hkj1009@naver.com"); //Member 타입의 인스턴스 주소
		members[3] = new Member("hkh1009", "황기현", "hkh1094@gmail.com"); //Member 타입의 인스턴스 주소
		members[4] = new Member("gnine0427", "윤현구", "yhg0427@naver.com"); //Member 타입의 인스턴스 주소

//		members[0].showInfo();
//		members[1].showInfo();
//		members[2].showInfo();
//		members[3].showInfo();
//		members[4].showInfo();
		
		for (int i=0; i<members.length; i++) {
			System.out.println(members[i]);
		}
		
		System.out.println("---------------------------------");
		
		for (int i=0; i<members.length; i++) {
			members[i].showInfo();
			System.out.println("------------------------");
		}

	}

}
