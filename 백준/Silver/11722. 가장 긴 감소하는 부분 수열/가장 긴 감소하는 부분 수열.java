import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 수열 A의 크기
		int[] A = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = sc.nextInt();
		}
		int[] dp = new int[N]; // 해당 부분까지 가장 긴 감소하는 부분 수열 길이
		dp[0] = 1; // 0번째 숫자까지의 길이는 무조건 1
		int maxL = 1; // 수열 A의 가장 긴 감소하는 부분 수열 길이(1로 초기화!! 수열의 원소 개수가 1이면 1)
		for (int i = 1; i < N; i++) {
			// i번째 숫자까지 가장 긴 감소하는 부분 수열 길이 구하기
			int max = 0;
			for (int j = i - 1; j >= 0; j--) {
				// i번째보다 앞에 있는 숫자들 중에서 i번째 수보다 크면서 & 가장 긴 길이인 곳 찾기
				if (A[j] > A[i]) {
					max = (max < dp[j]) ? dp[j] : max;
				}
			}
			dp[i] = max + 1; // 가장 긴 감소하는 부분 수열 길이 갱신
			maxL = (maxL < dp[i]) ? dp[i] : maxL;
		}

		System.out.println(maxL);
	}
}