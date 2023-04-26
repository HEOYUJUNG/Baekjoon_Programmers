import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 목표 채널
		int M = sc.nextInt(); // 고장난 버튼 개수
//		int[] broken = new int[M]; // 고장난 버튼들 저장할 배열
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < M; i++) {
//			broken[i] = sc.nextInt();
			list.add(sc.nextInt());
		}

		int min = Math.abs(N - 100); // 최소값은 + or - 버튼만으로 이동하는 경우로 초기화
		// 목표 채널보다 큰 채널에서 내려오는 경우
		for (int ch = N; ch <= 999999; ch++) {
			// 목표채널보다 큰 채널 중에서 고장나지 않은 버튼들로 누를 수 있는 가장 가까운 채널 찾기
			int cur = ch;
			boolean flag = true;
			int size = 0; // 자릿수
			if (cur == 0 && list.contains(0)) {
				flag = false;
			}
			while (cur > 0) {
				size++;
				if (list.contains(cur % 10)) {
					flag = false;
					break;
				}
				cur = cur / 10;
			}
			if (flag) { // 가장 가까운 채널 찾았으면 최소 이동 횟수 갱신하고 종료
//				System.out.println("크면서 가장 가까운 채널 : " + ch);
				if (ch == 0)
					size = 1;
				min = Math.min(min, size + (ch - N));
				break;
			}
		}

//		System.out.println("첫번쨰 min : " + min);

		// 목표 채널보다 작은 채널에서 올라오는 경우
		for (int ch = N; ch >= 0; ch--) {
			// 목표채널보다 작은 채널 중에서 고장나지 않은 버튼들로 누를 수 있는 가장 가까운 채널 찾기
			int cur = ch;
			boolean flag = true;
			int size = 0; // 자릿수
			if (cur == 0 && list.contains(0)) {
				flag = false;
			}
			while (cur > 0) {
				size++;
				if (list.contains(cur % 10)) {
					flag = false;
					break;
				}
				cur = cur / 10;
			}
			if (flag) { // 가장 가까운 채널 찾았으면 최소 이동 횟수 갱신하고 종료
				if (ch == 0)
					size = 1;
//				System.out.println("작으면서 가장 가까운 채널 : " + ch);
				min = Math.min(min, size + (N - ch));
				break;
			}
		}

		System.out.println(min);
	}
}