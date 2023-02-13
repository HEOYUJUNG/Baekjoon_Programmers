package Class2;

import java.util.Scanner;

public class P2775_부녀회장이될테야 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // 테스트케이스

		for (int i = 0; i < T; i++) {
			int k = sc.nextInt(); // k층
			int n = sc.nextInt(); // n호
			int[][] arr = new int[k+1][n]; // 행 = 층, 열 = 호

			for (int r = 0; r <= k; r++) {
				for (int c = 1; c <= n; c++) {
					if (r == 0) { // 0층 설정
						arr[r][c-1] = c;  // 배열 인덱스는 0부터 시작하니까 1빼기!
					} else {
						for (int s = 0; s < c; s++) {
							arr[r][c-1] += arr[r - 1][s];
						}
					}
				}
			} 
			
			System.out.println(arr[k][n-1]);

		} // testcase
	} // main
}
