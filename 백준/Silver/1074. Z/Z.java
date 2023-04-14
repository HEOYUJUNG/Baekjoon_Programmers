import java.util.Scanner;

public class Main {
	static int num = 0, r, c;
	static boolean flag;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		r = sc.nextInt();
		c = sc.nextInt();

		recursive(0, 0, (int) Math.pow(2, N) - 1, (int) Math.pow(2, N) - 1);
	}

	private static void recursive(int stR, int stC, int edR, int edC) {
		// 기저 조건
		if (flag)
			return;

		if (stR == edR && stC == edC) {
			if (stR == r && stC == c) {
				flag = true; // 종료해도 됨!
				System.out.println(num);
			}
			return;
		}

		// 유도 조건
		// 4가지 경우 다 부를 필요 없이 찾고자 하는 값이 포함되는 영역만 더 찾아보기
		int cnt = ((stR + edR) / 2 - stR + 1) * ((stR + edR) / 2 - stR + 1); // 하나의 영역당 있는 칸 개수
		if (stR <= r && stC <= c && r <= (stR + edR) / 2 && c <= (stC + edC) / 2) { // 왼쪽위
			recursive(stR, stC, (stR + edR) / 2, (stC + edC) / 2);
		} else if (stR <= r && (stC + edC) / 2 + 1 <= c && r <= (stR + edR) / 2 && c <= edC) { // 오른쪽위
			num += cnt;
			recursive(stR, (stC + edC) / 2 + 1, (stR + edR) / 2, edC);
		} else if ((stR + edR) / 2 + 1 <= r && stC <= c && r <= edR && c <= (stC + edC) / 2) { // 왼쪽아래
			num += cnt * 2;
			recursive((stR + edR) / 2 + 1, stC, edR, (stC + edC) / 2);
		} else { // 오른쪽아래
			num += cnt * 3;
			recursive((stR + edR) / 2 + 1, (stC + edC) / 2 + 1, edR, edC);
		}
	}
}