import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 집 개수
		int M = Integer.parseInt(st.nextToken()); // 길 개수

		// 프림은 최소 비용의 간선이 존재하는 정점 선택
		List<Edge>[] graph = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			// 양방향
			graph[A].add(new Edge(B, C));
			graph[B].add(new Edge(A, C));
		}

		boolean[] visited = new boolean[N + 1];
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		// 시작 정점
		int W = 0;
		int max = 0;
		int pick = 1;
		visited[1] = true;
		for (Edge e : graph[1]) {
			pq.add(e);
		}
		while (pick != N) {
			Edge cur = pq.poll();
			if (visited[cur.ed]) {
				continue;
			}
			visited[cur.ed] = true;
			W += cur.w;
			max = (max < cur.w) ? cur.w : max;
			pick++;
			for (Edge e : graph[cur.ed]) {
				if (!visited[e.ed]) {
					pq.add(e);
				}
			}
		}
		System.out.println(W - max);
	}

	static class Edge implements Comparable<Edge> {
		int ed, w;

		public Edge(int ed, int w) {
			this.ed = ed;
			this.w = w;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.w, o.w); // 가중치 오름차순
		}
	}
}