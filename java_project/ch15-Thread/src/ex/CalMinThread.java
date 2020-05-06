package ex;

public class CalMinThread extends Thread {

	Calcurator cal;
	
	CalMinThread(Calcurator c) {
		
		cal = c;
	}

	@Override
	public void run() {
		System.out.println(cal.min(5, 1));
		try {
			sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(cal.min(7, 6));
		
		try {
			sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
