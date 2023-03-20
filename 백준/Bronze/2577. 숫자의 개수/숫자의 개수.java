import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		int result = A * B * C;
		int[] counting = new int[10];
		while (result > 0) {
			counting[result % 10]++;
			result /= 10;
		}
		for (int i = 0; i < 10; i++) {
			System.out.println(counting[i]);
		}
	}
}