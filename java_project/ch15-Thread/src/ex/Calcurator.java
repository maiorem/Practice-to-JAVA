package ex;

public class Calcurator {

	int opCnt=0; //메서드의 실행 횟수 카운팅

	int add(int n1, int n2) {	
		System.out.println("덧셈 연산");
		synchronized(this) {opCnt++;}		
		return n1+n2;
	}
	
	
	int min(int n1, int n2) {
		System.out.println("빼기연산");
		synchronized(this) {opCnt++;}
		return n1-n2;
	}
	
	void showOpCnt() {
		System.out.println("연산의 횟수는 : "+opCnt);
	}
	
}
