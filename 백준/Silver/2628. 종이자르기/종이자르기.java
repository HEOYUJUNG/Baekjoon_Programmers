import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 종이 가로 길이 (최대 100cm)
		int width = sc.nextInt();
		// 종이 세로 길이 (최대 100cm)
		int height = sc.nextInt();

		// 점선 개수
		int N = sc.nextInt();
		int[] w = new int[width];
		int[] h = new int[height];
		// 종이 자르기
		for (int n = 0; n < N; n++) {
			int wh = sc.nextInt();
			if (wh == 1) { // 가로로 자르는 점선
				// 점선 번호
				w[sc.nextInt()]++;
			} else { // 세로로 자르는 점선
				// 점선 번호
				h[sc.nextInt()]++;
			}
		}

		// 가로의 최대 길이, 세로의 최대 길이 각각 구하기
		int maxW = 0;
		int idxW = 0;
		int maxH = 0;
		int idxH = 0;
		for (int i = 0; i < width; i++) {
			if (w[i] == 1) {

				if (i - idxW > maxW) {
					maxW = i - idxW;
				}
				idxW = i;
			}
		}
		for (int i = 0; i < height; i++) {
			if (h[i] == 1) {
				if (i - idxH > maxH) {
					maxH = i - idxH;
				}
				idxH = i;
			}
		}

		maxW = Math.max(maxW, width-idxW);
		maxH = Math.max(maxH, height-idxH);

		System.out.println(maxW * maxH);
	} // main
}
