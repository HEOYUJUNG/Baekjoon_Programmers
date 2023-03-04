import java.util.Scanner;

public class Main {
	// 순서대로 시작할 때 쓰려고 넣어준거, 좌하, 하, 우하
	static int[] dc = { 0, -1, 0, 1 };
	static int N;
	static int M;
	static int[][] space;
	static int minCost = Integer.MAX_VALUE; // 달에 도달하기 위해 필요한 연료의 최소값. 큰 수로 초기화.
	static int sum = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 지구와 달 사이 N*M
		N = sc.nextInt();
		M = sc.nextInt();
		space = new int[N][M];
		// 우주선이 그 공간을 지날 때 소모되는 연료의 양 입력 받기
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				space[r][c] = sc.nextInt();
			}
		}

		// 이전 선택이 다음 선택에 영향을 준다.
		// 현재의 위치 & 현재까지의 합 & 직전에 움직인 방향 정보를 알면 다음에 어떤 방향으로 움직여야 하는지 알 수 있다.
		for (int c = 0; c < M; c++) {
			move(0, c, 0, 0);
		}
		System.out.println(minCost);
	}

	public static void move(int r, int c, int s, int d) {
		// 기저 조건 (언제 종료할지!)
		if (s > minCost) {
			// 합이 최소값 초과하면 더이상 탐색해도 의미 없음. 종료.
			return;
		}
		if (r == N) {
			// 달에 도착하면 최소값 갱신하고 종료.
			minCost = s;
//			System.out.println("minCost : " + minCost);
			return;
		}

		// 유도 조건
		s += space[r][c]; // 연료값 더해주기
//		System.out.println(s);
		if (d == 1) {
			// 이전에 움직인 방향이 1이었으면 다음은 2 or 3 방향으로 움직이기
			move(r + 1, c + dc[2], s, 2);
			if (c + dc[3] < M) { // 범위 벗어나지 않으면 움직이기
				move(r + 1, c + dc[3], s, 3);
			}
		} else if (d == 2) {
			// 이전에 움직인 방향이 2였으면 다음은 1 or 3 방향으로 움직이기
			if (c + dc[1] >= 0) {
				move(r + 1, c + dc[1], s, 1);
			}
			if (c + dc[3] < M) { // 범위 벗어나지 않으면 움직이기
				move(r + 1, c + dc[3], s, 3);
			}
		} else if (d == 3) {
			if (c + dc[1] >= 0) {
				move(r + 1, c + dc[1], s, 1);
			}
			move(r + 1, c + dc[2], s, 2);
		} else {
			// 처음 시작. 1, 2, 3 방향 전부 가능.
			if (c + dc[1] >= 0) {
				move(r + 1, c + dc[1], s, 1);
			}
			move(r + 1, c + dc[2], s, 2);
			if (c + dc[3] < M) { 
				move(r + 1, c + dc[3], s, 3);
			}
		}
	}
}