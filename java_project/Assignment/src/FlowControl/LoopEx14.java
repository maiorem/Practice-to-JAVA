package FlowControl;

public class LoopEx14 {

	public static void main(String[] args) {


		int A = 1;
		int B = 8;
		while (true) {
			if (A+B==9 && (10*A+B)+(10*B+A)==99) {
				System.out.println("A : "+A);
				System.out.println("B : "+B);
			}
			A++;
			B--;
			if ((10*A+B)+(10*B+A)>100) {
				break;
			}
		}
		

	}

}
