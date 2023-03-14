import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int[] visitN;
	static List<Integer>[] V;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int N = sc.nextInt(); // 정점 개수
		int M = sc.nextInt(); // 간선 개수
		int R = sc.nextInt(); // 시작 정점

		visitN = new int[N + 1]; // 방문 순서 저장할 배열

		V = new ArrayList[N + 1]; // 노드들의 배열인데, 각각의 노드의 자식 노드들을 리스트로 가지고 있음.
		for (int i = 1; i <= N; i++) {
			V[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			// 양방향 간선이니까 둘 다 추가해주기!!
			V[u].add(v);
			V[v].add(u);
		}

		for (int i = 1; i <= N; i++) {
			Collections.sort(V[i], new Comparator<Integer>() {

				@Override
				public int compare(Integer o1, Integer o2) {
					return o2 - o1;  // 인접 정점은 ****내림차순****으로 정렬
				}

			}); 
		}

		bfs(R);

		for (int i = 1; i <= N; i++) {
			sb.append(visitN[i] + "\n");
		}
		System.out.println(sb);

	} // main

	private static void bfs(int R) {
		int cnt = 0;
		Queue<Integer> q = new LinkedList<>();
		q.add(R); // 시작 정점 큐에 넣어두기
		visitN[R] = ++cnt; // 시작 정점 방문 처리
		while (!q.isEmpty()) {
			int node = q.poll();

			// 해당 정점의 자식 정점들 방문 처리 안 되어 있으면 큐에 넣어주기
			for (int i = 0; i < V[node].size(); i++) {
				int curNode = V[node].get(i);
				if (visitN[curNode] == 0) { // 방문한 적 없으면
					visitN[curNode] = ++cnt; // 방문 처리. 몇 번째 방문인지 저장.
					q.add(curNode); // 큐에 추가하기
				}
			}
		}
	}
}