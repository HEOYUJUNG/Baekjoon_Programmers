import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	// 상하좌우
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static int N, M, day;
	static int[][] box;
	static ArrayList<Pos> list;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		M = sc.nextInt(); // 가로 칸 수
		N = sc.nextInt(); // 세로 칸 수
		box = new int[N][M];
		list = new ArrayList<>();
		boolean flag = true; // 하나라도 익지 않은 토마토(0)가 있으면 false로 바꾸기
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				box[r][c] = sc.nextInt();
				if (box[r][c] == 1) {
					list.add(new Pos(r, c));
				} else if (box[r][c] == 0) {
					flag = false;
				}
			}
		}

		if (flag) { // 저장될 때부터 모든 토마토가 익어있는 상태
			System.out.println(0);
			return;
		}

		bfs();

		boolean imp = false;
		here: for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (box[r][c] == 0) {
					imp = true;
					break here;
				}
			}
		}

		if (imp) { // 토마토가 모두 익지는 못하는 상황
			System.out.println(-1);
		} else { // 토마토가 모두 익을 때까지의 최소 날짜
			System.out.println(day);
		}
	}

	private static void bfs() {
		Queue<Pos> q = new LinkedList<>();

		for (Pos p : list) {
			q.add(p);
		}
		day = -1;

		while (!q.isEmpty()) {
			int size = q.size();
			day++;
			while (size-- > 0) {
				Pos curr = q.poll();

				for (int d = 0; d < 4; d++) {
					int rr = curr.r + dr[d];
					int cc = curr.c + dc[d];
					if (rr >= 0 && rr < N && cc >= 0 && cc < M && box[rr][cc] == 0) { // 익지 않은 토마토이면
						box[rr][cc] = 1;
						q.add(new Pos(rr, cc));
					}
				}
			}
		}
	}

	private static class Pos {
		int r, c;

		public Pos(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
}
