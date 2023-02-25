import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 점의 개수
		int N = sc.nextInt();

		PriorityQueue<dot> pq = new PriorityQueue<>(new PositionComparator());

		// x, y 좌표 입력받아서 dot 객체 만들고 우선순위 큐에 넣기
		for (int i = 0; i < N; i++) {
			dot d = new dot(sc.nextInt(), sc.nextInt());
			pq.add(d);
		}

		// 우선순위 큐에 규칙대로 잘 정렬되어 있으니 그냥 뽑아서 출력
		for (int i = 0; i < N; i++) {
			System.out.println(pq.poll().toString());
		}

	} // main

	// 점 클래스 생성 (x좌표, y좌표)
	public static class dot {
		int x;
		int y;

		// 생성자
		public dot(int x, int y) {
			this.x = x;
			this.y = y;
		}

		// 출력 형식 지정해주기
		@Override
		public String toString() {
			return x + " " + y;
		}

	}

	// 우선순위의 규칙 설정 (좌표정렬하기1의 코드에서 여기만 손댐!!)
	public static class PositionComparator implements Comparator<dot> {
		@Override
		public int compare(dot o1, dot o2) {
			// y좌표가 같으면 x좌표가 증가하는 순서로 정렬
			if (o1.y == o2.y) {
				return o1.x - o2.x;
			} else { // y좌표가 다르면 y좌표가 증가하는 순으로 정렬
				return o1.y - o2.y;
			}
		}
	}

}