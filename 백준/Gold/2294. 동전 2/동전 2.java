import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); // 동전 종류
		int k = Integer.parseInt(st.nextToken()); // 동전 가치 합
		int[] coin = new int[n];
		for (int i = 0; i < n; i++) {
			coin[i] = Integer.parseInt(br.readLine());
		}
		int[] dp = new int[k + 1];
		Arrays.fill(dp, k + 1);
		dp[0] = 0;
		for (int i = 1; i <= k; i++) {
			for (int j = 0; j < n; j++) {
				if (i >= coin[j]) {
					dp[i] = Math.min(dp[i], dp[i - coin[j]] + 1);
				}
			}
		}
		if (dp[k] == k + 1) {
			System.out.println(-1);
		} else {
			System.out.println(dp[k]);
		}
	}
}