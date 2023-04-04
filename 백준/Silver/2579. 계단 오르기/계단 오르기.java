import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 계단 수
		int[] stair = new int[N];
		for (int i = 0; i < N; i++) {
			stair[i] = sc.nextInt();
		}

		if (N <= 2) {
			int sum = 0;
			for (int i = 0; i < N; i++) {
				sum += stair[i];
			}
			System.out.println(sum);
		} else {
			int[] dp = new int[N]; // 각 계단에 갈 수 있는 최대 비용 저장
			// 앞에 계단 3개는 따로 구해주기
			dp[0] = stair[0];
			dp[1] = stair[0] + stair[1];
			dp[2] = Math.max(stair[0], stair[1]) + stair[2];
			// 그 뒤부터는 규칙으로 구해가기
			for (int i = 3; i < N; i++) {
				// 1. 전 계단 밟고, 3개 연속은 안되니까 3개 전 계단 밟는 경우
				// 2. 2개 전 계단 밟기
				// 가능한 2가지 경우 중에서 더 큰 값으로 저장
				dp[i] = Math.max(stair[i - 1] + dp[i - 3], dp[i - 2]) + stair[i];
			}

			// 총 점수의 최댓값
			System.out.println(dp[N - 1]);
		}
	}
}