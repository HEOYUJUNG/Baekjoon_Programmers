import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 나무의 수
		int M = sc.nextInt(); // 집으로 가져가는 나무의 길이

		// 나무들 높이
		int[] trees = new int[N];
		int max = 0;
		for (int i = 0; i < N; i++) {
			trees[i] = sc.nextInt();
			if (trees[i] > max) {
				max = trees[i];
			}
		}

		// 이분 탐색!!
		int start = 0;
		int end = max;
		
		while (start <= end) {
			int H = (start + end) / 2; // 절단기 높이 이분탐색
			long sum = 0;  // 자른 나무들의 길이 합
			for (int i = 0; i < N; i++) {
				if (trees[i] - H > 0)
					sum += (trees[i] - H);
			}

			if (sum >= M) {
				start = H + 1;
			} else if (sum < M) {
				end = H - 1;
			}
		}

		System.out.println(end);

	} // main
}