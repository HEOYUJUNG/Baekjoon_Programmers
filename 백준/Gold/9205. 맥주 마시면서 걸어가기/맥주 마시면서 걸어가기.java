import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int n = Integer.parseInt(br.readLine()); // 편의점 개수
			Pos[] arr = new Pos[n + 2];
			boolean[] visited = new boolean[n + 2];
			for (int i = 0; i < n + 2; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				arr[i] = new Pos(x, y);
			}
			Queue<Pos> q = new LinkedList<>();
			q.add(arr[0]);
			visited[0] = true;
			boolean flag = false;
			here: while (!q.isEmpty()) {
				Pos cur = q.poll();
				for (int i = 0; i < n + 2; i++) {
					if (!visited[i] && getDistance(cur, arr[i]) <= 1000) {
						if (i == n + 1) {
							flag = true;
							break here;
						}
						visited[i] = true;
						q.add(arr[i]);
					}
				}
			}
			if (flag) {
				sb.append("happy");
			} else {
				sb.append("sad");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	static class Pos {
		int x, y;

		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int getDistance(Pos p1, Pos p2) {
		return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
	}
}
