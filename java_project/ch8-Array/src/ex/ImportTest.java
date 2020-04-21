package ex;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ImportTest {

	public static void main(String[] args) {

		//java.util.Date => 날짜와 시간 정보를 하나로 표현
		Date today = new Date();
		
		System.out.println(today); //today.toString 
		//=> java api 클래스의 toString은 오버라이딩 해 두었음.
		
		// Date포맷을 원하는 형식으로 바꿔주는 api 클래스
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd. HH:mm");
		
		
		System.out.println(dateFormat.format(today));
		
		
	}

}
