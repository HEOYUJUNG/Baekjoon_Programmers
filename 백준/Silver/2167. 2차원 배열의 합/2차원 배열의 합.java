import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] arr = new int[N + 1][M + 1];
		for (int r = 1; r <= N; r++) {
			for (int c = 1; c <= M; c++) {
				int x = sc.nextInt();
				arr[r][c] = arr[r - 1][c] + arr[r][c - 1] - arr[r - 1][c - 1] + x;
			}
		}

		int K = sc.nextInt();
		for (int i = 0; i < K; i++) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			System.out.println(arr[x2][y2] - arr[x1 - 1][y2] - arr[x2][y1 - 1] + arr[x1 - 1][y1 - 1]);
		}

	}
}
