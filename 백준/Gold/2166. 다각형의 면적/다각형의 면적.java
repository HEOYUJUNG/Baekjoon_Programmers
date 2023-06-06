import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		// 반시계 방향 순서로 x, y 좌표 배열에 저장하기 (첫 꼭짓점 좌표는 마지막에 한번 더 추가)
		long[][] vertex = new long[N + 1][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			vertex[i][0] = Integer.parseInt(st.nextToken());
			vertex[i][1] = Integer.parseInt(st.nextToken());
		}
		vertex[N][0] = vertex[0][0];
		vertex[N][1] = vertex[0][1];

		long sum1 = 0L;
		long sum2 = 0L;
		for (int i = 0; i < N; i++) {
			sum1 += vertex[i][0] * vertex[i + 1][1];
			sum2 += vertex[i][1] * vertex[i + 1][0];
		}
		System.out.println(String.format("%.1f", Math.abs(sum1 - sum2) / 2D));
	}
}