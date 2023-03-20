import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int i = 0; i < T; i++) {
			char[] result = sc.next().toCharArray();
			int cnt = 0;
			int score = 0;

			for (int j = 0; j < result.length; j++) {
				if (result[j] == 'O') {
					cnt++;
					score += cnt;
				} else {
					cnt = 0;
				}
			}
			System.out.println(score);
		}
	}
}