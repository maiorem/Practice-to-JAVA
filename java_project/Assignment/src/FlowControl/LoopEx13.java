package FlowControl;

public class LoopEx13 {

	public static void main(String[] args) {
	
		for(int i=2; i<10; i++) {
			if (i % 2 == 0) {
				for(int j=1; j<10; j++) {
					if (i % j == 0) {
						System.out.println(i+" X "+j+" = "+i*j);
					}
				}
			}
		}

	}

}
