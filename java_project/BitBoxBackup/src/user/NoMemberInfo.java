package user;

import java.util.ArrayList;

import Ticket.Ticket;

public class NoMemberInfo extends Info{

	private String phoneNum;
	ArrayList <Ticket> ticket;
	private int myMoney;
	
	public NoMemberInfo(String phoneNum) {
		myMoney=20000;
		this.phoneNum=phoneNum;
		ticket = new ArrayList<Ticket>();
	}
	
	
	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}


	public void setTicket(Ticket ticket) {
		try {
			this.ticket.add(ticket);
		} catch (Exception e) {
			System.out.println("----------안나옴-------------");
		}
	}

	public ArrayList<Ticket> getTicket() {
		return ticket;
	}


	public void setTicket(ArrayList<Ticket> ticket) {
		this.ticket = ticket;
	}


	public int getMyMoney() {
		return myMoney;
	}


	public void setMyMoney(int myMoney) {
		this.myMoney = myMoney;
	}
	
	


	public void showResevInfo() {
		System.out.println("전화번호 : "+phoneNum);
		this.showAllMyTicket();
	}
	
	
}
