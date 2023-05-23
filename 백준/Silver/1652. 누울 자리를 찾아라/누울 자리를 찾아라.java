import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		char[][] map = new char[N][N];
		for (int r = 0; r < N; r++) {
			map[r] = sc.next().toCharArray();
		}

		int x = 0; // 가로로 누울 수 있는 자리 개수
		for (int r = 0; r < N; r++) {
			int cnt = 0;
			for (int c = 0; c < N; c++) {
				if (map[r][c] == '.') {
					cnt++;
				}
				if (map[r][c] == 'X' || c == (N - 1)) {
					x = (cnt > 1) ? x + 1 : x;
					cnt = 0;
				}
			}
		}

		int y = 0; // 세로로 누울 수 있는 자리 개수
		for (int c = 0; c < N; c++) {
			int cnt = 0;
			for (int r = 0; r < N; r++) {
				if (map[r][c] == '.') {
					cnt++;
				}
				if (map[r][c] == 'X' || r == (N - 1)) {
					y = (cnt > 1) ? y + 1 : y;
					cnt = 0;
				}
			}
		}

		System.out.println(x + " " + y);

	}
}