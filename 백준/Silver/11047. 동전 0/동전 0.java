import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 동전 종류
		int K = sc.nextInt(); // 동전 합
		int[] coin = new int[N];

		// 동전 가치가 오름차순으로 주어진다.
		// 배열에는 내림차순으로, 큰 것부터 넣기!
		for (int i = N - 1; i >= 0; i--) {
			coin[i] = sc.nextInt();
		}

		int cnt = 0; // 동전 개수
		// 동전이 자신보다 하나 뒤에 있는 동전의 배수. 즉, 쓸 수 있으면 큰 동전 쓰는 게 무조건 이득!
		for (int i = 0; i < N; i++) { // 큰 것부터 보다가
			while (coin[i] <= K) { // 쓸 수 있으면 바로 써버리기
				K -= coin[i];
				cnt++;
			}
		}

		System.out.println(cnt);
	}
}