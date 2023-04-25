import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 문자열 P에서 O의 개수 (I는 N+1개) => 문자열 P의 총 길이는 2N+1

		int M = sc.nextInt(); // S의 길이
		char[] S = sc.next().toCharArray();
		int cnt = 0; // S 안에 P가 몇 군데 포함되어 있는지
		// 패턴 매칭!
		for (int i = 0; i < M - (2 * N + 1) + 1; i++) {
			boolean flag = true;
			for (int j = i; j < i + (2 * N + 1); j++) {
				// 문자열 P에서
				// 0, 2, 4, ... => 짝수번째 자리는 I
				// 1, 3, 5, ... => 홀수번째 자리는 O

//				int tmp = j - i;
//				System.out.println("i : " + i + " / j - i : " + tmp);
//				System.out.println(S[j]);
				if (((j - i) % 2 == 0 && S[j] == 'O') || ((j - i) % 2 == 1 && S[j] == 'I')) {
//					System.out.println(S[j]);
//					System.out.println("안됨 : " + i);
					// 1. 짝수번째 자리인데 O인 경우
					// 2. 홀수번째 자리인데 I인 경우
					// -> 현재 자리에서는 문자열 P를 포함할 수 없음
					flag = false;
					break;
				}
			}
			if (flag) {
//				System.out.println("됨 : " + i);
				cnt++;
			}
		}

		System.out.println(cnt);
	} // main
}