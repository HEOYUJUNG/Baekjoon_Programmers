import java.io.*;
import java.util.*;

public class Main {
	static int M, N;
	static int[][] board;
	static boolean[][] visited;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken()); // 세로 길이
		N = Integer.parseInt(st.nextToken()); // 가로 길이
		board = new int[M][N];
		int cnt = 0; // 치즈 조각이 놓여 있는 칸의 개수 카운트
		for (int r = 0; r < M; r++) {
			String input = br.readLine();
			for (int c = 0; c < N; c++) {
				board[r][c] = input.charAt(2 * c) - '0';
				if (board[r][c] == 1)
					cnt++;
			}
		}
		// 치즈가 모두 녹아 없어질 때까지 반복
		int prevCnt = 0;
		int time = 0;
		while (cnt != 0) {
			time++;
			prevCnt = cnt;
			cnt = 0;
			// 1) 치즈 바깥은 전부 -1로 채우기
			BFS();
			// 2) 전체 탐색하면서 가장자리 치즈는 2로 바꾸기
			findEdge();
			// 3) 다시 한 번 전체 탐색하면서 2인 곳은 -1로 만들어주고(치즈 녹이기), 남은 치즈 조각 cnt하기
			for (int r = 0; r < M; r++) {
				for (int c = 0; c < N; c++) {
					if (board[r][c] == 2)
						board[r][c] = -1;
					else if (board[r][c] == 1)
						cnt++;
				}
			}
		}

		System.out.println(time);
		System.out.println(prevCnt);
	}

	static class Pos {
		int r, c;

		public Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	// 치즈 바깥쪽은 -1로 채우기
	static void BFS() {
		visited = new boolean[M][N];
		Queue<Pos> q = new LinkedList<>();
		q.add(new Pos(0, 0));
		board[0][0] = -1;
		visited[0][0] = true;
		while (!q.isEmpty()) {
			Pos cur = q.poll();
			for (int d = 0; d < 4; d++) {
				int rr = cur.r + dr[d];
				int cc = cur.c + dc[d];
				if (!outOfRange(rr, cc) && board[rr][cc] != 1 && !visited[rr][cc]) {
					board[rr][cc] = -1;
					visited[rr][cc] = true;
					q.add(new Pos(rr, cc));
				}
			}
		}
	}

	// 공기와 접촉한 치즈들 2라고 표시하기
	static void findEdge() {
		for (int r = 0; r < M; r++) {
			for (int c = 0; c < N; c++) {
				if (board[r][c] == 1 && isEdge(r, c))
					board[r][c] = 2;
			}
		}
	}

	static boolean outOfRange(int r, int c) {
		return r < 0 || r >= M || c < 0 || c >= N;
	}

	// 치즈가 가장자리에 있는 공기와 접촉된 치즈인지 판단
	static boolean isEdge(int r, int c) {
		for (int d = 0; d < 4; d++) {
			int rr = r + dr[d];
			int cc = c + dc[d];
			// 판의 가장 바깥쪽 테두리에는 치즈가 없기 때문에 배열 범위 벗어날 일은 없음!
			if (board[rr][cc] == -1)
				return true;
		}
		return false;
	}
}
