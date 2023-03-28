import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int R, C;
	static int maxOfMinT = 0; // 최단 거리로 이동하는데 있어 가장 긴 시간
	static char[][] map;
	static boolean[][] visited;

	// 상하좌우
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt(); // 보물 지도 세로 크기
		C = sc.nextInt(); // 보물 지도 가로 크기
		map = new char[R][C];
		maxOfMinT = 0;

		// 보물 지도 입력받기
		for (int r = 0; r < R; r++) {
			map[r] = sc.next().toCharArray();
		}

		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (map[r][c] == 'L') {
					visited = new boolean[R][C]; // 방문 체크 할 배열
					BFS(new Pos(r, c, 0));
				}
			}
		}

		System.out.println(maxOfMinT);
	}

	private static void BFS(Pos p) {
		Queue<Pos> q = new LinkedList<>();
		q.add(p);
		visited[p.r][p.c] = true;
		int min = 0;
		while (!q.isEmpty()) {
			Pos curr = q.poll();
			for (int d = 0; d < 4; d++) {
				int rr = curr.r + dr[d];
				int cc = curr.c + dc[d];
				if (check(rr, cc) && map[rr][cc] != 'W' && !visited[rr][cc]) {
					q.add(new Pos(rr, cc, curr.dist + 1));
					visited[rr][cc] = true;
				}
			}

			if (q.isEmpty()) {
				min = curr.dist;
			}
		}

		maxOfMinT = Math.max(maxOfMinT, min);
	}

	// 인덱스 범위 확인
	private static boolean check(int r, int c) {
		if (r >= 0 && r < R && c >= 0 && c < C) {
			return true;
		}
		return false;
	}

	private static class Pos {
		int r, c, dist;

		public Pos(int r, int c, int dist) {
			super();
			this.r = r;
			this.c = c;
			this.dist = dist;
		}

		@Override
		public String toString() {
			return "Pos [r=" + r + ", c=" + c + ", dist=" + dist + "]";
		}
	}
}