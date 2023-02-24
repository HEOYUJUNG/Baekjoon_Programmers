import java.util.HashMap;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		// 상근이가 가지고 있는 숫자 카드의 개수
		int N = sc.nextInt();

		// key : 카드 번호 , value : 해당 번호의 카드가 몇 장인지
		HashMap<Integer, Integer> cards = new HashMap<>();
		// 숫자 카드에 적혀있는 정수 입력받기
		for (int i = 0; i < N; i++) {
			int cardNum = sc.nextInt();

			if (cards.containsKey(cardNum)) {
				// 이미 받은 적 있는 숫자면 기존 값 + 1
				int cnt = cards.get(cardNum);
				cards.replace(cardNum, cnt + 1);
			} else {
				// 처음 받은 숫자면 map에 추가해주기
				cards.put(cardNum, 1);
			}
		}

		// 정수 개수
		int M = sc.nextInt();
		// M개만큼 숫자 입력받기 -> 각 숫자 카드 몇 장 있는지 출력
		for (int i = 0; i < M; i++) {
			int num = sc.nextInt();
			int result = 0; // 카드 없으면 0
			if (cards.containsKey(num)) {
				// 카드 있으면 몇 장 있는지 가져오기
				result = cards.get(num);
			}
			sb.append(result + " ");
		}
		System.out.println(sb);
	} // main
}