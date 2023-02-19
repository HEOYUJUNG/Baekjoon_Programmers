package baekjoon;

import java.util.Scanner;

public class P2527_직사각형 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int tc = 0; tc < 4; tc++) {
			// 왼쪽 아래 꼭짓점 (x,y)
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			// 오른쪽 위 꼭짓점 (p,q)
			int p1 = sc.nextInt();
			int q1 = sc.nextInt();
			// 왼쪽 아래 꼭짓점 (x,y)
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			// 오른쪽 위 꼭짓점 (p,q)
			int p2 = sc.nextInt();
			int q2 = sc.nextInt();

			int w1 = p1 - x1;
			int h1 = q1 - y1;
			int w2 = p2 - x2;
			int h2 = q2 - y2;

			int w = Math.max(p1, p2) - Math.min(x1, x2);
			int h = Math.max(q1, q2) - Math.min(y1, y2);

			if (w1 + w2 > w && h1 + h2 > h) { // 직사각형
				System.out.println("a");
			} else if (w1 + w2 == w && h1 + h2 > h || w1 + w2 > w && h1 + h2 == h) { // 선분
				System.out.println("b");
			} else if(w1 + w2 == w && h1 + h2 == h) { //점
				System.out.println("c");
			} else { // 공통부분 없음
				System.out.println("d");
			}
		}
	}
}
