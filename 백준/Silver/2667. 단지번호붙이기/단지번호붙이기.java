import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N;
	static int[][] map;
	static boolean[][] visited;
	static List<Integer> cntList;
	// 상하좌우
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		N = sc.nextInt(); // 지도 크기
		map = new int[N][N];
		visited = new boolean[N][N];
		cntList = new ArrayList<>(); // 단지별 집 개수 저장할 리스트

		// 지도 정보 입력받기
		for (int i = 0; i < N; i++) {
			String input = sc.next();
			for (int j = 0; j < N; j++) {
				map[i][j] = (input.charAt(j) - '0');
			}
		}

		int cnt2 = 0; // 총 단지수
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				// 집이 있는 곳이 있으면, 같은 단지 안에 몇 개의 집이 있는지 BFS로 카운트
				if (!visited[i][j] && map[i][j] == 1) {
					cnt2++;
					BFS(i, j);
				}
			}
		}

		sb.append(cnt2 + "\n");

		Collections.sort(cntList);
		for (int x : cntList) {
			sb.append(x + "\n");
		}

		System.out.println(sb);
	} // main

	private static void BFS(int r, int c) {
		Queue<Pos> q = new LinkedList<>();
		q.add(new Pos(r, c));
		int cnt = 0;// 현재 단지 안에 있는 집 개수 카운트
		while (!q.isEmpty()) {
			Pos curr = q.poll();
			if (visited[curr.r][curr.c]) // 이미 방문했으면 스킵
				continue;

			cnt++;
			visited[curr.r][curr.c] = true; // 방문처리
			for (int d = 0; d < 4; d++) {
				int rr = curr.r + dr[d];
				int cc = curr.c + dc[d];
				// 같은 단지 내, 즉 집이 있으면서 아직 방문하지 않은 곳이면 큐에 넣기 
				if (rr >= 0 && rr < N && cc >= 0 && cc < N && map[rr][cc] == 1 && !visited[rr][cc]) {
					q.add(new Pos(rr, cc));
				}
			}
		}
		cntList.add(cnt);
	}

	private static class Pos {
		int r, c;

		public Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
}