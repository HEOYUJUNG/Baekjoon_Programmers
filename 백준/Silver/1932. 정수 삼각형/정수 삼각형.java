

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] map = new int[n][n];
		int[][] dp = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		dp[0][0] = map[0][0];
		for (int i = 1; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				// 1. 왼쪽 위 2. 바로 위 까지의 합 중 큰 것 + 나
				if (j == 0) {
					dp[i][j] = dp[i - 1][j] + map[i][j];
				} else {
					dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + map[i][j];
				}
			}
		}

		int max = 0;
		for (int i = 0; i < n; i++) {
			max = (max < dp[n - 1][i]) ? dp[n - 1][i] : max;
		}

		System.out.println(max);
	}
}