import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	static int[] visited;
	static List<Integer>[] V;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int N = sc.nextInt(); // 정점 개수
		int M = sc.nextInt(); // 간선 개수
		int R = sc.nextInt(); // 시작 정점

		visited = new int[N + 1];
		V = new ArrayList[N + 1]; // 노드들의 배열인데, 각각의 노드의 자식 노드들을 리스트로 가지고 있음.
		for (int i = 1; i <= N; i++) {
			V[i] = new ArrayList<>();
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
			Collections.sort(V[i], new Comparator<Integer>() {

				@Override
				public int compare(Integer o1, Integer o2) {
					return o2 - o1; // 인접 정점은 내림차순으로 정렬
				}

			}); 
		}

		dfs(R);

		for (int i = 1; i <= N; i++) {
			sb.append(visited[i] + "\n");
		}
		System.out.println(sb);
	} // main

	private static void dfs(int R) {
		Stack<Integer> stack = new Stack<>();
		stack.push(R); // 일단 시작 정점 넣어주기
		int cnt = 0;
		visited[R] = ++cnt; // 시작 정점의 방문 순서 1
		while (!stack.isEmpty()) {
			int node = stack.peek();
			if (!V[node].isEmpty()) { // 탐색할 자식이 남아 있으면
				int curNode = V[node].remove(0); // 가장 앞에 있는 자식 지우면서 꺼내기
				if (visited[curNode] == 0) { // 방문한 적 없으면
					visited[curNode] = ++cnt; // 방문처리
					stack.push(curNode);
				}
			} else {
				stack.pop(); // 더 이상 탐색할 자식이 없으면 스택에서 꺼내기
			}
		}
	}
}