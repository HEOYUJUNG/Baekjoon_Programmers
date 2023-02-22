import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int H = sc.nextInt(); // 호텔의 층 수
			int W = sc.nextInt(); // 각 층의 방 수
			int N = sc.nextInt(); // 몇 번째 손님

			// 호 => N/H+1, 단 나누어떨어지면 N/H
			int room;
			if (N % H != 0) {
				room = N / H + 1;
			} else {
				room = N / H;
			}
			// 층 => N%H, 단 0이면 가장 높은 층(H)
			int floor;
			if (N % H != 0) {
				floor = N % H;
			} else {
				floor = H;
			}
			System.out.printf("%d%02d\n", floor, room);
		}
	}
}
