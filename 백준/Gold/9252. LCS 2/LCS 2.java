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

		int num = dp[S1.length][S2.length];
		// 두 문자열의 LCS 길이 출력
		System.out.println(num);
		
		// LCS 쌓을 스트링빌더 준비
		StringBuilder sb = new StringBuilder();
		
		// LCS의 가장 마지막 문자부터 탐색 시작
		here: for (int r = S1.length; r >= 1; r--) {
			for (int c = S2.length; c >= 1; c--) {
				// LCS 길이가 num이면서 위 or 왼쪽과 같지 않은 곳의 문자가 해당 LCS에서 해당 순서의 문자!
				if (dp[r][c] == num && dp[r - 1][c] == (num - 1) && dp[r][c - 1] == (num - 1)) {
					sb.append(S1[r - 1]);
					num--; // LCS 길이 하나 줄이고
					r--; // 현재 문자에 대해서는 LCS에서의 위치 찾았으니까 이전 문자 찾으러 가기
					if (r == 0)
						break here;
				}
			}
		}

		// 스트링빌더에는 뒤에서부터 쌓여있기 때문에 출력 전에 뒤집어주기
		System.out.println(sb.reverse());
	}
}