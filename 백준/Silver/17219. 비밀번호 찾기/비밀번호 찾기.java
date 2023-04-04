import java.util.HashMap;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int N = sc.nextInt(); // 저장된 주소 개수
		int M = sc.nextInt(); // 찾으려는 주소 개수
		HashMap<String, String> map = new HashMap<>();
		for (int i = 0; i < N; i++) {
			map.put(sc.next(), sc.next());
		}
		for (int i = 0; i < M; i++) {
			sb.append(map.get(sc.next()) + "\n");
		}
		System.out.println(sb);
	}
}