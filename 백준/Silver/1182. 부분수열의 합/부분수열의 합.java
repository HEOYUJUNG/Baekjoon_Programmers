import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 정수 개수
		int S = Integer.parseInt(st.nextToken()); // 합이 S인 부분수열 개수 구하기
		int[] arr = new int[N];
		Arrays.sort(arr);
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int cnt = 0;
		for (int i = 1; i < (1 << N); i++) { // 부분집합 i (크기가 양수이니까 0 제외)
			int sum = 0; // 부분집합 i에 포함되는 원소들의 합
			for (int j = 0; j < N; j++) { // j번째 원소
				// 부분집합 i에 j번째 원소가 포함되는 경우
				if ((i & (1 << j)) > 0) {
					sum += arr[j];
				}
			}
			if (sum == S)
				cnt++;
		}
		System.out.println(cnt);
	}
}