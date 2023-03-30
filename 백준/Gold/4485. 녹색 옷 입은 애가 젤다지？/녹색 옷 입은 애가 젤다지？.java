import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	// 상하좌우
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static final int INF = Integer.MAX_VALUE;
	static int N;
	static int[][] map, dist;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = 0;
		while (true) {
			N = sc.nextInt();
			if (N == 0) {
				return;
			}
			map = new int[N][N]; // 지도 정보
			dist = new int[N][N]; // 최단 경로 저장할 배열

			// 지도 정보 입력받기
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					map[r][c] = sc.nextInt();
				}
				Arrays.fill(dist[r], INF); // 최단 경로 배열 처음에 무한대로 초기화하기
			}

			dijkstra(0, 0); // 시작지점 입력해서 다익스트라 시작!

			System.out.println("Problem " + ++tc + ": " + dist[N - 1][N - 1]);

		} // testcase
	} // main

	private static void dijkstra(int r, int c) {
		boolean[][] visited = new boolean[N][N];

		PriorityQueue<Node> pq = new PriorityQueue<>(); // 가중치 오름차순 정렬

		// 시작점 큐에 넣기 & 방문처리 & 거리는 가중치만큼
		pq.add(new Node(r, c, map[r][c]));


		// 전부 확인해서 큐 빌 때까지 반복!
		while (!pq.isEmpty()) {

			// 현재 가장 가중치가 작은 정점 뽑기!
			Node cur = pq.poll();

			// 뽑았는데 이미 방문했던 곳이면 건너뛰기!
			if (visited[cur.r][cur.c])
				continue;

			// 현재 뽑은 정점 거리 dist에 저장하고, 방문 처리 해주기
			dist[cur.r][cur.c] = cur.w;
			visited[cur.r][cur.c] = true;

			// 현재 뽑은 정점에서 갈 수 있는 모든 곳 큐에 넣어주기!
			for (int d = 0; d < 4; d++) {
				int rr = cur.r + dr[d];
				int cc = cur.c + dc[d];
				if (check(rr, cc) && !visited[rr][cc]) { // 이미 방문했으면 갈 필요 없음
					pq.add(new Node(rr, cc, cur.w + map[rr][cc]));
				}
			}
		}
	}

	// 배열 범위 벗어나는지 확인
	private static boolean check(int r, int c) {
		return (r >= 0 && r < N && c >= 0 && c < N);
	}

	static class Node implements Comparable<Node> {
		int r, c, w; // r, c는 좌표. w는 가중치

		public Node(int r, int c, int w) {
			this.r = r;
			this.c = c;
			this.w = w;
		}

		@Override
		public int compareTo(Node o) { // 가중치 낮은 것부터 오름차순!
			return Integer.compare(this.w, o.w);
		}

		@Override
		public String toString() {
			return "Node [r=" + r + ", c=" + c + ", w=" + w + "]";
		}

	}
}