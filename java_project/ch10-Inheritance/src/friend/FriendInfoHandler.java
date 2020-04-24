package friend;

import java.util.Scanner;

public class FriendInfoHandler {
	

	// Friend 타입의 정보를 저장할 배열을 가진다.
	// Friend 타입의 정보를 저장하는 기능
	// 기본 정보 출력 기능
	// 상세 정보 출력 기능
	private Friend[] myFriends;	// Friend 타입의 배열 선언
	private int numOfFriend;	// 저장된 친구의 정보 갯수
	
	Scanner sc; 
	
	//초기화 : 저장공간(사이즈) 크기를 받아서 배열 생성
	FriendInfoHandler(int num) {
		myFriends = new Friend[num];
		numOfFriend=0;
		sc = new Scanner(System.in);
	}
	
	// 저장 기능
	// 1. 배열에 저장하는 기능	
	void addFriendInfo(Friend f) {	// 배열에 저장
		myFriends[numOfFriend++]=f;
	}
	
	// 2. 사용자에게 데이터를 받아서 사용자 요청에 맞는 인스턴스를 생성
	// HighFriend / UnivFriend => 두개의 타입. 필요한 데이터가 서로 다름.
	void addFriend(int choice) {
		//기본정보 받기
		System.out.print("이름 : ");
		String name=sc.nextLine();
		System.out.print("전화번호 : ");
		String phoneNum=sc.nextLine();
		System.out.print("주소 : ");
		String addr=sc.nextLine();
		
		Friend friend=null;
		
		if(choice==1) {
		//1일 때 정보 받기
			System.out.print("직업 : ");
			String job=sc.nextLine();
		//HighFriend 인스턴스 생성
			friend=new HighFriend(name, phoneNum, addr, job);
		} else {
		//2일 때 정보 받기
			System.out.print("전공 : ");
			String major=sc.nextLine();
			System.out.print("학년 : ");
			String grade=sc.nextLine(); //nextInt는 버퍼 문제 발생
		//UnivFriend 인스턴스 생성
			friend=new UnivFriend(name, 
					phoneNum, 
					addr, 
					major, 
					Integer.parseInt(grade)); //스트링타입을 인티저로 변경.
		}
		
		//addFriendInfo 호출
		addFriendInfo(friend);
	}
	
	// 기본 정보 출력
	void showAllSimpleData() {
		System.out.println("친구의 기본 정보를 출력합니다===============");
		for(int i=0; i<numOfFriend; i++) {
			myFriends[i].showBasicInfo();
			System.out.println("-------------------------------");
		}
	}
	
	
	// 상세 정보 출력
	void showAllDate() {
		System.out.println("친구의 상세 정보를 출력합니다================");
		for(int i=0; i<numOfFriend; i++) {
			myFriends[i].showData();
			System.out.println("-------------------------------");
		}
	}
	
}
