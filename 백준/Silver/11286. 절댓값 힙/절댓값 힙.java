import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int N = sc.nextInt(); // 연산 개수

		PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
			@Override
			public int compare(Pair o1, Pair o2) {
				if (o1.abs == o2.abs) {
					return o1.num - o2.num; // 절댓값이 같으면 작은 수가 앞으로
				}
				return o1.abs - o2.abs; // 절댓값 기준으로 오름차순 정렬
			}
		});

		for (int i = 0; i < N; i++) {
			int x = sc.nextInt();
			if (x != 0) {
				pq.add(new Pair(x, Math.abs(x)));
			} else if (pq.isEmpty()) { // 입력이 0인데 배열이 비어 있는 경우
				sb.append(0 + "\n");
			} else {
				sb.append(pq.poll().num + "\n");
			}
		}
		
		System.out.println(sb);
	}

	private static class Pair {
		int num, abs;

		public Pair(int num, int abs) {
			this.num = num;
			this.abs = abs;
		}
	}
}