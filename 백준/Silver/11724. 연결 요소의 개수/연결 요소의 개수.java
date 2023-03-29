import java.util.Scanner;

public class Main {

	static int M;
	static boolean[] visited;
	static int[][] relations;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 창용 마을에 사는 사람의 수 (정점 개수)
		M = sc.nextInt(); // 서로를 알고 있는 사람의 관계 수 (간선 개수)
		relations = new int[M][2];
		visited = new boolean[N + 1];
		int cnt = 0; // 무리 개수 카운트

		for (int i = 0; i < M; i++) {
			relations[i][0] = sc.nextInt();
			relations[i][1] = sc.nextInt();
		}

		for (int i = 1; i <= N; i++) {
			if (!visited[i]) {
				DFS(i);
				cnt++;
			}
		}

		System.out.println(cnt);

	} // main

	private static void DFS(int x) {
		visited[x] = true;
		for (int i = 0; i < M; i++) {
			if ((relations[i][0] == x && !visited[relations[i][1]])) {
				DFS(relations[i][1]);
			} else if ((relations[i][1] == x && !visited[relations[i][0]])) {
				DFS(relations[i][0]);
			}
		}
	}

}