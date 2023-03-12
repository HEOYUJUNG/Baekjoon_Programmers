import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	static List<Space>[] graph;
	static boolean[] visited;
	static int M;
	static int cnt;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			M = sc.nextInt(); // 배추밭 가로 길이
			int N = sc.nextInt(); // 배추밭 세로 길이
			int K = sc.nextInt(); // 배추 심어져 있는 위치 개수
			graph = new ArrayList[N * M];
			visited = new boolean[N * M];
			int[][] ground = new int[N][M];
			for (int i = 0; i < N * M; i++) {
				graph[i] = new ArrayList<>();
			}

			// 배추 위치 정보 입력받기
			// 한 칸을 하나의 정점으로 생각
			// 인접한 정점끼리는 tree 상에서 서로 이어주기 (상하좌우 다)
			// 2차원 배열에서 (r,c)인 칸은 1차원 배열에서 M*r+c.
			Space start = new Space(0, 0);
			for (int i = 0; i < K; i++) {
				int c = sc.nextInt();
				int r = sc.nextInt();
				ground[r][c] = 1;
				Space sp = new Space(r, c);
				start = (i == 0) ? sp : start;
				if (r - 1 >= 0 && ground[r - 1][c] == 1) {
					graph[M * (r - 1) + c].add(sp);
					graph[M * r + c].add(new Space(r - 1, c));
				}
				if (r + 1 < N && ground[r + 1][c] == 1) {
					graph[M * (r + 1) + c].add(sp);
					graph[M * r + c].add(new Space(r + 1, c));
				}
				if (c - 1 >= 0 && ground[r][c - 1] == 1) {
					graph[M * r + (c - 1)].add(sp);
					graph[M * r + c].add(new Space(r, c - 1));
				}
				if (c + 1 < M && ground[r][c + 1] == 1) {
					graph[M * r + (c + 1)].add(sp);
					graph[M * r + c].add(new Space(r, c + 1));
				}
			}

			cnt = 0; // 배추 몇 개 방문했는지 세는 변수
			int min = 0;

			for (int i = 0; i < N * M; i++) {
				if (ground[i / M][i % M] == 1 && !visited[i]) {
					dfs(new Space(i / M, i % M));
					min++;
				}
			}

			System.out.println(min);

		} // testcase
	} // main

	// 한 칸을 클래스로 만든 것
	private static class Space {
		int r;
		int c;

		public Space(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}

	private static void dfs(Space start) {
		Stack<Space> stack = new Stack<>();
		stack.push(start); // 일단 시작 정점 넣어주기
		visited[M * start.r + start.c] = true; // 방문 처리
		cnt++;
		while (!stack.isEmpty()) {
			Space s = stack.peek();
			if (!graph[M * s.r + s.c].isEmpty()) { // 탐색할 자식이 남아 있으면
				Space curS = graph[M * s.r + s.c].remove(0); // 가장 앞에 있는 자식 지우면서 꺼내기
				if (!visited[M * curS.r + curS.c]) { // 방문한 적 없으면
					visited[M * curS.r + curS.c] = true; // 방문처리
					stack.push(curS);
					cnt++;
				}
			} else {
				stack.pop(); // 더 이상 탐색할 자식이 없으면 스택에서 꺼내기
			}
		}
	} // dfs
}