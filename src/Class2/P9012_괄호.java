package Class2;

import java.util.Scanner;

public class P9012_괄호 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			String line = sc.next();
			char[] PS = line.toCharArray();

			int LR = 0;
			int RR = 0;
			for (char ps : PS) {
				if (ps == '(') {
					LR++;
				}
				if (ps == ')') {
					RR++;
					if(RR>LR) break;
				}
			}
			if (LR != RR) {
				System.out.println("NO");
			} else {
				System.out.println("YES");
			}
		}
	}
}
