package user;

import java.util.ArrayList;

import Ticket.Ticket;

public class Info {

	ArrayList <Ticket> ticket;
	private int myMoney;
	private int point;
	private String birth;

	
	
	public void showAllMyTicket() {
		for(int i=0; i<ticket.size()-1; i++) {
			try {
				System.out.println(i+">");
				ticket.get(i).showTicket();
			} catch(Exception e) {
				System.out.println("예매된 내역이 없습니다.");
			}
		}
	}
	
	public ArrayList<Ticket> getTicket() {
		return ticket;
	}
	
	
	public void setTicket(Ticket ticket) {
		try {
			this.ticket.add(ticket);
		} catch (Exception e) {
			System.out.println("-----------------------");
		}
	}
	
	public int getMyMoney() {
		return myMoney;
	}
	public void setMyMoney(int myMoney) {
		this.myMoney = myMoney;
	}


	
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public String getBirth() {
		return birth;
	}
	//	public void setBirth(int birth) {
	//		this.birth = birth;
	//	}

	

}
