import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		// 입력 받아서 문자 1개씩 쪼개기
		String input = sc.next();
		char[] infix = input.toCharArray();

		// 연산자 저장할 스택
		// 스택 밖에서 연산자별 우선순위 : 낮 +, - *, / ( 높
		// 스택 안에서 연산자별 우선순위 : 낮 ( +, - *,/ 높
		Stack<Character> st = new Stack<>();

		for (int i = 0; i < infix.length; i++) {
			char curr = infix[i];
			// 피연산자(알파벳 대문자) => 결과로 바로 내보내기
			if (curr >= 'A' && curr <= 'Z') {
				sb.append(curr);
			} else { // 연산자인 경우 +, -, *, /, (, )
				// 1. 스택 비어있으면 -> 그냥 넣기
				if (st.isEmpty()) {
					st.add(curr);
				} else if (curr != ')') { // 2. 스택 비어있지 않은데 ) 외의 연산자들인 경우
					// 2-1. top 우선순위가 나보다 같거나 크면, 작아질때까지 빼기 (같아도 안됨. 앞에 있는게 먼저 나와야 하니까.)
					if (inStPriority(st.peek()) >= outStPriority(curr)) {
						while (!st.isEmpty() && inStPriority(st.peek()) >= outStPriority(curr)) {
							sb.append(st.pop());
						}
					}
					// 2-2. top 우선순위가 나보다 작으면 그냥 넣기
					st.add(curr);
				} else { // 스택 비어있지 않은데 )인 경우
					// ( 만날 때까지 스택에서 빼서 결과로 내보내기
					while (st.peek() != '(') {
						sb.append(st.pop());
					}
					st.pop(); // ( 빼줘야 함.
				}
			}
		}

		// 스택에 남아있는 연산자들 빼서 결과로 내보내기
		while (!st.isEmpty()) {
			sb.append(st.pop());
		}
		System.out.println(sb);
	} // main

	// 스택 밖에 있을 때의 우선순위 (숫자 작은 것이 우선순위가 높다!)
	private static int inStPriority(char c) {
		if (c == '+' || c == '-') {
			return 1;
		} else if (c == '*' || c == '/') {
			return 2;
		} else { // ( 일 때
			return 0;
		}
	}

	// 스택 안에 있을 때의 우선순위
	private static int outStPriority(char c) {
		if (c == '+' || c == '-') {
			return 1;
		} else if (c == '*' || c == '/') {
			return 2;
		} else { // ( 일 때 -> 스택에 무조건 들어감!
			return 4;
		}
	}
}