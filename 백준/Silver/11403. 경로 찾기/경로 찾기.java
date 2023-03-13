import java.util.Scanner;

public class Main {
	static int[][] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 정점 개수
		int[][] arr = new int[N][N];
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				arr[r][c] = sc.nextInt();
			}
		}

		int[][] possible = new int[N][N];
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (arr[r][c] == 1) {
					for (int idx = 0; idx < N; idx++) {
						if (arr[c][idx] == 1) {
							arr[r][idx] = 1;
						}
					}
				}
			}
		}
		
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (arr[r][c] == 1) {
					for (int idx = 0; idx < N; idx++) {
						if (arr[c][idx] == 1) {
							arr[r][idx] = 1;
						}
					}
				}
			}
		}

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				System.out.print(arr[r][c] + " ");
			}
			System.out.println();
		}
	} // main

//	public static boolean find(int i, int j) {
//		
//	}
}