import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 수빈이 위치
		int K = sc.nextInt(); // 동생 위치
		boolean[] visited = new boolean[100001];
		int[] depth = new int[100001];
		Queue<Integer> q = new LinkedList<>();
		q.add(N); // 처음 시작 위치 넣어두기
		visited[N] = true;
		depth[N] = 0;
		while (!q.isEmpty()) {
			int X = q.poll();
			if (X - 1 >= 0 && !visited[X - 1]) {
				q.add(X - 1);
				visited[X - 1] = true;
				depth[X - 1] = depth[X] + 1;
			}
			if (X + 1 <= 100000 && !visited[X + 1]) {
				q.add(X + 1);
				visited[X + 1] = true;
				depth[X + 1] = depth[X] + 1;
			}
			if (X * 2 <= 100000 && !visited[X * 2]) {
				q.add(X * 2);
				visited[X * 2] = true;
				depth[X * 2] = depth[X] + 1;
			}

			if (X - 1 == K || X + 1 == K || X * 2 == K) {
				break;
			}
		}

		System.out.println(depth[K]);
	} // main
}