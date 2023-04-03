import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int N = sc.nextInt(); // 학생 수
		int M = sc.nextInt(); // 키 비교 횟수

		int[] inDegree = new int[N + 1];
		ArrayList<Integer>[] graph = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>(); // 초기화
		}

		for (int i = 0; i < M; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			graph[A].add(B);
			inDegree[B]++;
		}

		Queue<Integer> q = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			if (inDegree[i] == 0) {
				q.add(i);
			}
		}

		while (!q.isEmpty()) {
			int n = q.poll();
			sb.append(n + " ");
			for (int x : graph[n]) {
				inDegree[x]--;
				if (inDegree[x] == 0) {
					q.add(x);
				}
			}
		}

		System.out.println(sb);
	}
}