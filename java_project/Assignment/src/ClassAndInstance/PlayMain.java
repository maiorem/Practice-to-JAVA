package ClassAndInstance;

public class PlayMain {

	public static void main(String[] args) {
		
		Player p1 = new Player();
		Player p2 = new Player();
		
		p1.marble = 15; // 어린이1의 구슬은 15개
		p2.marble = 9; // 어린이2의 구슬은 9개
		
		//“1차 게임에서 어린이 1은 어린이 2의 구슬 2개를 획득한다” 
		p1.game(p2, 2);
		
		//“2차 게임에서 어린이 2는 어린이 1의 구슬 7개를 획득한다.”
		p2.game(p1,7);

		System.out.println("어린이 1이 가진 구슬의 수 : "+p1.marble);
		System.out.println("어린이 2가 가진 구슬의 수 : "+p2.marble);

		
	}

}
