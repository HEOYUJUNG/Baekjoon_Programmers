import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();

		A = (A % 10) * 100 + A / 10 % 10 * 10 + (A / 100);
		B = (B % 10) * 100 + B / 10 % 10 * 10 + (B / 100);
		
		System.out.println(Math.max(A, B));
	}
}