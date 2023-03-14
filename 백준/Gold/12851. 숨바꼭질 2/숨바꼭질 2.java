import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 수빈이 위치
		int K = sc.nextInt(); // 동생 위치
		boolean[] visited = new boolean[100001];
		int[] depth = new int[100001]; // 최단 경로. 깊이.
		int cnt = 0; // 가장 빠른 시간으로 찾는 방법 개수
		int min = Integer.MAX_VALUE;

		Queue<Integer> q = new LinkedList<>();
		q.add(N); // 처음 시작 위치 넣어두기
		depth[N] = 0;
		while (!q.isEmpty()) {
			int X = q.poll();

			if (depth[X] > min) {
				break;
			}
			
			if (X == K) {
				cnt++; // 같은 최단 시간을 가지는 다른 방법이 있을 때마다 +1
				min = depth[K];
			}

			if (X - 1 >= 0 && (!visited[X - 1] || depth[X - 1] == depth[X] + 1)) {
				q.add(X - 1);
				visited[X - 1] = true;
				depth[X - 1] = depth[X] + 1;
			}
			if (X + 1 <= 100000 && (!visited[X + 1] || depth[X + 1] == depth[X] + 1)) {
				q.add(X + 1);
				visited[X + 1] = true;
				depth[X + 1] = depth[X] + 1;
			}
			if (X * 2 <= 100000 && (!visited[X * 2] || depth[X * 2] == depth[X] + 1)) {
				q.add(X * 2);
				visited[X * 2] = true;
				depth[X * 2] = depth[X] + 1;
			}
			// 1에서 2로 이동하는 경우 걸어서 +1, 순간이동해서 *2 숫자는 같지만 다른 경우이기 때문에 따로 탐색해줘야 함.
			// 그니까 큐에 한번 더 넣어줄 수 있도록!!
		}

		System.out.println(depth[K]);
		System.out.println(cnt);
	} // main
}