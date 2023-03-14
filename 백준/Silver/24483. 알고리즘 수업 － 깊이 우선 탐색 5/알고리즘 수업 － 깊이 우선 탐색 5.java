import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	static long[] visited;
	static long[] depth;
	static List<Integer>[] V;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 정점 개수
		int M = sc.nextInt(); // 간선 개수
		int R = sc.nextInt(); // 시작 정점

		visited = new long[N + 1];
		depth = new long[N + 1];

		V = new ArrayList[N + 1]; // 노드들의 배열인데, 각각의 노드의 자식 노드들을 리스트로 가지고 있음.
		for (int i = 1; i <= N; i++) {
			V[i] = new ArrayList<>();
			depth[i] = -1; // 깊이 -1로 초기화
		}

		// M개의 간선 정보 입력받기
		for (int i = 0; i < M; i++) {
			int p = sc.nextInt();
			int c = sc.nextInt();
			// 양방향 간선이니까 둘 다 추가해주기!!
			V[p].add(c);
			V[c].add(p);
		}

		for (int i = 1; i <= N; i++) {
			Collections.sort(V[i]); // 인접 정점은 오름차순으로 정렬
		}

		dfs(R);

		long sum = 0;
		for (int i = 1; i <= N; i++) {
			sum += visited[i] * depth[i];
		}
		System.out.println(sum);
	} // main

	private static void dfs(int R) {
		Stack<Integer> stack = new Stack<>();
		stack.push(R); // 일단 시작 정점 넣어주기
		int cnt = 0;
		visited[R] = ++cnt; // 시작 정점의 방문 순서 1
		depth[R] = 0; // 시작 정점 깊이 0
		while (!stack.isEmpty()) {
			int node = stack.peek();
			long d = depth[node]; // 이전 노드의 깊이 가져오기
			if (!V[node].isEmpty()) { // 탐색할 자식이 남아 있으면
				int curNode = V[node].remove(0); // 가장 앞에 있는 자식 지우면서 꺼내기
				if (visited[curNode] == 0) { // 방문한 적 없으면
					visited[curNode] = ++cnt; // 방문처리
					depth[curNode] = d + 1; // 깊이는 부모 노드의 깊이 +1
					stack.push(curNode);
				}
			} else {
				stack.pop(); // 더 이상 탐색할 자식이 없으면 스택에서 꺼내기
			}
		}
	}
}