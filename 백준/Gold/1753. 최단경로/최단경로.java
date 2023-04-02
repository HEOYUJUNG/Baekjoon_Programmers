import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	static final int INF = Integer.MAX_VALUE;

	static ArrayList<Node>[] graph;
	static int[] dist;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt(); // 정점 개수
		int E = sc.nextInt(); // 간선 개수
		int start = sc.nextInt(); // 시작 정점 번호

		graph = new ArrayList[V + 1];
		dist = new int[V + 1];
		Arrays.fill(dist, INF);
		for (int i = 1; i <= V; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < E; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			int w = sc.nextInt();
			graph[u].add(new Node(v, w));
		}

		dijkstra(start, V);

		for (int i = 1; i <= V; i++) {
			if (dist[i] == INF) {
				System.out.println("INF");
			} else {
				System.out.println(dist[i]);
			}
		}
	}

	private static void dijkstra(int start, int V) {
		boolean[] visited = new boolean[V + 1];
		PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				return o1.w - o2.w;
			}
		});

		dist[start] = 0;
		pq.add(new Node(start, 0));

		while (!pq.isEmpty()) {
			Node n = pq.poll();
			if (visited[n.v]) {
				continue;
			}

			dist[n.v] = n.w;
			visited[n.v] = true;
			for (Node node : graph[n.v]) {
				pq.add(new Node(node.v, node.w + n.w));
			}
		}

	}

	static class Node {
		int v, w; // v : 도착지, w : 가중치

		public Node(int v, int w) {
			this.v = v;
			this.w = w;
		}
	}
}