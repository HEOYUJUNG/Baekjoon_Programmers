import java.util.Scanner;

public class Main {
	static int N, M, max, zeroCnt;
	static int[][] map;
	static boolean[][] visited;
	static int[][] copy;

	// 상하좌우
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 지도 세로 크기
		M = sc.nextInt(); // 지도 가로 크기
		map = new int[N][M]; // 연구실 지도
		copy = new int[N][M];
		max = 0; // 얻을 수 있는 안전 영역의 최대 크기 (0으로 초기화)
		zeroCnt = 0;

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				map[r][c] = sc.nextInt();
				if (map[r][c] == 0) {
					zeroCnt++; // 0개수 세기
				}
			}
		}

		// 벽을 세울 수 있는 곳 3개 고르기 (벽은 0인 곳에 세울 수 있음!)
		for (int i = 0; i <= M * N - 3; i++) {
			if (map[i / M][i % M] == 0) {
				for (int j = i + 1; j <= M * N - 2; j++) {
					if (map[j / M][j % M] == 0) {
						for (int k = j + 1; k <= M * N - 1; k++) {
							if (map[k / M][k % M] == 0) {

//								System.out.println("i : " + i + " / j : " + j + " / k : " + k);

								for (int s = 0; s < N; s++) {
									copy[s] = map[s].clone();
								}
								visited = new boolean[N][M];
								// 벽을 세울 3곳 선택 완료! 벽 세우기
								copy[i / M][i % M] = 1;
								copy[j / M][j % M] = 1;
								copy[k / M][k % M] = 1;

								// 2인 곳들을 찾아서 인접(상하좌우)한 0들은 1 만날 때까지 2로 바꿔주기
								// 2인 곳 찾기
								for (int r = 0; r < N; r++) {
									for (int c = 0; c < M; c++) {
										if (copy[r][c] == 2) {
											dfs(r, c);
										}
									}
								}

								// 0인 영역 개수 세기
								// max값 갱신
								max = Math.max(max, countSafe());

//								System.out.println(countSafe());
//								for (int r = 0; r < N; r++) {
//									for (int c = 0; c < M; c++) {
//										System.out.print(copy[r][c] + " ");
//									}
//									System.out.println();
//								}
							}
						}
					}
				}
			}
		} // 벽 3개

		System.out.println(max);
	} // main

	private static void dfs(int x, int y) {
		// 기저 조건
		if (!check(x, y) || copy[x][y] == 1 || visited[x][y]) {
			return;
		}

		visited[x][y] = true;
		copy[x][y] = 2;

		// 유도 조건
		for (int d = 0; d < 4; d++) {
			dfs(x + dr[d], y + dc[d]);
		}
	}

	// 인덱스 범위 확인
	private static boolean check(int r, int c) {
		if (r >= 0 && r < N && c >= 0 && c < M) {
			return true;
		}
		return false;
	}

	private static int countSafe() {
		int cnt = 0;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (copy[r][c] == 0) {
					cnt++;
				}
			}
		}
		return cnt;
	}
}