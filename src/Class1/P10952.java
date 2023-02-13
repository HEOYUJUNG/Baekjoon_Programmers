package Class1;

import java.util.Scanner;

public class P10952 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (sc.hasNext()) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			if (A == 0 && B == 0) {
				break;
			} else {
				System.out.println(A + B);
			}
		}

	}
}
