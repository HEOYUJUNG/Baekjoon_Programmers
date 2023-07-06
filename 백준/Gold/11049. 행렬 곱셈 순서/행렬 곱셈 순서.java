import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 행렬 개수
		int[][] arr = new int[N][2];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		// dp[i][j] : i부터 j번째까지 행렬의 곱셈 연산 최솟값
		int[][] dp = new int[N][N];
		for (int k = 1; k < N; k++) { // 계단식으로 들어가는 정도
			for (int i = 0; i + k < N; i++) { // 행
				dp[i][i + k] = Integer.MAX_VALUE;
				for (int j = i; j < i + k; j++) { // 열 0~직전까지 비교해보기
					dp[i][i + k] = Math.min(dp[i][i + k],
							dp[i][j] + dp[j + 1][i + k] + arr[i][0] * arr[j][1] * arr[i + k][1]);
				}
			}
		}
		System.out.println(dp[0][N - 1]);
	}
}