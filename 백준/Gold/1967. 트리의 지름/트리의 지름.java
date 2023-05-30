import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	static final int INF = Integer.MAX_VALUE;
	static List<Edge>[] adjList;
	static boolean[] visited;
	static int tmpMax;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 노드 개수
		int R = 0; // 트리의 지름
		List<Integer> leaf = new ArrayList<>(); // 리프 노드들

		// 인접리스트
		adjList = new ArrayList[N + 1];

		for (int i = 1; i <= N; i++) {
			adjList[i] = new ArrayList<>();
		}

		// 간선 정보 입력받기
		for (int i = 0; i < N - 1; i++) {
			int A = sc.nextInt(); // 부모 노드
			int B = sc.nextInt(); // 자식 노드
			int W = sc.nextInt(); // 가중치

			adjList[A].add(new Edge(B, W));
			adjList[B].add(new Edge(A, W));
		}

		// 리프 노드만 따로 구하기
		for (int i = 2; i <= N; i++) {
			if (adjList[i].size() == 1) {
				leaf.add(i);
			}
		}

		// 모든 리프노드들에 대해서 DFS 수행 => 최대 거리 구하기
		for (int x : leaf) {
			tmpMax = 0; // 현재 리프노드 x에서 출발했을 대의 최대 거리
			visited = new boolean[N + 1];
			visited[x] = true;
			DFS(adjList[x].get(0).ed, adjList[x].get(0).w);
			R = (R < tmpMax) ? tmpMax : R; // 전체 지름 갱신
		}

		System.out.println(R);
	}

	private static class Edge {
		int ed, w;

		public Edge(int ed, int w) {
			this.ed = ed;
			this.w = w;
		}
	}

	private static void DFS(int x, int sum) {
		// 기저 조건(다른 리프 노드에 도달하면 종료)
		if (adjList[x].size() == 1) {
			tmpMax = (tmpMax < sum) ? sum : tmpMax;
			return;
		}

		// 유도 조건
		visited[x] = true;
		for (Edge y : adjList[x]) {
			if (!visited[y.ed]) {
				DFS(y.ed, sum + y.w);
			}
		}
	}
}
