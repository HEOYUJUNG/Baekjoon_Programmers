import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Meeting[] arr = new Meeting[N]; // 회의들 저장할 배열
		for (int i = 0; i < N; i++) {
			arr[i] = new Meeting(sc.nextInt(), sc.nextInt());
		}

		Arrays.sort(arr, new Comparator<Meeting>() {

			@Override
			public int compare(Meeting o1, Meeting o2) {
				if (o1.end == o2.end) {
					return o1.start - o2.start;
				}
				// 종료시간 기준 오름차순으로 정렬
				return o1.end - o2.end;
			}

		});

		// 일단 종료 시간이 가장 빠른 첫 번째 회의 카운트
		int cnt = 1;
		int idx = 0; // 현재 회의실 쓰고 있는 회의의 인덱스
		for (int i = 1; i < N; i++) {
			if (arr[i].start >= arr[idx].end) {
				cnt++;
				idx = i;
			}
		}

		System.out.println(cnt);
	}

	public static class Meeting {
		int start;
		int end;

		public Meeting(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}
	}
}