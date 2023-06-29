import java.io.*;
import java.util.*;

public class Main {
	// 상우하좌
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int[][] room;
	static int N, M;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 방 크기 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		// 로봇 청소기 위치, 방향 입력 (0 : 북쪽 / 1 : 동쪽 / 2 : 남쪽 / 3 : 서쪽)
		st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		// 방 상태 입력 (0 : 청소되지 않은 빈 칸 / 1 : 벽 / 2 : 청소된 칸)
		room = new int[N][M];
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++) {
				room[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		// 청소 시작!
		int cnt = 0; // 청소하는 칸의 개수
		here: while (true) {
			// 1. 현재 칸이 아직 청소되지 않은 경우
			if (room[R][C] == 0) {
				room[R][C] = 2; // 현재 칸 청소
				cnt++;
			}
			// 2. 주변이 전부 청소된 경우
			if (allCleaned(R, C)) {
				// 방향 유지하며 한 칸 후진
				R -= dr[D];
				C -= dc[D];
				if (room[R][C] == 1) // 벽이라 후진할 수 없으면 중지
					break here;
			} else { // 3. 청소되지 않은 칸이 있는 경우
				// 반시계 방향으로 90도 회전
				D = (D + 3) % 4;
				if (room[R + dr[D]][C + dc[D]] == 0) { // 청소되지 않은 경우
					// 한 칸 전진
					R += dr[D];
					C += dc[D];
				}
			}
		}
		System.out.println(cnt);
	}

	static boolean allCleaned(int R, int C) {
		for (int d = 0; d < 4; d++) {
			int RR = R + dr[d];
			int CC = C + dc[d];
			if (room[RR][CC] == 0)
				return false;
		}
		return true;
	}
}
