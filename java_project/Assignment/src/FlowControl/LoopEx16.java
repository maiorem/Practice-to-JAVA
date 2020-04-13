package FlowControl;

public class LoopEx16 {

	public static void main(String[] args) {

		int sum = 0;
		for(int i=1; i<100; i++) {
			sum = sum + i;
		} System.out.println("for문으로 구하기 :" +sum);
		
		int i = 1;
		sum = 0;
		while (i<100) {
			sum = sum + i;
			i++;			
		} System.out.println("while문으로 구하기 :" +sum);
		
		i = 1;
		sum = 0;
		do {
			sum = sum + i;
			i++;
		} while (i<100);
		System.out.println("do-while문으로 구하기 :"+sum);
	}

}
