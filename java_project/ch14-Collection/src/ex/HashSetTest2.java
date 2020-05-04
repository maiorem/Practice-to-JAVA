package ex;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetTest2 {

	public static void main(String[] args) {
		
		HashSet<SimpleNumber> set = new HashSet<>();
		//Set<String> set = new HashSet<>();
		
		set.add(new SimpleNumber(10));
		set.add(new SimpleNumber(20));
		set.add(new SimpleNumber(20));
		
		System.out.println("저장된 데이터의 개수 : "+set.size());
		
		Iterator<SimpleNumber> itr = set.iterator();
		
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
	}

}



class SimpleNumber {
	
	int num;
	
	SimpleNumber(int num){
		this.num=num;
	}
	
	public String toString() {
		return String.valueOf(num);
	}
	
	// HashSet의 동등비교 과정
	//1. hashcode를 비교한다. => 같은 해시코드를 가진 객체를 기반으로 비교한다.
	//2. equals 메서드로 비교한다.
	
	@Override
	public int hashCode() {		
		return num/2;
	}
	

	@Override
	public boolean equals(Object obj) {
		boolean result=false;
		
		//num의 값을 비교
		if(obj instanceof SimpleNumber) {
			SimpleNumber sm = (SimpleNumber) obj;
			result = this.num == sm.num;
		}
		
		return result;
	}


	
	
	
}









