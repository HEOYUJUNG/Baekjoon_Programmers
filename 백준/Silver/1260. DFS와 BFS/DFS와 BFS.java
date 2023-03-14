import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	static boolean[] visitedBFS;
	static List<Integer> BFSresult = new ArrayList<>();
	static boolean[] visitedDFS;
	static List<Integer> DFSresult = new ArrayList<>();
	static List<Integer>[] tree;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 정점 개수
		int M = sc.nextInt(); // 간선 개수
		int V = sc.nextInt(); // 시작 정점

		visitedBFS = new boolean[N + 1];
		visitedDFS = new boolean[N + 1];
		tree = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			tree[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			int node1 = sc.nextInt();
			int node2 = sc.nextInt();
			tree[node1].add(node2);
			tree[node2].add(node1);
		}

		for (int i = 1; i <= N; i++) {
			Collections.sort(tree[i]); // 인접 정점은 오름차순으로 정렬
		}
		bfs(V);
		dfs(V);

		for (int i = 0; i < DFSresult.size(); i++) {
			System.out.print(DFSresult.get(i) + " ");
		}
		System.out.println();
		for (int i = 0; i < BFSresult.size(); i++) {
			System.out.print(BFSresult.get(i) + " ");
		}
	}

	private static void bfs(int R) {
		int cnt = 0;
		Queue<Integer> q = new LinkedList<>();
		q.add(R); // 시작 정점 큐에 넣어두기
		visitedBFS[R] = true; // 시작 정점 방문 처리
		BFSresult.add(R);
		while (!q.isEmpty()) {
			int node = q.poll();

			// 해당 정점의 자식 정점들 방문 처리 안 되어 있으면 큐에 넣어주기
			for (int i = 0; i < tree[node].size(); i++) {
				int curNode = tree[node].get(i);
				if (!visitedBFS[curNode]) { // 방문한 적 없으면
					visitedBFS[curNode] = true; // 방문 처리.
					BFSresult.add(curNode);
					q.add(curNode); // 큐에 추가하기
				}
			}
		}
	}

	private static void dfs(int R) {
		Stack<Integer> stack = new Stack<>();
		stack.push(R); // 일단 시작 정점 넣어주기
		int cnt = 0;
		visitedDFS[R] = true; // 방문처리
		DFSresult.add(R);
		while (!stack.isEmpty()) {
			int node = stack.peek();
			if (!tree[node].isEmpty()) { // 탐색할 자식이 남아 있으면
				int curNode = tree[node].remove(0); // 가장 앞에 있는 자식 지우면서 꺼내기
				if (!visitedDFS[curNode]) { // 방문한 적 없으면
					visitedDFS[curNode] = true; // 방문처리
					DFSresult.add(curNode);
					stack.push(curNode);
				}
			} else {
				stack.pop(); // 더 이상 탐색할 자식이 없으면 스택에서 꺼내기
			}
		}
	}
}