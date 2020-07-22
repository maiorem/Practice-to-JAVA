package message.model;

import java.sql.Date;

public class Message {
	
	private int msg_idx;
	private String msg_receiver;
	private int msg_writer;
	private String msg_text;
	private String msg_img;
	private Date msg_date;
	private int msg_readcheck;
	
	public Message() {
		
	}

	
	
	
	public Message(int msg_idx, String msg_receiver, int msg_writer, String msg_text, String msg_img, Date msg_date,
			int msg_readcheck) {
		super();
		this.msg_idx = msg_idx;
		this.msg_receiver = msg_receiver;
		this.msg_writer = msg_writer;
		this.msg_text = msg_text;
		this.msg_img = msg_img;
		this.msg_date = msg_date;
		this.msg_readcheck = msg_readcheck;
	}




	public int getMsg_idx() {
		return msg_idx;
	}




	public void setMsg_idx(int msg_idx) {
		this.msg_idx = msg_idx;
	}




	public String getMsg_receiver() {
		return msg_receiver;
	}




	public void setMsg_receiver(String msg_receiver) {
		this.msg_receiver = msg_receiver;
	}




	public int getMsg_writer() {
		return msg_writer;
	}




	public void setMsg_writer(int msg_writer) {
		this.msg_writer = msg_writer;
	}




	public String getMsg_text() {
		return msg_text;
	}




	public void setMsg_text(String msg_text) {
		this.msg_text = msg_text;
	}




	public String getMsg_img() {
		return msg_img;
	}




	public void setMsg_img(String msg_img) {
		this.msg_img = msg_img;
	}




	public Date getMsg_date() {
		return msg_date;
	}




	public void setMsg_date(Date msg_date) {
		this.msg_date = msg_date;
	}




	public int getMsg_readcheck() {
		return msg_readcheck;
	}




	public void setMsg_readcheck(int msg_readcheck) {
		this.msg_readcheck = msg_readcheck;
	}




	@Override
	public String toString() {
		return "Message [msg_idx=" + msg_idx + ", msg_receiver=" + msg_receiver + ", msg_writer=" + msg_writer
				+ ", msg_text=" + msg_text + ", msg_img=" + msg_img + ", msg_date=" + msg_date + ", msg_readcheck="
				+ msg_readcheck + "]";
	}


	
	
	
	

}
