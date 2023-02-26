import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		// 전체 사람 수
		int N = sc.nextInt();
		// K번째 사람 제거
		int K = sc.nextInt();

		// 일단 1~N 넣어주기
		Queue<Integer> Josephus = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			Josephus.add(i);
		}

		sb.append("<");
		while (!Josephus.isEmpty()) {
			// K-1번째 까지는 제거하지 않고 다시 넣어주기
			for (int i = 0; i < K - 1; i++) {
				Josephus.add(Josephus.poll());
			}
			// K번쨰 제거
			sb.append(Josephus.poll() + ", ");
		}

		// 마지막에 붙어있는 , 공백 없애주기
		sb.delete(sb.length() - 2, sb.length());
		sb.append(">");
		System.out.println(sb);
	}
}