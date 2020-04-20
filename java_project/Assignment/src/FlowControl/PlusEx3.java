package FlowControl;

public class PlusEx3 {

	public static void main(String[] args) {
//		[3] 1+(1+2)+(1+2+3)+(1+2+3+4)+...+(1+2+3+...+10)의 결과를 계산하시오.
		
		int i = 1;
		int beforeSum = 0;
		int sum = 0;
		while (i<=10) {
			beforeSum += i;
			sum = sum + beforeSum;
			i++;
		}
		System.out.println(sum);
		

	}

}

/*
int sum = 0;

for(int i=1; i<=10; i++ {
	int k = 0;
	for(int j=1; j<=i; j++ {
		k=k+j;
	}
	sum=sum+k;
}
*/