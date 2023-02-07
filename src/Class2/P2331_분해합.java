package Class2;

import java.util.Scanner;

public class P2331_분해합 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int M =0; // 어떤 수 j의 분해합
		int print = 0;
		
		for (int j = 1 ; j<N; j++) {
			int len = Integer.toString(j).split("").length;
//			System.out.println("j : "+j);
//			System.out.println("len : " +len);
			int temp=j;
			int[] arr = new int[len];
			for (int i = len -1 ; i >= 0 ;i--) {
				arr[len-1-i] = temp / ((int) Math.pow(10, i));
				temp -= arr[len-1-i]*Math.pow(10, i);
			}
//			System.out.println("arr : " + Arrays.toString(arr));
			
			M= j ;
			for (int i =0;i<len;i++ ) {
				M += arr[i];
			}
//			System.out.println("result : " +M);
//			System.out.println();
			if (M==N) {
				System.out.println(j);		
				print++;
				break;
			}
		}
		
		if (print==0) {
			System.out.println(0);
		}
		
//		System.out.println(Arrays.toString(arr));
		
	}
}
