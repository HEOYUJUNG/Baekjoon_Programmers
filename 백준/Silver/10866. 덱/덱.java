import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		Deque<Integer> deque = new ArrayDeque<>();

		// 명령의 수
		int N = sc.nextInt();

		// 명령 수만큼 반복
		for (int n = 0; n < N; n++) {
			String cmd = sc.next();
			if (cmd.equals("push_front")) {
				deque.addFirst(sc.nextInt());
			} else if (cmd.equals("push_back")) {
				deque.addLast(sc.nextInt());
			} else if (cmd.equals("pop_front")) {
				if (deque.isEmpty()) {
					// 덱이 비었으면 -1 출력
					sb.append(-1 + "\n");
				} else {
					// 덱의 가장 앞에 있는 수 뺴고, 그 수 출력
					sb.append(deque.pollFirst() + "\n");
				}
			} else if (cmd.equals("pop_back")) {
				if (deque.isEmpty()) {
					// 덱이 비었으면 -1 출력
					sb.append(-1 + "\n");
				} else {
					// 덱의 가장 뒤에 있는 수 뺴고, 그 수 출력
					sb.append(deque.pollLast() + "\n");
				}
			} else if (cmd.equals("size")) {
				sb.append(deque.size() + "\n");
			} else if (cmd.equals("empty")) {
				if (deque.isEmpty()) {
					sb.append(1 + "\n");
				} else {
					sb.append(0 + "\n");
				}
			} else if (cmd.equals("front")) {
				if (deque.isEmpty()) {
					// 덱이 비었으면 -1 출력
					sb.append(-1 + "\n");
				} else {
					sb.append(deque.peekFirst() + "\n");
				}
			} else if (cmd.equals("back")) {
				if (deque.isEmpty()) {
					// 덱이 비었으면 -1 출력
					sb.append(-1 + "\n");
				} else {
					sb.append(deque.peekLast() + "\n");
				}
			}
		}

		System.out.println(sb);
	} // main
}