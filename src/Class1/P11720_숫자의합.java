package Class1;

import java.util.Scanner;

public class P11720_숫자의합 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		char[] arr = sc.next().toCharArray();
		int sum = 0;
		for (int i = 0; i < N; i++) {
			sum += (arr[i]-'0');
		}
		System.out.println(sum);
	}
}
