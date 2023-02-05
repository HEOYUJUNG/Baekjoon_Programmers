package Class2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class 프린터큐1966 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt(); // 테스트케이스 수
		int[] result = new int[tc];

		for (int i = 0; i < tc; i++) { // 테스트케이스 개수만큼 테스트 반복
//			System.out.println();
//			System.out.println("테스트케이스 : " + (i + 1));
			// Queue는 인터페이스. LinkedList 클래스가 구현.
			// Queue에 N개 문서의 중요도 저장
			Queue<Integer> q = new LinkedList<>();

			int N = sc.nextInt(); // 문서의 개수
			int M = sc.nextInt(); // 타겟 문서가 현재 Queue의 몇 번째에 있는지

			int print = 0; // 몇번째 인쇄인지
			int end = 0;

//			System.out.println("N : " + N);
//			System.out.println("M : " + M);
//			System.out.println("print : " + print);
//			System.out.println("end : " + end);

			// 테스트케이스3 여기까진 동작함.

			List<Integer> imp = new ArrayList<>(); // Queue와 별개로 중요도 저장해 둘 배열

			for (int j = 0; j < N; j++) {
//				System.out.println("for 진입!");
//				System.out.println("j : "+j);
				imp.add(sc.nextInt());
//				System.out.println(imp.toString());
				q.offer(imp.get(j));
//				System.out.println(imp.get(j));
			}

//			System.out.println(imp.toString());

			// 타겟 문서의 인덱스도 인쇄 or 뒤로 재배치에 따라 변할 것임. 같이 추적해보자.

			// Queue에 문서 남아있지 않을 때까지 계속 반복
			while (end == 0) {

				int noPrint = 0;
				for (int j = 0; j < imp.size(); j++) { // imp 배열에 남아있는 중요도들과 비교하다가
					if (q.peek() < imp.get(j)) { // 첫번째보다 중요도 높은 게 하나라도 있으면
						q.offer(q.poll()); // 가장 뒤에 재배치
						noPrint++; // 인쇄 안함을 나타냄
						if (M == 0) {
							M = (N - 1);
						} else {
							M--;
						}
						break;
					}
				}

				// 중요도 높은 게 없다면, 인쇄!!

				if (noPrint == 0) {
					int temp = q.poll(); // 출력!!

					print++;
					if (M == 0) { // 타깃 문서가 가장 앞에 있었다면 인쇄하면서 몇 번째 인쇄인지 콘솔창에 출력
//						System.out.println("답 : " + print);
						result[i] = print;
						end++;
					} else {
						M--;
					}

					// imp 배열에서도 출력한 것 없애줘야 함.
					// 순서는 중요X. 그 중요도 값만 없어지면 됨.
//					System.out.println("imp 길이" + imp.size());
					for (int idx = 0; idx < imp.size(); idx++) {
						if (imp.get(idx) == temp) {
							imp.remove(idx);
						}
					}

					N--;

				}

				// 테스트용
//				System.out.println("N : " + N);
//				System.out.println("M : " + M);
//				System.out.println("noPrint : " + noPrint);
//				System.out.println("print : " + print);
//				System.out.println("q : " + q);
//				System.out.println(imp.toString());
//				System.out.println();
			} // while

		} // test-case

		for (int i = 0; i < tc; i++) {
			System.out.println(result[i]);
		}
	} // main
}
