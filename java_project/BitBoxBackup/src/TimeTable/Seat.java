package TimeTable;

public class Seat {
	private char rowNum;
	private int seatNum;
	
	public Seat(char rowNum, int seatNum) {
		this.rowNum = rowNum;
		this.seatNum = seatNum;
	}

	@Override
	public String toString() {
		return "● 예약 좌석 : " + rowNum + "열 " + seatNum;
	}

	public char getRowNum() {
		return rowNum;
	}

	public void setRowNum(char rowNum) {
		this.rowNum = rowNum;
	}

	public int getSeatNum() {
		return seatNum;
	}

	public void setSeatNum(int seatNum) {
		this.seatNum = seatNum;
	}
	
	
	
}
