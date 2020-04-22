package Array;

import java.util.Scanner;

public class ArrayP4 {

	
	static int min;
	static int max;
	
	public static int miniValue(int[] arr) {
		
		min = arr[0];
		for(int i=0; i<arr.length; i++) {
			if (min>arr[i]) {
				min=arr[i];
			} 
		}
		return min;
	}
	
	public static int maxValue(int[] arr) {
		max = arr[0];
		for(int i=0; i<arr.length; i++) {
			if (max<arr[i]) {
				max=arr[i];
			} 
		}
		return max;
	}
	
	
	
	public static void main(String[] args) {
	
		Scanner ar = new Scanner(System.in);
		int [] array = new int[5];
		for(int i=0; i<array.length; i++) {
			System.out.print("배열에 들어갈 정수를 입력하세요 : ");
			array[i] = ar.nextInt();
		}
		
		miniValue(array);
		maxValue(array);
		System.out.println("최대값 : "+max);
		System.out.println("최소값 : "+min);
		
		
	}
}
