package D2;

import java.util.Arrays;
import java.util.Scanner;

public class P7568_덩치 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] wh = new int[N][2];
		// N명의 몸무게, 키 입력받기
		for (int p = 0; p < N; p++) {
			wh[p][0] = sc.nextInt();
			wh[p][1] = sc.nextInt();
		}

		for (int i = 0; i < N; i++) {
			int cnt = 1;
			for (int j = 0; j < N; j++) {
				if (wh[j][0] > wh[i][0] && wh[j][1] > wh[i][1]) {
					cnt++;
				}
			}
			System.out.print(cnt+" ");
		}

	}
}
