import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 전체 용액의 수
		int[] arr = new int[N];
		// 용액 특성값 입력받기 (★오름차순)
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int[] res = new int[2];
		int sum = Integer.MAX_VALUE;
		here: for (int i = 0; i < N - 1; i++) {
			int start = i + 1;
			int end = N - 1;
			int mid = 0;
			while (start <= end) {
				mid = (start + end) / 2;
				if (arr[i] + arr[mid] < 0) {
					start = mid + 1;
				} else if (arr[i] + arr[mid] > 0) {
					end = mid - 1;
				} else {
					res[0] = arr[i];
					res[1] = arr[mid];
					break here;
				}
				if (Math.abs(arr[i] + arr[mid]) <= sum) {
					sum = Math.abs(arr[i] + arr[mid]);
					res[0] = arr[i];
					res[1] = arr[mid];
				}
			}
		}
		System.out.println(res[0] + " " + res[1]);
	}
}