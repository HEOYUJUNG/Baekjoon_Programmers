import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 피연산자 개수
		char[] postfix = sc.next().toCharArray();
		double[] operand = new double[N];
		for (int i = 0; i < N; i++) {
			operand[i] = sc.nextDouble();
		}

		Stack<Double> st = new Stack<>();
		for (int i = 0; i < postfix.length; i++) {
			if (postfix[i] >= 'A' && postfix[i] <= 'Z') { // 피연산자인 경우
				st.push(operand[postfix[i] - 'A']); // 스택에 쌓기
			} else { // 연산자인 경우
				// 스택에서 위에 있는거 2개 꺼내서 연산하고 연산결과를 다시 스택에 쌓기
				double y = st.pop(); // 위쪽에 있는 숫자를 뒤에 계산해야 함!
				double x = st.pop();
				switch (postfix[i]) {
				case '+':
					st.push(x + y);
					break;
				case '-':
					st.push(x - y);
					break;
				case '*':
					st.push(x * y);
					break;
				default:
					st.push(x / y);
					break;
				}
			}
		}

		System.out.printf("%.2f", st.pop());
	}
}