import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N, M;
	static int[] data;
	static int[] sel;
	static boolean[] visited;
	static StringBuilder sb;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sb = new StringBuilder();
		N = sc.nextInt();
		M = sc.nextInt();
		data = new int[N];
		for (int i = 0; i < N; i++) {
			data[i] = sc.nextInt();
		}
		Arrays.sort(data);
		sel = new int[M];
		visited = new boolean[N];
		comb(0, 0);
		System.out.println(sb);
	}

	private static void comb(int idx, int sidx) {
		// 기저 조건
		if (sidx == M) { // M개 선택 완료
			for (int x : sel) {
				sb.append(x + " ");
			}
			sb.append("\n");
			return;
		}

		// 유도 조건
		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				sel[sidx] = data[i];
				visited[i] = true;
				comb(i + 1, sidx + 1);
				visited[i] = false;
			}
		}
	}
}