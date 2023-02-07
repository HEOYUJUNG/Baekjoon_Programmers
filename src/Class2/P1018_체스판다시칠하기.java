package Class2;

import java.util.Scanner;

public class P1018_체스판다시칠하기 {
	public static void main(String[] args) {
		/* 체스판 자르기 */
		Scanner sc = new Scanner(System.in);

		int M = sc.nextInt();
		int N = sc.nextInt();
		String[][] board = new String[M][N];
		for (int i = 0; i < M; i++) {
			String input = sc.next();
			String[] temp = input.split("");
			for (int j = 0; j < N; j++) {
				board[i][j] = temp[j];
			}
		}

		int min = 64;

		for (int i = 0; i < (M - 8 + 1); i++) {
			for (int j = 0; j < (N - 8 + 1); j++) {
				// 8*8짜리 체스판 시작 포인트 : (i,j)
				int re1 = 0;
				int re2 = 0;
				int re = 0;

				for (int s = i; s < (i + 8); s++) {
					for (int t = j; t < (j + 8); t++) {
						// 맨 왼쪽 위 칸이 흰색인 경우
						if (Math.abs(s - t) % 2 == 0 && board[s][t].equals("B")) { // 행과 열의 차이가 짝수인 칸들, 이 경우 W여야함
							re1++;
						}
						if (Math.abs(s - t) % 2 == 1 && board[s][t].equals("W")) { // 행과 열의 차이가 홀수인 칸들, 이 경우 B여야함
							re1++;
						}
						// 맨 왼쪽 위 칸이 검은색인 경우
						if (Math.abs(s - t) % 2 == 0 && board[s][t].equals("W")) { // 행과 열의 차이가 짝수인 칸들, 이 경우 B여야함
							re2++;
						}
						if (Math.abs(s - t) % 2 == 1 && board[s][t].equals("B")) { // 행과 열의 차이가 홀수인 칸들, 이 경우 W여야함
							re2++;
						}
					}
				} // (s,t) 끝. 즉, 체스판 하나에 대해 탐색 끝냄

				if (re1 > re2) {
					re = re2;
				} else {
					re = re1;
				}

				if (re < min) {
					min = re;
				}
			}
		}

		System.out.println(min);

	}
}
