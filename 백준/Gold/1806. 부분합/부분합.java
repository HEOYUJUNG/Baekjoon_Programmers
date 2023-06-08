import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 수열 길이
		int S = Integer.parseInt(st.nextToken()); // 연속된 수들의 부분합이 S 이상이 되어야 함

		int[] nums = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			int num = Integer.parseInt(st.nextToken());
			if (num >= S) { // 길이 1로 S 이상이 되는 경우
				System.out.println(1);
				return;
			}
			nums[i] = nums[i - 1] + num; // 누적합
		}
		
		// S 이상의 합을 만드는 것이 불가능한 경우
		if (nums[N] < S) {
			System.out.println(0);
			return;
		}

		int min = N; // 최소 길이
		for (int i = 0; i < N; i++) {
			int start = i + 1;
			int end = N;
			int mid = 0;
			while (start <= end) {
				mid = (start + end) / 2;
				if (nums[mid] - nums[i] >= S) {
					end = mid - 1;
					min = (mid - i < min) ? mid - i : min;
				} else {
					start = mid + 1;
				}
			}
		}
		System.out.println(min);
	}
}