package FlowControl;

public class ForEx11 {

	public static void main(String[] args) {
/*
 * 문제 11.
ContinueBasic.java의 내부에 존재하는 while 문을 for 문으로 변경하여 작성
 */
//class ContinueBasic {
//	public static void main(String[] args) {
//	int num=0;
//	int count=0;
//	while((num++)<100){
//	if(num%5!=0 || num%7!=0)
//	continue;
//	count++;
//	System.out.println(num);
//	}
//	System.out.println("count: " + count);
//	}
//	}
		
		int count=0;
		for(int num=1; num<100; num++) {
			if (num%5 != 0 || num%7 != 0) {
				continue;
			}
			count++;
			System.out.println(num);
		}
		System.out.println("count:" +count);

	}

}
