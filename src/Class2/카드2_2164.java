package Class2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 카드2_2164 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 카드 개수

		/*list 쓰되 앞의 카드들 제거하는 과정 굳이 안 넣으니까 시간 안에 해결..ㅎ*/
		// 우선 N장의 카드를 cards 리스트에 쌓는다.
		// 인덱스 0이 위, 마지막 인덱스가 아래
		List<Integer> cards = new ArrayList<>(N);
		for (int i = 1; i <= N; i++) {
			cards.add(i);
		}

		int start = 0;
		int end = N-1;
		// 카드가 한 장 남을 떄까지 반복
		while (start != end) {
			// 1. 제일 위(앞)에 있는 카드 버리기
//			cards.remove(0);
			// 2. 제일 위(앞)에 있는 카드 밑(뒤)으로 옮기기
			cards.add(cards.get(start + 1));
//			cards.remove(0);
			start += 2;
			end++;
//			N--;
//			System.out.println(cards.toString());
		}

		// 마지막 남은 카드 출력
		System.out.println(cards.get(end));

		/* HashMap 쓰면 메모리 초과.. */
//		// 우선 N장의 카드를 cards 맵에 쌓는다.
//		HashMap<Integer, Integer> map = new HashMap<>();
//		for (int i = 1; i <= N; i++) {
//			map.put(i, i);
//		}
//
//		int start = 1;
//		int end = N;
//		// 카드가 한 장 남을 떄까지 반복
//		while (map.size() != 1) {
//			// 1. 제일 위(앞)에 있는 카드 버리기
//			map.remove(start);
//			// 2. 제일 위(앞)에 있는 카드 밑(뒤)으로 옮기기
//			map.put(end + 1, map.get(start + 1));
//			map.remove(start + 1);
//			start += 2;
//			end++;
//			System.out.println(map.toString() + " " + map.size());
//		}
//
//		// 마지막 남은 카드 출력
//		System.out.println(map.get(end));
	} // main
}
