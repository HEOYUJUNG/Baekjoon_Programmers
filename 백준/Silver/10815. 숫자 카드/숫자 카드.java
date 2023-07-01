import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int N = sc.nextInt();
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < N; i++) {
			set.add(sc.nextInt());
		}
		int M = sc.nextInt();
		for (int i = 0; i < M; i++) {
			if (set.contains(sc.nextInt())) {
				sb.append(1 + " ");
			} else {
				sb.append(0 + " ");
			}
		}
		System.out.println(sb.toString());
	}
}
