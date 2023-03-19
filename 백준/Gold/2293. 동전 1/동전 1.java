import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N;
	static int[] coin;
	static int[] dp;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 동전 가지수
		int K = sc.nextInt(); // 가치 합
		coin = new int[N];
		dp = new int[K + 1]; // 해당 액수를 만드는 경우의 수
		for (int i = 0; i < N; i++) {
			coin[i] = sc.nextInt();
		}
		Arrays.sort(coin); // 오름차순 정렬
		dp[0] = 1; // 초기값
//		dp[coin[0]] = 1; // 동전 종류 중 가장 작은 액수를 만드는 경우의 수는 1가지

		int idx = 0; // 몇 번째 동전까지 포함할 수 있는지
		for (int i = N - 1; i >= 0; i--) {
			if (coin[i] <= K) {
				idx = i;
				break;
			}
		}

		for (int i = 0; i <= idx; i++) {
//			System.out.println(coin[i]);
			for (int j = 1; j <= K; j++) {
				dp[j] = (j - coin[i] >= 0) ? dp[j] + dp[j - coin[i]] : dp[j];
//				System.out.println(Arrays.toString(dp));
			}

			//
		}
		System.out.println(dp[K]);
	}

	// K원을 만들 수 있는 경우의 수 반환하는 메서드
//	public static int cal(int k) {
//		System.out.println("k : " + k);
//		System.out.println(Arrays.toString(dp));
//
//		if (k == 0 || dp[k] != 0) {
//			return dp[k];
//		}
//
//		int idx = 0; // 몇 번째 동전까지 포함할 수 있는지
//		for (int i = N - 1; i >= 0; i--) {
//			if (coin[i] <= k) {
//				idx = i;
//				break;
//			}
//		}
//
//		for (int i = 0; i <= idx; i++) {
//			dp[k] += cal(k - coin[i]);
//		}
//
//		return dp[k];
//	}
}