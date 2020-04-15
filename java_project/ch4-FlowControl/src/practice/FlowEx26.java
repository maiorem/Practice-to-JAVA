package practice;

public class FlowEx26 {
	public static void main(String[] args) {
		for(int i=0;i <= 10;i++) {
			if (i%3==0)
				continue;
			System.out.println(i); // 10 이하의 정수 중 3의 배수를 제외하고 출력.
		}
	}
}
