import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
	static int N, M;
	static int[] data;
	static int[] sel;
	static boolean[] visited;
	static Set<String> result;
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
		result = new LinkedHashSet<>(); // 중복된 데이터 저장 X, 입력된 순서대로 데이터 관리!
		comb(0);
		for (String res : result) {
			for (String s : res.split(" ")) {
				sb.append(s + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	private static void comb(int sidx) {
		// 기저 조건
		if (sidx == M) { // M개 선택 완료
			StringBuilder sb = new StringBuilder();
			for (int x : sel) {
				sb.append(x + " ");
			}
			result.add(sb.toString());
			return;
		}

		// 유도 조건
		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				sel[sidx] = data[i];
				visited[i] = true;
				comb(sidx + 1);
				visited[i] = false;
			}
		}
	}
}