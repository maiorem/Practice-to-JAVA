package friend;

public class HighFriend extends Friend {

	String job;		// 친구의 직업
	
	public HighFriend(String name, String phoneNum, String addr, String job) {
		super(name, phoneNum, addr);
		this.job = job;
	}

	@Override
	public void showData() {
		showBasicInfo();
		System.out.println("직업 : "+job);
	}

	
	
	
	
}
