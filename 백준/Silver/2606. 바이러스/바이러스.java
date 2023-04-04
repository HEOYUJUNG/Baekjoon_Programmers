import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 컴퓨터 수
		ArrayList<Integer>[] computer = new ArrayList[N + 1]; // 컴퓨터는 1 ~ N
		for (int i = 1; i <= N; i++) {
			computer[i] = new ArrayList<>();
		}

		int M = sc.nextInt(); // 컴퓨터 쌍 수
		for (int i = 0; i < M; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			computer[A].add(B);
			computer[B].add(A);
		}

		// BFS로 탐색하기
		boolean[] visited = new boolean[N + 1];
		Queue<Integer> q = new LinkedList<>();
		q.add(1); // 일단 시작 정점 넣기
		while (!q.isEmpty()) {
			int cur = q.poll();
			visited[cur] = true; // 방문처리
			for (int next : computer[cur]) { // 갈 수 있는 곳들 탐색
				if (!visited[next]) { // 방문한 적 없으면
					q.add(next); // 큐에 넣기
				}
			}
		}

		int cnt = 0; // 바이러스에 걸리게 되는 컴퓨터의 수
		for (int i = 2; i <= N; i++) {
			if (visited[i]) {
				cnt++;
			}
		}

		System.out.println(cnt);
	}
}