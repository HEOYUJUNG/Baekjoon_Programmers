package saessak;

import java.util.Scanner;

public class P15964_이상한기호 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		long A = sc.nextInt();
		long B = sc.nextInt();
		
		System.out.println((A+B)*(A-B));
	}
}
