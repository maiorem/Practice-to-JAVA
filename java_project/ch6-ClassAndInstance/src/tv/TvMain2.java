package tv;

public class TvMain2 {

	public static void main(String[] args) {
		
		Tv tv1 = new Tv();
		Tv tv2 = new Tv(); // 서로 다른 메모리 공간이 만들어짐.
		
		System.out.println(tv1==tv2); // 객체를 따로 만든다는 것은 서로 다른 메모리에 생성이 된다. (주소값이 다르다)
		
		System.out.println("======================");
		System.out.println("tv1의 channel : " +tv1.channel);
		System.out.println("tv2의 channel : " +tv2.channel);
		
		System.out.println("----------------------");
		tv1.channel =10;
		System.out.println("tv1의 channel을 10으로 변경");

		System.out.println("tv1의 channel : " +tv1.channel);
		System.out.println("tv2의 channel : " +tv2.channel);


	}

}
