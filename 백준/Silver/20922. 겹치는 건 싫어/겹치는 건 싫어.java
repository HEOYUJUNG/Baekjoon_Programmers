import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
//		int N = sc.nextInt(); // 수열 길이
//		int K = sc.nextInt(); // 같은 원소가 K개 이하로 들어 있는 최장 연속 부분 수열의 길이 구하기
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		int[] counting = new int[100001];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int ps = 0; // 수열의 시작을 가리키는 포인터
		int pe = 0; // 수열의 끝을 가리키는 포인터
		counting[arr[pe]]++;
		int L = 0; // 구하고자 하는 수열의 길이 최대값

		while (true) {
//			System.out.println("ps : " + ps + " / pe :" + pe);
//			if (N - ps < L) {
//				break;
//			}

//			boolean flag = true; // 현재의 수열 가능한지 판단

			if (counting[arr[pe]] > K) { // 같은 원소가 K개 초과해서 있다면
//				flag = false; // 불가능
				counting[arr[ps]]--;
				ps++; // 시작 위치 옮기기
				continue;
			}

//			if (flag) {
			L = (L < pe - ps + 1) ? pe - ps + 1 : L; // 가능한 경우면 최대 길이 갱신
			pe++; // 끝점 하나 뒤로 밀기
			if (pe == N) {
				break;
			}
			counting[arr[pe]]++;
//			}			
		}

		System.out.println(L);
	}
}