import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 회의 개수
		int[] cnt = new int[N + 1]; // 회의별 회의 인원 저장할 배열
		for (int i = 1; i <= N; i++) {
			sc.nextInt();
			sc.nextInt();
			cnt[i] = sc.nextInt();
		}
		// 앞뒤 회의와는 회의 시간이 겹친다.=> 회의의 시작, 끝 시간은 고려하지 않고 회의 인원만 고려하면 됨!
		// 현재 회의까지 진행했을 때의 최대 인원 저장할 배열
		int[] dp = new int[N + 1];
		// 첫번째 회의는 무조건 그 회의를 했을 때가 최대 인원
		dp[1] = cnt[1];
		if (N >= 2) {
			dp[2] = Math.max(cnt[1], cnt[2]);
			// 다른 회의들은
			// 1) 전전 회의 + 지금 회의 하는 경우
			// 2) 전 회의
			// 중에서 최대값
			for (int i = 3; i <= N; i++) {
				dp[i] = Math.max(Math.max(dp[i - 3] + cnt[i], dp[i - 2] + cnt[i]), dp[i - 1]);
			}
		}

		System.out.println(dp[N]);
	}
}
