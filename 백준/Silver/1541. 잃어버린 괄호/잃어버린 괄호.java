import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] cal = sc.next().toCharArray();
		List<Integer> num = new ArrayList<>(); // 숫자들만 저장할 리스트
		List<Character> op = new ArrayList<>(); // 연산자(+, -)들만 저장할 리스트

		// cal 배열 돌면서 숫자는 num리스트에, 연산자는 op리스트에 나눠서 넣어주기
		int temp = 0;
		for (int i = 0; i < cal.length; i++) {
			if (cal[i] == '+' || cal[i] == '-') {
				// 연산자면 연산자 리스트에 저장
				op.add(cal[i]);
				// 연산자 앞에 있는 숫자 저장하고
				num.add(temp);
				// temp 다시 0으로 초기화
				temp = 0;
			} else {
				// 숫자면 temp 변수 이용해서 전체 숫자 만들기
				temp = temp * 10 + (cal[i] - '0');
			}
		}
		num.add(temp); // 마지막 숫자 넣어주기
		
		// 계산값이 최소가 되려면 최대한 큰 수를 빼야 한다.
		// 따라서 + 연산 먼저 하고 커진 수들 가지고 - 연산 하면 됨.

		// + 먼저 계산해주기
		// i=0, 즉 앞에서부터 시작하면 + 계산되었을 때 다음 연산자를 하나 건너뛰게 됨
		// 그래서 뒤에서부터 계산 시작해서 앞으로 가도록!
		for (int i = op.size() - 1; i >= 0; i--) {
			if (op.get(i) == '+') {
				num.set(i, num.get(i) + num.get(i + 1));
				num.remove(i + 1);
				op.remove(i);
			}
		}

		// - 계산해주기
		int result = num.get(0); // + 연산밖에 없었으면 이 결과 그대로 출력됨
		for (int i = 0; i < op.size(); i++) {
			if (op.get(i) == '-') {
				result -= num.get(i + 1);
			}
		}

		System.out.println(result);

	}
}