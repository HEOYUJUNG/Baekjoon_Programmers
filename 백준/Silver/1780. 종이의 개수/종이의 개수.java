import java.util.Scanner;

public class Main {
	static int[][] paper;
	static int[] cnt;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		paper = new int[N][N];
		cnt = new int[3]; // 순서대로 -1, 0, 1로만 채워진 종이 개수
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				paper[r][c] = sc.nextInt();
			}
		}

		recursive(0, 0, N - 1, N - 1);

		for (int n : cnt) {
			System.out.println(n);
		}
	}

	private static void recursive(int stR, int stC, int edR, int edC) {
		// 기저 조건
		if (stR == edR) {
			cnt[paper[stR][stC] + 1]++;
			return;
		}

		// 유도 조건
		int num = paper[stR][stC];
		for (int r = stR; r <= edR; r++) {
			for (int c = stC; c <= edC; c++) {
				if (paper[r][c] != num) { // 종이에 다른 수가 있음!
					// 9개의 종이로 잘라야 함
					// 1 2 3
					// 4 5 6
					// 7 8 9
					int L = (edR - stR + 1) / 3; // 9등분해서 잘릴 종이의 한 변 길이
					recursive(stR, stC, stR + L - 1, stC + L - 1); // 1번 영역
					recursive(stR, stC + L, stR + L - 1, stC + 2 * L - 1); // 2번 영역
					recursive(stR, stC + 2 * L, stR + L - 1, edC); // 3번 영역
					recursive(stR + L, stC, stR + 2 * L - 1, stC + L - 1); // 4번 영역
					recursive(stR + L, stC + L, stR + 2 * L - 1, stC + 2 * L - 1); // 5번 영역
					recursive(stR + L, stC + 2 * L, stR + 2 * L - 1, edC); // 6번 영역
					recursive(stR + 2 * L, stC, edR, stC + L - 1); // 7번 영역
					recursive(stR + 2 * L, stC + L, edR, stC + 2 * L - 1); // 8번 영역
					recursive(stR + 2 * L, stC + 2 * L, edR, edC); // 9번 영역
					return;
				}
			}
		}

		// 여기까지 왔다면 전부 같은 수인 종이 -> 그대로 사용
		cnt[num + 1]++;
	}
}
