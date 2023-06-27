import java.io.*;
import java.util.*;

public class Main {
	static int[][] wheel;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		wheel = new int[5][8]; // 톱니바퀴 상태
		for (int i = 1; i <= 4; i++) {
			String input = br.readLine();
			for (int j = 0; j < 8; j++) {
				wheel[i][j] = input.charAt(j) - '0';
			}
		}
		int K = Integer.parseInt(br.readLine()); // 회전 횟수
		int[] turn = new int[5]; // 4개 톱니바퀴의 회전 방향 정보 저장할 배열
		for (int k = 0; k < K; k++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int wheel_num = Integer.parseInt(st.nextToken());
			int turn_dir = Integer.parseInt(st.nextToken());
			Arrays.fill(turn, 0);
			turn[wheel_num] = turn_dir;
			// 왼쪽으로 가면서 톱니바퀴별 회전 방향 조사
			for (int i = wheel_num; i > 1; i--) {
				if (wheel[i][6] != wheel[i - 1][2]) { // 맞닿은 부분이 다른 경우
					turn[i - 1] = turn[i] * (-1); // 반대 방향 회전
				} else { // 맞닿은 부분이 같은 경우
					break; // 이후로는 더이상 회전하지 않음
				}
			}
			// 오른쪽으로 가면서 톱니바퀴별 회전 방향 조사
			for (int i = wheel_num; i < 4; i++) {
				if (wheel[i][2] != wheel[i + 1][6]) { // 맞닿은 부분이 다른 경우
					turn[i + 1] = turn[i] * (-1); // 반대 방향 회전
				} else {
					break;
				}
			}
			for (int i = 1; i <= 4; i++) {
				if (turn[i] == 1) {
					toRight(i);
					continue;
				}
				if (turn[i] == -1) {
					toLeft(i);
				}
			}
		}
		System.out.println(calScore());
	}

	// 시계방향 회전
	static void toRight(int idx) {
		int tmp = wheel[idx][7];
		for (int i = 6; i >= 0; i--) {
			wheel[idx][i + 1] = wheel[idx][i];
		}
		wheel[idx][0] = tmp;
	}

	// 반시계방향 회전
	static void toLeft(int idx) {
		int tmp = wheel[idx][0];
		for (int i = 0; i < 7; i++) {
			wheel[idx][i] = wheel[idx][i + 1];
		}
		wheel[idx][7] = tmp;
	}

	// 점수 계산
	static int calScore() {
		int res = 0;
		int score = 1; // 획득 점수
		for (int i = 1; i <= 4; i++) {
			if (wheel[i][0] == 1) {
				res += score;
			}
			score = score << 1; // 획득 점수 2배
		}
		return res;
	}
}
