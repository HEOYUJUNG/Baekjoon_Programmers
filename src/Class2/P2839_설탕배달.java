package D2;

import java.util.Scanner;

public class P2839_설탕배달 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int sugar = sc.nextInt();
		// 일단 그리디하게
		int max5 = sugar / 5;
		// 5kg를 최대한 많이 했는데 정확하게 나누어 떨어지지 않으면, 욕심 조금 줄여서 5kg 줄이고 3kg 늘리기
		// 그렇게 해도 안되면 -1 출력
		for (int i = max5; i >= 0; i--) {
			if((sugar - i*5)%3==0) {
				System.out.println(i+(sugar - i*5)/3);
				return;
			}
		}
		System.out.println(-1);
	}// main
}
