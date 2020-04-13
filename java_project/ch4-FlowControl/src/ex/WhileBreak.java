package ex;

public class WhileBreak {

	public static void main(String[] args) {
		int i=0;
		int sum=0;	
		
		// 무한반복
		while(true){
			if(sum>100){
				break;
			}
			i++;
			sum += i;
		}

		System.out.println("마지막 값 : " + i);
		System.out.println("합이 100이 넘어간 값 : " + sum);
	}

}
