import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 용돈 사용할 일수
		int M = sc.nextInt(); // 통장에서 돈을 빼서 쓰는 횟수
		int[] cost = new int[N];
		int maxCost = 0;
		for (int i = 0; i < N; i++) {
			cost[i] = sc.nextInt();
			maxCost = (maxCost < cost[i]) ? cost[i] : maxCost;
		}
		int start = 0; // 인출 금액 최소
		// 극단적인 경우! 하루에 10000씩 N일 쓸 건데 인출 횟수를 1로 하고싶을 수도 있음 
		int end = 10000 * N; // 인출 금액 최대
		while (start <= end) {
			int mid = (start + end) / 2;
			int cnt = 1; // 인출 횟수 카운트
			int remainMoney = mid;
			// 남은 금액이 모자라도 그걸 집어넣고 다시 K원 인출하니까 결국 그 날 쓸 수 있는 최대 금액은 K원!!
			// 인출하는 금액이 그 날 쓰는 금액보다는 크거나 같아야 함!
			if (maxCost <= mid) {
				for (int i = 0; i < N; i++) {
					if (cost[i] <= remainMoney) { // 남은 돈이 많으면 또 인출하지 않고 그대로 사용
						remainMoney -= cost[i];
					} else { // 남은 돈이 모자라면 남은 금액 통장에 넣고 다시 인출
						cnt++;
						remainMoney = mid - cost[i];
					}
				}
				if (cnt > M) { // 더 많이 인출했으면 인출 횟수 줄여야 하니까 최소 금액 높여야 함
					start = mid + 1;
				} else {
					end = mid - 1;
				}
			} else { // 인출하는 금액이 그 날 쓰는 금액보다 작은 경우가 있다면 무조건 인출 금액을 크게 만들어줘야 함
				start = mid + 1;
			}

		}
		System.out.println(start);
	} // main
}