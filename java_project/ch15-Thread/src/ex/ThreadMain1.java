package ex;

public class ThreadMain1 {

	public static void main(String[] args) {
		
		//쓰래드 인스턴스 생성
		ShowThread st1=new ShowThread("멋진 쓰레드");
		ShowThread st2=new ShowThread("예쁜 쓰레드");
		
		st1.setPriority(Thread.MAX_PRIORITY);
		
		//Thread의 실행 : 새로운 프로그램 코드 실행의 흐름
		st1.start();
		st2.start();
		
		for(int i=0; i<100; i++) {
			System.out.println("메인 쓰레드가 실행 중입니다.");
		}
	}

}
