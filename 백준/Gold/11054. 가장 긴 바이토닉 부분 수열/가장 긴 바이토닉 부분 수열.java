import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 수열 A의 크기
		int[] A = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = sc.nextInt();
		}
		// dp1 : 증가하는 부분 수열 길이 구하기
		int[] dp1 = new int[N];
		dp1[0] = 1;
		for (int i = 1; i < N; i++) {
			int curMax = 0;
			for (int j = i - 1; j >= 0; j--) {
				if (A[j] < A[i] && curMax < dp1[j]) {
					curMax = dp1[j];
				}
			}
			dp1[i] = curMax + 1;
		}
		// dp2 : 뒤에서부터 증가하는 부분 수열 길이 구하기
		int[] dp2 = new int[N];
		dp2[N - 1] = 1;
		int max = 2;
		for (int i = N - 2; i >= 0; i--) {
			int curMax = 0;
			for (int j = i + 1; j < N; j++) {
				if (A[j] < A[i] && curMax < dp2[j]) {
					curMax = dp2[j];
				}
			}
			dp2[i] = curMax + 1;
			max = (max < dp1[i] + dp2[i]) ? dp1[i] + dp2[i] : max;
		}
		// dp1 + dp2 - 1 의 최대값 구하기
		System.out.println(max - 1);
	}
}