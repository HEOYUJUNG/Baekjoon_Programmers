import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 1 <= N <= 10
		int K = sc.nextInt(); // 0 <= K <= N

		System.out.println(factorial(N) / (factorial(K) * factorial(N - K)));
	}

	public static int factorial(int n) {
		if (n == 1 || n == 0)
			return 1;
		return factorial(n - 1) * n;
	}
}