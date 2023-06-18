import java.io.*;
import java.util.*;

public class Main {
	static List<Integer>[] friends;
	static boolean[] check;
	static int[] candy;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 거리에 있는 아이들 수
		int M = Integer.parseInt(st.nextToken()); // 친구 관계 수
		int K = Integer.parseInt(st.nextToken()); // 우는 아이는 K미만이어야 함
		st = new StringTokenizer(br.readLine());
		candy = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			candy[i] = Integer.parseInt(st.nextToken());
		}

		friends = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			friends[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			friends[a].add(b);
			friends[b].add(a);
		}

		// 친구들끼리 그룹 만들기
		List<Group> groups = new ArrayList<>();
		check = new boolean[N + 1];
		for (int i = 1; i <= N; i++) {
			if (!check[i]) {
				groups.add(makeGroup(i));
			}
		}

		// dp[r][c] = 1~r번째 그룹까지 있을 때, c명의 사탕을 뺏어서 얻을 수 있는 최대 사탕 개수
		int[] dp = new int[K];
		for (int r = 0; r < groups.size(); r++) {
			Group g = groups.get(r);
			for (int c = K - 1; c >= g.people; c--) {
				// 1. c번째 그룹 포함하지 않는 경우
				// 2. c번째 그룹 포함하는 경우
				dp[c] = Math.max(dp[c], dp[c - g.people] + g.candy);
			}
		}
		System.out.println(dp[K - 1]);
	}

	static class Group {
		int people, candy;

		public Group(int people, int candy) {
			this.people = people;
			this.candy = candy;
		}
	}

	static Group makeGroup(int x) {
		Queue<Integer> q = new LinkedList<>();
		int pCnt = 0;
		int cCnt = 0;
		q.add(x);
		check[x] = true;
		while (!q.isEmpty()) {
			int cur = q.poll();
			pCnt++;
			cCnt += candy[cur];

			for (int f : friends[cur]) {
				if (!check[f]) {
					check[f] = true;
					q.add(f);
				}
			}
		}
		return new Group(pCnt, cCnt);
	}
}