package ver05;

public interface MenuNum {
/*
	1.정보 저장
	2.정보 검색
	3.정보 삭제
	4.정보 수정
	5.정보 전체 보기
	6.프로그램 종료 
	
	1.대학  2.회사  3.동호회
		
 */
	
	//public static final 상수=리터럴;
	
	int INSERT=1; 	//	1.정보 저장
	int SEARCH=2; 	//	2.정보 검색
	int DELETE=3; 	//	3.정보 삭제
	int EDIT=4; 	//	4.정보 수정
	int SHOWALL=5;	//	5.정보 전체 보기
	int EXIT=6;		//	6.프로그램 종료
	
	int UNIV=1;		// 1.대학  
	int COMPANY=2;	// 2.회사 
	int CAFE=3;		// 3.동호회
}
