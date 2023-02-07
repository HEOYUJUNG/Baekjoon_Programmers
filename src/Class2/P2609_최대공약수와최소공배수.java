package Class2;

import java.util.Scanner;

public class P2609_최대공약수와최소공배수 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();

		// 최대 공약수
		int max = 1;
		for (int i = 2; i <= Math.min(num1, num2); i++) {
			if (num1 % i == 0 && num2 % i == 0) {
				max = i;
			}
		}
		// 최소 공배수
		int min = Math.max(num1, num2);
		while(min%num1!=0 || min%num2!=0) {
			min++;
		}
		
		System.out.println(max);
		System.out.println(min);
	}
}
