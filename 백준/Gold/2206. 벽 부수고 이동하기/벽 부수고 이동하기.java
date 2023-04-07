import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	// 상하좌우
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static int N, M, minD;
	static int[][] map;
	static boolean[][][] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 가로
		M = sc.nextInt(); // 세로
		map = new int[N + 2][M + 2];

		// 맵 입력받기
		for (int i = 1; i <= N; i++) {
			String input = sc.next();
			for (int j = 1; j <= M; j++) {
				map[i][j] = input.charAt(j - 1) - '0';
			}
		}

		// 테두리에는 2로 두르기 (범위쳌 하기시로)
		for (int i = 0; i < N + 2; i++) {
			map[i][0] = 2;
			map[i][M + 1] = 2;
		}
		for (int i = 0; i < M + 2; i++) {
			map[0][i] = 2;
			map[N + 1][i] = 2;
		}

		minD = 0; // 최단 경로 (전체 칸 수로 초기화)
		BFS();
		if (visited[N][M][0] || visited[N][M][1]) {
			System.out.println(minD);
		} else { // 불가능하면 -1 출력
			System.out.println(-1);
		}
	}

	// (r, c) : 현재 위치
	// d : 경로 길이
	// destroy : 벽을 부순 횟수
	private static void BFS() {
		Queue<Pos> q = new LinkedList<>();
		visited = new boolean[N + 2][M + 2][2];

		// 시작 위치 큐에 넣어주기
		q.add(new Pos(1, 1, 0));

		while (!q.isEmpty()) {
			minD++; // 거리 갱신
			int size = q.size();
			while (size-- > 0) {
				Pos curr = q.poll();

				if (curr.r == N && curr.c == M) { // 끝까지 도착 했으면 종료!
					visited[curr.r][curr.c][curr.destroy] = true;
					return;
				}
				
				if (visited[curr.r][curr.c][curr.destroy]) {
					continue;
				}

				// 현재 지점 방문처리
				visited[curr.r][curr.c][curr.destroy] = true;

				for (int d = 0; d < 4; d++) { // 상하좌우 이동해보기
					int rr = curr.r + dr[d];
					int cc = curr.c + dc[d];
					if (!visited[rr][cc][curr.destroy] && map[rr][cc] == 0) { // 0이면 그냥 이동
						q.add(new Pos(rr, cc, curr.destroy));
					} else if (!visited[rr][cc][curr.destroy] && map[rr][cc] == 1 && curr.destroy == 0) { // 벽인데 아직 부순 적
																											// 없으면 벽 부수고
																											// 이동
						q.add(new Pos(rr, cc, curr.destroy + 1));
					}
				}
			}
		}
	}

	private static class Pos {
		// destroy : 지금까지 벽 부순 횟수
		int r, c, destroy;

		public Pos(int r, int c, int destroy) {
			this.r = r;
			this.c = c;
			this.destroy = destroy;
		}
	}
}