package ex;

public class PlayerC {
	
	
	int numOfMarble; // 구슬의 갯수
	
	// 구슬 갯수 데이터를 넣는 생성자
	PlayerC (int num) {
		numOfMarble=num;
	}
	
	//구슬의 갯수 설정
	void setMarble(int num) {
		numOfMarble = num;
	}
	
	//Player a와의 게임에서 이기는 경우 구슬의 수 변화 메서드.
	//(한쪽이 이기면 한쪽은 지므로 이기는 경우만 생성)
	void gameWin(PlayerC a/*게임상대*/, int num) {
		numOfMarble+=num;
		a.numOfMarble-=num;
	}
	
	//게임의 결과를 출력하는 메서드
	void showData() {
		System.out.println("현재 보유한 구슬의 갯수는 "+numOfMarble+"개 입니다.");	
	}
	
	public static void main(String[] args) {
		
		PlayerC p1 = new PlayerC(15); //철수
		PlayerC p2 = new PlayerC(9); //영희
		
		//철수는 구슬을 15개, 영희는 구슬을 9개 보유
//		p1.setMarble(15);
//		p2.setMarble(9);
		
		System.out.println("철수는 구슬을 "+p1.numOfMarble+"개 가지고 있고 영희는 구슬을 "+p2.numOfMarble+"개 가지고 있다.");
		System.out.println("==================================");
		
		// “1차 게임에서 어린이 1은 어린이 2의 구슬 2개를 획득한다”
		System.out.println("1차 게임에서 철수는 영희의 구슬 2개를 획득한다");
		p1.gameWin(p2, 2);


		System.out.print("철수 : ");
		p1.showData();
		System.out.print("영희 : ");
		p2.showData();
		
		System.out.println("==================================");
		
		// “2차 게임에서 어린이 2는 어린이 1의 구슬 7개를 획득한다.”
		System.out.println("2차 게임에서 영희는 철수의 구슬 7개를 획득한다");
		p2.gameWin(p1, 7);

		System.out.print("철수 : ");
		p1.showData();
		System.out.print("영희 : ");
		p2.showData();

	}
	

}
