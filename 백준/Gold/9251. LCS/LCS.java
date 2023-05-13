import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 문자열 입력받기
		char[] S1 = sc.next().toCharArray();
		char[] S2 = sc.next().toCharArray();

		// 두 문자열 비교하면서 해당 지점까지의 LCS(최장 공통 부분 수열) 길이 저장할 dp 배열
		int[][] dp = new int[S1.length + 1][S2.length + 1];

		for (int r = 1; r <= S1.length; r++) {
			for (int c = 1; c <= S2.length; c++) {
				if (S1[r - 1] == S2[c - 1]) { // 두 문자가 같다면
					// 두 문자열에서 하나씩 앞에 있는 문자들끼리 비교했던 시점에서의 LCS 길이에 1 더하기
					dp[r][c] = dp[r - 1][c - 1] + 1;
				} else { // 두 문자 같지 않으면
					// 두 문자열에서 각각 하나 전에 구한 LCS 길이 중 더 긴 길이로 반영
					dp[r][c] = Math.max(dp[r - 1][c], dp[r][c - 1]);
				}
			}
		}

		System.out.println(dp[S1.length][S2.length]);
	}
}
