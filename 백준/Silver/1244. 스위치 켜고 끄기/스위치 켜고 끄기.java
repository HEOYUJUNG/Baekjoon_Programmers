import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int N = sc.nextInt(); // 스위치 개수
		int[] swit = new int[N + 1];

		// 스위치 상태 입력받기
		// 켜짐 : 1, 꺼짐 : 0
		for (int i = 1; i <= N; i++) {
			swit[i] = sc.nextInt();
		}

		int M = sc.nextInt(); // 학생수
		for (int i = 0; i < M; i++) {
			// 학생 성별(1:남학생, 2:여학생)
			int sex = sc.nextInt();
			// 학생이 받은 수
			int num = sc.nextInt();
			if (sex == 1) { // 남학생
				for (int j = 1; j * num <= N; j++) {
					swit[j * num] = (1 - swit[j * num]);
				}
			} else { // 여학생
				// 일단 받은 번호의 스위치 상태 바꾸기
				swit[num] = (1 - swit[num]);
				for (int j = 1; num - j >= 1 && num + j <= N; j++) { // for문 안에서 인덱스 범위 제한해줌
					if (swit[num - j] == swit[num + j]) {
						swit[num - j] = (1 - swit[num - j]);
						swit[num + j] = (1 - swit[num + j]);
					} else {
						break;
					}
				}
			}
		}

		for (int i = 1; i <= N; i++) {
			System.out.print(swit[i]+" ");
			if (i % 20 == 0)
				System.out.println();
		}
	}
}