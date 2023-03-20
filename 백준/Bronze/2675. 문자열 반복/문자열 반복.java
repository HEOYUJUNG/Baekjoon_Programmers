import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			int R = sc.nextInt();
			char[] arr = sc.next().toCharArray();
			String result = "";
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < R; j++) {
					result += arr[i];
				}
			}
			System.out.println(result);
		}
	}
}