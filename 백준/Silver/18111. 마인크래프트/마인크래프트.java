import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken()); // 인벤토리에 들어있는 블록 개수

		int min = 256;
		int max = 0;

		// 카운팅 배열. 땅 높이가 인덱스, 해당 높이의 땅 개수가 값
		// 땅의 높이는 0~256
		int[] counting = new int[257];

		// 땅 높이의 최대/최소값도 같이 찾기
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int h = Integer.parseInt(st.nextToken());
				counting[h]++;
				if (h < min)
					min = h;
				if (h > max)
					max = h;
			}
		}

		int minSec = Integer.MAX_VALUE; // '땅 고르기' 작업에 걸리는 최소 시간. 가능한 가장 큰 값으로 초기화.
		int height = min;
		int result = 0;
		while (height <= max) {
			// 최종적으로 height 높이까지 만드는 데 걸리는 시간
			int sec = 0;
			int tempB = B;
			for (int i = 0; i < 257; i++) {
				if (counting[i] != 0) {
					if (i > height) { // 목표 높이보다 높으면 block 없애서 인벤토리 넣어줘야 함
						tempB += (i - height) * counting[i];
						sec += ((i - height) * 2) * counting[i];
					} else if (i < height) { // 목표 높이보다 낮으면 인벤토리에서 꺼내서 block 추가해줘야 함
						tempB -= (height - i) * counting[i];
						sec += (height - i) * counting[i];
					}
				}
			}
			// 인벤토리에 있는 블록 수가 음수라면 이건 불가능한 경우!
			// 시간 더 짧으면 시간, 높이 정보 업데이트
			// height는 계속 커지니까 같은 최소시간이어도 뒤에 들어간 게 더 큰 높이
			if (tempB >= 0 && sec <= minSec) {
				minSec = sec;
				result = height;
			}

			// 다음 높이 탐색
			height++;

		}
		// 1. 땅을 고르는 데 걸리는 시간
		// 2. 땅의 높이
		// 출력
		sb.append(minSec + " " + result);
		System.out.print(sb);
	} // main
}