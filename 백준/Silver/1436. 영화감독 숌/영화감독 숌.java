import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int num = 666;
		int cnt = 1;
		while (cnt < N) {
			num++;
			String number = Integer.toString(num);
			if (number.contains("666")) {
				cnt++;
			}
		}
		
		System.out.println(num);
	} // main
}