package Array;

public class ArrayP3 {

	public static void main(String[] args) {
		int[][] arr = {{1,2,3},{4,5,6},{7,8,9}};
	
		switchArr(arr);

		for (int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}

	}

	static void switchArr(int[][] arr) {
		int[][] temp = {{0}};
		temp[0] = arr[0];
		arr[0] = arr[2];
		arr[2] = arr[1];
		arr[1] = temp[0];
	}

}
