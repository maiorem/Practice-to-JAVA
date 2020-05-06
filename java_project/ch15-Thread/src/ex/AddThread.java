package ex;

public class AddThread extends Thread {

	Sum sumInst;
	long start;
	long end;
	
	AddThread(Sum sum, long start, long end){
		this.sumInst=sum;
		this.start=start;
		this.end=end;
	}

	@Override
	public void run() {
		for(long i=start; i<=end; i++) {
			sumInst.addNum(i);
		}
	}
	
	
	
	
}
