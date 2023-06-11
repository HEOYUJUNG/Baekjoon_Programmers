import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 문제 개수
		int M = Integer.parseInt(st.nextToken()); // 문제 선후관계에 대한 정보 개수

		List<Integer>[] graph = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}
		int[] inDegree = new int[N + 1]; // 진입차수

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			graph[A].add(B); // A를 B보다 먼저 풀어야 함
			inDegree[B]++; // B의 진입차수 증가
		}

		// 우선순위 큐로 문제 난이도가 낮은 것 앞으로 정렬
//		PriorityQueue<Problem> pq = new PriorityQueue<>(new Comparator<Problem>() {
//			@Override
//			public int compare(Problem o1, Problem o2) {
//				if (o1.cnt == o2.cnt) { // 같은 시점에 들어왔다면
//					return o1.num - o2.num; // 난이도 낮은 문제 먼저 풀기
//				}
//				return o1.cnt - o2.cnt; // 먼저 들어온 문제 먼저 나가기
//			}
//		});

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		// 우선 진입차수 0인 정점(문제)들 큐에 넣기
		for (int i = 1; i <= N; i++) {
			if (inDegree[i] == 0) {
				pq.add(i);
			}
		}

		while (!pq.isEmpty()) {
			int cur = pq.poll();
			bw.write(cur + " "); // 결과로 출력
			for (int x : graph[cur]) {
				inDegree[x]--; // 문제 하나 해결했으니 진입차수 감소
				if (inDegree[x] == 0) { // 선행 문제 모두 해결하면 큐에 넣기
					pq.add(x);
				}
			}
		}
		
		bw.flush();
		br.close();
		bw.close();
	}

//	static class Problem {
//		int num; // 문제 번호
//		int cnt; // 몇 번째로 들어왔는지 (진입차수가 0이 된 시점)
//
//		public Problem(int num, int cnt) {
//			this.num = num;
//			this.cnt = cnt;
//		}
//	}
}