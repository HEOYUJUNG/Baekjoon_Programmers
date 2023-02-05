package Class2;

import java.util.ArrayList;
import java.util.Scanner;

public class 소수구하기1929_2 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int M = sc.nextInt();
		int N = sc.nextInt();

		/**
		 * 에라토스테네스의 체
		 * 
		 * 1~n 구간에서 소수를 구할 때, 2의 배수 제외, 3의 배수 제외.... 결국 소수만 남음
		 */

		// 우선 N이하인 소수 구하기
		// 소수면 true, 소수 아니면 false
		ArrayList<Boolean> primeList = new ArrayList<>(N + 1);
		// 0,1은 무조건 소수 아님
		primeList.add(false);
		primeList.add(false);

		// 2이상은 일단 다 소수라고 가정
		for (int i = 2; i <= N; i++) {
			primeList.add(i, true);
		}

		for (int i = 2; i * i <= N; i++) {    // i와 i보다 작은 수를 곱한 경우는 이전에 이미 고려했기 때문에.. i*i
			if (primeList.get(i)) { // 이미 소수가 아니라고 지워져서 false인 경우는 건너뛰기. 소수의 배수만 따지면 됨.
				for (int j = 2; i * j <= N; j++) {
					primeList.set(i * j, false);
				}
			}
		}

		
		// M 이상인 소수만 출력
		for (int i = M; i <= N; i++) {
			if (primeList.get(i)) {
				System.out.println(i);
			}
		}

		

	} // main
}
