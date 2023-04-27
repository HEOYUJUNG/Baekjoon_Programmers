import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] A = sc.next().toCharArray();
		char[] B = sc.next().toCharArray();
		long res = 0;
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < B.length; j++) {
				res += ((A[i] - '0') * (B[j] - '0'));
			}
		}

		System.out.println(res);
	}
}