package Class2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class 스택수열1874 {
	public static void main(String[] args) {
		Stack<Integer> st = new Stack<>();
		Scanner sc = new Scanner(System.in);

		st.push(0); // 스택 제일 밑에 0 깔아두기. 비어있지 않도록..!!

		// 입력 받아와서 목표 배열 arr 만들기
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		// 1~n 오름차순으로 스택에 넣기
		int num = 1; // 스택에 넣어줄 수
		List<String> result = new ArrayList<>();

		for (int i = 0; i < n; i++) { // i는 arr의 인덱스
			
			// 스택의 가장 위에 있는 수가 배열의 다음에 들어가야 할 수보다 큰 경우면 무조건 안됨. 종료해주기.
			if (st.peek() > arr[i]) {
				result.clear();
				result.add("NO");
				break;
			}
			
			// 스택에서 가장 위에 있는 수가 배열의 다음에 들어가야 할 수와 다르면 push
			// 같으면 pop
			if (st.peek() != arr[i]) {
				st.push(num++);
				result.add("+");
				i--;
			} else {
				st.pop();
				result.add("-");
			}

		}

		// 결과 출력
		for (int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i));
		}
	} // main
}
