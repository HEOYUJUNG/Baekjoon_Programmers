import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static long[] depthN;
	static long[] visitN;
	static List<Integer>[] V;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 정점 개수
		int M = sc.nextInt(); // 간선 개수
		int R = sc.nextInt(); // 시작 정점

		depthN = new long[N + 1]; // 정점의 깊이 저장할 배열
		visitN = new long[N + 1]; // 정점 방문 순서 저장할 배열
		for (int i = 1; i <= N; i++) {
			depthN[i] = -1; // 전부 -1로 초기화
		}

		V = new ArrayList[N + 1]; // 노드들의 배열인데, 각각의 노드의 자식 노드들을 리스트로 가지고 있음.
		for (int i = 1; i <= N; i++) {
			V[i] = new ArrayList<>();
		}

		// 간선 정보 입력받기
		for (int i = 0; i < M; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			// 양방향 간선이니까 둘 다 추가해주기!!
			V[u].add(v);
			V[v].add(u);
		}

		for (int i = 1; i <= N; i++) {
			Collections.sort(V[i]); // 인접 정점은 오름차순으로 정렬
		}

		bfs(R);

		long sum = 0; // long으로 해줘야 함!!
		for (int i = 1; i <= N; i++) {
			sum += depthN[i] * visitN[i];
		}
		System.out.println(sum);

	} // main

	private static void bfs(int R) {
		Queue<Integer> q = new LinkedList<>();
		q.add(R); // 시작 정점 큐에 넣어두기
		depthN[R] = 0; // 시작 정점 방문 처리
		int cnt = 0;
		visitN[R] = ++cnt;
		while (!q.isEmpty()) {
			int node = q.poll();
			long depth = depthN[node]; // 이전 노드의 깊이 가져오기
			// 해당 정점의 자식 정점들 방문 처리 안 되어 있으면 큐에 넣어주기
			for (int i = 0; i < V[node].size(); i++) {
				int curNode = V[node].get(i);
				if (visitN[curNode] == 0) { // 방문한 적 없으면
					depthN[curNode] = depth + 1; // 방문 처리. 깊이는 이전 노드에 +1 한 깊이로 저장.
					visitN[curNode] = ++cnt; // 방문 순서
					q.add(curNode); // 큐에 추가하기
				}
			}
		}
	}
}