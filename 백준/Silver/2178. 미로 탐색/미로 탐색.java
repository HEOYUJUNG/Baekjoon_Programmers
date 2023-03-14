import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static List<Space>[] tree;
	static boolean[] visited;
	static int[] depth;
	static int M;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 행
		M = sc.nextInt(); // 열
		char[][] maze = new char[N][M]; // (0,0) ~ (N-1,M-1)
		visited = new boolean[N * M];
		depth = new int[N * M];
		tree = new ArrayList[N * M];
		for (int i = 0; i < N * M; i++) {
			tree[i] = new ArrayList<>();
		}

		// 미로 정보 입력 받기
		// 한 칸을 하나의 정점으로 생각
		// 인접한 정점끼리는 tree 상에서 서로 이어주기 (상하좌우 다)
		// 2차원 배열에서 (r,c)인 칸은 1차원 배열에서 M*r+c.
		for (int r = 0; r < N; r++) {
			String input = sc.next();
			for (int c = 0; c < M; c++) {
//				System.out.println("r: " + r + "/ c: " + c);
				if (input.charAt(c) == '1') {
					maze[r][c] = '1';
					Space sp = new Space(r, c);
					if (r - 1 >= 0 && maze[r - 1][c] == '1') {
						tree[M * (r - 1) + c].add(sp);
						tree[M * r + c].add(new Space(r - 1, c));
					}
					if (r + 1 < N && maze[r + 1][c] == '1') {
						tree[M * (r + 1) + c].add(sp);
						tree[M * r + c].add(new Space(r + 1, c));
					}
					if (c - 1 >= 0 && maze[r][c - 1] == '1') {
						tree[M * r + (c - 1)].add(sp);
						tree[M * r + c].add(new Space(r, c - 1));
					}
					if (c + 1 < M && maze[r][c + 1] == '1') {
						tree[M * r + (c + 1)].add(sp);
						tree[M * r + c].add(new Space(r, c + 1));
					}
				}
			}
		}

		System.out.println(bfs(new Space(0, 0), new Space(N - 1, M - 1))); // (0,0)부터 시작
	}

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

	private static int bfs(Space start, Space end) {
		Queue<Space> q = new LinkedList<>();
		q.add(start); // 시작 정점 큐에 넣어두기
		visited[0] = true; // 시작 정점 방문 처리
		depth[0] = 1; // 시작 위치도 포함해서 칸 세기
		while (!q.isEmpty()) {
			Space s = q.poll();
			int d = depth[M * s.r + s.c];
			// 해당 정점의 자식 정점들 방문 처리 안 되어 있으면 큐에 넣어주기
			for (int i = 0; i < tree[M * s.r + s.c].size(); i++) {
				Space curNode = tree[M * s.r + s.c].get(i);
				if (!visited[M * curNode.r + curNode.c]) { // 방문한 적 없으면
					visited[M * curNode.r + curNode.c] = true; // 방문 처리. 몇 번째 방문인지 저장.
					depth[M * curNode.r + curNode.c] = d + 1;
					q.add(curNode); // 큐에 추가하기
				}
			}
		}

		return depth[M * end.r + end.c];
	}
}