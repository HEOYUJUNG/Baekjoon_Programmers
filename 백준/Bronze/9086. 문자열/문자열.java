import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			String s = sc.next();
			sb.append(s.charAt(0));
			sb.append(s.charAt(s.length() - 1));
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}