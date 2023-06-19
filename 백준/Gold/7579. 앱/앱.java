import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 활성화된 앱 개수
		int M = Integer.parseInt(st.nextToken()); // 추가로 필요한 메모리
		// 활성화된 앱들의 메모리&비용 입력받기
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		int[] memory = new int[N + 1];
		int[] cost = new int[N + 1];
		int sumM = 0;
		for (int i = 1; i <= N; i++) {
			memory[i] = Integer.parseInt(st1.nextToken());
			cost[i] = Integer.parseInt(st2.nextToken());
			sumM += memory[i];
		}
		// dp[i][j] : 1~i번 앱이 있고, j만큼의 비용을 사용하여 확보할 수 있는 메모리
		// 1차원으로 풀자
		int[] dp = new int[10001];
		int minCost = 10000;
		for (int i = 1; i <= N; i++) {
			for (int j = 10000; j >= cost[i]; j--) {
				dp[j] = Math.max(dp[j], dp[j - cost[i]] + memory[i]);
				if (dp[j] >= M) {
					minCost = Math.min(minCost, j);
				}
			}
		}
		System.out.println(minCost);
	}
}