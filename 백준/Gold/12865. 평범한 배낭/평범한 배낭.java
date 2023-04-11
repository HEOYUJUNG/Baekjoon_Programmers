import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 물품 개수
		int K = sc.nextInt(); // 제한 무게

		int[][] arr = new int[N + 1][2];
		for (int i = 1; i <= N; i++) {
			arr[i][0] = sc.nextInt(); // 각 물건의 무게
			arr[i][1] = sc.nextInt(); // 해당 물건의 가치
		}

		int[][] dp = new int[N + 1][K + 1]; // 배낭의 넣은 물건들의 최대 가치 저장해 나갈 배열
		for (int i = 1; i <= N; i++) { // i번째 물건에 대해
			for (int j = 1; j <= K; j++) { // 임시 무게 j
				if (j >= arr[i][0]) { // 현재 임시 무게가 i번째 물건의 물게 이상이면 i번째 물건을 넣을 수는 있음!
					// 1. i-1번째 물건을 봤을 때 무게가 j인 상태 그대로 (즉, i번째 물건은 넣지 않는 경우)
					// 2. i-1번째 물건을 봤을 때 (j - i번째 물건 무게)인 상태에 i번째 물건 무게 더해서 j가 된 경우 (즉, i번째 물건을 넣은 경우)
					// 둘 중 가치가 더 큰 경우의 가치 저장
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - arr[i][0]] + arr[i][1]);
				} else { // i번째 물건을 아예 넣을 수 없는 경우면
					dp[i][j] = dp[i - 1][j]; // i-1번째의 경우 그대로 가져오기
				}
			}
		}
		
		// 배낭에 넣을 수 있는 물건들의 가치합의 최댓값 출력
		System.out.println(dp[N][K]); 
	} // main
}
