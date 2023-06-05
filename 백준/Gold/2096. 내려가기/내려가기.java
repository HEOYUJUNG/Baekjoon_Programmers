import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][3];
		int[] dp_max = new int[3];
		int[] dp_min = new int[3];
		int zero, one, two;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			map[i][0] = st.nextToken().charAt(0) - '0';
			map[i][1] = st.nextToken().charAt(0) - '0';
			map[i][2] = st.nextToken().charAt(0) - '0';
			if (i == 0) {
				dp_max[0] = dp_min[0] = map[i][0];
				dp_max[1] = dp_min[1] = map[i][1];
				dp_max[2] = dp_min[2] = map[i][2];
				continue;
			}
			// 최대
			zero = Math.max(dp_max[0], dp_max[1]) + map[i][0];
			one = Math.max(dp_max[0], Math.max(dp_max[1], dp_max[2])) + map[i][1];
			two = Math.max(dp_max[1], dp_max[2]) + map[i][2];
			dp_max[0] = zero;
			dp_max[1] = one;
			dp_max[2] = two;
			// 최소
			zero = Math.min(dp_min[0], dp_min[1]) + map[i][0];
			one = Math.min(dp_min[0], Math.min(dp_min[1], dp_min[2])) + map[i][1];
			two = Math.min(dp_min[1], dp_min[2]) + map[i][2];
			dp_min[0] = zero;
			dp_min[1] = one;
			dp_min[2] = two;
		}

		int max = Math.max(dp_max[0], Math.max(dp_max[1], dp_max[2]));
		int min = Math.min(dp_min[0], Math.min(dp_min[1], dp_min[2]));
		System.out.println(max + " " + min);
	}
}
