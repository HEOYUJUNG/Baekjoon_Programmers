import java.util.Scanner;

public class Main {
	static int[][] arr;
	static int white, blue;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		arr = new int[N][N];
		// 색종이 입력받기 (0 : 하얀색 / 1 : 파란색)
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				arr[r][c] = sc.nextInt();
			}
		}

		white = 0; // 잘라진 하얀색 색종이 개수
		blue = 0; // 잘라진 파란색 색종이 개수

		cut(0, N - 1, 0, N - 1);

		System.out.println(white);
		System.out.println(blue);
	}

	private static void cut(int Rst, int Red, int Cst, int Ced) {
		// 기저 조건
		if (Rst == Red) {
			if (arr[Rst][Cst] == 0) {
				white++;
			} else {
				blue++;
			}
			return;
		}

		// 유도 조건
		boolean flag = true;
		int color = arr[Rst][Cst]; // 해당 영영의 왼쪽위 색깔
		here: for (int r = Rst; r <= Red; r++) {
			for (int c = Cst; c <= Ced; c++) {
				if (arr[r][c] != color) { // 전체가 같은 색이 아님
					flag = false;
					cut(Rst, (Rst + Red) / 2, Cst, (Cst + Ced) / 2);
					cut(Rst, (Rst + Red) / 2, (Cst + Ced) / 2 + 1, Ced);
					cut((Rst + Red) / 2 + 1, Red, Cst, (Cst + Ced) / 2);
					cut((Rst + Red) / 2 + 1, Red, (Cst + Ced) / 2 + 1, Ced);
					break here;
				}
			}
		}

		// 다 같은 색깔이면!
		if (flag) {
			if (color == 0) {
				white++;
			} else {
				blue++;
			}
		}

	}
}