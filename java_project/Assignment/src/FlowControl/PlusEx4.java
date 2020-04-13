package FlowControl;

public class PlusEx4 {

	public static void main(String[] args) {
		// [4] 1+(-2)+3+(-4)+... 과 같은 식으로 계속 더해나갔을 때, 몇까지 더해야 총합이 100이상이되는지 구하시오.

		int i=0;
		int EvenSum = 0;
		int OddSum = 0;
		while(true) {
			if (i % 2 == 0) {
				EvenSum = EvenSum + i; 
		   } else {
			   OddSum = OddSum + i;
		   }
			i++;
			if (OddSum-EvenSum>100) {
				System.out.println(i);
				break;
			}
		}


	}

}
