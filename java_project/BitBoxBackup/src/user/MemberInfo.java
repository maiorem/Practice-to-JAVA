package user;

import java.util.ArrayList;

import Ticket.Ticket;
import Ticket.TicketManager;
import TimeTable.TimeTableManager;

public class MemberInfo extends Info {
	
	// 아이디, 비밀번호
	// 이름, 전화번호, 이메일
	// 보유금액, 포인트
	private String id;
	private String pw;
	private String name;
	private String phoneNum;
	private String email;
	private int myMoney;
	private int point;
	private String birth;
	TicketManager tm = new TicketManager();
	ArrayList <Ticket> ticket;
	
	public MemberInfo(String id, String pw, String name, String birth, String phoneNum, String email) {
		this.id=id;
		this.pw=pw;
		this.name=name;
		this.birth = birth;
		this.phoneNum=phoneNum;
		this.email=email;
		this.myMoney=50000;
		this.point=0;
		ticket = new ArrayList<Ticket>();
	}
	
	MemberInfo(){}
		
	
	public String getEmail() {
		return email;
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

	
	
	public int getPoint() {
		return point;
	}
	
	public void setPoint(int point) {
		this.point = point;
	}

	public void showPoint() {
		System.out.println(point);
	}
//	
//	public void addPoint() {
//		this.point += ticket.showPrice()/100;
//	}
//	
//	public void usePoint() {
//		this.point-=
//	}

	//티켓보기(예매내역확인)


	public void showBasicInfo() {
		System.out.println("아이디 : "+this.id);
		System.out.println("이름 : "+this.name);
		System.out.println("전화번호 : "+this.phoneNum);
		System.out.println("이메일 : "+this.email);
	}
	
	public void showMoney() {
		System.out.println("나의 보유 금액 : "+this.myMoney);
		System.out.println("나의 보유 포인트 : "+this.point);
	}
	
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getPw() {
		return pw;
	}


	public void setPw(String pw) {
		this.pw = pw;
	}


	public int getMyMoney() {
		return myMoney;
	}


	public void setMyMoney(int myMoney) {
		this.myMoney = myMoney;
	}
	public String getBirth() {
		return birth;
	}

}
