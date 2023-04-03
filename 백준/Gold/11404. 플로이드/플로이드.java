import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int N = sc.nextInt(); // 도시 개수
		int M = sc.nextInt(); // 버스 개수
		int INF = 10000000; // 도시 개수 최대 100개. 한 번 비용 최대 100000.
		int[][] graph = new int[N + 1][N + 1];

		// 무한대로 초기화
		for (int i = 1; i <= N; i++) {
			Arrays.fill(graph[i], INF);
			graph[i][i] = 0; // 자기 자신으로 가는 비용은 0
		}

		for (int i = 0; i < M; i++) {
			int a = sc.nextInt(); // 출발
			int b = sc.nextInt(); // 도착
			int c = sc.nextInt(); // 비용

			// **시작 도시와 도착 도시를 연결하는 노선은 하나가 아닐 수 있다.
			// 같은 경로인데 비용이 더 싼 경우가 있으면 더 싼 비용으로 저장하기!!
			graph[a][b] = Math.min(graph[a][b], c);
		}

		// 플로이드 워셜~~!!
		for (int k = 1; k <= N; k++) { // 경유지
			for (int a = 1; a <= N; a++) { // 출발지
				for (int b = 1; b <= N; b++) { // 도착지
					graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]); // 더 작은 값으로 갱신!
				}
			}
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (graph[i][j] == INF) { // 갈 수 없는 경우
					sb.append(0 + " "); // 0 출력
				} else {
					sb.append(graph[i][j] + " ");
				}
			}
			sb.append("\n");
		}

		System.out.println(sb);
	} // main
}