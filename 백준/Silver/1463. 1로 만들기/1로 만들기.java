import java.util.Scanner;

public class Main {
	static int[] cnt;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 1보다 크거나 같고, 10^6보다 작거나 같은 정수
		cnt = new int[1000001];
		// 일단 처음 3개 값은 넣어두고 시작하기 (일부러 하나씩 크게 넣어줬음.. cal에서 조건땜에..)
		cnt[1] = 0;
		cnt[2] = 1;
		cnt[3] = 1;

		System.out.println(cal(N));
	}

	// n을 만들 수 있는 경우는
	// 1. n-1에 +1 하거나
	// 2. n/2에 *2 하거나 (n/2가 정수인 경우)
	// 3. n/3에 *3하거나 (n/3이 정수인 경우)

	// n을 만들 수 있는 연산 횟수 최솟값 반환
	private static int cal(int n) {
		if (cnt[n] != 0 || n == 1) {
			return cnt[n];
		}

		if (n % 6 == 0) {
			cnt[n] = Math.min(Math.min(cal(n / 3) + 1, cal(n / 2) + 1), cal(n - 1) + 1);
		} else if (n % 3 == 0) {
			cnt[n] = Math.min(cal(n / 3) + 1, cal(n - 1) + 1);
		} else if (n % 2 == 0) {
			cnt[n] = Math.min(cal(n / 2) + 1, cal(n - 1) + 1);
		} else {
			cnt[n] = cal(n - 1) + 1;
		}

		// 1~3번 경우 중 최솟값 반환
		return cnt[n];
	}
}