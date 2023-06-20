import java.io.*;
import java.util.*;

public class Main {
	static int N, res;
	static int[][] dp, cost;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		cost = new int[N][3];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			cost[i][0] = Integer.parseInt(st.nextToken());
			cost[i][1] = Integer.parseInt(st.nextToken());
			cost[i][2] = Integer.parseInt(st.nextToken());
		}
		dp = new int[N][3];
		// 1) 첫 번째 집을 빨강으로 칠하는 경우
		dp[0][0] = cost[0][0];
		dp[0][1] = 1001;
		dp[0][2] = 1001;
		calculate();
		int res = Math.min(dp[N - 1][1], dp[N - 1][2]);
		// 2) 첫 번째 집을 초록으로 칠하는 경우
		dp[0][0] = 1001;
		dp[0][1] = cost[0][1];
		dp[0][2] = 1001;
		calculate();
		res = Math.min(res, Math.min(dp[N - 1][0], dp[N - 1][2]));
		// 3) 첫 번째 집을 파랑으로 칠하는 경우
		dp[0][0] = 1001;
		dp[0][1] = 1001;
		dp[0][2] = cost[0][2];
		calculate();
		res = Math.min(res, Math.min(dp[N - 1][0], dp[N - 1][1]));
		System.out.println(res);
	}

	static void calculate() {
		for (int r = 1; r < N; r++) {
			for (int c = 0; c < 3; c++) {
				dp[r][c] = cost[r][c] + Math.min(dp[r - 1][(c + 1) % 3], dp[r - 1][(c + 2) % 3]);
			}
		}
	}
}