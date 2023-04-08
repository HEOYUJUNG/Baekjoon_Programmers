import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int N = sc.nextInt();
		PriorityQueue<Integer> q = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			int x = sc.nextInt();
			if (x != 0) {
				q.add(x);
			} else {
				if (q.isEmpty()) {
					sb.append(0 + "\n");
				} else {
					sb.append(q.poll() + "\n");
				}
			}
		}
		System.out.println(sb);
	}
}