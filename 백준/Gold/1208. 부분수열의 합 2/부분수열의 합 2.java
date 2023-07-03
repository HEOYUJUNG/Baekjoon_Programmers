import java.io.*;
import java.util.*;

public class Main {
	static int N, S;
	static int[] arr;
	static int[] L, R;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 정수 개수
		S = Integer.parseInt(st.nextToken()); // 합이 S인 부분수열 개수 구하기
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		// 수열 2개로 쪼개기
		L = new int[(int) Math.pow(2, N / 2)];
		R = new int[(int) Math.pow(2, N - N / 2)];
		getPartPerm(L, 0, N / 2 - 1);
		getPartPerm(R, N / 2, N - 1);

		// 왼쪽, 오른쪽 부분수열의 합들 오름차순 정렬
		Arrays.sort(L);
		Arrays.sort(R);

		// 투포인터로 비교하며 합이 0이 되는 조합 찾기
		long cnt = 0;
		int leftP = 0;
		int rightP = R.length - 1;
		while (leftP < L.length && rightP >= 0) {
			int leftVal = L[leftP];
			int rightVal = R[rightP];
			if (leftVal + rightVal > S) {
				rightP--;
			} else if (leftVal + rightVal < S) {
				leftP++;
			} else {
				long leftCnt = 0;
				long rightCnt = 0;
				// L 또는 R 내에 값이 같은 경우가 있을 수 있음
				while (leftP < L.length && leftVal == L[leftP]) {
					leftP++;
					leftCnt++;
				}
				while (rightP >= 0 && rightVal == R[rightP]) {
					rightP--;
					rightCnt++;
				}
				cnt += (leftCnt * rightCnt);
			}
		}

		// "크기가 양수인 부분수열 중에서" 구해야 하기 때문에 L, R 모두 공집합인 경우는 제외해야 함
		System.out.println((S == 0) ? cnt - 1 : cnt);
	}

	static void getPartPerm(int[] Arr, int st, int ed) {
		int n = ed - st + 1;
		// 비트마스킹으로 부분순열 구하기
		for (int i = 0; i < (1 << n); i++) { // 부분집합 i (공집합 포함)
			int sum = 0; // 부분집합 i에 포함되는 원소들의 합
			for (int j = st; j <= ed; j++) { // j번째 원소
				// 부분집합 i에 j번째 원소가 포함되는 경우
				if ((i & (1 << (j - st))) > 0) {
					sum += arr[j];
				}
			}
			Arr[i] = sum;
		}
	}
}