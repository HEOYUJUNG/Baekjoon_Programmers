import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 수의 개수
		int M = sc.nextInt(); // 합을 구해야 하는 횟수
		int[] arr = new int[N + 1];
		int[] sum = new int[N + 1]; // 누적합
		sum[0] = 0;
		for (int i = 1; i <= N; i++) {
			arr[i] = sc.nextInt();
			sum[i] = sum[i - 1] + arr[i];
		}

		for (int i = 0; i < M; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			System.out.println(sum[end] - sum[start - 1]);
		}
	}
}