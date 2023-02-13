package Class3;

import java.util.Scanner;

public class P11726_2n타일링 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long sum = 0; // 경우의 수

		for (long i = n / 2; i >= 0; i--) {
			long x = i; // 가로로 있는 타일 개수
			long y = n - 2 * i; // 세로로 있는 타일 개수 , 2x + y = n
			
			// nCy
			long up = 1;
			long down = 1;
			for (long j = y+1;j<=x+y;j++) up*=j;
			for (long j = 1;j<=x;j++) down*=j;
			if (down == 0) {
				sum += 1;
			} else {
				sum += up/down;
			}
			
//			System.out.println("x : " + x + " y : " + y);
//			System.out.p                        rintln("up : " + up + " down : " + down);
//			System.out.println(sum);
//			System.out.println();
		}
		
		System.out.println(sum%10007);
	}
}
