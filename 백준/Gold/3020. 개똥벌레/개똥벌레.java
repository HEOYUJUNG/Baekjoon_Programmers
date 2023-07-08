import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 동굴 길이 (항상 짝수)
		int H = Integer.parseInt(st.nextToken()); // 동굴 높이
		int[] down = new int[N / 2]; // 석순 (아래에 있음)
		int[] up = new int[N / 2]; // 종유석 (위에 있음)
		for (int i = 0; i < N; i++) {
			if (i % 2 == 0) { // 석순
				down[i / 2] = Integer.parseInt(br.readLine());
			} else { // 종유석
				up[i / 2] = Integer.parseInt(br.readLine());
			}
		}
		Arrays.sort(down);
		Arrays.sort(up);
		int front = 0; // down배열 앞에서부터 탐색
		int back = N / 2 - 1; // up배열 뒤에서부터 탐색
		int min = N; // 파괴해야 하는 장애물 최솟값
		int[] obstacle = new int[H + 1]; // 높이별 장애물 수
		int cur = N / 2; // 현재 높이(h)에서의 장애물 수
		for (int h = 1; h <= H; h++) {
			while (front < N / 2 && down[front] < h) {
				cur--;
				front++;
			}
			while (back >= 0 && H - up[back] + 1 <= h) {
				cur++;
				back--;
			}
			min = (cur < min) ? cur : min;
			obstacle[h] = cur;
		}
		int cnt = 0;
		for (int h = 1; h <= H; h++) {
			if (obstacle[h] == min) {
				cnt++;
			}
		}
		System.out.println(min + " " + cnt);
	}
}
