package ex;

public class AccessWayMain {

	public static void main(String[] args) {
		System.out.println(AccessWay.num); // num이 static 변수가 아니라면 이렇게 쓸 수 없음.
		AccessWay.num++;
		System.out.println(AccessWay.num);
		
		AccessWay ac = new AccessWay();
		System.out.println(ac.num2);
		
		//System.out.println(AccessWay.num2); // static이 아니라서 인스턴스화 시키지 않으면 이런식으로 불러올 수 없음
		System.out.println(ac.num); //static변수는 인스턴스를 참조하는 식으로도 가능하다.
	}

}
