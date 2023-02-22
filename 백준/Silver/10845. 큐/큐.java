import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 명령의 수
		int N = sc.nextInt();

		// 명령 수만큼 반복
		for (int n = 0; n < N; n++) {
			String cmd = sc.next();
			if (cmd.equals("push")) {
				push(sc.nextInt());
			} else if (cmd.equals("pop")) {
				pop();
			} else if (cmd.equals("size")) {
				size();
			} else if (cmd.equals("empty")) {
				empty();
			} else if (cmd.equals("front")) {
				front();
			} else if (cmd.equals("back")) {
				back();
			}
		}

		System.out.println(sb);
	} // main

	// queue 메서드
	// 구현------------------------------------------------------------------

	// 명령의 수 N (1 ≤ N ≤ 10,000)
	static int[] queue = new int[10000];
	// front, rear 초기화
	static int f = -1;
	static int r = -1;
	// 스트링빌더도 static으로 선언
	static StringBuilder sb = new StringBuilder();

	/**
	 * 정수 X를 큐에 넣는 연산이다.
	 * 
	 * @param X
	 */
	public static void push(int X) {
		queue[++r] = X;
	}

	/**
	 * 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
	 */
	public static void pop() {
		if (f != r) {
			sb.append(queue[++f] + "\n");
		} else {
			// 비어있는 경우
			sb.append(-1 + "\n");
		}
		return;
	}

	/**
	 * 큐에 들어있는 정수의 개수를 출력한다.
	 * 
	 * @return
	 */
	public static void size() {
		sb.append(r - f + "\n");
	}

	/**
	 * 큐가 비어있으면 1, 아니면 0을 출력한다.
	 * 
	 * @return
	 */
	public static boolean empty() {
		if (f != r) {
			// 비어있지 않은 경우
			sb.append(0 + "\n");
			return false;
		} else {
			// 비어있는 경우
			sb.append(1 + "\n");
			return true;
		}
	}

	/**
	 * 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
	 * 
	 * @return
	 */
	public static void front() {
		if (f == r) {
			// 비어있는 경우
			sb.append(-1).append("\n");
		} else {
			sb.append(queue[f + 1]).append("\n");
		}
	}

	/**
	 * 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
	 */
	public static void back() {
		if (f == r) {
			// 비어있는 경우
			sb.append(-1 + "\n");
		} else {
			sb.append(queue[r] + "\n");
		}
	}
}