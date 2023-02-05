package Class2;

import java.util.Scanner;

public class Solution1085 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// x, y, w, h 입력 받기
		int x = sc.nextInt();
		int y = sc.nextInt();
		int w = sc.nextInt();
		int h = sc.nextInt();

		// 각 경계선까지 가는 거리 : x, y, (w-x), (h-y)
		// 이 중 최솟값 구하기
		int[] dist = { x, y, (w - x), (h - y) };
		int min = dist[0];
		for (int i = 0; i < 4; i++) {
			if (dist[i] < min) {
				min = dist[i];
			}
		}

		System.out.println(min);
	} // main
}
