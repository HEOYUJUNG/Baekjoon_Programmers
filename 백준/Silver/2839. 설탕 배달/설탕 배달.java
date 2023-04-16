import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int sugar = sc.nextInt();
		int max5 = sugar / 5;
		for (int i = max5; i >= 0; i--) {
			if((sugar - i*5)%3==0) {
				System.out.println(i+(sugar - i*5)/3);
				return;
			}
		}
		System.out.println(-1);
	}// main
}
