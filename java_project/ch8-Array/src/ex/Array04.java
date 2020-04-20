package ex;

public class Array04 {

	public static void main(String[] args) {
		
		
		// 정수 45개를 저장할 수 있는 배열을 생성
		int[] ball = new int[45];
		
		// 각 배열의 요소에 1~45 숫자를 초기화
		for(int i=0; i<ball.length; i++) {
			ball[i] = i+1;
		}

//		for(int i=0; i<ball.length; i++) {
//			System.out.println(ball[i]);
//		}
		

		int temp=0;	// 배열의 요소 값의 변경을 위한 임시 변수
		int j=0; // 랜덤한 index 값 : 1~44 (index 0과 자리를 바꾸니 0부터 할 필요 없음..)
		for(int i=0; i<10000; i++) {
			
			j=(int)(Math.random()*44)+1;
			
			// 배열 안 두개의 변수 자리 바꾸기
			temp = ball[0];
			ball[0] = ball[j];
			ball[j] = temp;
			
		}
		
		// 섞인 배열을 앞에서부터 6개 출력
		for(int i=0; i<6; i++) {
			System.out.println(ball[i]);
		}
		
	}

}
