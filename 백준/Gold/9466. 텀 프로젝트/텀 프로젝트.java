import java.io.*;
import java.util.*;

public class Main {
	static int cnt;
	static int[] choice;
	static boolean[] checked, finished;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int n = Integer.parseInt(br.readLine()); // 학생 수 (2~10만)
			choice = new int[n + 1];
			checked = new boolean[n + 1];
			finished = new boolean[n + 1];
			cnt = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= n; i++) {
				choice[i] = Integer.parseInt(st.nextToken());
			}
			for (int i = 1; i <= n; i++) {
				if (!finished[i]) {
					findTeam(i);
				}
			}

			System.out.println(n - cnt);
		}
	}

	static void findTeam(int x) {
		checked[x] = true;
		int next = choice[x];
		if (!checked[next])
			findTeam(next);
		if (checked[next] && !finished[next]) { // 사이클이 있다는 것
			cnt++;
			while (next != x) {
				cnt++;
				next = choice[next];
			}
		}
		finished[x] = true;
	}
}