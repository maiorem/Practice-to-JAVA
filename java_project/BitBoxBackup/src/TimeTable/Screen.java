package TimeTable;


/*
 *20.05.05 스크린 생성자 가격 추가
 *
 */


public class Screen {
	private String name;
	boolean[][] seats;
	private int price;
	private int seatLeft;

	Screen(String name, int rowNum,int seatNum, int price) {
		this.name = name;
		this.seats = new boolean[rowNum][seatNum];
		this.price = price;
		this.seatLeft = rowNum*seatNum;
	}

	public void seatMap() {

		char row = 65;
		char seat=1;
		System.out.print("  ");
		for (int i=0;i<seats[0].length;i++) {
			System.out.print(" "+(seat+i)+" ");
		}
		System.out.println();
		for (int i=0; i<seats.length;i++) {
			System.out.print((char)(row+i)+" ");
			for (int j=0; j<seats[i].length ; j++) {
				if (seats[i][j]==false) {
					System.out.print(" □ ");
				}else {
					System.out.print(" ■ ");
					seatLeft--;
				}
			}
			System.out.println();
		}
		System.out.println("● 잔여좌석 : "+seatLeft);
	}
	

	public int getPrice() {
		return price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean getSeats(int selectRow, int selectSeat) {
		return seats[selectRow-1][selectSeat-1];
	}
	
	public boolean[][] getSeats() {
		return seats;
	}

	public void setSeats(int selectRow, int selectSeat, boolean rSeat) {
		this.seats[selectRow-1][selectSeat-1] = rSeat;
	}
	
	void showScreenInfo() {
		System.out.println("● 상영관 이름(또는 번호) : "+this.name);
		System.out.println("● 영화표 가격: "+this.price+"원");
		System.out.println("\t<< 좌석 >>\t");
		seatMap();

		System.out.println();
	}
	
	
	boolean checkScreenName(String name) {
		return this.name.equals(name);
	}
	
	
	
}
	
	
	

