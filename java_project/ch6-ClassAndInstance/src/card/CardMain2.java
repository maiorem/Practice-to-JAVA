package card;

public class CardMain2 {

	public static void main(String[] args) {
				

		for(int i=1; i<=4; i++) {
			for (int j=1; j<=13; j++) {

				String kind = "";
				
				switch(i) {
				
				case 1 :
					kind = "Heart";
					break;
				case 2 :
					kind = "Spade";
					break;
				case 3 :
					kind = "Clover";
					break;
				case 4 :
					kind = "Diamond";
					break;
				}
				
				Card c = new Card();
				c.kind = kind;
				c.number = j; // 참조변수 c는 지역변수이다.
				
				System.out.println("카드의 종류 : "+c.kind+", "+c.number);
				
			}

		}

	}

}


