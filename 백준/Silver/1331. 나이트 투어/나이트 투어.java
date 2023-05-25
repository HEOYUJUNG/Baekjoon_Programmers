import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] map = new int[6][6];
		String input = sc.next();
		int r = input.charAt(0) - 'A';
		int c = input.charAt(1) - '1';
		int stR = r;
		int stC = c;
		map[r][c]++;
		for (int i = 1; i < 36; i++) {
			input = sc.next();
			int rr = input.charAt(0) - 'A';
			int cc = input.charAt(1) - '1';
			map[rr][cc]++;
			if (i == 35 && ((Math.abs(rr - stR) != 2 || Math.abs(cc - stC) != 1)
					&& (Math.abs(rr - stR) != 1 || Math.abs(cc - stC) != 2))) {
				System.out.println("Invalid");
				return;
			} else if (((Math.abs(rr - r) == 2 && Math.abs(cc - c) == 1)
					|| (Math.abs(rr - r) == 1 && Math.abs(cc - c) == 2)) && map[rr][cc] < 2) {
				r = rr;
				c = cc;
			} else {
				System.out.println("Invalid");
				return;
			}
		}
		System.out.println("Valid");
	}
}