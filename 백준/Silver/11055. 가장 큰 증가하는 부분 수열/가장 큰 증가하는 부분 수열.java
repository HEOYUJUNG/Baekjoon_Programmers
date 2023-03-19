import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 1<=N<=1000
		int[] A = new int[N]; // 1 ~ 1000
		int[] dp = new int[N]; // 해당 원소까지 증가하는 원소들의 합
		for (int i = 0; i < N; i++) {
			A[i] = sc.nextInt();
			dp[i] = A[i];
		}

		int max = 0; 
		for (int i = 0; i < N; i++) { // 0부터 시작 (그래야 5 4 3 2 1 이런 경우에 5라고 나온다!)
			for (int j = i - 1; j >= 0; j--) {
				if (A[j] < A[i]) { // 이전 원소들 중 나보다 작은 원소들 찾아서
					// 그 원소까지의 증가 부분 합에 나를 더한 것 중 최대를 dp[i]에 저장
					// 최대인지 확인하는 과정 없으면 틀림!!
					// e.g. 10 1 5 2 9 => 이런 경우 9를 5에 붙일지 2에 붙일지에 따라 결과 달라짐
					dp[i] = (dp[i] < dp[j] + A[i]) ? dp[j] + A[i] : dp[i];
				}
			}
			max = (max < dp[i]) ? dp[i] : max;
//			System.out.println(Arrays.toString(dp));
		}

		System.out.println(max);
	}
}