package D2;

import java.util.Scanner;

public class P2869_달팽이는올라가고싶다 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 낮에 +A(m)
		int A = sc.nextInt();
		// 밤에 -B(m)
		int B = sc.nextInt();
		// 정상은 V(m)
		int V = sc.nextInt();

		int height = 0;
		int day = 1;
		
		// 일단 A만큼 올라가기
		V -= A;
		if (V > 0) {
			// 남았으면 하루치 (A-B)만큼 며칠 올라가야 하는지 계산
			day += V / (A - B);
			if (V % (A - B) == 0) {
				System.out.println(day);
			} else {
				// 조금 남았으면 하루 더 올라가야 함
				System.out.println(day + 1);
			}
		} else {
			// 한 번 올라갔는데 정상이면 출력!
			System.out.println(day);
		}
	}
}
