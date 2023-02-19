package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class P2578_빙고 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] board = new int[5][5];
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				board[i][j] = sc.nextInt();
			}
		}

		int cnt = 0;
		for (cnt = 0; cnt < 25; cnt++) {
			int input = sc.nextInt();
			// 수 비교 -> 같은 수 0으로
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {
					if (board[i][j] == input) {
						board[i][j] = 0;
					}
				}
			}

			// 빙고 있는지
			int bingo = 0;
			// 가로 빙고
			for (int i = 0; i < 5; i++) {
				int zero = 0;
				for (int j = 0; j < 5; j++) {
					if (board[i][j] == 0) {
						zero++;
					}
				}
				if (zero == 5) {
					bingo++;
//					System.out.println("가로");
				}
			}
			// 세로 빙고
			for (int i = 0; i < 5; i++) {
				int zero = 0;
				for (int j = 0; j < 5; j++) {
					if (board[j][i] == 0) {
						zero++;
					}
				}
				if (zero == 5) {
					bingo++;
//					System.out.println("세로");
				}
			}
			// 대각선 빙고
			int zero = 0;
			for (int i = 0; i < 5; i++) {
				
				if (board[i][i] == 0) {
					zero++;
				}
				if (zero == 5) {
					bingo++;
//					System.out.println("오른쪽아래 대각선");
				}
			}
			// 대각선 빙고
			zero = 0;
			for (int i = 0; i < 5; i++) {
				
				if (board[i][4 - i] == 0) {
					zero++;
				}
				if (zero == 5) {
					bingo++;
//					System.out.println("오른쪽위 대각선");
				}
			}

			if (bingo == 3) {
				System.out.println(cnt+1);
				return;
			}

		}

	} // main
}
