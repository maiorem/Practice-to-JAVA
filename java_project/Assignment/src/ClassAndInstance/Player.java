package ClassAndInstance;

public class Player {
	
	int marble; // 플레이어가 가진 구슬의 수
	
	void game(Player a, int num) {// 플레이어가 이긴 경우 구슬의 주고받음을 표현하는 메서드
		
		marble = marble + num;
		a.marble = a.marble - num;
	
	}
	
}
