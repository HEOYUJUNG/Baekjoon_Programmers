import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 블로그 시작하고 지난 일수
		int X = sc.nextInt(); // X일 동안 가장 많이 들어온 방문자와 기간 구하기
		int[] day = new int[N];
		for (int i = 0; i < N; i++) {
			day[i] = sc.nextInt();
		}

		int[] visitors = new int[N]; // 해당 일까지 X일동안의 방문자 수 합
		for (int i = 0; i < X; i++) {
			visitors[X - 1] += day[i];
		}

		int max = visitors[X - 1]; // 최대 방문자 수
		for (int i = X; i < N; i++) {
			visitors[i] = visitors[i - 1] + day[i] - day[i - X];
			max = (max < visitors[i]) ? visitors[i] : max; // 최대값 갱신
		}

		int cnt = 0;
		for (int i = 0; i < N; i++) {
			if (visitors[i] == max) {
				cnt++;
			}
		}
	
		if (max == 0) {
			System.out.println("SAD");
		} else {
			System.out.println(max);
			System.out.println(cnt);
		}
	}
}