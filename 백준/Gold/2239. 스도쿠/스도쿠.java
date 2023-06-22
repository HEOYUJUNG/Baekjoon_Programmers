import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int[][] map;
	static List<Point> list;

	public static void main(String[] args) throws Exception {
		map = new int[9][9];
		list = new ArrayList<>();
		for (int r = 0; r < 9; r++) {
			String input = br.readLine();
			for (int c = 0; c < 9; c++) {
				map[r][c] = input.charAt(c) - '0';
				if (map[r][c] == 0) {
					list.add(new Point(r, c));
				}
			}
		}
		backtracking(0);
		br.close();
		bw.close();
	}

	static class Point {
		int r, c;

		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static void backtracking(int idx) throws IOException {
		// 기저조건
		if (idx == list.size()) {
			for (int r = 0; r < 9; r++) {
				for (int c = 0; c < 9; c++) {
					bw.write(Integer.toString(map[r][c]));
				}
				bw.write('\n');
			}
			bw.flush();
			System.exit(0); // 다른 경우 더이상 탐색하지 않도록 완전 종료!
		}
		// 유도조건
		Point cur = list.get(idx);
		// 들어갈 수 있는 후보들 찾기
		boolean[] nums = new boolean[10];
		// 1) 행
		for (int c = 0; c < 9; c++) {
			if (map[cur.r][c] != 0) {
				nums[map[cur.r][c]] = true;
			}
		}
		// 2) 열
		for (int r = 0; r < 9; r++) {
			if (map[r][cur.c] != 0) {
				nums[map[r][cur.c]] = true;
			}
		}
		// 3) 3*3박스
		for (int r = cur.r / 3 * 3; r < cur.r / 3 * 3 + 3; r++) {
			for (int c = cur.c / 3 * 3; c < cur.c / 3 * 3 + 3; c++) {
				if (map[r][c] != 0) {
					nums[map[r][c]] = true;
				}
			}
		}
		// 작은 수부터 선택해서 채워보기
		for (int i = 1; i <= 9; i++) {
			if (!nums[i]) {
				map[cur.r][cur.c] = i;
				backtracking(idx + 1);
				map[cur.r][cur.c] = 0; // 원상복구
			}
		}
	}
}