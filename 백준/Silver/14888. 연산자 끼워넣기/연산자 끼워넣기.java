import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N;
	static int[] arr;
	static int[] op;
//	static long result;
	static long max = -Integer.MAX_VALUE; // 최댓값. 10억보다 작거나 같다.
	static long min = Integer.MAX_VALUE; // 최솟값. -10억보다 크거나 같다.

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 정수 개수

		// 수 입력받기
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		// 연산자 입력받기
		op = new int[4];
		for (int i = 0; i < 4; i++) {
			op[i] = sc.nextInt();
		}
//		System.out.println(Arrays.toString(arr));
//		System.out.println(Arrays.toString(op));

		// 몇 번째 수에 대해 연산을 하는지를 파라미터로 전달
		// 지금까지 +, -, *, / 연산 몇 번 했는지 전달
		long result = arr[0];
		cal(1, result, 0, 0, 0, 0);

		System.out.println(max); // 만들 수 있는 식의 결과의 최댓값
		System.out.println(min); // 만들 수 있는 식의 결과의 최솟값
	} // main

	public static void cal(int idx, long result, int plus, int minus, int mtp, int div) {
		// 기저 조건
		if (idx == N) {
			max = (max < result) ? result : max;
			min = (result < min) ? result : min;
//			System.out.println("****result : " + result + "/ max : " + max + " / min : " + min);
			return;
		}
//		System.out.println("idx : " + idx + " / result : " + result);
		// 유도 조건
		if (plus < op[0]) {
			// 아직 더하기 할 수 있으면 더하기 하고 값에 저장
			cal(idx + 1, result + arr[idx], plus + 1, minus, mtp, div);
		}
		if (minus < op[1]) {
			cal(idx + 1, result - arr[idx], plus, minus + 1, mtp, div);
		}
		if (mtp < op[2]) {
			cal(idx + 1, result * arr[idx], plus, minus, mtp + 1, div);
		}
		if (div < op[3]) {
			// 음수일 때와 양수일 때 나눗셈 다르게 해주기
			cal(idx + 1, (result < 0) ? (-1) * ((result * (-1)) / arr[idx]) : result / arr[idx], plus, minus, mtp,
					div + 1);
		}
	}

}