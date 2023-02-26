import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int K = sc.nextInt(); // 이미 가지고 있는 랜선의 개수
		int N = sc.nextInt(); // 필요한 랜선의 개수
		long[] arr = new long[K]; // 이미 가지고 있는 각 랜선의 길이

		// 랜선 길이 입력받기
		for (int i = 0; i < K; i++) {
			arr[i] = sc.nextInt();
		}

		Arrays.toString(arr);

		long start = 1;
		long end = arr[0];
		while (start <= end) {
			int n = 0;
			long mid = (start + end) / 2;
			for (int i = 0; i < K; i++) {
				n += (arr[i] / mid);
			}

			if (n < N) { // 필요한 개수보다 적게 잘렸으면, 자르는 길이를 줄여야 함
				end = mid - 1;
			} else { // 필요한 개수보다 많이 잘렸어도 ㄱㅊ, 랜선의 길이는 최대로 찾자.
				start = mid + 1;
			}
		}

		// start로 출력하면 최대값보다 하나 더 큰 값이 나올 수 있음...!!!
		System.out.println(end);
	}
}