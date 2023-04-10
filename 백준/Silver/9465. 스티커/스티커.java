import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt(); // 가로 길이
			int[][] sticker = new int[3][N + 1];
			for (int r = 1; r <= 2; r++) {
				for (int c = 1; c <= N; c++) {
					sticker[r][c] = sc.nextInt();
				}
			}

			int[][] dp = new int[3][N + 1];

			// 첫번째 열 값들 초기화 해주기
			dp[1][1] = sticker[1][1];
			dp[2][1] = sticker[2][1];

			for (int c = 2; c <= N; c++) {
				// 첫번째 행. 왼쪽 아래 스티커 + 나를 붙이는 경우 vs 나를 안 붙이고 내 왼쪽 스티커 붙이는 경우 => 둘 중 더 큰 값으로 갱신
				dp[1][c] = Math.max(dp[2][c - 1] + +sticker[1][c], dp[1][c - 1]);
				// 두번째 행. 왼쪾 위 스티커 + 나를 붙이는 경우 vs 나를 안 붙이고 내 왼쪽 스티커 붙이는 경우 => 둘 중 더 큰 값으로 갱신
				dp[2][c] = Math.max(dp[1][c - 1] + sticker[2][c], dp[2][c - 1]); 
			}

			System.out.println(Math.max(dp[1][N], dp[2][N]));
		}
	}
}