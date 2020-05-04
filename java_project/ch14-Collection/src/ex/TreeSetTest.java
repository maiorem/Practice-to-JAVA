package ex;

import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetTest {

	public static void main(String[] args) {
		
		TreeSet<Integer> treeSet = new TreeSet<Integer>();
	
		treeSet.add(1);
		treeSet.add(2);
		treeSet.add(5);
		treeSet.add(3);
		treeSet.add(1);
		treeSet.add(2);
		
		System.out.println("요소의 갯수 : "+treeSet.size());
		
		Iterator<Integer> itr = treeSet.iterator();
		
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
	}

}
