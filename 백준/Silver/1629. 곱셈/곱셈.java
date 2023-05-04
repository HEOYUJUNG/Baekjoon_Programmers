import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long A = sc.nextInt();
		long B = sc.nextInt();
		long C = sc.nextInt();
		System.out.println(cal(A, B, C));
	}

	private static long cal(long a, long b, long c) {
		// 기저 조건
		if (b == 1) {
			return a % c;
		}

		// 유도 조건
		long tmp = cal(a, b / 2, c);
		if (b % 2 == 0) { // 짝수
			return tmp * tmp % c;
		} else {
			return (tmp * tmp % c) * a % c;
		}
	}
}
