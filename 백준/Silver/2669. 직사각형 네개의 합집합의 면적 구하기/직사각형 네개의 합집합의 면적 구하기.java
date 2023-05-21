import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean[][] arr = new boolean[101][101];
		for (int i = 0; i < 4; i++) {
			int c1 = sc.nextInt();
			int r1 = sc.nextInt();
			int c2 = sc.nextInt();
			int r2 = sc.nextInt();
			for (int r = r1; r < r2; r++) {
				for (int c = c1; c < c2; c++) {
					arr[r][c] = true;
				}
			}
		}

		int region = 0;
		for (int r = 1; r <= 100; r++) {
			for (int c = 1; c <= 100; c++) {
				if (arr[r][c]) {
					region++;
				}
			}
		}

		System.out.println(region);
	}
}