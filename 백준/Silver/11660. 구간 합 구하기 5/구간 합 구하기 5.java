import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int N = sc.nextInt(); // 표의 크기
		int M = sc.nextInt(); // 합을 구해야 하는 회수
		int[][] sum = new int[N + 1][N + 1];

		for (int r = 1; r <= N; r++) {
			for (int c = 1; c <= N; c++) {
				sum[r][c] = sc.nextInt();
				if (r - 1 >= 0) {
					sum[r][c] += sum[r - 1][c];
				}
				if (c - 1 >= 0) {
					sum[r][c] += sum[r][c - 1];
				}
				if (r - 1 >= 0 && c - 1 >= 0) {
					sum[r][c] -= sum[r - 1][c - 1];
				}
			}
		}

		for (int tc = 1; tc <= M; tc++) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			int res = sum[x2][y2] - sum[x1 - 1][y2] - sum[x2][y1 - 1] + sum[x1 - 1][y1 - 1];
			sb.append(res + "\n");
		}
		System.out.println(sb);
	}
}