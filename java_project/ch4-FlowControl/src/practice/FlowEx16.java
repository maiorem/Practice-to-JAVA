package practice;

public class FlowEx16 {
	public static void main(String[] args) {
		for(int i=2; i <=9; i++) { // 2~9단
			for(int j=1; j <=9; j++) { // 곱해지는 1부터 9까지의 수
				System.out.println( i +" * "+ j + " = " + i*j ); // 구구단 출력하기.
			}
		}
	}
}
