import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	private static class Node {
		int idx; // 다음 노드의 인덱스. 즉, 길의 도착 지점
		int cost; // 비용

		Node(int idx, int cost) {
			this.idx = idx;
			this.cost = cost;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 헛간 개수. 찬홍이가 있는 헛간.
		int M = sc.nextInt(); // 양방향 길 개수

		ArrayList<Node>[] graph = new ArrayList[N + 1];

		// 안에 있는 list도 초기화 해주기
		for (int i = 0; i <= N; i++) {
			graph[i] = new ArrayList<Node>();
		}

		// 길, 비용 정보 입력받기
		for (int i = 0; i < M; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			int C = sc.nextInt();
			// 양방향이니까 둘 다 넣어주기
			graph[A].add(new Node(B, C)); // A -> B 가는 데 C만큼 필요함
			graph[B].add(new Node(A, C)); // B -> A 가는 데 C만큼 필요함
		}

		// 다익스트라
		int[] dist = new int[N + 1]; // 최소 비용 저장할 배열
		for (int i = 1; i <= N; i++) {
			dist[i] = Integer.MAX_VALUE; // 큰 값(무한대)으로 초기화 해두기
		}

		// 방문한 정점들은 우선순위 큐에 넣어준다. 최소 비용을 가지는 것이 높은 우선순위!
		PriorityQueue<Node> q = new PriorityQueue<Node>(new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				return o1.cost - o2.cost;
			}
		});

		q.add(new Node(1, 0));
		dist[1] = 0;

		while (!q.isEmpty()) {
			Node cur = q.poll();

			if (dist[cur.idx] < cur.cost) {
				continue;
			}

			// 현재 노드에서 출발한 지름길의 도착지점에서 갈 수 있는 모든 곳 탐색하기
			for (int i = 0; i < graph[cur.idx].size(); i++) {
				Node next = graph[cur.idx].get(i);
				if (dist[cur.idx] + next.cost < dist[next.idx]) {
					// 이 길 이용해서 가는 경우가 더 빠르면 갱신
					dist[next.idx] = dist[cur.idx] + next.cost;
					// 갱신된 경우에만 큐에 넣기!
					q.offer(new Node(next.idx, dist[next.idx]));
				}
			}
		}

		// while문 다 돌고 나면 dist 배열에 각각의 정점으로 가는 최소 비용 저장되어 있음!

		System.out.println(dist[N]);

	}
}