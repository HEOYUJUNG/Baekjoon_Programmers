import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	static List<Edge>[] graph;
	static boolean[] visited;
	static int R;
	static int node;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt(); // 정점 개수
		graph = new List[V + 1];
		List<Integer> leaf = new ArrayList<>();

		for (int i = 1; i <= V; i++) {
			graph[i] = new ArrayList<>();
		}

		// 간선 정보 입력받기
		for (int i = 0; i < V; i++) {
			int st = sc.nextInt();
			// 마지막 입력이 아닐 때까지 반복해서 입력 받기
			while (true) {
				int ed = sc.nextInt();
				if (ed == -1)
					break;
				int d = sc.nextInt();
				graph[st].add(new Edge(ed, d));
			}
		}

		R = 0; // 트리의 지름
		node = 0; // 정점 번호

		// 임의의 정점에서 가장 먼 점을 구한다! 이 점이 지름을 구성하는 2개의 점 중 하나이다.
		visited = new boolean[V + 1];
		DFS(1, 0);

		// 위에서 구한 점에서 가장 먼 점까지의 거리를 구한다. 이것이 트리의 지름!
		visited = new boolean[V + 1];
		DFS(node, 0);

		System.out.println(R);
	}

	private static class Edge {
		int ed, d;

		public Edge(int ed, int d) {
			this.ed = ed;
			this.d = d;
		}
	}

	private static void DFS(int x, int sum) {
		if (R < sum) {
			R = sum; // 현재의 최대 거리 갱신
			node = x; // 정점 번호 저장
		}

		// 유도 조건
		visited[x] = true; // 방문처리
		for (Edge e : graph[x]) {
			if (!visited[e.ed]) {
				DFS(e.ed, sum + e.d);
			}
		}
	}
}