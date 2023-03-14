import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static List<Integer>[] tree;
	static boolean[] visit;
	static int[] count; // 각 노드들의 촌수 세는 배열

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 전체 사람 수
		// p1, p2 두 사람의 촌수 계산해야 함
		int p1 = sc.nextInt();
		int p2 = sc.nextInt();

		int M = sc.nextInt(); // 부모 자식들 간의 관계 개수. 즉, 간선 개수.

		visit = new boolean[N + 1];
		count = new int[N + 1];
		tree = new ArrayList[N + 1]; // 관계도. 자식은 리스트에 추가해서 저장.
		for (int i = 1; i <= N; i++) {
			tree[i] = new ArrayList<>(); // 모드 리스트들 생성해놓기.
		}
		// M개의 관계 입력 받기
		for (int i = 0; i < M; i++) {
			int x = sc.nextInt(); // 부모
			int y = sc.nextInt(); // 자식
			tree[x].add(y); // 부모 x의 자식으로 y 추가하기
			tree[y].add(x); // 자식 y의 부모, 즉 인접 정점으로도 x 추가하기
		}

		for (int i = 1; i <= N; i++) {
			Collections.sort(tree[i]); // 인접 정점은 오름차순으로 정렬
		}

		System.out.println(bfs(p1, p2));

	} // main

	private static int bfs(int start, int end) {
		Queue<Integer> q = new LinkedList<>();
		q.add(start); // 시작 정점 큐에 넣어두기
		visit[start] = true; // 시작 정점 방문 처리
		count[start] = 0; // 시작 정점의 촌수는 0
		while (!q.isEmpty()) {
			int node = q.poll();
			int cnt = count[node];
			// 해당 정점의 자식 정점들 방문 처리 안 되어 있으면 큐에 넣어주기
			for (int i = 0; i < tree[node].size(); i++) {
				int curNode = tree[node].get(i);
				if (curNode == end)
					return cnt + 1; // 찾았으면 종료해버리기. 단, 한 다리 더 건넌 거니까 촌수+1
				if (!visit[curNode]) { // 방문한 적 없으면
					visit[curNode] = true; // 방문 처리. 깊이는 이전 노드에 +1 한 깊이로 저장.
					count[curNode] = cnt + 1; // 촌수 하나 더해서 저장해주기
					q.add(curNode); // 큐에 추가하기
				}
			}
		}
		return -1; // 다 순회할 때까지 p2 못 찾았으면 친척 관계가 없는 것이니 -1 반환
	}
}