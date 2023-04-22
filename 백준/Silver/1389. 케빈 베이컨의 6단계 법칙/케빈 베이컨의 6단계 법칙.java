import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N;
	static int[][] graph;
	static int[] KB;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 유저 수
		int M = sc.nextInt(); // 관계 수
		// 그래프와 정점(2~100)보다 간선(1~5000)이 더 많기 떄문에 인접행렬로 하자
		graph = new int[N + 1][N + 1];
		// 친구관계 입력받기
		for (int i = 0; i < M; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			graph[A][B] = graph[B][A] = 1;
		}

		// 각 사람별 케빈 베이컨 수 구하기
		KB = new int[N + 1];
		int min = Integer.MAX_VALUE; // 가장 작은 케빈 베이컨 수
		for (int i = 1; i <= N; i++) {
			KB[i] = getKB(i);
			min = (KB[i] < min) ? KB[i] : min;
		}
		// 케빈 베이컨의 수가 가장 작은 사람을 출력
		for (int i = 1; i <= N; i++) {
			if (KB[i] == min) {
				System.out.println(i);
				break;
			}
		}
	}

	// 번호가 num인 사람의 케빈 베이컨 수 구하기
	// 각 사람 까지 몇 단계를 거쳐야 하는지는 BFS로 구하기!
	private static int getKB(int num) {
		int res = 0; // 번호가 num인 사람의 케빈 베이컨 수
		boolean[] visited = new boolean[N + 1]; // 방문처리
		Queue<Person> q = new LinkedList<>();
		q.add(new Person(0, num));
		while (!q.isEmpty()) {
			Person cur = q.poll();
			if (visited[cur.num])
				continue;
			visited[cur.num] = true;
			res += cur.d; 
			for (int i = 1; i <= N; i++) {
				if (graph[cur.num][i] > 0 && !visited[i]) { // 아는 사람이고, 아직 방문 안했으면
					q.add(new Person(cur.d + 1, i));
				}
			}
		}

		return res;
	}

	private static class Person {
		int d, num; // 시작 사람부터 몇 단계 지났는지, 번호

		public Person(int d, int num) {
			super();
			this.d = d;
			this.num = num;
		}
	}
}
