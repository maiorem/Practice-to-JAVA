package ex;

public class TvMain {

	public static void main(String[] args) {
		Tv tv1 = new Tv();
		
		CaptionTv cTv1 = new CaptionTv();
		
		Tv tv2 = new CaptionTv();
		
		//형변환 (상위 -> 하위)
		CaptionTv cTv2 = (CaptionTv) tv2;
//		((CaptionTv) tv2).caption();
		cTv2.display();
		
		//하위클래스에서 상위클래스 형변환은 자동.
		Tv t = cTv1;

		
//		IpTv itv = (IpTv) tv1; // 에러
//		IpTv itv2 = (IpTv) tv2; // => 명시해도 형변환이 안되는 경우.
//		s
//		itv.power(); // 에러
//		itv2.display(); // => 에러.
		
//		System.out.println(tv2.power);
		tv2.power();
//		System.out.println(tv2.power);
//		tv2.display();
		
		Tv tv3 = new IpTv();
		Tv tv4 = new SmartTv();
		
//		tv3.display();
//		tv4.display();
		
		Tv[] tvs = new Tv[4];
		
		tvs[0] = new Tv();
		tvs[1] = new CaptionTv();
		tvs[2] = new IpTv();
		tvs[3] = new SmartTv();
		
//		for(int i=0;i<tvs.length; i++) {
//			tvs[i].display();
		}
		
	}

