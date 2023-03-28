import java.util.Scanner;

public class Main {
	static int N, M, cnt;
	static int[] arr;
	static int[] sel;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 재료의 개수
		M = sc.nextInt(); // 갑옷을 만드는 데 필요한 수
		arr = new int[N]; // 재료의 번호들 입력받을 배열
		sel = new int[2]; // 선택한 두 재료의 번호 저장할 배열
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		cnt = 0; // 갑옷을 만들 수 있는 개수
		comb(0, 0);
		System.out.println(cnt);
	}

	// N개 중에 2개 고르는 거니까 조합
	private static void comb(int idx, int sidx) {
		// 기저 조건
		if (sidx == 2) { // 2개 다 골랐으면 종료
			int sum = 0;
			for (int i = 0; i < sidx; i++) {
				sum += sel[i]; 
			}
			if (sum == M) { 
				cnt++;
			}
			return;
		}
		if (idx == N) { // 2개 못 골랐어도 arr에 있는 거 다 고려했으면 종료.
			return;
		}

		// 유도 조건
		comb(idx + 1, sidx); // idx번째 안 뽑거나
		sel[sidx] = arr[idx];  // 선택 결과 저장
		comb(idx + 1, sidx + 1); // 뽑거나
	}
}