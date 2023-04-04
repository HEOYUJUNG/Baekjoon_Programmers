import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] P = new int[N];
		for (int i = 0; i < N; i++) {
			P[i] = sc.nextInt();
		}
		Arrays.sort(P); // 오름차순 정렬
		int[] sum = new int[N];
		sum[0] = P[0];
		int total = sum[0];
		for (int i = 1; i < N; i++) {
			sum[i] = sum[i - 1] + P[i];
			total += sum[i];
		}

		System.out.println(total);
	}
}