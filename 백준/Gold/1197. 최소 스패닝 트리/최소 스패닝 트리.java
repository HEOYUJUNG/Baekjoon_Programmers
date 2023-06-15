import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int[] p; // 집합의 대표 저장하는 배열

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken()); // 정점 개수
		int E = Integer.parseInt(st.nextToken()); // 간선 개수

		// 크루스칼 1단계 : 간선을 정렬한다. (오름차순)
		PriorityQueue<Edge> pq = new PriorityQueue<>(new Comparator<Edge>() {
			@Override
			public int compare(Edge o1, Edge o2) {
				return o1.w - o2.w; // 가중치 기준 오름차순 정렬
			}
		});
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken()); // 정점
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken()); // 가중치
			pq.add(new Edge(A, B, C));
		}

		// 크루스칼 2단계 : V-1개의 간선을 뽑는데, 사이클이 발생 안 하는 애들만!!
		// 사이클 판단은 unionfind~ 같은 집합이라면 사이클 발생
		p = new int[V + 1];
		for (int i = 1; i <= V; i++) {
			p[i] = i;
		}

		int W = 0;
		while (!pq.isEmpty()) {
			Edge cur = pq.poll();
			if (findSet(cur.n1) == findSet(cur.n2)) { // 사이클 발생
				continue;
			}
			union(cur.n1, cur.n2); // 이어주기
			W += cur.w;
		}
		System.out.println(W);
	}

	static class Edge {
		int n1, n2, w; // 정점, 가중치

		public Edge(int n1, int n2, int w) {
			this.n1 = n1;
			this.n2 = n2;
			this.w = w;
		}
	}

	static int findSet(int x) {
		if (x != p[x]) {
			p[x] = findSet(p[x]);
		}
		return p[x];
	}

	static void union(int x, int y) {
		p[findSet(y)] = findSet(x);
	}
}