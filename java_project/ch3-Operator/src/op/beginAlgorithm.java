package op;

public class beginAlgorithm {

	public static void main(String[] args) {
		
		int EvenSum = 0;
		int OddSum = 0;
		for (int i=0; i<=100; i++) {
			if (i % 2 == 0) {
				EvenSum = EvenSum + i; 
			} else {
				OddSum = OddSum + i;
			}
		}
		System.out.println(OddSum-EvenSum);
	}

}
