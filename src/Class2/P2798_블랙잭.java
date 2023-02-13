package Class2;

import java.util.Scanner;

public class P2798_블랙잭 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 총 N장의 카드
		int M = sc.nextInt(); // M을 넘지 않으면서 최대한 가까운 카드 3장의 합 구해야 함

		// N장의 카드 입력받기
		int[] cards = new int[N];
		for (int i = 0; i < N; i++) {
			cards[i] = sc.nextInt();
		}

		int max = 0;
		// N장 중 3장을 뽑는 경우의 수 전부 탐색 -> 최대값 갱신
		for (int a = 0; a < N - 2; a++) {
			for (int b = a + 1; b < N - 1; b++) {
				for (int c = b + 1; c < N; c++) {
//					System.out.printf("3장의 카드 : %d %d %d \n", cards[a], cards[b], cards[c]);
					if (cards[a] + cards[b] + cards[c] > max && cards[a] + cards[b] + cards[c] <= M) {
						max = cards[a] + cards[b] + cards[c];
					}
				}
			}
		}
		
		System.out.println(max);

	} // main
}
