package FlowControl;

public class WhileEx7 {

	public static void main(String[] args) {
		/*
		 * 문제 7.
1부터 100까지 출력한 후, 다시 거꾸로 100부터 1까지 출력하는 프로그램을 작성. while문과 do~while 문을 각각 한번씩 사용해서 작성
		 */

		int i = 1;
		while (i<=100) {
			System.out.println(i); // 여기에 i++을 해줘도 됨...
			i++;
		}
		System.out.println("---------------");
		do {
			i--;
			System.out.println(i); // 여기에 --i 해줘도 됨
		} while(i>1);
	}

}
