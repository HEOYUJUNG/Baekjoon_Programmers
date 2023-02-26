import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int N = sc.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		// 오름차순 정렬
		Arrays.sort(arr);

		int M = sc.nextInt();
		for (int i = 0; i < M; i++) {
			int num = sc.nextInt();
			int flag = 0;
			int start = 0;
			int end = N - 1;
			while (start <= end) {
				int mid = (start + end) / 2;
				if (arr[mid] == num) {
					flag = 1;
					break;
				} else if (arr[mid] > num) {
					end = mid - 1;
				} else {
					start = mid + 1;
				}
			}
			sb.append(flag + "\n");
		}
		System.out.println(sb);
	}
}