import java.util.Scanner;

public class Main {
	static int[][] arr;
	static StringBuilder sb;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sb = new StringBuilder();
		int N = sc.nextInt(); // 영상 크기
		arr = new int[N][N];

		for (int i = 0; i < N; i++) {
			String input = sc.next();
			for (int j = 0; j < N; j++) {
				arr[i][j] = (input.charAt(j) - '0');
			}
		}

		cut(0, N - 1, 0, N - 1);

		System.out.println(sb);
	}

	private static void cut(int Rst, int Red, int Cst, int Ced) {
		// 기저 조건
		if (Rst == Red) {
			sb.append(arr[Rst][Cst]);
			return;
		}

		// 유도 조건
		boolean flag = true;
		int color = arr[Rst][Cst]; // 해당 영영의 왼쪽위 색깔
		here: for (int r = Rst; r <= Red; r++) {
			for (int c = Cst; c <= Ced; c++) {
				if (arr[r][c] != color) { // 전체가 같은 색이 아님
					flag = false;
					sb.append("(");
					cut(Rst, (Rst + Red) / 2, Cst, (Cst + Ced) / 2);
					cut(Rst, (Rst + Red) / 2, (Cst + Ced) / 2 + 1, Ced);
					cut((Rst + Red) / 2 + 1, Red, Cst, (Cst + Ced) / 2);
					cut((Rst + Red) / 2 + 1, Red, (Cst + Ced) / 2 + 1, Ced);
					sb.append(")");
					break here;
				}
			}
		}

		// 다 같은 색깔이면!
		if (flag) {
			sb.append(color);
		}

	}
}