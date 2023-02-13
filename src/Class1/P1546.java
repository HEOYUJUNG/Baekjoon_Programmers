package Class1;

import java.util.Scanner;

public class P1546 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] scores = new int[N];
		double max = 0;
		
		for(int i = 0;i<N;i++) {
			scores[i]=sc.nextInt();
			if(scores[i]>max) max=scores[i];
		}
		
		
		double sum = 0;
		for(int i = 0;i<N;i++) {
			sum += (scores[i]/max)*100;
		}
		System.out.println(sum/N);
	}
}
