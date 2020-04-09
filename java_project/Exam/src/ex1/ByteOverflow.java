package ex1;

public class ByteOverflow {

	public static void main(String[] args) {
		
		byte b = 0; //byte형 변수 b를 선언하고 0으로 초기화.
		int i = 0;
		
		//반복문을 사용하여 byte b와 int i의 값을 1씩, 270까지 증가시키면 
		for (int x=0; x <= 270; x++) {
			System.out.print(b++); // 127 이후로는 음수로 변환. 왜곡이 일어남.
			System.out.print('\t');
			System.out.println(i++); 
		}

	}

}
