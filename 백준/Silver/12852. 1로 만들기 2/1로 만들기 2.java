import java.util.Scanner;

public class Main {
	static int[] cnt;
//	static List<Integer> path = new ArrayList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 1보다 크거나 같고, 10^6보다 작거나 같은 정수

		int[] dp = new int[N + 1];
		int[] from = new int[N + 1]; // 최소 연산 횟수일 때, 그 이전 경로가 어디였는지를 저장하는 배열

		dp[1] = 0;
		for (int i = 2; i <= N; i++) {
			dp[i] = dp[i - 1] + 1;
			from[i] = i - 1;
			if (i % 3 == 0 && dp[i / 3] + 1 < dp[i]) {
				dp[i] = dp[i / 3] + 1;
				from[i] = i / 3;
			}
			if (i % 2 == 0 && dp[i / 2] + 1 < dp[i]) {
				dp[i] = dp[i / 2] + 1;
				from[i] = i / 2;
			}
		}

		System.out.println(dp[N]);

		while (N > 0) {
			System.out.print(N + " ");
			N = from[N];
		}
	}
}