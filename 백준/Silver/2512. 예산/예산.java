import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 지방 수
		int[] money = new int[N];
		int total = 0;
		int max = 0;
		for (int i = 0; i < N; i++) {
			money[i] = sc.nextInt();
			total += money[i];
			max = (max < money[i]) ? money[i] : max;
		}
		int M = sc.nextInt(); // 예산 총액
		if (total <= M) { // 모든 요청이 배정될 수 있는 경우
			System.out.println(max);
		} else { // 모든 요청이 배정될 수 없는 경우
			int start = 0;
			int end = max;
			while (start <= end) {
				total = 0;
				int mid = (start + end) / 2;
				for (int i = 0; i < N; i++) {
					total += (mid < money[i]) ? mid : money[i];
				}
				if (M < total) { // 더 크면 상한액을 낮춰야 함
					end = mid - 1;
				} else { // 총액보다 같거나 작으면 최대 찾을 때까지 상한액 높여야 함
					start = mid + 1;
				}
			}
			System.out.println(end);
		}

	}
}