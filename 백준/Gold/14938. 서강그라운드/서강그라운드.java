import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static final int INF = 1500; // 길의 길이 최대 15, 길의 개수 최대 100.

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 지역 개수
		int M = sc.nextInt(); // 수색 범위
		int R = sc.nextInt(); // 길 개수
		int[] item = new int[N + 1]; // 1 ~ N
		int[][] graph = new int[N + 1][N + 1]; // 2차원 테이블 (모든 지점 -> 모든 지점 정보 필요하니까!)
		for (int i = 1; i <= N; i++) {
			Arrays.fill(graph[i], INF); // 무한대로 초기화
		}

		// 자기 자신으로 가는 비용은 0으로 초기화
		for (int r = 1; r <= N; r++) {
			graph[r][r] = 0;
		}

		// 구역별 아이템 수 입력받기
		for (int i = 1; i <= N; i++) {
			item[i] = sc.nextInt();
		}

		// 길 양 끝 지역, 길이 정보 입력받기
		for (int i = 0; i < R; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int l = sc.nextInt();
			// 양방향 통행이 가능. 즉, 무향 그래프니까 양쪽에 다 입력해주기
			graph[a][b] = graph[b][a] = l;
		}

		// 플로이드 워셜!! 경출도!!
		for (int k = 1; k <= N; k++) { // 경유지
			for (int a = 1; a <= N; a++) { // 출발지
				if (a != k) { // 경유지와 출발지 같은 때는 굳이 안 봐도 됨
					for (int b = 1; b <= N; b++) { // 도착지
						graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);
					}
				}
			}
		}

//		for (int i = 1; i <= N; i++) {
//			System.out.println(Arrays.toString(graph[i]));
//		}

		// 출발지를 바꿔가면서 얻을 수 있는 아이템 개수 세고 최대 개수 갱신하기
		int max = 0; // 예은이가 얻을 수 있는 아이템 최대 개수 (0으로 초기화)
		for (int st = 1; st <= N; st++) {
			int cur = 0; // 현재 상황(st가 시작지점인 경우)에서 얻을 수 있는 아이템 개수
			for (int end = 1; end <= N; end++) {
				if (graph[st][end] <= M) {
					cur += item[end];
				}
			}
			max = Math.max(max, cur);
		}
		System.out.println(max);
	} // main
}