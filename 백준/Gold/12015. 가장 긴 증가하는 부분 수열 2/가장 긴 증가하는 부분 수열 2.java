import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int[] dp;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 수열 A의 크기
		dp = new int[N + 1]; // 특정 길이의 증가하는 부분 수열 중에서 끝점의 최솟값!! 그래야 가장 유리함.
		Arrays.fill(dp, Integer.MAX_VALUE);
		for (int i = 0; i < N; i++) {
			int cur = sc.nextInt(); // A 수열의 i번째 숫자 입력받기
			dp[BS(1, i + 1, cur)] = cur; // i번째 숫자가 dp에서 어느 곳에 들어갈 수 있는지 찾아서 dp 갱신
		}

		// 가장 긴 증가하는 부분 수열의 길이 출력
		for (int i = N; i > 0; i--) {
			if (dp[i] != Integer.MAX_VALUE) {
				System.out.println(i);
				break;
			}
		}
	}

	// 현재 입력받은 숫자가 들어갈 수 있는 위치를 이분 탐색으로 찾기 => 현재 숫자가 dp에서 들어가야 할 인덱스 반환
	// dp에는 숫자가 오름차순 정렬된 상태로 저장되기 때문에 이분탐색 가능!
	private static int BS(int st, int ed, int cur) {
		while (st <= ed) {
			int mid = (st + ed) / 2;
			if (dp[mid] < cur) {
				st = mid + 1;
			} else {
				ed = mid - 1;
			}
		}
		return st;
	}
}