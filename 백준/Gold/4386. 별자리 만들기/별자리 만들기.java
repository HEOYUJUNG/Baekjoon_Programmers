import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); // 별 개수
		double[][] star = new double[n][2];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			star[i][0] = Double.parseDouble(st.nextToken());
			star[i][1] = Double.parseDouble(st.nextToken());
		}

		boolean[] visited = new boolean[n];
		PriorityQueue<Edge> pq = new PriorityQueue<>(new Comparator<Edge>() {
			@Override
			public int compare(Edge o1, Edge o2) {
				if (o1.d > o2.d) {
					return 1;
				} else {
					return -1;
				}
			}
		});
		// 시작 정점 뽑기
		visited[0] = true;
		for (int i = 1; i < n; i++) {
			pq.add(new Edge(0, i, getDistance(star[0][0], star[0][1], star[i][0], star[i][1])));
		}
		int pick = 1;
		double cost = 0;
		while (pick != n) {
			Edge cur = pq.poll();
			if (visited[cur.ed])
				continue;
			visited[cur.ed] = true;
			pick++;
			cost += cur.d;
			for (int i = 1; i < n; i++) {
				if (!visited[i]) {
					pq.add(new Edge(cur.ed, i, getDistance(star[cur.ed][0], star[cur.ed][1], star[i][0], star[i][1])));
				}
			}
		}
		System.out.println(Math.floor(cost * 100) / 100.00);
	}

	static double getDistance(double x1, double y1, double x2, double y2) {
		return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
	}

	static class Edge {
		int st, ed;
		double d;

		public Edge(int st, int ed, double d) {
			this.st = st;
			this.ed = ed;
			this.d = d;
		}
	}
}