import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int cnt = 1;
		while (B > 0) {
			if (B % 2 == 0) { // 짝수인 경우
				B /= 2;
				cnt++;
			} else if (B % 10 == 1) { // 일의 자리가 1인 경우
				B /= 10;
				cnt++;
			} else { // 2가지 연산 다 불가능한 경우 => -1 출력
				cnt = -1;
				break;
			}

			if (B == A) { // 연산 가능한 경우
				break;
			}
		}

		// while문은 나왔지만 연산이 불가능한 경우 => -1 출력
		if (B == 0) {
			cnt = -1;
		}
		System.out.println(cnt);
	}
}