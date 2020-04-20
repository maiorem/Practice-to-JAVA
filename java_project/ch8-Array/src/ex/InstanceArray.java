package ex;

public class InstanceArray {

	public static void main(String[] args) {

		//참조형(String) 변수를 저장하는 배열 생성
		String[] strArr=new String[3];

		// strArray[0] : 배열의 첫번째 참조변수
		strArr[0]="Java"; // = new String("JAVA");
		strArr[1]="JavaScript";
		strArr[2]="Python";
		
		// String 타입의 참조변수 -> strArr[0]
		System.out.println("문자열의 길이 : "+strArr[0].length());
		System.out.println("문자열의 toString() : "+strArr[0].toString());
		
		// 배열의 순차적 참조 : 반복문을 이용해서 순차 참조 가능.
		for(int i=0; i<strArr.length; i++) {
			System.out.println(strArr[i]);
		}

	}

}
