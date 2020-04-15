package practice;

public class FlowEx20 {
	public static void main(String[] args) {
		System.out.println("자, 이제 카운트다운을 시작합니다.");
		for(int i=10; i >= 0; i--) {
			for(int j = 0; j < 1000000000; j++) {
				;
			}
			System.out.println(i);
		}
		System.out.println("GAME OVER"); // for문으로 j를 10억까지 반복하면서 10부터 하나씩 떨어지는 시간을 벌려고 하는 식인 것 같은데 그래도 너무 빨리 끝난다...
	} // j를 long타입으로 바꿔주고 100억으로 하니 카운트다운 속도가 느려졌다. long타입 10억이 적당한 빠르기인 것 같다.
}
