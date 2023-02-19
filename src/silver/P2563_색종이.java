package baekjoon;

import java.util.Scanner;

public class P2563_색종이 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] paper = new int[100][100];
		int size = 0;
		for (int n = 0; n < N; n++) {
			// 색종이 왼쪽 변 ~ 도화지 왼쪽 변 거리
			int x = sc.nextInt();
			// 색종이 아래쪽 변 ~ 도화지 아래쪾 변 거리
			int y = sc.nextInt();

			
			for (int i = x; i < x + 10; i++) {
				for (int j = y; j < y + 10; j++) {
					if (paper[i][j] == 0) {
						paper[i][j]++;
						size++;
					}
				}
			}			
		}
		System.out.println(size);
	}
}
