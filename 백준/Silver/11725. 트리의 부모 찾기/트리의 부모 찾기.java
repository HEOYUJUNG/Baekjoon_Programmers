import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 노드 개수
		List<Integer>[] tree = new ArrayList[N + 1];
		// 초기화 해주기
		for (int i = 1; i <= N; i++) {
			tree[i] = new ArrayList<>();
		}
		// 정점 입력받기
		for (int i = 0; i < N - 1; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			// 양방향이니까 둘 다 추가해주기
			tree[A].add(B);
			tree[B].add(A);
		}

		// 부모 노드 찾기
		int[] parent = new int[N + 1];
		Queue<Integer> q = new LinkedList<>();
		q.add(1); // 루트부터 넣기
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int num = q.poll(); // 현재 정점
				for (int x : tree[num]) {
					if (parent[x] == 0) {
						// 현재 정점과 연결되어 있으면서 방문하지 않았던 정점 찾기
						parent[x] = num;
						q.add(x);
					}
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 2; i <= N; i++) {
			sb.append(parent[i] + "\n");
		}

		System.out.println(sb);
	}
}