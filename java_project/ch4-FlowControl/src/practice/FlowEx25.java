package practice;

public class FlowEx25 {
	public static void main(String[] args) {
		int sum =0;
		int i = 1;
		while(true) {
			if(sum > 100)
				break;
			sum += i;
			i++;
		} //1부터 계속 더해나갔을 때 i가 몇일 때 처음으로 합이 100이 넘어가는지, 100이 넘어가는 합은 얼마인지 구하기.
		System.out.println("i=" + i);
		System.out.println("sum=" + sum);
	}
}
