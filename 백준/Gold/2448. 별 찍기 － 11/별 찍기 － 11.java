import java.util.Scanner;

public class Main {
	static boolean[][] map;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		map = new boolean[N][2 * (N - 1) + 1];

		// 전체 삼각형에서 양변 길이 : N
		// 중간 지점 : N-1
		triangle(0, N - 1, N);

		StringBuilder sb = new StringBuilder();
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < 2 * (N - 1) + 1; c++) {
				if (map[r][c]) {
					sb.append("*");
				} else {
					sb.append(" ");
				}
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}

	// 위 꼭짓점 : (r,c)
	// 양쪽변 길이 : d
	private static void triangle(int r, int c, int d) {
		// 기저 조건 (최소 단위 삼각형이 됐을 경우)
		if (d == 3) {
			miniTree(r, c);
			return;
		}

		// 유도 조건
		// 작은 삼각형 3개로 나누기
		triangle(r, c, d / 2); // 위
		triangle(r + d / 2, c + d / 2, d / 2); // 오른쪽아래
		triangle(r + d / 2, c - d / 2, d / 2); // 왼쪽아래
	}

	private static void miniTree(int r, int mid) {
		map[r][mid] = true;
		map[r + 1][mid - 1] = true;
		map[r + 1][mid + 1] = true;
		for (int i = 0; i <= 2; i++) {
			map[r + 2][mid + i] = true;
			map[r + 2][mid - i] = true;
		}
	}
}