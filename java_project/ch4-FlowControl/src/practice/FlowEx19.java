package practice;

public class FlowEx19 {
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis(); // 1970년 1월 1일 0시 0분 0초를 기준으로 현재 시각에서 기준 시간을 뺀 값
		for(int i=0; i < 1000000000; i++) {
			;
		}
		long endTime = System.currentTimeMillis(); // for문이 0부터 10억까지 도달하는데 걸리는 시간을 계산.
		System.out.println("시작시간 : " + startTime);
		System.out.println("종료시간 : " + endTime);
		System.out.println("소요시간 : " + (endTime - startTime));
	}
}
