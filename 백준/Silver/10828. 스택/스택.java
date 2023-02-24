import java.util.Scanner;

// 정수를 저장하는 스택을 '구현' 해보자
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 명령의 수
		int N = sc.nextInt();

		// 명령 수만큼 반복
		for (int n = 0; n < N; n++) {
			String cmd = sc.next();
			if(cmd.equals("push")) {
				push(sc.nextInt());
			} else if(cmd.equals("pop")) {
				pop();
			} else if(cmd.equals("size")) {
				size();
			} else if(cmd.equals("empty")) {
				empty();
			} else if(cmd.equals("top")) {
				top();
			}
		}
		System.out.println(sb);
	} // main

	// 명령의 수 N (1 ≤ N ≤ 10,000)
	static int[] stack = new int[10000];
	// top 초기화
	static int top = -1;
	static StringBuilder sb = new StringBuilder();

	// stack 메서드 구현

	/**
	 * 정수 X를 스택에 넣는 연산이다.
	 * 
	 * @param X
	 */
	public static void push(int X) {
		stack[++top] = X;
	}

	/**
	 * 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
	 */
	public static void pop() {
		if (top != -1) {
			sb.append(stack[top--]);
			sb.append("\n");
		} else {
			sb.append(-1);
			sb.append("\n");
		}
		return;
	}

	/**
	 * 스택에 들어있는 정수의 개수를 출력한다.
	 * 
	 * @return
	 */
	public static void size() {
		sb.append(top+1);
		sb.append("\n");
	}

	/**
	 * 스택이 비어있으면 1, 아니면 0을 출력한다.
	 * 
	 * @return
	 */
	public static void empty() {
		if (top != -1) {
			sb.append(0);
			sb.append("\n");
		} else {
			sb.append(1);
			sb.append("\n");
		}
	}

	/**
	 * 스택의 가장 위에 있는 정수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
	 * 
	 * @return
	 */
	public static void top() {
		if (top == -1) {
			sb.append(-1);
			sb.append("\n");
		} else {
			sb.append(stack[top]);
			sb.append("\n");
		}
	}
}