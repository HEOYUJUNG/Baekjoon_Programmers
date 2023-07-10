import java.io.*;
import java.util.*;

public class Main {
	static int N, cnt;
	static int[][] house;

	static class Pipe {
		int dir;
		int firstR, firstC, secondR, secondC;

		public Pipe(int dir, int firstR, int firstC, int secondR, int secondC) {
			this.dir = dir;
			this.firstR = firstR;
			this.firstC = firstC;
			this.secondR = secondR;
			this.secondC = secondC;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); // 집의 크기
		house = new int[N + 1][N + 1];
		// 집의 상태 입력받기
		for (int r = 1; r <= N; r++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int c = 1; c <= N; c++) {
				house[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		cnt = 0;
		DFS(1, 1, 1, 1, 2);
		System.out.println(cnt);
	}

	public static void DFS(int dir, int firstR, int firstC, int secondR, int secondC) {
		// 기저
		if (secondR == N && secondC == N) {
			cnt++;
			return;
		}
		// 유도
		if (dir == 1) { // 파이프가 가로로 있는 경우
			// -> 이동 가능한 경우
			if (inRange(secondR, secondC + 1) && house[secondR][secondC + 1] == 0) {
				DFS(1, firstR, firstC + 1, secondR, secondC + 1);
			}
			// 대각선 아래 이동 가능한 경우
			if (inRange(secondR + 1, secondC + 1) && house[secondR][secondC + 1] == 0
					&& house[secondR + 1][secondC] == 0 && house[secondR + 1][secondC + 1] == 0) {
				DFS(3, firstR, firstC + 1, secondR + 1, secondC + 1);
			}
		} else if (dir == 2) { // 세로
			// 아래 이동 가능한 경우
			if (inRange(secondR + 1, secondC) && house[secondR + 1][secondC] == 0) {
				DFS(2, firstR + 1, firstC, secondR + 1, secondC);
			}
			// 대각선 아래 이동 가능한 경우
			if (inRange(secondR + 1, secondC + 1) && house[secondR][secondC + 1] == 0
					&& house[secondR + 1][secondC] == 0 && house[secondR + 1][secondC + 1] == 0) {
				DFS(3, firstR + 1, firstC, secondR + 1, secondC + 1);
			}
		} else { // 대각선
			// 가로로 이동 가능한 경우
			if (inRange(secondR, secondC + 1) && house[secondR][secondC + 1] == 0) {
				DFS(1, firstR + 1, firstC + 1, secondR, secondC + 1);
			}
			// 세로로 이동 가능한 경우
			if (inRange(secondR + 1, secondC) && house[secondR + 1][secondC] == 0) {
				DFS(2, firstR + 1, firstC + 1, secondR + 1, secondC);
			}
			// 대각선 아래 이동 가능한 경우
			if (inRange(secondR + 1, secondC + 1) && house[secondR][secondC + 1] == 0
					&& house[secondR + 1][secondC] == 0 && house[secondR + 1][secondC + 1] == 0) {
				DFS(3, firstR + 1, firstC + 1, secondR + 1, secondC + 1);
			}
		}
	}

	public static boolean inRange(int R, int C) {
		return R >= 1 && R <= N && C >= 1 && C <= N;
	}
}