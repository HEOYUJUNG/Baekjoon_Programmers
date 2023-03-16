import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 집 개수
		int C = sc.nextInt(); // 공유기 개수
		int[] house = new int[N];
		for (int i = 0; i < N; i++) {
			house[i] = sc.nextInt();
		}
		int[] wifi = new int[C];

		Arrays.sort(house); // 오름차순 정렬
		wifi[0] = house[0];

		int start = 0; // 최소 거리
		int end = house[N - 1] - house[0]; // 최대 거리
		int mid = 0; // 거리 평균 (초기화)
		while (start <= end) {

			mid = (start + end) / 2;
//			System.out.println("start " + start);
//			System.out.println("end " + end);
//			System.out.println("mid " + mid);
//			System.out.println();

			// 공유기 개수만큼 탐색
			int cnt = 1; // 설치한 공유기 개수.
			for (int i = 1; i < N; i++) { // i번째 집에 공유기 설치할지 정하기
				if (cnt - 1 < C && wifi[cnt - 1] + mid <= house[i]) {
					if (cnt < C) {
						wifi[cnt] = house[i];
					}
					cnt++;
				}
			}

			if (cnt < C) { // 설치 다 못했으면 거리 줄여야 함
				end = mid - 1;
			} else { // 공유기 개수 딱 맞게 세어지거나 더 많이 설치되면 거리 늘려봐야 함
				start = mid + 1;
			}
//
//			System.out.println(Arrays.toString(house));
//			System.out.println(Arrays.toString(wifi));
//			System.out.println("cnt " + cnt);
		}

		System.out.println(end);
	} // main
}