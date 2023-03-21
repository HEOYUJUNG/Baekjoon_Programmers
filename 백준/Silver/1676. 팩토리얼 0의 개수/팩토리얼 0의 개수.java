import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int cnt = 0;

		for (int i = 5; i <= N; i *= 5) {
			cnt += N / i;
			// 1. i가 5일 때 => 5가 1개 이상 있는 수들 중에서 5의 개수 1개씩 세어줌 e.g. 5, 10, 15, 20, 25, 30
			// .... 여기에 일단 5 1개씩 있다!
			// 2. i가 25일 때 => 5가 2개 이상 있는 수들 중에서 5의 개수 1개씩 또 세어줌 e.g. 25, 125 ... 여기에 앞에서 세지
			// 않은 5 1개 또 있다!
			// 3. ....
		}

		System.out.println(cnt);

	}
}