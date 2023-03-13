import java.util.Scanner;

public class Main {
	// 상, 우, 하, 좌
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		char[][] arrRR = new char[N][N]; // 적록색약인 사람이 봤을 때
		char[][] arrRG = new char[N][N]; // 적록색약이 아닌 사람이 봤을 때
		for (int r = 0; r < N; r++) {
			String input = sc.next();
			for (int c = 0; c < N; c++) {
				arrRG[r][c] = input.charAt(c);
				arrRR[r][c] = (input.charAt(c) == 'G') ? 'R' : input.charAt(c); // 적록색약이면 G 대신 R 넣어줌
			}
		}

		int cntRR = 0;
		int cntRG = 0;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (arrRG[r][c] == 'R' || arrRG[r][c] == 'G' || arrRG[r][c] == 'B') {
					cntRG++;
					dfs(r, c, arrRG, arrRG[r][c]);
				}
				if (arrRR[r][c] == 'R' || arrRR[r][c] == 'B') {
					cntRR++;
					dfs(r, c, arrRR, arrRR[r][c]);
				}
			}
		}
		System.out.println(cntRG + " " + cntRR);
	}

	private static void dfs(int r, int c, char[][] arr, char region) {
		for (int d = 0; d < 4; d++) {
			if (IdxCheck(r + dr[d], c + dc[d]) && arr[r + dr[d]][c + dc[d]] == region) {
				arr[r + dr[d]][c + dc[d]] = 'V'; // 구역 안에 들어간다고 탐색된 곳은 visited의 V로 바꿔주기
				dfs(r + dr[d], c + dc[d], arr, region);
			}
		}
	}

	private static boolean IdxCheck(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}
}