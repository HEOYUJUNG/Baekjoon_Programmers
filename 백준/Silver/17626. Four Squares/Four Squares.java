import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] dp = new int[N + 1]; // 필요한 제곱수의 최소 개수
		dp[1] = 1;
		for (int i = 2; i <= N; i++) { // 숫자 i를 만드는 데 필요한 제곱수의 최소 개수 구하기
			int min = Integer.MAX_VALUE;
			for (int j = 1; j * j <= i; j++) { // 제곱수가 i보다 작은 경우, 그 제곱수를 사용한 경우들 중 최소 개수 구하기
				min = Math.min(min, dp[i - j * j] + 1);
			}
			dp[i] = min;
		}

		System.out.println(dp[N]);
	}
}