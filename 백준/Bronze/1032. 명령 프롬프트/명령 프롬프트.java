import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String[] arr = new String[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.next();
		}
		char[] result = new char[arr[0].length()];
		for (int i = 0; i < arr[0].length(); i++) {
			result[i] = arr[0].charAt(i);
		}

		for (int i = 0; i < arr[0].length(); i++) {
			char c = arr[0].charAt(i);
			for (int j = 1; j < N; j++) {
				if (arr[j].charAt(i) != c) {
					result[i] = '?';
					break;
				}
				if (j == N - 1) {
					result[i] = arr[j].charAt(i);
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < arr[0].length(); i++) {
			sb.append(result[i]);
		}


		System.out.println(sb);
	}
}