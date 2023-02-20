package D2;

import java.util.Scanner;
import java.util.Stack;

public class P4949_균형잡힌세상 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			String line = sc.nextLine();
			// 온점 하나(.) 입력되면 종료
			if (line.equals(".")) {
				return;
			}
			char[] lineChar = line.toCharArray();
			Stack<Character> stack = new Stack<>();

			// 소괄호 : round bracket => R
			// 대괄호 : square bracket => S
			// 각각 기호의 개수 저장

			boolean flag = true;
			for (int i = 0; i < lineChar.length; i++) {
				if (lineChar[i] == '(' || lineChar[i] == '[') {
					stack.push(lineChar[i]);
				} else if (lineChar[i] == ')') {
					if (stack.isEmpty() || stack.peek() != '(') {
						flag = false;
						break;
					} else {
						stack.pop();
					}
				} else if (lineChar[i] == ']') {
					if (stack.isEmpty() || stack.peek() != '[') {
						flag = false;
						break;
					} else {
						stack.pop();
					}
				}
			}

			// 전체 다 돌았을 때 스택에 괄호 남아있으면 => 유효하지 않음
			if (!stack.isEmpty()) {
				flag = false;
			}

			if (flag) {
				System.out.println("yes");
			} else {
				System.out.println("no");
			}
		}
	} // main
}
