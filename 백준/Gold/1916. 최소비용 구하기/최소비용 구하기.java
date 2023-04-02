import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	static final int INF = Integer.MAX_VALUE;
	static ArrayList<Node>[] city;
	static int[] dist;
	static int N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 도시 개수
		int M = sc.nextInt(); // 버스 개수
		city = new ArrayList[N + 1];
		dist = new int[N + 1];
		Arrays.fill(dist, INF); // 거리는 무한대로 초기화

		for (int i = 1; i <= N; i++) {
			city[i] = new ArrayList<>(); // 다 돌면서 초기화 해주기
		}
		for (int i = 0; i < M; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			int cost = sc.nextInt();
			city[A].add(new Node(B, cost)); // A도시에서 출발해서 갈 수 있는 도시(B), 비용(cost) 인접 리스트로 저장
		}

		int start = sc.nextInt(); // 출발점
		int end = sc.nextInt(); // 도착점
		dijkstra(start);

		System.out.println(dist[end]);
	}

	private static class Node implements Comparable<Node> {
		int B, cost; // B : 도착지, cost : 버스 비용

		public Node(int b, int cost) {
			B = b;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost; // 비용 작은 것이 더 높은 우선순위를 가짐! 비용 작은 것부터 오름차순 배열
		}
	}

	private static void dijkstra(int start) {
		boolean[] visited = new boolean[N + 1]; // 방문 처리

		PriorityQueue<Node> pq = new PriorityQueue<>();
		dist[start] = 0; // 출발 지점 거리 0으로 바꿔주기
		pq.add(new Node(start, 0)); // 우선순위 큐에 출발 지점 넣어주기

		while (!pq.isEmpty()) {
			Node m = pq.poll(); // 현재 큐에 있는 것들 중 가장 적은 비용을 가진 노드가 튀어나옴
			if (visited[m.B]) { // 이미 방문한 곳이면 뛰어넘기
				continue;
			}

			// 아직 방문 안 한 곳이면..!!
			visited[m.B] = true; // 방문처리하고
			dist[m.B] = m.cost; // 거리 갱신하기 (큐 안에서 자동정렬 돼서 최소 비용인 애가 튀어나온 거니까 바로 저장해주면 됨)
			for (Node move : city[m.B]) { // 현재 뽑은 도시에서 갈 수 있는 곳들 조사
				pq.add(new Node(move.B, m.cost + move.cost)); // 비용 갱신해서 넣어주기
			}
		}
	}
}
