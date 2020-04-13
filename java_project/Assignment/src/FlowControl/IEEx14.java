package FlowControl;

public class IEEx14 {

	public static void main(String[] args) {

//		문제 14.
//		다음 식을 만족하는 조합을 찾는 프로그램 작성. 
//		A B
//		B A
//		------
//		9 9

		int A = 1;
		while(A<9) {
			int B = 9-A;
			System.out.println("A :"+A+", B: "+B);
			A++;
		}
		
	}

}
