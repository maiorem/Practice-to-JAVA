package Array;

public class ArrayP2 {

	public static void addOneDArr(int[] arr, int add){
		for (int i=0; i<arr.length; i++) {
			arr[i] +=add;
		}
	}
	
	public static void addOneDArr(int[][] arr, int add) {
		
		for (int i=0; i<arr.length; i++) {
			
			for (int j=0; j<arr[i].length ; j++)  {
				arr[i][j] += add;
			}	
		}
		
	}
	

	public static void main(String[] args) {
		
		int[][] arr = new int[5][3];
		
		for (int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				arr[i][j]=i+j;
			}
		}
		
		addOneDArr(arr, 3);
		
		for (int i=0; i<arr.length; i++) {
			for (int j=0; j<arr[i].length; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}

	}

}
