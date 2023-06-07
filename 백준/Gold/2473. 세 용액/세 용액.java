import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 전체 용액의 수
		long[] arr = new long[N];
		// 용액 특성값 입력받기
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}
		Arrays.sort(arr);

		long[] res = new long[3];
		long sum = Long.MAX_VALUE;
		here: for (int j = 0; j < N - 2; j++) {
			for (int i = j + 1; i < N - 1; i++) {
				long tmp = arr[i] + arr[j];
				int start = i + 1;
				int end = N - 1;
				int mid = 0;
				while (start <= end) {
					mid = (start + end) / 2;
					if (tmp + arr[mid] < 0) {
						start = mid + 1;
					} else if (tmp + arr[mid] > 0) {
						end = mid - 1;
					} else {
						res[0] = arr[j];
						res[1] = arr[i];
						res[2] = arr[mid];
						break here;
					}
					if (Math.abs(tmp + arr[mid]) < sum) {
						sum = Math.abs(tmp + arr[mid]);
						res[0] = arr[j];
						res[1] = arr[i];
						res[2] = arr[mid];
					}
				}
			}
		}
		System.out.println(res[0] + " " + res[1] + " " + res[2]);
	}
}