import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] A = new int[N][M];
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				A[r][c] = sc.nextInt();
			}
		}

		M = sc.nextInt();
		int K = sc.nextInt();
		int[][] B = new int[M][K];
		for (int r = 0; r < M; r++) {
			for (int c = 0; c < K; c++) {
				B[r][c] = sc.nextInt();
			}
		}

		int[][] R = new int[N][K];
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < K; c++) {
				for (int i = 0; i < M; i++) {
					R[r][c] += A[r][i] * B[i][c];
				}
				sb.append(R[r][c] + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}