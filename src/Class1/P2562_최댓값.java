package Class1;

import java.util.Scanner;

public class P2562_최댓값 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int max = 0;
		int idx = 0;
		for (int i = 0;i<9;i++) {
			int input = sc.nextInt();
			if (input > max) {
				max = input;
				idx = i+1;
			}
		}
		
		System.out.println(max);
		System.out.println(idx);
		
	}
}
