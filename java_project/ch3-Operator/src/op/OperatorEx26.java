package op;

public class OperatorEx26 {

	public static void main(String[] args) {
		
		int x = 10;
		int y = -10;
		int absX = (x >= 0) ? x : -x; // x가 양수라면 x, 음수라면 -x, absX = 10
		int absY = (y >= 0) ? y : -y; // y가 양수라면 y, 음수라면 -y, absY = -(-10)
		System.out.println("x= 10일 때, x의 절대값은 "+absX);
		System.out.println("y=-10일 때, y의 절대값은 "+absY);
		}
	
}
