package ex;

public class ThreadMain2 {

	public static void main(String[] args) {
		
		//Runable을 구현하는 인스턴스 생성
		AdderThread at1=new AdderThread(1, 50);
		AdderThread at2=new AdderThread(51, 100);

		//쓰래드 인스턴스 생성
		Thread t1 = new Thread(at1);
		Thread t2 = new Thread(at2);
		
		//실행의 흐름 생성
		t1.start(); //run() 호출, 프로그램 실행
		t2.start();
		
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		System.out.println("1~100까지의 합 : "+(at1.getNum()+at2.getNum()));
	}
	
}
