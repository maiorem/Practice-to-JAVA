package FlowControl;

public class PlusEx5 {

	public static void main(String[] args) {
		// [5] 다음의 for문을 while문으로 변경하시오.
//		[연습문제]/ch4/Exercise4_5.java
//		public classExercise4_5 {
	//	public static void main(String[] args) {
//		for(int i=0; i<=10; i++) {
//			for(int j=0; j<=i; j++)
//				System.out.print("*");
//				System.out.println();
//		}
		 // end of main
		 // end ofclass

		int i=1;
		int j=1;
		while(i<=10) {
			while(j<=i) {
				System.out.print("*");
				System.out.println();
				j++;
			}
			i++;
			
		}
		
		
	}

}
