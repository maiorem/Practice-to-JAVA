package ex;

import java.util.Scanner;

public class KeyboardScanning {

	public static void main(String[] args) {
		
		Scanner kb = new Scanner(System.in);

		System.out.print("숫자를 입력해 주세요 : ");
		int num1 = kb.nextInt();
		
		System.out.print("숫자를 입력해 주세요 : ");
		int num2 = kb.nextInt();
		
		System.out.print("숫자를 입력해 주세요 : ");
		int num3 = kb.nextInt();
	
		int sum = num1 + num2 + num3;
		System.out.printf("입력된 정수 %d, %d, %d 입니다. 합은 %d입니다.", num1,num2,num3,sum);
	}

}
