import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		long[] dp = new long[101];
		dp[1] = 1;
		dp[2] = 1;
		dp[3] = 1;
		for (int i = 4; i <= 100; i++) {
			dp[i] = dp[i - 3] + dp[i - 2];
		}

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt(); // N번째 삼각형까지 있을 때 나선에 있는 정삼각형의 변의 길이
			System.out.println(dp[N]);
		}
	}
}