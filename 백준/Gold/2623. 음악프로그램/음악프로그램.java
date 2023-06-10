import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 가수 수 (1~1000)
		int M = Integer.parseInt(st.nextToken()); // 보조 PD 수 (1~100)

		List<Integer>[] graph = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}
		int[] inDegree = new int[N + 1]; // 진입 차수

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken()); // 담당한 가수 수
			int from = Integer.parseInt(st.nextToken());
			for (int j = 1; j < n; j++) {
				int to = Integer.parseInt(st.nextToken());
				graph[from].add(to);
				inDegree[to]++; // 진입차수 증가
				from = to;
			}
		}

		Queue<Integer> q = new LinkedList<>();

		// 진입 차수 0인 정점들부터 큐에 넣기
		for (int i = 1; i <= N; i++) {
			if (inDegree[i] == 0) {
				q.add(i);
			}
		}

		int cnt = 0;
		while (!q.isEmpty()) {
			int cur = q.poll();
			bw.write(cur + "\n");
			cnt++;
			for (int next : graph[cur]) {
				inDegree[next]--;
				if (inDegree[next] == 0) { // 진입차수 0이되면
					q.add(next); // 큐에 넣어주기
				}
			}
		}
		if (cnt != N) {
			System.out.println(0);
			return;
		}

		bw.flush();
		br.close();
		bw.close();
	}
}