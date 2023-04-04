import java.util.HashMap;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();

		HashMap<String, String> map = new HashMap<>();
		// 포켓몬 입력받기
		for (int i = 1; i <= N; i++) {
			String input = sc.next();
			map.put(Integer.toString(i), input);
			map.put(input, Integer.toString(i));
		}
		// 문제 입력받기
		for (int i = 0; i < M; i++) {
			String quiz = sc.next();

			System.out.println(map.get(quiz));

		}
	}
}