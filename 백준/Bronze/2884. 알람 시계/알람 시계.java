import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int H = sc.nextInt();
		int M = sc.nextInt();
		if (45 <= M) {
			M -= 45;
		} else {
			M = 60 - (45 - M);
			H = (H == 0) ? 23 : H - 1;
		}

		System.out.println(H + " " + M);
	}
}