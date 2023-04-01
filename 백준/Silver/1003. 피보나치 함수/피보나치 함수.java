import java.util.Scanner;

public class Main {
	static int[] cnt0 = new int[41];
	static int[] cnt1 = new int[41];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		cnt0[0] = 1;
		cnt1[1] = 1;
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();

			fibonacci(N);
			sb.append(cnt0[N] + " " + cnt1[N] + "\n");
		}
		System.out.println(sb);
	}

	private static void fibonacci(int x) {
		if (x == 0) {
			return;
		} else if (x == 1) {
			return;
		} else if (cnt0[x] > 0) {
			return;
		}

		fibonacci(x - 1);
		cnt0[x] = cnt0[x - 2] + cnt0[x - 1];
		cnt1[x] = cnt1[x - 2] + cnt1[x - 1];
	}
}