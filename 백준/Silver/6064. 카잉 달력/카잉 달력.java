import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // 테케 개수
		for (int tc = 1; tc <= T; tc++) {
			int M = sc.nextInt(); // <M:N>은 카잉 달력의 마지막 해
			int N = sc.nextInt();
			int x = sc.nextInt();
			int y = sc.nextInt();

			boolean flag = true;
			for (int i = 0; i <= N; i++) {
				if ((M * i + x - y) % N == 0) {
					flag = false;
					System.out.println(M * i + x);
					break;
				}
			}

			if (flag) {
				System.out.println(-1);
			}
		}
	}
}